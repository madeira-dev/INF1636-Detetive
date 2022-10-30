package view;

import java.awt.*;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.imageio.ImageIO.*;
import java.io.*;
import javax.swing.*;

import javax.swing.*;

public class PlayerCards extends JFrame {
	public final int width = 900;
	public final int height = 650;
	JLabel label_comodo = new JLabel("Comodo(s)");
	JLabel label_arma = new JLabel("Arma(s)");
	ImageIcon arma = new ImageIcon("/home/madeira/Documents/PUC/INF1636-Detetive/clue-workspace/ClueModel/src/view/Armas/Faca.jpg");
	ImageIcon comodo = new ImageIcon("/home/madeira/Documents/PUC/INF1636-Detetive/clue-workspace/ClueModel/src/view/Comodos/Entrada.jpg");
	
	JLabel imagem_arma = new JLabel(arma);
	JLabel imagem_comodo = new JLabel(comodo);
	
	public PlayerCards() {
		
		this.setSize(width, height);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		
		label_comodo.setBounds(100, 100, 100, 100);
		imagem_comodo.setBounds(200, 20, 150, 240);

		label_arma.setBounds(100, 360, 100, 100);
		imagem_arma.setBounds(200, 300, 175, 275);
		

		this.add(label_comodo);
		this.add(label_arma);
		this.add(imagem_arma);
		this.add(imagem_comodo);
		
		label_comodo.setVisible(true);
		label_arma.setVisible(true);
		imagem_arma.setVisible(true);
		imagem_comodo.setVisible(true);
	}

	public static void main(String[] args) {
		PlayerCards cards = new PlayerCards();
		cards.setTitle("cards");
		cards.setVisible(true);
	}
}
