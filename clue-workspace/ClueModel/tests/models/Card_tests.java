package models;

import static org.junit.Assert.*;
import org.junit.Test;
import models.Card;

public class Card_tests {
	
	@Test
	public void test_getName() {
		String card_name = "sus";
		String card_type = "suspeito";
		Card test_card = new Card(card_name, card_type);
		
		String expected_name = test_card.getName();
		String expected_type = test_card.getType();
		String actual_name = card_name;
		String actual_type = card_type;
		
		assertEquals(expected_name, actual_name);
		assertEquals(expected_type, actual_type);
		
	}
}
