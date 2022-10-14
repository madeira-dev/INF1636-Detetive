package main;

public class notepad {

	//	ordem de armas no array: Corda, Cano de Chumbo, Faca, Chave Inglesa, Castiçal, Revólver
	private Boolean[] weapons = {false, false, false, false, false, false};

	//	ordem dos suspeitos no array: Coronel Mustard, Srta. Scarlet, Professor Plum, Reverendo Green, Srta. White, Srta. Peacock
	private Boolean[] suspects = {false, false, false, false, false, false};

	//	ordem dos comodos no array: <não tem os nomes dos comodos ainda>
	private Boolean[] rooms = {false, false, false, false, false, false, false, false, false};

	public void printWeapons() { System.out.println(this.weapons); }
	
	public void printSuspects() { System.out.println(this.suspects); }
	
	public void printRooms() { System.out.println(this.rooms); }
	
	public Boolean[] setTrue(Boolean[] arr, int index) { arr[index] = true; return arr; }
	
	public Boolean[] setFalse(Boolean[] arr, int index) { arr[index] = false; return arr; }
	
}
