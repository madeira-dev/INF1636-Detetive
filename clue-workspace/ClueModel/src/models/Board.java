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
	public Player[] getPlayers(){
		return players;
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

	public void order_to_play(){
		Player aux = new Player("Aux","Aux");

		for(int i=0, j=0 ; i<num_players; i++, j++){
			if(Objects.equals(players[i].getName(), "Srta. Scarlett")){
				aux = players[i];
				players[i] = players[0];
				players[0] = players[i];
			}
		}
	}


}