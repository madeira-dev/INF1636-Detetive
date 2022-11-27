package models;

import java.util.Arrays;
import java.util.Objects;

class Notepad {

	// ordem de armas no array: Corda, Cano de Chumbo, Faca, Chave Inglesa,
	// Castiçal, Revólver
	private Boolean[] weapons = { false, false, false, false, false, false };

	// ordem dos suspeitos no array: Coronel Mustard, Srta. Scarlet, Professor Plum,
	// Reverendo Green, Srta. White, Srta. Peacock
	private Boolean[] suspects = { false, false, false, false, false, false };

	// ordem dos comodos no array: <não tem os nomes dos comodos ainda>
	private Boolean[] rooms = { false, false, false, false, false, false, false, false, false };

	public void printWeapons() {
		System.out.println(Arrays.toString(this.weapons));
	}

	public void printSuspects() {
		System.out.println(Arrays.toString(this.suspects));
	}

	public void printRooms() {
		System.out.println(Arrays.toString(this.rooms));
	}

	public Boolean[] getWeapons() {
		return weapons;
	}

	public Boolean[] getSuspects() {
		return suspects;
	}

	public Boolean[] getRooms() {
		return rooms;
	}

	public void setTrue(Card arr, int index) {

		if (Objects.equals(arr.getType(), "comodo")) {
			if (Objects.equals(arr.getName(), "Biblioteca")) {
				rooms[0] = true;
			}
			else if(Objects.equals(arr.getName(), "Entrada")) {
				rooms[2] = true;
			} else if (Objects.equals(arr.getName(), "Escritorio")) {
				rooms[3] = true;
			} else if (Objects.equals(arr.getName(), "JardimInverno")) {
				rooms[4] = true;
			} else if (Objects.equals(arr.getName(), "SalaDeEstar")) {
				rooms[5] = true;
			} else if (Objects.equals(arr.getName(), "SalaDeJantar")) {
				rooms[6] = true;
			} else if (Objects.equals(arr.getName(), "SalaDeMusica")) {
				rooms[7] = true;
			} else if (Objects.equals(arr.getName(), "SalaoDeJogos")) {
				rooms[8] = true;
			} else if (Objects.equals(arr.getName(), "Cozinha")) {
				rooms[1] = true;
			}
		}
		if (Objects.equals(arr.getType(), "personagem")) {

			if (Objects.equals(arr.getName(), "White")) {
				suspects[0] = true;
			}
			else if(Objects.equals(arr.getName(), "Green")) {
				suspects[1] = true;
			} else if (Objects.equals(arr.getName(), "Scarlet")) {
				suspects[2] = true;
			} else if (Objects.equals(arr.getName(), "Plum")) {
				suspects[3] = true;
			} else if (Objects.equals(arr.getName(), "Peacock")) {
				suspects[4] = true;
			} else if (Objects.equals(arr.getName(), "Mustard")) {
				suspects[5] = true;
			}

		}
		if (Objects.equals(arr.getType(), "arma")) {
			if (Objects.equals(arr.getName(), "Cano")) {
				weapons[0] = true;
			}
			else if(Objects.equals(arr.getName(), "Castical")) {
				weapons[1] = true;
			} else if (Objects.equals(arr.getName(), "Corda")) {
				weapons[2] = true;
			} else if (Objects.equals(arr.getName(), "ChaveInglesa")) {
				weapons[3] = true;
			} else if (Objects.equals(arr.getName(), "Faca")) {
				weapons[4] = true;
			} else if (Objects.equals(arr.getName(), "Revolver")) {
				weapons[5] = true;
			}

		}
	}

}
