package models;

import static org.junit.Assert.*;
import org.junit.Test;
import models.Card;

public class Card_tests {
	
	@Test
	public void test_getName() {
		String card_name = "sus";
		Card test_card = new Card(card_name);
		
		String expected = test_card.getName();
		String actual = card_name;
		
		assertEquals(expected, actual);
		
	}
}
