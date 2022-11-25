package models;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import models.API;

// Implementação lógica do tabuleiro (Precisa ser conectado a uma interface gráfica!!)
public class Board {
	private Cell[][] cells;
	private final int width;
	private final int height;
	private static Board instance = null;

	private Board() {
		this.width = 26;
		this.height = 27;
		generate_grid();
		init_all();
	}
	
	public static Board getInstance() {
		if (instance == null) {
			instance = new Board();
			}
		return instance;
		}

	// Inicializa o tabuleiro com base na imagem fornecida
	public void init_all() {
		//Study
		snip(1, 1, 7, 4);
		set_room("Study",7,4);
		configura_passagem(7,20,4,19);
		
		//Hall
		snip(10, 1, 6, 7);
		snip(9, 1, 1, 1);
		snip(16, 1, 1, 1);
		set_room("Hall",10,5);
		set_room("Hall",13,7);
		set_room("Hall",12,7);
		
		//Lounge
		snip(18, 1, 7, 6);
		set_room("Lounge", 18, 6);

		//Library
		snip(1, 7, 6, 5);
		snip(7, 8, 1, 3);
		snip(1, 5, 1, 1);
		set_room("Library", 7, 9);
		set_room("Library", 4, 11);

		//Meio do Mapa
		snip(10, 9, 5, 7);

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
		configura_passagem(5,18,20,6);

		//Billard Room
		snip(1,13,6,5);
		snip(1,18,1,1);
		snip(1, 12, 1, 1);
		set_room("Billard Room",2,13);
		set_room("Billard Room",6,16);

		// lilfix
		snip(0, 25, 10, 1);
		snip(11, 25, 4, 1);
		snip(16, 25, 10, 1);


		set_character("Coronel Mustard",8,25);
		set_character("Srta. Scarlett",17,0);
		set_character("Reverendo Green",9,25);
		set_character("Srta. Peacock",14,25);
		set_character("Professor Plum",0,6);
		set_character("Srta. White",0,19);
		
	}
	
	public void generate_grid(){
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
	
	private void snip(int x, int y, int width, int height){
		for(int i=x; i < x + width; i++){
			for(int j=y; j < y + height; j++){
				cells[i][j].tira_do_mapa();
			}
		}
	}
	
	private void set_room(String comodo, int x, int y){
		cells[x][y].vira_comodo(comodo);
		cells[x][y].coloca_no_mapa();
	}
	
	private void set_character(String character, int x, int y){
		cells[x][y].aloca_personagem(character);
	}

	
	private void configura_passagem(int x1, int x2, int y1, int y2){
		cells[x1][y1].configura_passagem(cells[x2][y2]);
		cells[x2][y2].configura_passagem(cells[x1][y1]);
	}

	// Printa tabuleiro (usada para debug apenas)
	public void print_board(){
		for(int i=0; i < height; i++){
			for(int j=0; j < width; j++){
				cells[j][i].print();
			}
			System.out.print("\n");
		}
	}
	
	// Getter
	public Cell get_cell(int x, int y){
		return cells[x][y];
	}
	
	// Move jogador
	public void move_player(Player player, Cell destination) {
		player.set_cell(destination);
	}
	}
