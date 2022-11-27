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

	public void setTrue(String card, String tipo) {

		if (Objects.equals(tipo, "comodo")) {
			if (Objects.equals(card, "Biblioteca")) {
				rooms[0] = true;
			}
			else if(Objects.equals(card, "Entrada")) {
				rooms[2] = true;
			} else if (Objects.equals(card, "Escritorio")) {
				rooms[3] = true;
			} else if (Objects.equals(card, "JardimInverno")) {
				rooms[4] = true;
			} else if (Objects.equals(card, "SalaDeEstar")) {
				rooms[5] = true;
			} else if (Objects.equals(card, "SalaDeJantar")) {
				rooms[6] = true;
			} else if (Objects.equals(card, "SalaDeMusica")) {
				rooms[7] = true;
			} else if (Objects.equals(card, "SalaoDeJogos")) {
				rooms[8] = true;
			} else if (Objects.equals(card, "Cozinha")) {
				rooms[1] = true;
			}
		}
		if (Objects.equals(tipo, "personagem")) {

			if (Objects.equals(card, "Srta. Scarlett")) {
				suspects[0] = true;
			}
			else if(Objects.equals(card, "Reverendo Green")) {
				suspects[1] = true;
			} else if (Objects.equals(card, "Srta. Peacock")) {
				suspects[2] = true;
			} else if (Objects.equals(card, "Professor Plum")) {
				suspects[3] = true;
			} else if (Objects.equals(card, "Coronel Mustard")) {
				suspects[4] = true;
			} else if (Objects.equals(card, "Srta. White")) {
				suspects[5] = true;
			}

		}
		if (Objects.equals(tipo, "arma")) {
			if (Objects.equals(card, "Corda")) {
				weapons[0] = true;
			}
			else if(Objects.equals(card, "Cano")) {
				weapons[1] = true;
			} else if (Objects.equals(card, "Faca")) {
				weapons[2] = true;
			} else if (Objects.equals(card, "ChaveInglesa")) {
				weapons[3] = true;
			} else if (Objects.equals(card, "Castical")) {
				weapons[4] = true;
			} else if (Objects.equals(card, "Revolver")) {
				weapons[5] = true;
			}

		}
	}

}
