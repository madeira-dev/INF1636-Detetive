package main;
import models.Board;
import models.Card;
import models.Cell;
import models.Player;

public class Main {
	public static void main(String[] args) {
		Board b = Board.getInstance();
		b.init_players(3);
		b.add_player("Thiago", "Coronel Mustard");
		b.add_player("Rafael", "Professor Plum");
		b.add_player("Madeira", "Srta. Scarlett");

		b.gera_arquivo();
		b.deal_cards();

		for(Card card : b.getPlayers()[0].getCardsArr()){
			System.out.println(card.getName());
		}
	}
}
// casssa
// escrevi e sai correndo pau no cu de quem ta lendo
