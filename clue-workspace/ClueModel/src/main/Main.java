package main;
import models.Board;

public class Main {
	public static void main(String[] args) {
<<<<<<< HEAD
		Componentes personagem = new Componentes();
		int dado = personagem.dados();
		System.out.printf("%s", dado);
	}
=======
		Board b = Board.getInstance();
		b.generate_grid(10, 10);
		b.snip(2, 4, 3, 3);
		b.set_room("Hotel", 3, 3);
		b.set_character("Mordomo James", 7, 7);
		b.print_board();
>>>>>>> b501ba8a56edcb25c85c5f5fdff56d779f9bd940

	}
}
