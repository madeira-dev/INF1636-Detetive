package models;

public interface ObservadorIF {
	
	public void notify_dice_rolled(ObservadoIF observed);
	
	public void notify_player_moved(ObservadoIF observed);
	
	public void notify_notepad_used(ObservadoIF observed);
	
	public void notify_cards_shown(ObservadoIF observed);
}
