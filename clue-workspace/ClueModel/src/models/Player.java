package models;

import java.util.Arrays;
import java.util.Objects;
import models.API;

public class Player implements PlayerFactory {
	private Player vizinho;
	private final String character;
	private final String nome;
	private int[] coord;
	private Notepad note = new Notepad();
	private Card[] cardsArr = new Card[0];
	public Player (String character, String nome) {
		this.nome = nome;
		this.character = character;
		switch (character) {
		case "Reverendo Green": {
			coord = new int[] { 10, 25 };
			break;
		}
		case "Coronel Mustard": {
			coord = new int[] { 24, 8 };
			break;
		}
		case "Srta. Peacock": {
			coord = new int[] { 1, 19 };
			break;
		}
		case "Professor Plum": {
			coord = new int[] { 1, 6 };
			break;
		}
		case "Srta. Scarlett": {
			coord = new int[] { 17, 1 };
			break;
		}
		case "Srta. White": {
			coord = new int[] { 15, 25 };
			break;
		}
		}
	}

	public void setNoteOptions(String card, String type) {note.setTrue(card, type);}

	public Boolean[] getNoteOptionsWeapons() {return note.getWeapons();}
	public Boolean[] getNoteOptionsRooms() {return note.getRooms();}
	public Boolean[] getNoteOptionsSuspects() {return note.getSuspects();}

	public void printNote() {note.printRooms();note.printWeapons();note.printSuspects();}

	@Override
	public Card[] getCardsArr() { return cardsArr; }

	public String[] get_card_by_type(String type) {
		int counter = 0;
		String[] cards = new String[cardsArr.length];
		for (int i = 0; i < cardsArr.length; i++) {
			if (Objects.equals(cardsArr[i].getType(), type)) {
				cards[counter] = cardsArr[i].getName();
				counter++;
			}
		}
		cards = Arrays.copyOf(cards, counter);
		return cards;
	}

	@Override
	public String getCharacter() {
		return this.character;
	}

	public String get_name(){return this.nome;}
	@Override
	public void addCard(Card _card) {
		Card[] newArray = Arrays.copyOf(cardsArr, cardsArr.length + 1);
		newArray[cardsArr.length] = _card;

		cardsArr = newArray;
	}

	public Card[] possui_algum(String[] cards) {
		Card[] possui = new Card[0];
		for (Card c : cardsArr) {
			for (String card : cards) {
				if (Objects.equals(c.getName(), card)) {
					possui = Arrays.copyOf(possui, possui.length + 1);
					possui[possui.length - 1] = c;
				}
			}
		}
		return possui;
	}

	public Player getVizinho() {
		return this.vizinho;
	}

	public void setVizinho(Player vizinho) {
		this.vizinho = vizinho;
	}

	public int[] get_coord() {
		return coord;
	}

	public void move(int x, int y) {
		coord[0] = x;
		coord[1] = y;
	}
}
