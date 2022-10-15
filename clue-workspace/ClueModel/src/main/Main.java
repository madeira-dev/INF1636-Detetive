package main;
import models.*;

public class Main {
	public static void main(String[] args) {
		Board b = Board.getInstance();
		b.init_players(3);
		b.add_player("Thiago", "Coronel Mustard");
		b.add_player("Rafael", "Professor Plum");
		b.add_player("Madeira", "Srta. Scarlett");
		b.set_neighbors();

		b.gera_arquivo();
		b.deal_cards();

		for(int i=0; i < b.getNum_players(); i++){
			System.out.printf("Cartas do jogador %d:\n", i);
			for(Card card : b.getPlayers()[i].getCardsArr()){
				System.out.println(card.getName());
			}
			System.out.println();
		}
		Card [] palpite = new Card[3];
		palpite[0] = Componentes.armas_cartas()[1];
		palpite[1] = Componentes.personagens_cartas()[3];
		palpite[2] = Componentes.comodos_cartas()[0];

		System.out.printf("Jogador 1 vai fazer o palpite:\n");
		for(Card p: palpite){
			System.out.println(p.getName());
		}

		b.chuta_palpite(palpite);
		System.out.println();
		Card[] options = b.guess(b.getPlayers()[0], palpite);
	}

}

