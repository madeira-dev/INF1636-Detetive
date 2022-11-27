package view;

import javax.imageio.ImageIO;

import javax.swing.*;

import controller.Controller;
import models.API;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class SelecaoPersonagem extends JFrame implements ActionListener {

	Image img_menu;
	JPanel p;

	JCheckBox scarlett = new JCheckBox("Mrs. Scarlett");
	JCheckBox mustard = new JCheckBox("Coronel Mustard");
	JCheckBox white = new JCheckBox("Mrs. White");
	JCheckBox peacock = new JCheckBox("Mrs. Peacock");
	JCheckBox plum = new JCheckBox("Prof. Plum");
	JCheckBox green = new JCheckBox("Rev. Green");
	JTextField[] nomes = new JTextField[6];

	JButton jogar = new JButton("Jogar");

	public SelecaoPersonagem() {
		for(int i=0; i < 6; i++){
			nomes[i] = new JTextField();
		}
		try {
			img_menu = ImageIO.read(new File("imagens/Tabuleiros/CluePersonagens.png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		p = new MyPanel(img_menu);
		jogar.setBounds(600, 440, 150, 40);
		jogar.addActionListener(this);
		scarlett.setBounds(600, 190, 150, 40);
		green.setBounds(600, 230, 150, 40);
		white.setBounds(600, 270, 150, 40);
		mustard.setBounds(600, 310, 150, 40);
		plum.setBounds(600, 350, 150, 40);
		peacock.setBounds(600, 390, 150, 40);

		for(int i=0; i < 6; i++){
			nomes[i].setBounds(750, 190 + 40*i, 150, 40);
			this.add(nomes[i]);
		}
		// nova_partida.setBounds(700,370,150,40);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setSize(966, 700);
		this.setVisible(true);
		this.setTitle("Seleção Personagem");

		this.add(jogar);
		this.add(scarlett);
		this.add(green);
		this.add(white);
		this.add(mustard);
		this.add(plum);
		this.add(peacock);
	}

	public void actionPerformed(ActionEvent e) {
		inicia_jogo();
		this.dispose();
	}

	public void inicia_jogo() {
		if (scarlett.isSelected()) {
			API.add_player("Srta. Scarlett", nomes[0].getText(), Controller.get_num_players());
			Controller.alter_num_players(1);
		}
		if (green.isSelected()) {
			API.add_player("Reverendo Green", nomes[1].getText(), Controller.get_num_players());
			Controller.alter_num_players(1);
		}
		if (white.isSelected()) {
			API.add_player("Srta. White", nomes[2].getText(), Controller.get_num_players());
			Controller.alter_num_players(1);
		}
		if (mustard.isSelected()) {
			API.add_player("Coronel Mustard", nomes[3].getText(), Controller.get_num_players());
			Controller.alter_num_players(1);
		}
		if (plum.isSelected()) {
			API.add_player("Professor Plum", nomes[4].getText(), Controller.get_num_players());
			Controller.alter_num_players(1);
		}
		if (peacock.isSelected()) {
			API.add_player("Srta. Peacock", nomes[5].getText(), Controller.get_num_players());
			Controller.alter_num_players(1);
		}
		if (Controller.get_num_players() >= 3) {
			new JogoClue();
			API.init_all();
		}
	}

	public void paint(Graphics g2d) {
		super.paint(g2d);
		g2d.drawImage(img_menu, 0, 55, this);

	}

}
