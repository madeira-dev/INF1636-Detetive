package models;

import java.util.Arrays;
import java.util.Objects;

class MoveGenerator {
	Board board;

	// Index do primeiro nó da iteração atual
	int first;
	String comodo_inicio;
	// Index do último nó da iteração atual
	int last;
	boolean first_iteration;
	MoveNode current_cell;
	MoveNode[] nodes;
	private static volatile MoveGenerator instance = null;

	public MoveGenerator(Board board) {
		this.board = board;
		this.nodes = new MoveNode[100000];
		this.comodo_inicio = null;
	}

	public static MoveGenerator getInstance(Board b) {
		if (instance == null) {
			instance = new MoveGenerator(b);
		}
		return instance;
	}

//	bloco de inicialização
	{
		reset_variables();
	}

	// Reinicia variáveis
	private void reset_variables() {
		this.last = 0;
		this.first = 0;
		this.first_iteration = true;
		this.comodo_inicio = null;
	}

	// Reinicia o gerador para configurar uma nova casa de início
	public void reset_generator(Cell start) {
		reset_variables();
		set_generator(start);
	}

	// Configura pela primeira vez um gerador para cada casa inicial
	public void set_generator(Cell start) {
		this.current_cell = new MoveNode(start, null);
		nodes[0] = current_cell;
		last++;
	}

	// Função principal de gerar movimentos
	public Cell[] get_moves(int depth) {
		int[][] temp;
		boolean[] neighbors;
		int old_last = last;

		// Opções de movimentação
		int[][] mov = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

		// Se é a primeira iteração, algumas coisas são diferentes
		// Caso não seja, não podemos sair por outra porta ou pegar passagens secretas
		if (first_iteration) {
			if (current_cell.is_room()) {
				comodo_inicio = current_cell.get_room();
				if (current_cell.has_shortcut()) {

					// Caso começamos numa passagem secreta, podemos atravessar para o outro lado
					add_node(current_cell.get_shortcut(), current_cell);

					nodes[last - 1].setIs_final();
					old_last++;
				}
				// Se estamos num cômodo, podemos sair por qualquer porta
				temp = get_coord_room(nodes[0].get_room());

				for (int[] coord : temp) {
					add_node(board.get_cell(coord[0], coord[1]), current_cell);
					old_last++;
				}
			}
		}
		// Vamos iterar por toda a camada de folhas (adicionados na última iteração)
		for (int i = first; i < old_last; i++) {
			current_cell = nodes[i];
			// Não podemos andar sobre cômodos fora da primeira iteração
			if (current_cell.is_room() && !first_iteration) {
				continue;
			}
			// Nem passagens secretas
			if (current_cell.has_shortcut() && nodes[0] != current_cell) {
				continue;
			}
			// Quais vizinhos estão livres
			neighbors = neighbor_availability();
			for (int j = 0; j < 4; j++) {
				Cell c = board.get_cell(current_cell.get_x() + mov[j][0], current_cell.get_y() + mov[j][1]);
				if (neighbors[j] && !Objects.equals(c.getRoom(), comodo_inicio)) {
					// Se está livre, adicionamos à lista
					add_node(c, current_cell);
					if (depth == 1 || c.is_room()) {
						// Se é a última iteração ou uma porta, é um destino final
						nodes[last - 1].setIs_final();
					}
				}
			}

		}

		first_iteration = false;

		// Ajustamos a nova camada de folhas
		first = old_last;

		// Retornamos caso seja a última iteração
		if (depth == 1) {
			return get_cells(nodes);
		}
		// Caso não seja, chamamos recursivamente
		return get_moves(depth - 1);
	}

	// Extrai as células únicas da lista de MoveNodes
	private Cell[] get_cells(MoveNode[] nodes) {
		Cell[] cells = new Cell[1000];
		Cell c;
		boolean add;

		int added = 0;

		for (int i = 0; i < last; i++) {
			if (!nodes[i].is_final()) {
				continue;
			}
			c = nodes[i].getCell();
			add = true;
			for (Cell c2 : cells) {
				if (c2 == c) {
					add = false;
					break;
				}
			}
			if (add) {
				cells[added] = c;
				added++;
			}
		}
		return Arrays.copyOf(cells, added);
	}

	private void add_node(Cell to_add, MoveNode src) {
		MoveNode m = new MoveNode(to_add, src);
		m.pass_node();
		nodes[last] = m;
		last++;
	}

	// Consulta onde estão as portas de cada cômodo (usada na movimentação)
	private int[][] get_coord_room(String nome) {
		int[][] coords = new int[2][0];
		switch (nome) {
		case ("Escritorio"):
			coords = Arrays.copyOf(coords, 1);
			coords[0] = new int[] { 7, 4 };
			break;

		case ("SalaDeEstar"):
			coords = Arrays.copyOf(coords, 1);
			coords[0] = new int[] { 18, 6 };
			break;

		case ("Biblioteca"):
			coords = Arrays.copyOf(coords, 2);
			coords[0] = new int[] { 7, 9 };
			coords[1] = new int[] { 4, 11 };
			break;
		case ("SalaDeJantar"):
			coords = Arrays.copyOf(coords, 2);
			coords[0] = new int[] { 18, 10 };
			coords[1] = new int[] { 17, 13 };
			break;

		case ("Cozinha"):
			coords = Arrays.copyOf(coords, 1);
			coords[0] = new int[] { 20, 19 };
			break;

		case ("JardimInverno"):
			coords = Arrays.copyOf(coords, 1);
			coords[0] = new int[] { 5, 20 };
			break;

		case ("SalaoDeJogos"):
			coords = Arrays.copyOf(coords, 2);
			coords[0] = new int[] { 2, 13 };
			coords[1] = new int[] { 6, 16 };
			break;

		case ("SalaDeMusica"):
			coords = Arrays.copyOf(coords, 4);
			coords[0] = new int[] { 15, 18 };
			coords[1] = new int[] { 10, 18 };
			coords[2] = new int[] { 9, 20 };
			coords[3] = new int[] { 16, 20 };
			break;

		case ("Entrada"):
			coords = Arrays.copyOf(coords, 3);
			coords[0] = new int[] { 10, 4 };
			coords[1] = new int[] { 13, 6 };
			coords[2] = new int[] { 12, 6 };
			break;
		}
		return coords;
	}

	// Consulta quais vizinhos estão disponíveis
	private boolean[] neighbor_availability() {
		boolean[] availability = { false, false, false, false };
		Cell c;

		// right, left, up, down
		int[][] mov = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

		for (int i = 0; i < 4; i++) {
			c = board.get_cell(current_cell.get_x() + mov[i][0], current_cell.get_y() + mov[i][1]);
			if (c.is_free() && !current_cell.has_passed(c)) {
				availability[i] = true;
			}
		}
		if (current_cell.get_x() == 17 && current_cell.get_y() == 6) {
			availability[0] = false;
		}
		if (current_cell.get_x() == 8 && current_cell.get_y() == 4) {
			availability[1] = false;
		}
		if (current_cell.get_x() == 5 && current_cell.get_y() == 19) {
			availability[3] = false;
		}
		return availability;
	}

	public int[][] cell_to_coord(Cell[] cells) {
		int size = cells.length;
		int[][] coord = new int[size][2];
		for (int i = 0; i < size; i++) {
			coord[i][0] = cells[i].get_x();
			coord[i][1] = cells[i].get_y();
		}
		return coord;
	}

}
