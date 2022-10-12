package models;

public class Cards {
	private static volatile Cards instance = null;
	
	private Cards() {}
	
	public static Cards getInstance() {
		if (instance == null) {
			
//			making thread safe
			synchronized (Cards.class) {
//				check again as multiple threads can reach above step
				if (instance == null)
					instance = new Cards();
			}
		}
		return instance;
	}
}
