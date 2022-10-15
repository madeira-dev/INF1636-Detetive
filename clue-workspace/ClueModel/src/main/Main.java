package main;
import models.*;

public class Main {
	public static void main(String[] args) {
		Board b = Board.getInstance();
		b.init_all();
		b.print_board();
		Cell[] origin = new Cell[100];
		origin[0] = b.get_cell(20, 19);
		Cell[] moves = b.gen_moves(origin, 2, 1);
		for(Cell m:moves){
			if(m == null){
				break;
			}
			m.print_coord();
		}
	}

}