package view;

import controller.Controller;
import models.Componentes;
import models.Player;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

	JogoClue tela_jogo = new JogoClue();
	Controller c = Controller.getInstance();
	ShowCard s = new ShowCard(Componentes.personagens_cartas()[1], new Player("Rafael", "Green"));
	 //SelecaoPersonagem tela_personagem = new SelecaoPersonagem();
	 //MenuClue tela_menu = new MenuClue();

	 // Apenas para teste, irei colocar todas as cartas

//	 PlayerCards cards = new PlayerCards(Componentes.comodos_cartas(), Componentes.armas_cartas(), Componentes.personagens_cartas());

	 // PlayerCards cards = new PlayerCards(Componentes.comodos_cartas(), Componentes.armas_cartas(), Componentes.personagens_cartas());
//	 Transicao t = new Transicao("Plum");
	 //Palpite palpite = new Palpite(true);
	}
}
