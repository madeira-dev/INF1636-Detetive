package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;



public class JogoClue extends JFrame implements ActionListener {

    Image img_tabuleiro;
    JPanel p;
    
    JButton passagem_secreta = new JButton("Passagem Secreta");
    JButton prox = new JButton("Próximo");
    JButton mostrar_cartas = new JButton("Mostrar Cartas");
    JButton bloco_notas = new JButton("Bloco de Notas");
    JButton palpite = new JButton("Palpite");
    JButton acusar = new JButton("Acusar");
    JButton salvar_jogo = new JButton("Salvar Jogo");
    JButton jogar_dados = new JButton("Jogar Dados");
    JButton escolher_dados = new JButton("Escolher Dados");

    String []valores_dados= {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};


    JList num_dados = new JList(valores_dados);
    
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    int sl = screenSize.width;
    int sa = screenSize.height;
    int x = sl/2-1200/2;
    int y = sa/2-700/2;

  public JogoClue()
       {
           try
           {
               img_tabuleiro = ImageIO.read(new File("/home/madeira/Documents/PUC/INF1636-Detetive/clue-workspace/ClueModel/src/view/Tabuleiro.jpg"));
           }
           catch(IOException e)
           {
               System.out.println(e.getMessage());
           }

           passagem_secreta.setBounds(700,0,400,45);
           prox.setBounds(700,50,400,45);
           mostrar_cartas.setBounds(700,100,400,45);
           bloco_notas.setBounds(700,150,400,45);
           bloco_notas.addActionListener(this);
           palpite.setBounds(700,200,400,45);
           acusar.setBounds(700,250,400,45);
           salvar_jogo.setBounds(700,325,400,45);
           jogar_dados.setBounds(700,500,400,45);
           escolher_dados.setBounds(900,550,200,55);
           num_dados.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
           //num_dados.addListSelectionListener(new MeuListListener());
           num_dados.setBounds(800,550,15,15);

           this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
           this.setLayout(null);
           this.setSize(1200, 700);
           this.setVisible(true);
           this.setTitle("Gameplay - Clue");
           this.setBounds(x, y, 1200, 700);

           this.add(passagem_secreta);
           this.add(prox);
           this.add(mostrar_cartas);
           this.add(bloco_notas);
           this.add(palpite);
           this.add(acusar);
           this.add(salvar_jogo);
           this.add(jogar_dados);
           this.add(escolher_dados);
           this.add(num_dados);

           p = new MyPanel(img_tabuleiro);


   }

   public void paint(Graphics g2d){
      super.paint(g2d);
      g2d.drawImage(img_tabuleiro,0,0,this);

   }

@Override
public void actionPerformed(ActionEvent e) {
	if (e.getSource() == bloco_notas) {
		Notepad notes = new Notepad();
		}
	}
}
