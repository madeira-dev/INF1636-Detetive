package view;

import models.Card;
import models.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ShowCard extends JFrame {
	JLabel texto;
	Image imagem;

	ShowCard(Card carta, Player mostrador) throws IOException {
		this.setLayout(new BorderLayout());
		texto = new JLabel(String.format("%s te mostrou %s", mostrador.getCharacter(), carta.getName()),
				SwingConstants.CENTER);
		texto.setBounds(0, 0, 400, 50);
		// imagem = ImageIO.read(new
		// File(String.format("clue-workspace/ClueModel/imagens/Armas/Cano.jpg",
		// carta.get_folder(), carta.getName())));
		imagem = ImageIO.read(new File(String.format("imagens/%s/%s.jpg", carta.get_folder(), carta.getName())));

		this.add(texto, BorderLayout.PAGE_START);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(500, 400);
		this.setVisible(true);
		this.setTitle("Receber Carta");

	}

	public void paint(Graphics g2d) {
		super.paint(g2d);
		g2d.drawImage(imagem, 170, 100, this);
	}

}
