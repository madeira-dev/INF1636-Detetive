package models;

public class Players {
	private static volatile Players instance = null;
	
	private Players() {}
	
	public static Players getInstance() {
		if (instance == null) {
			
//			making thread safe
			synchronized (Players.class) {
//				check again as multiple threads can reach above step
				if (instance == null)
					instance = new Players();
			}
		}
		return instance;
	}
}
