package view;

import controller.Controller;
import models.*;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

	//JogoClue tela_jogo = new JogoClue();
	Controller c = Controller.getInstance();
	//ShowCard s = new ShowCard(Componentes.personagens_cartas()[1], new Player("Rafael", "Green"));
	 SelecaoPersonagem tela_personagem = new SelecaoPersonagem();
	 //MenuClue tela_menu = new MenuClue();
	Card [] array = new Card[3];
	array [0]= new Card("Cano","Arma");
	array [1]= new Card("Entrada","Comodo");
	array [2]= new Card("Scarlet","Suspeito");
	
	InfoPalpite inf = new InfoPalpite(new Player("Rafael", "Green"),array);

	 // Apenas para teste, irei colocar todas as cartas
	//MostrarCartasJogador j = new MostrarCartasJogador(inf);
//	 PlayerCards cards = new PlayerCards(Componentes.comodos_cartas(), Componentes.armas_cartas(), Componentes.personagens_cartas());

	 // PlayerCards cards = new PlayerCards(Componentes.comodos_cartas(), Componentes.armas_cartas(), Componentes.personagens_cartas());
//	 Transicao t = new Transicao("Plum");
	 //Palpite palpite = new Palpite(true);
	}
}
