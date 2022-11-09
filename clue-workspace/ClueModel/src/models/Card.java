package models;

class Card implements CardFactory {
	private String name;

	public Card(String name) { this.name=name; }

	@Override
	public String getName() { return this.name; }
}
