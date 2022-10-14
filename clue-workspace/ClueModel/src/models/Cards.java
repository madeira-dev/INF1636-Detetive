package models;

public class Cards implements CardFactory {
	
	private String name;
<<<<<<< HEAD
	public Cards(String name) {this.name=name;}
=======

	public Cards (String name) {
		this.name = name;
	}

>>>>>>> b501ba8a56edcb25c85c5f5fdff56d779f9bd940
	@Override
	public String getName() { return this.name; }
	
	@Override
	public void setName(String name) { this.name = name;}
}
