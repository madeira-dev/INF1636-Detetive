package models;

public class Board {
	Cell[][] cells;
	int width;
	int height;
	private static volatile Board instance = null;
	
	private Board() {}
	
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
				this.cells[i][j] = new Cell();
				if(i == 0 || j == 0 || i == width-1 || j == height-1){
					this.cells[i][j].fora_do_mapa = true;
				}
			}
		}
	}

	public void print_board(){
		for(int i=0; i < width; i++){
			for(int j=0; j < height; j++){
				cells[i][j].print();
			}
			System.out.print("\n");
		}
	}

}

// this is the implementation of double-checked locking singleton
