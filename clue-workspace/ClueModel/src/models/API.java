package models;

public class API {
	private  Player[] playersArr;
	private Card[] cardsArr;
	
	public Player[] getPlayersArray() { return playersArr; }
	
	public void setPlayersArray(Player[] players_arr) { playersArr = players_arr; }
	
	public Card[] getPlayerCardsArray() { return cardsArr; }
	
	public void setPlayerCardsArray(Card[] cards_arr) { cardsArr = cards_arr; }
	}
