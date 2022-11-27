package controller;

import models.*;
import view.JogoClue;
import view.Notepad;
import view.JogoClue;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

import javax.swing.JFileChooser;

public class Controller {
	private static Board board;
	private static int turn;
	private static Player[] players;
	private static int num_players;
	private static Card[] arquivo_confidencial = new Card[3];

	public static int get_turn() {
		return turn;
	}

	public static void set_turn(int turno) {
		turn = turno;
	}

	private static Controller instance = null;
	private static MoveGenerator move_generator;
	// ja andou, ja palpitou
	private static boolean[] acoes;
	private static int[] valores_dado;

	public static Controller getInstance() {
		if (instance == null) {
			instance = new Controller();
		}
		return instance;
	}

	private Controller() {
		board = Board.getInstance();
		valores_dado = new int[2];
		players = new Player[6];
		move_generator = new MoveGenerator(board);
		acoes = new boolean[] { false, false };
	}

	public static int get_num_players() {
		return num_players;
	}

	public static void set_num_players(int num) {
		num_players = num;
	}

	public static void pass_turn() {
		turn = (turn + 1) % num_players;
		acoes = new boolean[] { false, false };
	}

	public static void atualiza_acoes(int id) {
		acoes[id] = true;
	}

	public static boolean[] get_acoes() {
		return acoes;
	}

	public static void set_valores_dado(int v1, int v2) {
		valores_dado[0] = v1;
		valores_dado[1] = v2;
	}

	public static int[][] casas_disponiveis(int x, int y) {
		move_generator.reset_generator(board.get_cell(x, y));
		return move_generator.cell_to_coord(move_generator.get_moves(valores_dado[0] + valores_dado[1]));
	}

	// Procura entre os jogadores alguém com o personagem. Retorna o personagem caso
	// ache ou null caso contrário
	public static Player get_player_by_character(String name) {
		for (Player p : players) {
			if (Objects.equals(p.getCharacter(), name)) {
				return p;
			}
		}
		return null;
	}

	// Palpite
	public static Player get_current_player() {
		return players[turn];
	}

	public static void set_current_player(Player p) {
		players[turn] = p;
	}

	public static Player get_next_player() {
		return players[(turn + 1) % get_num_players()];
	}

	public static Player get_player(int i) {
		return players[i];
	}

	public static Card prepara_palpite() {
		if (acoes[1]) {
			return null;
		}
		return board.get_room(get_current_player());
	}

	public static InfoPalpite guess(Player guesser, Card[] cards) {
		// Move o acusado para a sala
		Player acusado = get_player_by_character(cards[1].getName());
		if (acusado != null) {
			board.move_player(acusado, guesser.get_coord());
		}

		Player temp = guesser.getVizinho();
		Card[] options = new Card[0];

        // Se chegamos de novo no palpitador, encerramos o loop
        while (!Objects.equals(temp.getCharacter(), guesser.getCharacter())){
            // Cartas que o jogador respondendo na vez possui dentre as 3 do palpite
            options = temp.possui_algum(cards);
            // Debug
            System.out.printf("\n%s pode mostrar\n", temp.getCharacter());
            for(Card c: options){
                System.out.println(c.getName());
            }
            // Se o jogador pode mostrar algo, encerramos
            if(options.length != 0){
                return new InfoPalpite(temp, options);
            }
            // Se não, avançamos para o próximo
            temp = temp.getVizinho();
        }
        return null;
    }
    // Funções usadas para configurar lógica do tabuleiro
    public static void add_player(String character){
        for(int i = 0; i < num_players; i++){
            if(Objects.equals(players[i].getCharacter(), character)){
                return;
            }
        }
        players[num_players] = new Player(character);
        num_players++;
    }
    private static void set_neighbors(){
        for(int i=0; i < num_players; i++){
            players[i].setVizinho(players[(i + 1) % num_players]);
        }
    }
    public static void move(int[] coord){
        board.move_player(get_current_player(), coord);
    }
    private static void deal_cards(){
        int i = 0;
        boolean[] ja_usado = new boolean[18];
        Card[] cards = new Card[18];
        Card[] suspeitos = Componentes.personagens_cartas();
        Card[] armas = Componentes.armas_cartas();
        Card[] locais = Componentes.comodos_cartas();

		for (Card sus : suspeitos) {
			if (!Objects.equals(sus.getName(), arquivo_confidencial[1].getName())) {
				cards[i] = sus;
				i++;
			}
		}

		for (Card arma : armas) {
			if (!Objects.equals(arma.getName(), arquivo_confidencial[0].getName())) {
				cards[i] = arma;
				i++;
			}
		}

		for (Card local : locais) {
			if (!Objects.equals(local.getName(), arquivo_confidencial[2].getName())) {
				cards[i] = local;

				i++;
			}
		}

		for (int j = 0; j < 18; j++) {
			ja_usado[j] = false;
		}

		Random result = new Random();

		int val;
		for (int j = 0; j < 18; j++) {
			val = result.nextInt(18);
			while (true) {
				if (!ja_usado[val]) {
					players[j % num_players].addCard(cards[val]);
					players[j % num_players].setNoteOptions(cards[val], val);
					;

					ja_usado[val] = true;
					break;
				}

				else {
					val = (val + 1) % 18;
				}
			}

		}
		// players[turn].printNote();

	}

	@SuppressWarnings("unused")
	public static void mudaNote() {
		Notepad notes = new Notepad(players[turn].getNoteOptionsWeapons(), players[turn].getNoteOptionsSuspects(),
				players[turn].getNoteOptionsRooms());
	}

	private static void gera_arquivo() {
		arquivo_confidencial = Componentes.arquivo_confidencial();
	}

	private static void seta_arquivo(Card[] cartas) {
		arquivo_confidencial[0] = cartas[0];
		arquivo_confidencial[1] = cartas[1];
		arquivo_confidencial[2] = cartas[2];

	}

	public static void init_all() {
		set_neighbors();
		gera_arquivo();
		deal_cards();
		players = Arrays.copyOf(players, num_players);
	}

	public static void joga_dados() {
		Random result1 = new Random();
		Random result2 = new Random();

		int val1 = 1;
		int val2 = 1;

		val1 += result1.nextInt(6);
		val2 += result2.nextInt(6);

		valores_dado[0] = val1;
		valores_dado[1] = val2;
	}

	public static int[] pega_dados() {
		return valores_dado;
	}

	public static boolean acusar(Card[] cards) {
		for (int i = 0; i < 3; i++) {
			if (!Objects.equals(cards[i].getName(), arquivo_confidencial[i].getName())) {
				return false;
			}
		}
		return true;
	}

	public static void remove_player() {
		int counter = 0;
		Player p = players[turn];
		Player[] new_array = new Player[num_players - 1];

		for (Player pl : players) {
			if (pl != get_current_player()) {
				new_array[counter] = pl;
				counter++;
			}
		}
		num_players--;
		players = new_array;
	}

	public static void salvaJogo() {
		/*
		 * bonecos escolhidos na partida bonecos vivos/mortos
		 */
		JFileChooser j = new JFileChooser("C:\\Users\\thiag\\Desktop\\teste");
		j.setMultiSelectionEnabled(false);
		int r = j.showSaveDialog(null);

		if (r == JFileChooser.APPROVE_OPTION) {

			try {

				FileWriter escritor = new FileWriter(new File(j.getSelectedFile().getPath()));

				// System.out.printf("%d",players.length );

				escritor.write(Integer.toString(turn) + "\n");
				escritor.write(get_current_player().getCharacter() + "\n");
				escritor.write(Integer.toString(players.length) + "\n");
				escritor.write(arquivo_confidencial[0].getName() + " " + arquivo_confidencial[1].getName() + " "
						+ arquivo_confidencial[2].getName() + "\n");
				for (Player c : players) {
					escritor.write(c.getCharacter() + "\n");
					escritor.write(Integer.toString(c.get_coord()[0]) + "\n");
					escritor.write(Integer.toString(c.get_coord()[1]) + "\n");
					escritor.write(Integer.toString(c.getCardsArr().length) + "\n");
					for (Card carta : c.getCardsArr()) {
						escritor.write(carta.getType() + " " + carta.getName() + "\n");
					}
					// escritor.write("Notepad Rooms:\n");
					for (Boolean v : c.getNoteOptionsRooms()) {
						escritor.write(v + "\n");
					}
					// escritor.write("Notepad Weapons:\n");
					for (Boolean v : c.getNoteOptionsWeapons()) {
						escritor.write(v + "\n");
					}
					// escritor.write("Notepad Suspects:\n");
					for (Boolean v : c.getNoteOptionsSuspects()) {
						escritor.write(v + "\n");
					}
				}

				escritor.close();

			} catch (IOException e) {
				e.getMessage();
			}
		}
	}

	public static void continuaJogo() {
		JFileChooser j = new JFileChooser("C:\\Users\\thiag\\Desktop\\teste");
		j.setMultiSelectionEnabled(false);

		int r = j.showSaveDialog(null);

		if (r == JFileChooser.APPROVE_OPTION) {

			try {
				FileReader arquivo = new FileReader(new File(j.getSelectedFile().getPath()));
				BufferedReader linha_arquivo = new BufferedReader(arquivo);
				Player current_player;
				Card[] arq_confidencial = new Card[3];
				String[] aux;
				Card[] personagens =  { new Card("White", "personagem"), new Card("Green", "personagem"),
						new Card("Scarlet", "personagem"), new Card("Plum", "personagem"), new Card("Peacock", "personagem"),
						new Card("Mustard", "personagem") };
				Card[] armas_cartas =  { new Card("Cano", "arma"), new Card("Castical", "arma"), new Card("Corda", "arma"),
						new Card("ChaveInglesa", "arma"), new Card("Faca", "arma"), new Card("Revolver", "arma") };
				Card[] comodos_cartas =  Componentes.comodos_cartas();

				int qtd_jogadores, x, y, i = 0, qtd_cards,p,trueOuFalse;

				String linha = linha_arquivo.readLine();
				set_turn(Integer.parseInt(linha));

				linha = linha_arquivo.readLine();
				current_player = new Player(linha);
				set_current_player(current_player);

				linha = linha_arquivo.readLine();
				qtd_jogadores = Integer.parseInt(linha);
				set_num_players(qtd_jogadores);

				linha = linha_arquivo.readLine();
				aux = linha.split(" ");

				arquivo_confidencial[0] = new Card(aux[0], "arma");
				arquivo_confidencial[1] = new Card(aux[1], "personagens");
				arquivo_confidencial[2] = new Card(aux[2], "comodo");

				System.out.printf("turno: %d\ncurrent_player: %s\nqtd_jogadores: %d\n", turn,get_current_player().getCharacter(),qtd_jogadores);
				int u = 0;
				for(Card c : arquivo_confidencial) {
					System.out.printf("arquvivo_confidencial[%d] -> %s\n",u,c.getName());
					u++;
				}

				linha = linha_arquivo.readLine();

				while (linha != null) {


					players[i] = new Player(linha); /* i ou turn?, estou com sono */

					linha = linha_arquivo.readLine();
					x = Integer.parseInt(linha);
					linha = linha_arquivo.readLine();
					y = Integer.parseInt(linha);
					players[i].move(x, y); /* i ou turn?, estou com sono */
					board.set_character(players[i].getCharacter(), x, y);
					linha = linha_arquivo.readLine();
					qtd_cards = Integer.parseInt(linha);
					System.out.printf("players[%d]: %s\n Coordenadas(x,y) = (%d,%d)\n qtd_cards: %d\n",i,players[i].getCharacter(),x,y, qtd_cards);

					for ( p = 0; p < qtd_cards; p++) {
						linha = linha_arquivo.readLine();
						aux = linha.split(" ");
						players[i].addCard(new Card(aux[1], aux[0]));
						System.out.printf("Personagem: %s tem a carta-> %s\n",players[i].getCharacter(),players[i].getCardsArr()[p].getName() );
					}

					for ( p = 0; p < 9; p++) {
						linha=linha_arquivo.readLine();

						if(Objects.equals(linha, "true")) {
							players[i].setNoteOptions(comodos_cartas[p],p);
						}

					}
					for ( p = 0; p < 6; p++) {
						linha=linha_arquivo.readLine();
						if(Objects.equals(linha, "true")) {
							players[i].setNoteOptions(armas_cartas[p],p);
						}
					}
					for ( p = 0; p < 6; p++) {
						linha=linha_arquivo.readLine();
						if(Objects.equals(linha, "true")) {
							players[i].setNoteOptions(personagens[p],p);
						}
					}
					players[i].printNote();

					i++;
					linha = linha_arquivo.readLine();

				}
				JogoClue jogo = new JogoClue();

			} catch (IOException ex) {
				ex.getMessage();
			}
		}
	}

}