package models;

public class Cards implements CardFactory {
	
	private String name;
	public Cards(String name) {this.name=name;}
	@Override
	public String getName() { return this.name; }
	
	@Override
	public void setName(String name) { this.name = name; }
	
//	private static volatile Cards instance = null;
//	
//	private Cards() {}
//	
//	public static Cards getInstance() {
//		if (instance == null) {
//			
////			making thread safe
//			synchronized (Cards.class) {
////				check again as multiple threads can reach above step
//				if (instance == null)
//					instance = new Cards();
//			}
//		}
//		return instance;
//	}
}
