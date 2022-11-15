package models;
import java.util.Random;

public final class Componentes {
	public static int num_personagens(){return 6;}
	public static int num_armas(){return 6;}
	public static int num_comodos(){return 9;}
	public static Card[] personagens_cartas(){
	Card[] personagens = {
      new Card("Srta. Scarlett", "personagem"),
      new Card("Reverendo Green", "personagem"),
      new Card("Srta. Peacock", "personagem"),
      new Card("Professor Plum", "personagem"),
      new Card("Coronel Mustard", "personagem"),
      new Card("Srta. White", "personagem")
      };
    	return personagens;
	}
	
	public static Card[] armas_cartas() {
		Card[] armas_cartas = {
				new Card("Corda", "arma"),
				new Card("Cano de Chumbo", "arma"),
				new Card("Faca", "arma"),
				new Card("Chave Inglesa", "arma"),
				new Card("Castiçal", "arma"),
				new Card("Revolver", "arma")
				};
	
		return armas_cartas;
		}
	
	public static Card[] comodos_cartas() {
		Card[] comodos_cartas = {
				new Card("Billard Room", "comodo"),
				new Card("Library", "comodo"),
				new Card("Study", "comodo"),
				new Card("Hall", "comodo"),
				new Card("Lounge", "comodo"),
				new Card("Dining Room", "comodo"),
				new Card("Kitchen", "comodo"),
				new Card("Ball Room", "comodo"),
				new Card("Conservatory", "comodo")
				};
		return comodos_cartas;
		}

	public static Card[] arquivo_confidencial() {
		Random result = new Random();
		Card[] arquivo = new Card[3];
		int index_suspeito,index_comodo,index_arma;
		Card[]armas = armas_cartas();
		Card[]personagens = personagens_cartas();
		Card[]comodos = comodos_cartas();
		
		index_suspeito = result.nextInt(6);
		index_arma = result.nextInt(6);
		index_comodo = result.nextInt(9);
		
		arquivo[0] = armas[index_arma];
		arquivo[1] = personagens[index_suspeito];
		arquivo[2] = comodos[index_comodo];
		
		return arquivo;
		
	}
	
}

