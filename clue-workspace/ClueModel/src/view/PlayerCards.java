package view;

import java.awt.*;
import java.awt.event.*;
import java.util.IllegalFormatWidthException;

import javax.swing.*;

public class PlayerCards extends JFrame {
	public final int width = 750;
	public final int height = 600;
	
	public PlayerCards() {
		setSize(width, height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		JLabel l = new JLabel("Comodo(s)");
		JLabel l2 = new JLabel("Arma(s)");
		l.setIcon(new ImageIcon("/home/madeira/Documents/PUC/INF1636-Detetive/clue-workspace/ClueModel/src/view/Comodos/SalaDeMusica.jpg"));
		l2.setIcon(new ImageIcon("/home/madeira/Documents/PUC/INF1636-Detetive/clue-workspace/ClueModel/src/view/Armas/Revolver.jpg"));
		getContentPane().add(l);
		getContentPane().add(l2);
//		pack();
		l.setVisible(true);
		l2.setVisible(true);
	}

	public static void main(String[] args) {
		PlayerCards cards = new PlayerCards();
		cards.setTitle("cards");
		cards.setVisible(true);
	}
}
