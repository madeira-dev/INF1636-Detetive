package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;



public class SelecaoPersonagem extends JFrame {

    Image img_menu;
    JPanel p;
    JCheckBox scarlett= new JCheckBox("Mrs. Scarlett");
    JCheckBox mustard= new JCheckBox("Coronel Mustard");
    JCheckBox white= new JCheckBox("Mrs. White");
    JCheckBox peacock= new JCheckBox("Mrs. Peacock");
    JCheckBox plum= new JCheckBox("Prof. Plum");
    JCheckBox green= new JCheckBox("Rev. Green");


    JButton jogar = new JButton("Jogar");


    public SelecaoPersonagem()
    {
        try
        {
            img_menu = ImageIO.read(new File("clue-workspace/ClueModel/src/view/CluePersonagens.png"));
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        p = new MyPanel(img_menu);
        jogar.setBounds(600,350,150,40);
        scarlett.setBounds(600,100,150,40);
        green.setBounds(600,140,150,40);
        white.setBounds(600,180,150,40);
        mustard.setBounds(600,220,150,40);
        plum.setBounds(600,260,150,40);
        peacock.setBounds(600,300,150,40);

        //nova_partida.setBounds(700,370,150,40);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

    public void paint(Graphics g2d){
        super.paint(g2d);
        g2d.drawImage(img_menu,0,0,this);

    }

}


