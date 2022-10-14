package models;
import java.util.Random;
import models.Cards;

public class Componentes{
	
	public Cards[] personagens_cartas(){
	Cards[] personagens = {
      new Cards("Srta. Scarlett"),
      new Cards("Reverendo Green"),
      new Cards("Srta. Peacock"),
      new Cards("Professor Plum"),
      new Cards("Coronel Mustard"),
      new Cards("Srta. White")
      };
    	return personagens;
	}
	
	public Cards[] armas_cartas() {
		
	Cards[] armas_cartas = {
      new Cards("Corda"),
      new Cards("Cano de Chumbo"),
      new Cards("Faca"),
      new Cards("Chave Inglesa"),
      new Cards("Castiçal"),
      new Cards("Revolver")
    };
	return armas_cartas;
	
	}
	public Cards[] comodos_cartas() {
		
		Cards[] comodos_cartas = {
	      new Cards("Billard Room"),
	      new Cards("Library"),
	      new Cards("Study"),
	      new Cards("Hall"),
	      new Cards("Lounge"),
	      new Cards("Dining Room"),
	      new Cards("Kitchen"),
	      new Cards("Ball Room"),
	      new Cards("Conservatory")
	    };
    
		return comodos_cartas;
  }
	public int dados() {
		Random result = new Random();
		int val,val1=1,val2=1;
		
		val1 += result.nextInt(6);
		val2 += result.nextInt(6);
		
		val = val1 + val2;
		
		return val;
	}

	public Cards[] arquivo_confidencial()
	{
		Random result = new Random();
		Cards[] arquivo = new Cards[3];
		int index_suspeito,index_comodo,index_arma;
		Cards[]armas = armas_cartas();
		Cards[]personagens = personagens_cartas();
		Cards[]comodos = comodos_cartas();
		
		index_suspeito = result.nextInt(6);
		index_arma = result.nextInt(6);
		index_comodo = result.nextInt(9);
		
		arquivo[0] = armas[index_arma];
		arquivo[1] = personagens[index_suspeito];
		arquivo[2] = comodos[index_comodo];
		
		return arquivo;
		
	} 
	
	
}

