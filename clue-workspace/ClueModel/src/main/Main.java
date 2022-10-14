package main;
import models.Board;
import models.Cell;

public class Main {
	public static void main(String[] args) {
		Board b = Board.getInstance();
		b.generate_grid(10, 10);
		b.snip(2, 4, 3, 3);
		b.set_room("Hotel", 3, 3);
		b.set_character("Mordomo James", 7, 7);
		b.print_board();
		Cell a = b.get_cell(7, 7);
		Cell[] moves = new Cell[1000];
		moves[0] = a;
		moves = b.gen_moves(moves, 2, 1);
		for(Cell move: moves){
			if(move == null){
				break;
			}
			move.print_coord();
		}
	}
}
