package main;
import models.*;

public class Main {
	public static void main(String[] args) {
		Board b = Board.getInstance();
		b.init_players(3);
		b.add_player("Thiago", "Coronel Mustard");
		b.add_player("Rafael", "Professor Plum");
		b.add_player("Madeira", "Srta. Scarlett");

		b.gera_arquivo();
		b.deal_cards();
		System.out.println("Cartas do jogador 0:");
		for(Card card : b.getPlayers()[0].getCardsArr()){
			System.out.println(card.getName());
		}
		Card[] teste = new Card[]{Componentes.armas_cartas()[0], Componentes.comodos_cartas()[0], Componentes.comodos_cartas()[0]};
		Card[] possui = b.getPlayers()[0].possui_algum(teste);

		for(Card c: possui){
			System.out.println(c.getName());
		}
	}
}
// casssa
// escrevi e sai correndo pau no cu de quem ta lendo
