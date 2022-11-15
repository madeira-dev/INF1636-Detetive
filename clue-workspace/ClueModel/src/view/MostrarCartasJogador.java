package view;
import controller.Controller;
import models.InfoPalpite;

import javax.imageio.ImageIO;
import javax.sound.midi.ControllerEventListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

class MostrarCartasJogador extends JFrame {
	
	Image comodo,arma,sus; 
	
	JButton mostrar_comodo = new JButton("Mostrar Comodo");
	JButton mostrar_arma = new JButton("Mostrar Arma");
	JButton mostrar_sus = new JButton("Mostrar Suspeito");
	
	MostrarCartasJogador(InfoPalpite informacoes) {
		
		//System.out.printf("%s",informacoes.getCards()[0].getName());
		 try {
		  	File arq_arma = new File(String.format("imagens/Armas/%s.jpg",informacoes.getCards()[0].getName()));
		  	File arq_comodo = new File(String.format("imagens/Comodos/%s.jpg",informacoes.getCards()[1].getName()));
		  	File arq_sus = new File(String.format("imagens/Suspeitos/%s.jpg",informacoes.getCards()[2].getName()));
		  	
            comodo = ImageIO.read(arq_comodo);
            arma = ImageIO.read(arq_arma);
            sus = ImageIO.read(arq_sus);
        }
        catch(IOException exception) {
            System.out.println(exception.getMessage());
        }
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setSize(966, 700);
        this.setVisible(true);
        this.setTitle("Suas Cartas");
        
        
        
        mostrar_comodo.setBounds(600,440,150,40);
        //mostrar_comodo.addActionListener(this);
        mostrar_arma.setBounds(400,440,150,40);
        //mostrar_arma.addActionListener(this);
        mostrar_sus.setBounds(200,440,150,40);
        //mostrar_sus.addActionListener(this);
        
        this.add(mostrar_comodo);
        this.add(mostrar_arma);
        this.add(mostrar_sus);
        
        
	}
	public void paint(Graphics g) {
		   Graphics2D g2D = (Graphics2D) g;
	      g2D.drawImage(comodo,600,155,this);
	      g2D.drawImage(arma, 400, 120, this);
		  g2D.drawImage(sus, 200, 120, this);
	      this.mostrar_arma.repaint();
	      this.mostrar_comodo.repaint();
	      this.mostrar_sus.repaint();
	   }
}
