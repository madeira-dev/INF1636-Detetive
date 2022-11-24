package models;

import java.util.Arrays;
import java.util.Objects;
import models.API;

public class Player implements PlayerFactory {
	private Player vizinho;
	private String character;
	private Cell cell;
	private Card[] cardsArr = new Card[0];
	public API player_api = new API();

	public Player (String character) {
		this.character = character;
	}

	@Override
	public Card[] getCardsArr() { return cardsArr; }

	public Card[] get_card_by_type(String type) {
		int counter = 0;
		Card[] cards = new Card[cardsArr.length];
		for(int i=0; i < cardsArr.length; i++) {
			if(Objects.equals(cardsArr[i].getType(), type)){
				cards[counter] = cardsArr[i];
				counter++;
			}
		}
		cards = Arrays.copyOf(cards, counter);
		return cards;
	}

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

	public Player getVizinho() { return this.vizinho; }

	public void setVizinho(Player vizinho) { this.vizinho = vizinho; }

	public Cell get_cell() { return cell; }

	public void set_cell(Cell c) { cell = c; }

	public void set_api_cards_arr(Card[] cards_arr) { player_api.setPlayerCardsArray(cards_arr); }
}
