package models;
<<<<<<< HEAD
=======

import java.util.Arrays;
>>>>>>> 51c9b2c69e30d85c4bef3b548a21ffea51e2d6ee

public class notepad {

	//	ordem de armas no array: Corda, Cano de Chumbo, Faca, Chave Inglesa, Castiçal, Revólver
	private Boolean[] weapons = {false, false, false, false, false, false};

	//	ordem dos suspeitos no array: Coronel Mustard, Srta. Scarlet, Professor Plum, Reverendo Green, Srta. White, Srta. Peacock
	private Boolean[] suspects = {false, false, false, false, false, false};

	//	ordem dos comodos no array: <não tem os nomes dos comodos ainda>
	private Boolean[] rooms = {false, false, false, false, false, false, false, false, false};

	public void printWeapons() { System.out.println(Arrays.toString(this.weapons)); }
	
	public void printSuspects() { System.out.println(Arrays.toString(this.suspects)); }
	
	public void printRooms() { System.out.println(Arrays.toString(this.rooms)); }
	
	public Boolean[] setTrue(Boolean[] arr, int index) { arr[index] = true; return arr; }
	
	public Boolean[] setFalse(Boolean[] arr, int index) { arr[index] = false; return arr; }
	
}
