package models;

public class Cards implements CardFactory {
	
	private String name;

	public Cards (String name) {
		this.name = name;
	}

	@Override
	public String getName() { return this.name; }

}
