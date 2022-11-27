package models;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public final class Componentes {

	public static int num_personagens() {
		return 6;
	}

	public static int num_armas() {
		return 6;
	}

	public static int num_comodos() {
		return 9;
	}

	public static Card[] personagens_cartas() {
		Card[] personagens = { new Card("Scarlet", "personagem"), new Card("Green", "personagem"),
				new Card("Peacock", "personagem"), new Card("Plum", "personagem"), new Card("Mustard", "personagem"),
				new Card("White", "personagem") };
		return personagens;
	}

	public static Card[] armas_cartas() {
		Card[] armas_cartas = { new Card("Corda", "arma"), new Card("Cano", "arma"), new Card("Faca", "arma"),
				new Card("ChaveInglesa", "arma"), new Card("Castical", "arma"), new Card("Revolver", "arma") };

		return armas_cartas;
	}

	public static Card[] comodos_cartas() {
		Card[] comodos_cartas = { new Card("Biblioteca", "comodo"), new Card("Cozinha", "comodo"),
				new Card("Entrada", "comodo"), new Card("Escritorio", "comodo"), new Card("JardimInverno", "comodo"),
				new Card("SalaDeEstar", "comodo"), new Card("SalaDeJantar", "comodo"),
				new Card("SalaDeMusica", "comodo"), new Card("SalaoDeJogos", "comodo") };
		return comodos_cartas;
	}

	public static Card[] arquivo_confidencial() {
		Random result = new Random();
		Card[] arquivo = new Card[3];
		int index_suspeito, index_comodo, index_arma;
		Card[] armas = armas_cartas();
		Card[] personagens = personagens_cartas();
		Card[] comodos = comodos_cartas();

		index_suspeito = result.nextInt(6);
		index_arma = result.nextInt(6);
		index_comodo = result.nextInt(9);

		arquivo[0] = armas[index_arma];
		arquivo[1] = personagens[index_suspeito];
		arquivo[2] = comodos[index_comodo];
		for (int i = 0; i < 3; i++) {
			System.out.println(arquivo[i].getName());
		}
		return arquivo;
	}

	public static Card get_room_by_name(String name) {
		for (Card c : comodos_cartas()) {
			if (Objects.equals(c.getName(), name)) {
				return c;
			}
		}
		return null;
	}

}
