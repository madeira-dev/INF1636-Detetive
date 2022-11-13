package models;

public interface ObservadorIF {
	public void notify_dice_rolled(ObservadoIF obj);
	
	public void notify_player_moved(ObservadoIF obj);
}
