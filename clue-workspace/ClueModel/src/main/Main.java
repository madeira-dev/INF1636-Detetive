package main;
import models.Board;

public class Main {
	public static void main(String[] args) {
		Board b = Board.getInstance();
		b.generate_grid(6, 6);
		b.print_board();
	}

}
