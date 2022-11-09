package models;

import java.util.Arrays;
import java.util.Objects;

class Player implements PlayerFactory {
	private Player vizinho;
	private final String name;
	private String character;

	private Cell cell;
	private Card[] cardsArr = new Card[0];
	
	public Player (String name, String character) {
		this.name = name;
		this.character = character;
	}

	@Override
	public Card[] getCardsArr(){ return cardsArr; }
	
	@Override
	public String getName() { return this.name; }
	
	@Override
	public String getCharacter() { return this.character; }
	
	public void setCharacter(String name) { this.character = name; }
	
	@Override
	public void addCard(Card _card) {
		Card[] newArray = Arrays.copyOf(cardsArr, cardsArr.length + 1);
		newArray[cardsArr.length] = _card;
		
		cardsArr = newArray;
	}
	public Card[] possui_algum(Card[] cards) {
		Card[] possui = new Card[0];
		for(Card c : cardsArr) {
			for(Card card : cards) {
				if(Objects.equals(c.getName(), card.getName())) {
					possui = Arrays.copyOf(possui, possui.length + 1);
					possui[possui.length - 1] = c;
				}
			}
		}
		return possui;
	}

	public Player getVizinho(){ return this.vizinho; }
	
	public void setVizinho(Player vizinho) { this.vizinho = vizinho; }
	
	public Cell get_cell(){ return cell; }
	
	public void set_cell(Cell c){ cell = c; }
	
}
