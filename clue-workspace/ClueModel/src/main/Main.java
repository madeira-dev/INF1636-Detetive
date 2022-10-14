package main;

public class Main {
	public static void main(String[] args) {
		Componentes personagem = new Componentes();
		int dado = personagem.dados();
		System.out.printf("%s", dado);
	}

}
