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
    Image dado_resultado1,dado_resultado2;

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
		  		File tabuleiro = new File("imagens/Tabuleiros/Tabuleiro.jpg");
               img_tabuleiro = ImageIO.read(tabuleiro);
           }
           catch(IOException exception) {
               System.out.println(exception.getMessage());
           }
           
           p = new MyPanel(img_tabuleiro);

           passagem_secreta.setBounds(700,0,400,45);
           prox.setBounds(700,50,400,45);
           mostrar_cartas.setBounds(700,100,400,45);
           mostrar_cartas.addActionListener(this);
           bloco_notas.setBounds(700,150,400,45);
           bloco_notas.addActionListener(this);
           palpite.setBounds(700,200,400,45);
            palpite.addActionListener(this);
           acusar.setBounds(700,250,400,45);
           salvar_jogo.setBounds(700,300,400,45);
           jogar_dados.setBounds(700,500,400,45);
           jogar_dados.addActionListener(this);
           escolher_dados.setBounds(900,550,200,55);
           escolher_dados.addActionListener(this);
           num_dados.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
           //num_dados.addListSelectionListener(new MeuListListener());
           num_dados.setBounds(800,550,15,15);
           
           

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
           this.setVisible(true);
           this.revalidate();
           this.repaint();
       }

   public void paint(Graphics g) {
	   Graphics2D g2D = (Graphics2D) g;
      g2D.drawImage(img_tabuleiro,0,0,this);
      g2D.drawImage(dado_resultado1, 730, 400, this);
	  g2D.drawImage(dado_resultado2, 830, 400, this);
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
		
		try {
			File dado1 = new File(String.format("imagens/Tabuleiros/dado%d.jpg", result1));
			File dado2 = new File(String.format("imagens/Tabuleiros/dado%d.jpg", result2));
			
			dado_resultado1 = ImageIO.read((dado1));
			dado_resultado2 = ImageIO.read((dado2));
		} catch (IOException exception) {
			System.out.println(exception.getMessage());
		}
		
		repaint();
		//System.out.printf(" ||| %d - ", result1);
		//System.out.printf("%d", result2);
		}
    else if(e.getSource() == palpite){
        Palpite palpite = new Palpite(true);
        }
    else if(e.getSource()== mostrar_cartas) {
        // Mockado

    	PlayerCards cartas_jogador = new PlayerCards(null, null, null);
    	}
	}
}
