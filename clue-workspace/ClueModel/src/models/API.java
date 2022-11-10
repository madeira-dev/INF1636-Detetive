package models;

public class API {
	private static Player[] playersArr;
	private static Card[] cardsArr;
	
	public static Player[] getPlayersArray() { return playersArr; }
	
	public static void setPlayersArray(Player[] players_arr) { playersArr = players_arr; }
	
	public static Card[] getCardsArray() { return cardsArr; }
	
	public static void setCardsArray(Card[] cards_arr) { cardsArr = cards_arr; }
	}
