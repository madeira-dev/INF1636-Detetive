package main;
import models.*;

public class Main {
	public static void main(String[] args) {
		Board b = Board.getInstance();
		b.init_all();
		b.print_board();
	}

}