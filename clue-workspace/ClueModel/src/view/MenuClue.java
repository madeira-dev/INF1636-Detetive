package view;

import javax.imageio.ImageIO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;



    class MenuClue extends JFrame implements ActionListener {

        Image img_menu;
        JPanel p;
        JButton continuar= new JButton("Continuar");
        JButton nova_partida = new JButton("Nova Partida");



        public MenuClue() {
            try {
                img_menu = ImageIO.read(new File("imagens/Tabuleiros/Clue1.jpg"));
            }
            catch(IOException e) {
                System.out.println(e.getMessage());
            }
            
            p = new MyPanel(img_menu);

            continuar.setBounds(700,370,150,40);
            nova_partida.setBounds(700,300,150,40);
            nova_partida.addActionListener(this);

           
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setLayout(null);
            this.setSize(966, 700);
            this.setTitle("Menu Inicial");
            this.add(nova_partida);
            this.add(continuar);
            this.setVisible(true);
            this.revalidate();
            this.repaint();
        }

        public void actionPerformed(ActionEvent e) {
        	if(e.getSource() == nova_partida) {
        		SelecaoPersonagem tela_personagem = new SelecaoPersonagem();
        	}
        }
        
        public void paint(Graphics g2d) {
            super.paint(g2d);
            g2d.drawImage(img_menu,0,0,this);
            this.continuar.repaint();
            this.nova_partida.repaint();
        }

    }


