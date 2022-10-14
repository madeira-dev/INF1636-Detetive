package main;
import models.Board;

public class Main {
	public static void main(String[] args) {
		Board b = Board.getInstance();
		b.generate_grid(10, 10);
		b.print_board();
		b.snip(2, 4, 3, 3);
		b.print_board();
	}

}
