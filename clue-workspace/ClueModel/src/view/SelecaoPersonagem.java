package view;

import javax.imageio.ImageIO;

import javax.swing.*;

import controller.Controller;
import models.Player;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;



public class SelecaoPersonagem extends JFrame implements ActionListener{

    Image img_menu;
    JPanel p;
    JCheckBox scarlett= new JCheckBox("Mrs. Scarlett");
    JCheckBox mustard= new JCheckBox("Coronel Mustard");
    JCheckBox white= new JCheckBox("Mrs. White");
    JCheckBox peacock= new JCheckBox("Mrs. Peacock");
    JCheckBox plum= new JCheckBox("Prof. Plum");
    JCheckBox green= new JCheckBox("Rev. Green");


    JButton jogar = new JButton("Jogar");


    public SelecaoPersonagem() {
        try {
            img_menu = ImageIO.read(new File("imagens/Tabuleiros/CluePersonagens.png"));
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }
        
        p = new MyPanel(img_menu);
        jogar.setBounds(600,440,150,40);
        jogar.addActionListener(this);
        scarlett.setBounds(600,190,150,40);
        green.setBounds(600,230,150,40);
        white.setBounds(600,270,150,40);
        mustard.setBounds(600,310,150,40);
        plum.setBounds(600,350,150,40);
        peacock.setBounds(600,390,150,40);

        //nova_partida.setBounds(700,370,150,40);
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
    	Player []lista_jogadores = new Player[6];
    	if(e.getSource() == jogar) {
    		this.dispose();
    		
    		lista_jogadores = produzJogadores();

    	}
    }
   
    public Player[] produzJogadores() {
    	int num_jogadores = 0 ;
    	Player lista_jogadores[] = new Player[6];
    	
    	if(scarlett.isSelected()) {
    		Controller.add_player("Srta. Scarlett");
		}
		if(green.isSelected()) {
            Controller.add_player("Reverendo Green");
		}
		if(white.isSelected()) {
            Controller.add_player("Srta. White");
		}
		if(mustard.isSelected()) {
            Controller.add_player("Coronel Mustard");
		}
		if(plum.isSelected()) {
            Controller.add_player("Professor Plum");
		}
		if(peacock.isSelected()) {
            Controller.add_player("Srta. Peacock");
		}
		if(Controller.get_num_players() >= 3) {
			JogoClue tela_jogo = new JogoClue();
		}

		return lista_jogadores;
    }
   
    public void paint(Graphics g2d) {
        super.paint(g2d);
        g2d.drawImage(img_menu,0,55,this);

    }

}


