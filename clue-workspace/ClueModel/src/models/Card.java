package models;

import java.util.Objects;

public class Card implements CardFactory {
	private String name;
	private String type;

	public Card(String name, String type) {
		this.name = name;
		this.type = type;
	}

	@Override
	public String getName() {
		return this.name;
	}

	public String getType() {
		return this.type;
	}

	public String get_folder() {
		if (Objects.equals(this.type, "personagem")) {
			return "Suspeitos";
		} else if (Objects.equals(this.type, "comodo")) {
			return "Comodos";
		} else if (Objects.equals(this.type, "arma")) {
			return "Armas";
		}
		return null;
	}
}
