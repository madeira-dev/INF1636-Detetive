//// a principio deletar esse aquivo porque notepad ta static
//package models;
//
//import static org.junit.Assert.*;
//import models.Notepad;
//import org.junit.Test;
//
//public class Notepad_tests {
//
//	@SuppressWarnings("deprecation")
//	@Test
//	public void setTrue() {
//		// testando se a posicao passada no array torna-se true
//		Notepad notepad = new Notepad();
//		Boolean[] arr1 = {false, false, false, false, false, false};
//		
//		Boolean[] actual1 = notepad.setTrue(arr1, 0);
//		Boolean[] expected1 = {true, false, false, false, false, false};
//		assertEquals(expected1, actual1);
//	}
//	
//	@SuppressWarnings("deprecation")
//	@Test
//	public void setFalse() {
//		// testando se a posicao passada no array torna-se false
//		Notepad notepad = new Notepad();
//		Boolean[] arr1 = {true, true, true, true, true, true};
//		
//		Boolean[] actual1 = notepad.setFalse(arr1, 1);
//		Boolean[] expected1 = {true, false, true, true, true, true};
//		
//		assertEquals(expected1, actual1);
//	}
//
//}
