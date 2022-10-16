package models;

interface PlayerFactory {
	
	public String getName();
	
	public String getCharacter();

	public void addCard(Card _card);
	public Card[] getCardsArr();
}
