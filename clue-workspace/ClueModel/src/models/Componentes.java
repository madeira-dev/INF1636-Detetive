package models;
import java.util.Random;

class Componentes {
	
	public static Card[] personagens_cartas(){
	Card[] personagens = {
      new Card("Srta. Scarlett"),
      new Card("Reverendo Green"),
      new Card("Srta. Peacock"),
      new Card("Professor Plum"),
      new Card("Coronel Mustard"),
      new Card("Srta. White")
      };
    	return personagens;
	}
	
	public static Card[] armas_cartas() {
		Card[] armas_cartas = {
				new Card("Corda"),
				new Card("Cano de Chumbo"),
				new Card("Faca"),
				new Card("Chave Inglesa"),
				new Card("Castiçal"),
				new Card("Revolver")
				};
	
		return armas_cartas;
		}
	
	public static Card[] comodos_cartas() {
		Card[] comodos_cartas = {
				new Card("Billard Room"),
				new Card("Library"),
				new Card("Study"),
				new Card("Hall"),
				new Card("Lounge"),
				new Card("Dining Room"),
				new Card("Kitchen"),
				new Card("Ball Room"),
				new Card("Conservatory")
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

