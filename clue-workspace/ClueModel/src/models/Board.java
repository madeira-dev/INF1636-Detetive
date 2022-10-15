package models;

import java.util.Arrays;
import java.util.Random;

public class Board {
	Player[] players;
	int num_players;
	Card[] arquivo_confidencial;
	Cell[][] cells;
	int width;
	int height;
	private static volatile Board instance = null;
	
	private Board(
	) {num_players = 0;}
	public static Board getInstance() {
		if (instance == null) {
			
//			making thread safe
			synchronized (Board.class) {
//				check again as multiple threads can reach above step
				if (instance == null)
					instance = new Board();
			}
		}
		return instance;
	}
	public void generate_grid(int width, int height){
		this.width = width;
		this.height = height;
		cells = new Cell[width][height];
		for(int i=0; i < width; i++){
			for(int j=0; j < height; j++){
				this.cells[i][j] = new Cell(i, j);
				if(i == 0 || j == 0 || i == width-1 || j == height-1){
					this.cells[i][j].tira_do_mapa();
				}
			}
		}
	}
	public void snip(int x, int y, int width, int height){
		for(int i=x; i < x + width; i++){
			for(int j=y; j < y + height; j++){
				cells[i][j].tira_do_mapa();
			}
		}
	}
	public void print_board(){
		for(int i=0; i < width; i++){
			for(int j=0; j < height; j++){
				cells[j][i].print();
			}
			System.out.print("\n");
		}
	}
	public void set_room(String comodo, int x, int y){
		cells[x][y].vira_comodo(comodo);
	}
	public void set_character(String character, int x, int y){
		cells[x][y].aloca_personagem(character);
	}

	public Cell get_cell(int x, int y){
		return cells[x][y];
	}
	public Cell[] gen_moves(Cell[] origins, int depth, int last){
		int added = 0;
		if(depth == 0){
			return origins;
		}
		for(int i=0; i < last; i++){
			Cell cell = origins[i];
			if(cells[cell.get_x() + 1][cell.get_y()].is_free() && !Arrays.asList(origins).contains(cells[cell.get_x() + 1][cell.get_y()])){
				origins[last + added] = cells[cell.get_x() + 1][cell.get_y()];
				added++;
			}
			if(cells[cell.get_x() - 1][cell.get_y()].is_free() && !Arrays.asList(origins).contains(cells[cell.get_x() - 1][cell.get_y()])){
				origins[last + added] = cells[cell.get_x() - 1][cell.get_y()];
				added++;
			}
			if(cells[cell.get_x()][cell.get_y() + 1].is_free() && !Arrays.asList(origins).contains(cells[cell.get_x()][cell.get_y() + 1])){
				origins[last + added] = cells[cell.get_x()][cell.get_y() + 1];
				added++;
			}
			if(cells[cell.get_x()][cell.get_y()-1].is_free() && !Arrays.asList(origins).contains(cells[cell.get_x()][cell.get_y() - 1])){
				origins[last + added] = cells[cell.get_x()][cell.get_y() - 1];
				added++;
			}
		}
		return gen_moves(origins, depth-1, last + added);
	}
	public void gera_arquivo(){
		arquivo_confidencial = Componentes.arquivo_confidencial();
	}
	public void init_players(int num){
		players = new Player[num];
	}
	public void add_player(String name, String character){
		players[num_players] = new Player(name, character);
		num_players++;
	}
	public void deal_cards(){
		int i = 0;
		Card[] cards = new Card[18];
		Card[] suspeitos = Componentes.personagens_cartas();
		Card[] armas = Componentes.armas_cartas();
		Card[] locais = Componentes.comodos_cartas();

		for(Card sus : suspeitos){
			if(sus != arquivo_confidencial[1]){
				cards[i] = sus;
				i++;
			}
		}
		for(Card arma : armas){
			if(arma != arquivo_confidencial[0]){
				cards[i] = arma;
				i++;
			}
		}
		for(Card local : locais){
			if(local != arquivo_confidencial[2]){
				cards[i] = local;
				i++;
			}
		}

		Random result = new Random();
		int val;
		for(int j=0; j < 18; j++){
			val = result.nextInt(18);

		}
	}

	public void order_to_play(){
		Player aux = new Player("Aux","Aux");
		//Acho q n precisa dessa String
		String order_in_game[] = { //ordem de jogada dos players ordenada no array
				"Srta. Scarlett",
				"Reverendo Green",
				"Srta. Peacock",
				"Professor Plum",
				"Coronel Mustard",
				"Srta. White"
		};
		for(int i=0, j=0 ; i<num_players; i++, j++){
			if(players[i].getName() == order_in_game[i]){
				aux = players[i];
				players[i] = players[0];
				players[0] = players[i];
			}
		}



	}


}