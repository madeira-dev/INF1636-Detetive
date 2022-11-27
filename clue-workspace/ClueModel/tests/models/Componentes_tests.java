//// a principio deletar esse arquivo de testes porque a classe é static
//
//package models;
//
//import static org.junit.Assert.*;
//
//import models.Card;
//import models.Componentes;
//
//import org.junit.Test;
//
//public class Componentes_tests {
//
//	@Test
//	public void test_personagens_cartas() {
//		Card[] actual = Componentes.personagens_cartas();
//		Card[] expected = {
//				new Card("Srta. Scarlett"),
//				new Card("Reverendo Green"),
//				new Card("Srta. Peacock"),
//				new Card("Professor Plum"),
//				new Card("Coronel Mustard"),
//				new Card("Srta. White")
//				};
//		
//		for (int i = 0; i < expected.length; i++) {
//			assertEquals(expected[i].getName(), actual[i].getName());
//		}			
//	}
//
//	@Test
//	public void test_armas_cartas() {
//		Card[] actual = Componentes.armas_cartas();
//		Card[] expected = {
//				new Card("Corda"),
//				new Card("Cano de Chumbo"),
//				new Card("Faca"),
//				new Card("Chave Inglesa"),
//				new Card("Castiçal"),
//				new Card("Revolver")
//			    };
//		
//		for (int i = 0; i < expected.length; i++) {
//			assertEquals(expected[i].getName(), actual[i].getName());
//		}
//	}
//	
//	@Test
//	public void test_comodos_cartas() {
//		Card[] actual = Componentes.comodos_cartas();
//		Card[] expected = {
//				new Card("Billard Room"),
//				new Card("Library"),
//				new Card("Study"),
//				new Card("Hall"),
//				new Card("Lounge"),
//				new Card("Dining Room"),
//				new Card("Kitchen"),
//				new Card("Ball Room"),
//				new Card("Conservatory")
//			    };
//		
//		for (int i = 0; i < expected.length; i++) {
//			assertEquals(expected[i].getName(), actual[i].getName());
//			}
//		}
//	}