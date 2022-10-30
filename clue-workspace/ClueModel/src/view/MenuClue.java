package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;



    public class MenuClue extends JFrame {

        Image img_menu;
        JPanel p;
        JButton continuar= new JButton("Continuar");
        JButton nova_partida = new JButton("Nova Partida");


        public MenuClue()
        {
            try
            {
                img_menu = ImageIO.read(new File("clue-workspace\\ClueModel\\src\\view\\Clue1.jpg"));
            }
            catch(IOException e)
            {
                System.out.println(e.getMessage());
            }
            p = new MyPanel(img_menu);
            continuar.setBounds(700,300,150,40);
            nova_partida.setBounds(700,370,150,40);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLayout(null);
            this.setSize(966, 700);
            this.setVisible(true);
            this.setTitle("Menu Inicial");
            this.add(continuar);
            this.add(nova_partida);

        }

        public void paint(Graphics g2d){
            super.paint(g2d);
            g2d.drawImage(img_menu,0,0,this);

        }

    }


