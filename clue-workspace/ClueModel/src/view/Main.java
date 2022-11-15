package view;

import controller.Controller;
import models.Componentes;

public class Main {

	public static void main(String[] args) {
		Controller c = Controller.getInstance();
	 //JogoClue tela_jogo = new JogoClue();
	 //SelecaoPersonagem tela_personagem = new SelecaoPersonagem();
	 //MenuClue tela_menu = new MenuClue();

	 // Apenas para teste, irei colocar todas as cartas
	 // PlayerCards cards = new PlayerCards(Componentes.comodos_cartas(), Componentes.armas_cartas(), Componentes.personagens_cartas());
	 Transicao t = new Transicao("Plum");
	 //Palpite palpite = new Palpite(true);
	}
}
