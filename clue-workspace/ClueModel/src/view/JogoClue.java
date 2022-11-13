package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import controller.*;

// I'm really sorry for the code below, but the deadline is close
public class JogoClue extends JFrame implements ActionListener {

    Image img_tabuleiro;
    Image dado_resultado;

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

    String[] valores_dados= {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
    
//  remover ImageIcons
    ImageIcon dado_gui1 =  new ImageIcon("clue-workspace/ClueModel/imagens/Tabuleiros/dado1.jpg");
    ImageIcon dado_gui2 =  new ImageIcon("clue-workspace/ClueModel/imagens/Tabuleiros/dado1.jpg");
    
//  remover ImageIcons
    ImageIcon dado1 = new ImageIcon("clue-workspace/ClueModel/imagens/Tabuleiros/dado1.jpg");
	ImageIcon dado2 = new ImageIcon("clue-workspace/ClueModel/imagens/Tabuleiros/dado2.jpg");
	ImageIcon dado3 = new ImageIcon("clue-workspace/ClueModel/imagens/Tabuleiros/dado3.jpg");
	ImageIcon dado4 = new ImageIcon("clue-workspace/ClueModel/imagens/Tabuleiros/dado4.jpg");
	ImageIcon dado5 = new ImageIcon("clue-workspace/ClueModel/imagens/Tabuleiros/dado5.jpg");
	ImageIcon dado6 = new ImageIcon("clue-workspace/ClueModel/imagens/Tabuleiros/dado6.jpg");
	
	JLabel imagem_dado_gui1 = new JLabel(dado_gui1);
	JLabel imagem_dado_gui2 = new JLabel(dado_gui2);
	JLabel imagem_dado1 = new JLabel(dado1);
	JLabel imagem_dado2 = new JLabel(dado2);
	JLabel imagem_dado3 = new JLabel(dado3);
	JLabel imagem_dado4 = new JLabel(dado4);
	JLabel imagem_dado5 = new JLabel(dado5);
	JLabel imagem_dado6 = new JLabel(dado6);


    JList num_dados = new JList(valores_dados);
    
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    int sl = screenSize.width;
    int sa = screenSize.height;
    int x = sl / 2-1200 / 2;
    int y = sa / 2-700 / 2;
    
    boolean[] armas_bool = new boolean[6];
    boolean[] suspeitos_bool = new boolean[6];
    boolean[] comodos_bool = new boolean[9];
    
  public JogoClue()
  {
//	  esse for loop é só pra testar o notepad, pode remover depois
	  for (int i = 0; i < 6; i++) {
		  armas_bool[i]=true;
		  suspeitos_bool[i]=true;
	  }
//    esse loop também pode remover
	  for (int i = 0; i < 9; i++)
		  comodos_bool[i]=true;
	  
	  try {
               img_tabuleiro = ImageIO.read(new File("imagens/Tabuleiros/Tabuleiro.jpg"));
           }
           catch(IOException e) {
               System.out.println(e.getMessage());
           }
           
           p = new MyPanel(img_tabuleiro);

           passagem_secreta.setBounds(700,0,400,45);
           prox.setBounds(700,50,400,45);
           mostrar_cartas.setBounds(700,100,400,45);
           bloco_notas.setBounds(700,150,400,45);
           bloco_notas.addActionListener(this);
           palpite.setBounds(700,200,400,45);
           acusar.setBounds(700,250,400,45);
           salvar_jogo.setBounds(700,300,400,45);
           jogar_dados.setBounds(700,500,400,45);
           jogar_dados.addActionListener(this);
           escolher_dados.setBounds(900,550,200,55);
           num_dados.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
           //num_dados.addListSelectionListener(new MeuListListener());
           num_dados.setBounds(800,550,15,15);
           
           imagem_dado_gui1.setBounds(700,380,100,100);
           imagem_dado_gui2.setBounds(820,380,100,100);
           imagem_dado1.setBounds(700,380,100,100);
           imagem_dado2.setBounds(700,380,100,100);
           imagem_dado3.setBounds(700,380,100,100);
           imagem_dado4.setBounds(700,380,100,100);
           imagem_dado5.setBounds(700,380,100,100);
           imagem_dado6.setBounds(700,380,100,100);

           this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
           this.setLayout(null);
           this.setSize(1200, 700);
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
           
           this.add(imagem_dado_gui1);
           this.add(imagem_dado_gui2);
           this.add(imagem_dado1);
           this.add(imagem_dado2);
           this.add(imagem_dado3);
           this.add(imagem_dado4);
           this.add(imagem_dado5);
           this.add(imagem_dado6);
           
           imagem_dado_gui1.setVisible(true);
           imagem_dado_gui2.setVisible(true);

           this.setVisible(true);
           this.revalidate();
           this.repaint();
       }

   public void paint(Graphics g) {
	   Graphics2D g2D = (Graphics2D) g;
      g2D.drawImage(img_tabuleiro,0,0,this);
      this.passagem_secreta.repaint();
      this.prox.repaint();
      this.mostrar_cartas.repaint();
      this.bloco_notas.repaint();
      this.palpite.repaint();
      this.salvar_jogo.repaint();
      this.acusar.repaint();
      this.jogar_dados.repaint();
      this.escolher_dados.repaint();
   }

@Override
public void actionPerformed(ActionEvent e) {
	if (e.getSource() == bloco_notas) {
		Notepad notes = new Notepad(armas_bool, suspeitos_bool, comodos_bool);
		}
	else if(e.getSource() == jogar_dados) {
		int result1,result2;
		result1 = Dados.joga_dados();
		result2 = Dados.joga_dados();
		
		imagem_dado1.setVisible(false);
        imagem_dado2.setVisible(false);
        imagem_dado3.setVisible(false);
        imagem_dado4.setVisible(false);
        imagem_dado5.setVisible(false);
        imagem_dado6.setVisible(false);
        imagem_dado_gui1.setVisible(false);
        imagem_dado_gui2.setVisible(false);
	
        if(result1==1) {
			imagem_dado1.setVisible(true);
		}
		else if(result1==2) {
			imagem_dado2.setVisible(true);
		}
		else if(result1==3) {
			imagem_dado3.setVisible(true);
		}
		else if(result1==4) {
			imagem_dado4.setVisible(true);
		}
		else if(result1==5) {
			imagem_dado5.setVisible(true);
		}
		else {
			imagem_dado6.setVisible(true);
		}
       
        if(result2==1) {
        	imagem_dado1.setBounds(820,380,100,100);
			imagem_dado1.setVisible(true);
		}
		else if(result2==2) {
			imagem_dado2.setBounds(820,380,100,100);
			imagem_dado2.setVisible(true);
		}
		else if(result2==3) {
			imagem_dado3.setBounds(820,380,100,100);
			imagem_dado3.setVisible(true);
		}
		else if(result2==4) {
			imagem_dado4.setBounds(820,380,100,100);
			imagem_dado4.setVisible(true);
		}
		else if(result2==5) {
			imagem_dado5.setBounds(820,380,100,100);
			imagem_dado5.setVisible(true);
		}
		else {
			imagem_dado6.setBounds(820,380,100,100);
			imagem_dado6.setVisible(true);
		}
		
		repaint();
		System.out.printf(" ||| %d - ", result1);
		System.out.printf("%d", result2);
		}
	}
}
