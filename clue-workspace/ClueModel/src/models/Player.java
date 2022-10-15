package models;

import java.util.Arrays;

public class Player implements PlayerFactory {
	
	private String name;
	private String character;

	private Cell cell;
	private Card cardsArr[] = new Card[0];
	
	public Player (String name, String character) {
		this.name = name;
		this.character = character;
	}
	
	@Override
	public String getName() { return this.name; }
		
	@Override
	public String getCharacter() { return this.character; }
	
	@Override
	public void addCard(Card _card) {
		Card newArray[] = Arrays.copyOf(cardsArr, cardsArr.length + 1);
		newArray[cardsArr.length] = _card;
		
		cardsArr = newArray;
	}
	public void move_to(Cell destination){
		this.cell = destination;
	}
}
