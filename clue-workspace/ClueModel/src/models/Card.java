package models;

public class Card implements CardFactory {
	private String name;
	private String type;
	public Card(String name, String type) { this.name=name; this.type=type;}

	@Override
	public String getName() { return this.name; }

	public String getType(){return this.type;}
}
