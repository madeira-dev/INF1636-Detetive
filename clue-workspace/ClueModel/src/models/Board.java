package models;

import java.util.Arrays;
import java.util.Objects;
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
	) {num_players = 0;
		this.width = 26;
		this.height = 26;}
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
	public Player[] getPlayers(){
		return players;
	}
	public void init_all(){
		generate_grid(width, height);
		init_players(3);
		add_player("Thiago", "Coronel Mustard");
		add_player("Rafael", "Professor Plum");
		add_player("Madeira", "Srta. Scarlett");
		set_neighbors();

		gera_arquivo();
		deal_cards();
		//Study
		snip(1, 1, 7, 4);
		set_room("Study",7,4);
		configura_passagem(7,20,4,19);
		//Hall
		snip(10, 1, 6, 6);
		snip(9, 1, 1, 1);
		snip(16, 1, 1, 1);
		set_room("Hall",10,4);
		set_room("Hall",13,6);
		set_room("Hall",12,6);
		//Lounge
		snip(18, 1, 7, 6);
		set_room("Lounge", 18, 6);

		//Library
		snip(1, 7, 6, 5);
		snip(7, 8, 1, 3);
		snip(1, 5, 1, 1);
		set_room("Library", 7, 9);
		set_room("Library", 3, 11);

		//Meio do Mapa
		snip(10, 8, 5, 7);

		//Dining Room
		snip(17, 10, 8, 6);
		snip(24, 9, 1, 1);
		snip(24, 7, 1, 1);
		snip(20,16,5,1);
		set_room("Dining Room", 18, 10);
		set_room("Dining Room", 17, 13);

		//Kitchen
		snip(24,17,1,1);
		snip(19,19,6,6);
		snip(18,24,1,1);
		snip(16,23,1,1);
		set_room("Kitchen", 20, 19);
		//Ball Room
		snip(9,18,8,6);
		snip(11,24,4,1);
		set_room("Ball Room", 15, 18);
		set_room("Ball Room", 10, 18);
		set_room("Ball Room", 9, 20);
		set_room("Ball Room", 16, 20);

		//Conservatory
		snip(1,20,5,5);
		snip(6,21,1,4);
		set_room("Conservatory", 5, 20);
		snip(7,24,1,1);
		configura_passagem(5,18,20,16);

		//Billard Room
		snip(1,13,5,5);
		snip(1,18,1,1);
		set_room("Billard Room",1,13);
		set_room("Billard Room",5,16);



	}
	public void generate_grid(int width, int height){
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
	public int getNum_players(){
		return num_players;
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
		cells[x][y].coloca_no_mapa();
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
	public void set_neighbors(){
		for(int i=0; i < num_players; i++){
			players[i].setVizinho(players[(i + 1) % num_players]);
		}
	}
	public void deal_cards(){
		int i = 0;
		boolean[] ja_usado = new boolean[18];
		Card[] cards = new Card[18];
		Card[] suspeitos = Componentes.personagens_cartas();
		Card[] armas = Componentes.armas_cartas();
		Card[] locais = Componentes.comodos_cartas();

		for(Card sus : suspeitos){
			if(!Objects.equals(sus.getName(), arquivo_confidencial[1].getName())){
				cards[i] = sus;
				i++;
			}
		}
		for(Card arma : armas){
			if(!Objects.equals(arma.getName(), arquivo_confidencial[0].getName())){
				cards[i] = arma;
				i++;
			}
		}
		for(Card local : locais){
			if(!Objects.equals(local.getName(), arquivo_confidencial[2].getName())){
				cards[i] = local;
				i++;
			}
		}
		for(int j=0; j < 18; j++){
			ja_usado[j] = false;
		}

		Random result = new Random();
		int val;
		for(int j=0; j < 18; j++){
			val = result.nextInt(18);
			while (true){
				if(!ja_usado[val]){
					players[j % num_players].addCard(cards[val]);
					ja_usado[val] = true;
					break;
				}
				else{
					val = (val + 1) % 18;
				}
			}
		}

	}
	public Card[] guess(Player guesser, Card[] cards){
		Player temp = guesser.getVizinho();
		Card[] options = new Card[0];
		while (!Objects.equals(temp.getName(), guesser.getName())){
			options = temp.possui_algum(cards);
			System.out.printf("%s pode mostrar\n", temp.getName());
			for(Card c: options){
				System.out.println(c.getName());
			}
			if(options.length != 0){
				return options;
			}
			temp = temp.getVizinho();
		}
		return options;
	}

	public void configura_passagem(int x1, int x2, int y1, int y2){
		cells[x1][y1].configura_passagem(cells[x2][y2]);
		cells[x2][y2].configura_passagem(cells[x1][y1]);
	}
}