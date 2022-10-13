package models;

public class Board {
	private static volatile Board instance = null;
	
	private Board() {}
	
	public static Board getInstance() {
		if (instance == null) {
			
//			making thread safe
			synchronized (Board.class) {
//				check again as multiple threads can reach above step
				if (instance == null)
					instance = new Board();
			}
		}
		return instance;
	}
}

// this is the implementation of double checked locking singleton
