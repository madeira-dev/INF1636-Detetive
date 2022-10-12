package models;

class Board {
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


// facade pattern says: "just provide a unified and simplified
// interface to a set of interfaces in a subsystem, therefore it
// hides the complexities of the subsystem from the client"

// every Abstract Factory is a type of facade
// implement facade for cards class?
