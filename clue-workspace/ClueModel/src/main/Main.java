package main;
import models.Board;

public class Main {
	public static void main(String[] args) {
		Board b = Board.getInstance();
		b.generate_grid(3, 3);
		b.cells[0][0].print();
	}

}
