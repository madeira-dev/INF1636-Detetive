package view;

import javax.imageio.ImageIO;

import javax.swing.*;
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


    public SelecaoPersonagem()
    {
        try
        {
            img_menu = ImageIO.read(new File("/home/madeira/Documents/PUC/INF1636-Detetive/clue-workspace/ClueModel/src/view/CluePersonagens.png"));
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        p = new MyPanel(img_menu);
        jogar.setBounds(600,350,150,40);
        jogar.addActionListener(this);
        scarlett.setBounds(600,100,150,40);
        scarlett.addActionListener(this);
        green.setBounds(600,140,150,40);
        white.setBounds(600,180,150,40);
        mustard.setBounds(600,220,150,40);
        plum.setBounds(600,260,150,40);
        peacock.setBounds(600,300,150,40);

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
    	String []lista_jogadores = new String[6];
    	if(e.getSource() == jogar) {
    		this.dispose();
    		lista_jogadores = produzJogadores();
    		//System.out.printf("%s\n%s\n%s\n%s\n%s\n%s",lista_jogadores[0],lista_jogadores[1],lista_jogadores[2],lista_jogadores[3],lista_jogadores[4],lista_jogadores[5]);
    	}
    	
    }
   
    public String[] produzJogadores() {
    	int num_jogadores = 0 ;
    	String []lista_jogadores = new String[6];
    	
    	if(scarlett.isSelected()) {
    		lista_jogadores[num_jogadores]= "Srta. Scarlett";
			num_jogadores++;
		}
		if(green.isSelected()) {
			lista_jogadores[num_jogadores]= "Rev. Green";
			num_jogadores++;
		}
		if(white.isSelected()) {
			lista_jogadores[num_jogadores]= "Mrs. White";
			num_jogadores++;
		}
		if(mustard.isSelected()) {
			lista_jogadores[num_jogadores]= "Coronel Mustard";
			num_jogadores++;
		}
		if(plum.isSelected()) {
			lista_jogadores[num_jogadores]= "Prof. Plum";
			num_jogadores++;
		}
		if(peacock.isSelected()) {
			lista_jogadores[num_jogadores]= "Mrs. Peacock";
			num_jogadores++;
		}
		if(num_jogadores>=3) {
			JogoClue tela_jogo = new JogoClue();
		}
		return lista_jogadores;
    }
    	
		
   
    public void paint(Graphics g2d){
        super.paint(g2d);
        g2d.drawImage(img_menu,0,0,this);

    }

}


