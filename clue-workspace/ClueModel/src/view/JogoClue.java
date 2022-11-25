package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import controller.*;

// I'm really sorry for the code below, but the deadline is close
public class JogoClue extends JFrame implements ActionListener, MouseListener {

    Image img_tabuleiro;
    Image img_casa_valida;
    Image dado_resultado1,dado_resultado2;
    JLabel texto1,texto2;

    JPanel p;

    JButton prox = new JButton("Próximo");
    JButton mostrar_cartas = new JButton("Mostrar Cartas");
    JButton bloco_notas = new JButton("Bloco de Notas");
    JButton palpite = new JButton("Palpite");
    JButton acusar = new JButton("Acusar");
    JButton salvar_jogo = new JButton("Salvar Jogo");
    JButton jogar_dados = new JButton("Jogar Dados");
    JButton escolher_dados = new JButton("Escolher Dados");

    String[] valores_dados= {"2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};

    @SuppressWarnings("unchecked")
	JComboBox dados_escolha = new JComboBox(valores_dados);
    
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    int sl = screenSize.width;
    int sa = screenSize.height;
    int x = sl / 2-1200 / 2;
    int y = sa / 2-700 / 2;
    
    boolean[] armas_bool = new boolean[6];
    boolean[] suspeitos_bool = new boolean[6];
    boolean[] comodos_bool = new boolean[9];
    int[][] lista_quadrados;

  public JogoClue() {	  
	  try {
          File tabuleiro = new File("clue-workspace/ClueModel/imagens/Tabuleiros/Tabuleiro.jpg");
          //File tabuleiro = new File("imagens/Tabuleiros/Tabuleiro.jpg");
          File casa_valida = new File("clue-workspace/ClueModel/imagens/Tabuleiros/quadrado_laranja.png");
		  img_tabuleiro = ImageIO.read(tabuleiro);
          img_casa_valida = ImageIO.read(casa_valida);
		  }
	  catch(IOException exception) {
		  System.out.println(exception.getMessage());
		  }
	  
	  		
           p = new MyPanel(img_tabuleiro);
           
           texto1 = new JLabel(String.format("Jogador da vez:  %s",Controller.get_current_player().getCharacter() ,SwingConstants.CENTER));
           texto2 = new JLabel(String.format("Proximo: %s  ", Controller.get_next_player().getCharacter(),SwingConstants.CENTER));
           
           texto1.setBounds(700, 0, 200, 30);
           texto2.setBounds(700, 10, 200, 40);
           
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
           
           dados_escolha.setBounds(800,550,90,55);
           dados_escolha.addActionListener(this);
           
           
           this.addMouseListener(this);
           
           

           this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
           this.setLayout(null);
           this.setSize(1200, 700);
           this.setTitle("Gameplay - Clue");
           this.setBounds(x, y, 1200, 700);

           this.add(prox);
           this.add(mostrar_cartas);
           this.add(bloco_notas);
           this.add(palpite);
           this.add(acusar);
           this.add(salvar_jogo);
           this.add(jogar_dados);
           this.add(escolher_dados);
           this.add(dados_escolha);
           this.add(texto1, BorderLayout.PAGE_START);
           this.add(texto2, BorderLayout.PAGE_START);
           
           this.setVisible(true);
           this.revalidate();
           this.repaint();
       }

   public void paint(Graphics g) {
	  super.paint(g);
	  Graphics2D g2D = (Graphics2D) g;
      g2D.drawImage(img_tabuleiro,0,0,this);
      g2D.drawImage(dado_resultado1, 730, 400, this);
	  g2D.drawImage(dado_resultado2, 830, 400, this);
       if(lista_quadrados != null){
           for(int[] coord: lista_quadrados){
               g2D.drawImage(img_casa_valida, 650 - 25 * coord[0], 675 - 25 * coord[1], this);
           }
       }

	  Ellipse2D srta_scarlet = new Ellipse2D.Double(232,658, 20, 20);
	  Ellipse2D srta_peacock = new Ellipse2D.Double(635,212, 20, 20);
	  Ellipse2D srta_white = new Ellipse2D.Double(275,50, 20, 20);
	  Ellipse2D rev_green = new Ellipse2D.Double(403,55, 20, 20);
	  Ellipse2D cor_mustard = new Ellipse2D.Double(55,483, 20, 20);
	  Ellipse2D prof_plum = new Ellipse2D.Double(635,534, 20, 20);


	  g2D.setPaint(Color.red);
	  g2D.fill(srta_scarlet);

	  g2D.setPaint(Color.blue);
	  g2D.fill(srta_peacock);

	  g2D.setPaint(Color.white);
	  g2D.fill(srta_white);

	  g2D.setPaint(Color.green);
	  g2D.fill(rev_green);

	  g2D.setPaint(Color.yellow);
	  g2D.fill(cor_mustard);

	  g2D.setPaint(Color.black);
	  g2D.fill(prof_plum);



      
   }

@Override
public void actionPerformed(ActionEvent e) {
	File dado1,dado2;
	
	if (e.getSource() == bloco_notas) {
		Notepad notes = new Notepad(armas_bool, suspeitos_bool, comodos_bool);
	}
	
	else if(e.getSource() == jogar_dados) {
        Controller.joga_dados();
		
		try {
			dado1 = new File(String.format("imagens/Tabuleiros/dado%d.jpg", Controller.pega_dados()[0]));
			dado2 = new File(String.format("imagens/Tabuleiros/dado%d.jpg", Controller.pega_dados()[1]));
			
			dado_resultado1 = ImageIO.read((dado1));
			dado_resultado2 = ImageIO.read((dado2));
		} catch (IOException exception) {
			System.out.println(exception.getMessage());
		}
		
		repaint();

		System.out.printf(" ||| %d - ", Controller.pega_dados()[0]);
		System.out.printf("%d",  Controller.pega_dados()[1]);
		}
    else if(e.getSource() == palpite){
        Palpite palpite = new Palpite(false, Controller.get_current_player());
        }
    
    else if(e.getSource() == acusar){
        Palpite palpite = new Palpite(true, Controller.get_current_player());
    }
    
    else if(e.getSource()== mostrar_cartas) {
    	PlayerCards cartas_jogador = new PlayerCards(Controller.get_current_player().get_card_by_type("comodo"),
                                                     Controller.get_current_player().get_card_by_type("arma"),
                                                     Controller.get_current_player().get_card_by_type("personagem"));

    }
    
    else if(e.getSource() == escolher_dados) {
    	int result = 0, dado1_valor = 0, dado2_valor = 0;
    	result = dados_escolha.getSelectedIndex() + 2;
    	
    	if(result%2==0) {
    		dado1_valor = result/2;
    		dado2_valor = result/2;
    	}
    	else {
    		dado1_valor = (result/2) + 1;
    		dado2_valor = (result/2);
    	} 
    	
    	System.out.printf("%d - %d \n",dado1_valor,dado2_valor);
    	try {
			dado1 = new File(String.format("imagens/Tabuleiros/dado%d.jpg", dado1_valor));
			dado2 = new File(String.format("imagens/Tabuleiros/dado%d.jpg", dado2_valor));
			
			dado_resultado1 = ImageIO.read((dado1));
			dado_resultado2 = ImageIO.read((dado2));
		} catch (IOException exception) {
			System.out.println(exception.getMessage());
		}

    	repaint();

    }
}

	public void mouseClicked(MouseEvent e) {
		int x_coordenada = (675-e.getX()  ) /25 ;
		int y_coordenada = (700-e.getY())  /25;
        int[][] coord = Controller.casas_disponiveis(x_coordenada, y_coordenada);
        for(int[] c: coord){
            System.out.printf("%d %d\n", c[0], c[1]);
        }
	}
	
	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
}
