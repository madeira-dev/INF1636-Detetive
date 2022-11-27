package models;

public class InfoPalpite {
	private final Player player;
	private final Card[] cards;

	public InfoPalpite(Player player, Card[] cards) {
		this.player = player;
		this.cards = cards;
	}

	public Card[] getCards() {
		return cards;
	}

	public Player getPlayer() {
		return player;
	}
}
