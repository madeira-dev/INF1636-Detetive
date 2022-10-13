package models;

public interface PlayerFactory {
	
	public String getName();
	
	public void setName(String name);
	
	public String getCharacter();
	
	public void setCharacter(String character);

	public void addCard(Cards _card);

}
