package models;

public class Cards implements CardFactory {
	
	private String name;
	
	public Cards (String name) {
		this.name = name;
	}

	@Override
	public String getName() { return this.name; }

<<<<<<< HEAD
=======
	@Override
	public void setName(String name) { this.name = name; }

>>>>>>> 51c9b2c69e30d85c4bef3b548a21ffea51e2d6ee
}
