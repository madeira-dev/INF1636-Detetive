package models;

public class Cards implements CardFactory {
	
	private String name;

	@Override
	public String getName() { return this.name; }

	@Override
	public void setName(String name) { this.name = name; }

}
