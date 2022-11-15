package view;

import java.awt.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.imageio.ImageIO.*;
import javax.swing.*;
import models.API;

public class PlayerCards extends JFrame {
	public final int width = 900;
	public final int height = 650;
	public API players_cards_api = new API();
	public Object[] cards_arr;
	
	JLabel label_comodo = new JLabel("Comodo(s)");
	JLabel label_arma = new JLabel("Arma(s)");
	
	Image image_arma;
	Image image_comodo;
	
	
	
	public PlayerCards() {
		
		
		cards_arr=players_cards_api.getCardsArray();
		
		try {
		  	   File arma = new File("imagens/Armas/Cano.jpg");
		  	   File comodo = new File("imagens/Comodos/Biblioteca.jpg");
	           image_arma = ImageIO.read(arma);
	           image_comodo = ImageIO.read(comodo);
	       }
	       catch(IOException exception) {
	           System.out.println(exception.getMessage());
	       }
		
		this.setTitle("cards");
		this.setVisible(true);
		
		this.setSize(width, height);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(null);
		
		label_comodo.setBounds(0, 0, 0, 0);
		label_arma.setBounds(100, 360, 100, 100);
		
		this.add(label_comodo);
		this.add(label_arma);
		
		label_comodo.setVisible(true);
		label_arma.setVisible(true);
		
	}
	public void paint(Graphics g) {
		   Graphics2D g2D = (Graphics2D) g;
	      g2D.drawImage(image_arma,50,50,this);
	      g2D.drawImage(image_comodo, 50, 350, this);
	}
}
