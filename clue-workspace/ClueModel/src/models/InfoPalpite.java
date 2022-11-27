package models;

public class InfoPalpite {
	private final Player player;
	private final Card[] cards;

	public InfoPalpite(Player player, Card[] cards) {
		this.player = player;
		this.cards = cards;
	}

	public String get_name() {
		return cards[0].getName();
	}
	public String get_folder(){
		return cards[0].get_folder();
	}
	public String get_type(){
		return cards[0].getType();
	}
	public Player getPlayer() {
		return player;
	}
}
