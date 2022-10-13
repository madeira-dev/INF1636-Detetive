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

//	private static volatile Players instance = null;
//	
//	private Players() {}
//	
//	public static Players getInstance() {
//		if (instance == null) {
//			
////			making thread safe
//			synchronized (Players.class) {
////				check again as multiple threads can reach above step
//				if (instance == null)
//					instance = new Players();
//			}
//		}
//		return instance;
//	}
}
