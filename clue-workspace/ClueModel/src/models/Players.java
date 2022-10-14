package models;

import java.util.Arrays;

public class Players implements PlayerFactory {
	
	private String name;
	private String character;
	private Cards cardsArr[] = new Cards[0];
	
	@Override
	public String getName() { return this.name; }
	
	@Override
	public void setName(String name) { this.name = name; }
	
	@Override
	public String getCharacter() { return this.character; }

	@Override
	public void setCharacter(String character) { this.character = character; }
	
	@Override
	public void addCard(Cards _card) {
		Cards newArray[] = Arrays.copyOf(cardsArr, cardsArr.length + 1);
		newArray[cardsArr.length] = _card;
		
		cardsArr = newArray;
	}
}
