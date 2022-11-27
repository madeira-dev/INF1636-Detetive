package view;

import java.awt.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class PlayerCards extends JFrame {
	public final int width = 900;
	public final int height = 700;
	File[] images_arma;
	File[] images_comodo;
	File[] images_personagens;

	public PlayerCards(String[] comodos, String[] armas, String[] personagens) {

		images_arma = new File[armas.length];
		images_comodo = new File[comodos.length];
		images_personagens = new File[personagens.length];

		for (int i = 0; i < armas.length; i++) {
			System.out.println(armas[i]);
			images_arma[i] = new File(String.format("imagens/Armas/%s.jpg", armas[i]));
		}
		for (int i = 0; i < personagens.length; i++) {
			images_personagens[i] = new File(String.format("imagens/Suspeitos/%s.jpg", personagens[i]));
		}
		for (int i = 0; i < comodos.length; i++) {
			images_comodo[i] = new File(String.format("imagens/Comodos/%s.jpg", comodos[i]));
		}

		this.setTitle("cards");
		this.setVisible(true);

		this.setSize(width, height);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(null);

	}

	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		for (int i = 0; i < images_arma.length; i++) {
			try {
				g2D.drawImage(ImageIO.read(images_arma[i]), width * i / 9, 0, this);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		for (int i = 0; i < images_comodo.length; i++) {
			try {
				g2D.drawImage(ImageIO.read(images_comodo[i]), width * i / 9, height / 3, this);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		for (int i = 0; i < images_personagens.length; i++) {
			try {
				g2D.drawImage(ImageIO.read(images_personagens[i]), width * i / 9, height * 2 / 3, this);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
