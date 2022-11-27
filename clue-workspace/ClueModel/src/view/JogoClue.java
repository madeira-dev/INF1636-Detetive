package view;

import java.awt.*;
import java.awt.geom.Arc2D;
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
	Image dado_resultado1, dado_resultado2;
	JLabel texto1, texto2;

	JPanel p;

	JButton prox = new JButton("Próximo");
	JButton mostrar_cartas = new JButton("Mostrar Cartas");
	JButton bloco_notas = new JButton("Bloco de Notas");
	JButton palpite = new JButton("Palpite");
	JButton acusar = new JButton("Acusar");
	JButton salvar_jogo = new JButton("Salvar Jogo");
	JButton jogar_dados = new JButton("Jogar Dados");
	JButton escolher_dados = new JButton("Escolher Dados");

	String[] valores_dados = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };

	@SuppressWarnings("unchecked")
	JComboBox dados_escolha = new JComboBox(valores_dados);

	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();
	int sl = screenSize.width;
	int sa = screenSize.height;
	int x = sl / 2 - 1200 / 2;
	int y = sa / 2 - 700 / 2;

	boolean[] armas_bool = new boolean[6];
	boolean[] suspeitos_bool = new boolean[6];
	boolean[] comodos_bool = new boolean[9];
	int[][] lista_quadrados;

	public JogoClue() {
		try {
			File tabuleiro = new File("imagens/Tabuleiros/Tabuleiro.jpg");
			File casa_valida = new File("imagens/Tabuleiros/quadrado_laranja.png");
			img_tabuleiro = ImageIO.read(tabuleiro);
			img_casa_valida = ImageIO.read(casa_valida);
		} catch (IOException exception) {
			System.out.println(exception.getMessage());
		}

		p = new MyPanel(img_tabuleiro);
		texto1 = new JLabel(String.format("Jogador da vez:  %s", Controller.get_current_player().getCharacter(),
				SwingConstants.CENTER));
		texto2 = new JLabel(
				String.format("Proximo: %s  ", Controller.get_next_player().getCharacter(), SwingConstants.CENTER));

		texto1.setBounds(700, 0, 200, 30);
		texto2.setBounds(700, 10, 200, 40);

		prox.setBounds(700, 50, 400, 45);

		prox.addActionListener(this);

		mostrar_cartas.setBounds(700, 100, 400, 45);
		mostrar_cartas.addActionListener(this);

		bloco_notas.setBounds(700, 150, 400, 45);
		bloco_notas.addActionListener(this);

		palpite.setBounds(700, 200, 400, 45);
		palpite.addActionListener(this);

		acusar.setBounds(700, 250, 400, 45);
		acusar.addActionListener(this);

		salvar_jogo.setBounds(700, 300, 400, 45);
		salvar_jogo.addActionListener(this);

		jogar_dados.setBounds(700, 500, 400, 45);
		jogar_dados.addActionListener(this);

		escolher_dados.setBounds(900, 550, 200, 55);
		escolher_dados.addActionListener(this);

		dados_escolha.setBounds(800, 550, 90, 55);
		dados_escolha.addActionListener(this);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setSize(1200, 700);
		this.setTitle("Gameplay - Clue");
		this.setBounds(x, y, 1200, 700);
		this.addMouseListener(this);

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
		g2D.drawImage(img_tabuleiro, 0, 0, this);
		g2D.drawImage(dado_resultado1, 730, 400, this);
		g2D.drawImage(dado_resultado2, 830, 400, this);
		if (lista_quadrados != null) {
			for (int[] coord : lista_quadrados) {
				System.out.printf("%d %d\n", coord[0], coord[1]);
				g2D.drawImage(img_casa_valida, 650 - 25 * coord[0], 675 - 25 * coord[1], this);
			}
		}
		for (int i = 0; i < Controller.get_num_players(); i++) {
			Ellipse2D e = new Ellipse2D.Double(650 - 25 * Controller.get_player(i).get_coord()[0],
					675 - 25 * Controller.get_player(i).get_coord()[1], 25, 25);
			switch (Controller.get_player(i).getCharacter()) {
			case "Reverendo Green": {
				g2D.setPaint(Color.green);

				break;
			}
			case "Coronel Mustard": {
				g2D.setPaint(Color.yellow);
				break;
			}
			case "Srta. Peacock": {
				g2D.setPaint(Color.blue);
				break;
			}
			case "Professor Plum": {
				g2D.setPaint(Color.magenta);
				break;
			}
			case "Srta. Scarlett": {
				g2D.setPaint(Color.red);
				break;
			}
			case "Srta. White": {
				g2D.setPaint(Color.white);
				break;
			}
			}
			g2D.fill(e);
			g2D.setPaint(Color.black);
			g2D.draw(new Arc2D.Double(650 - 25 * Controller.get_player(i).get_coord()[0],
					675 - 25 * Controller.get_player(i).get_coord()[1], 25, 25, 90, 360, Arc2D.PIE));
		}

	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		File dado1, dado2;

		if (e.getSource() == bloco_notas) {
			Controller.mudaNote();
		} else if (e.getSource() == prox) {
			salvar_jogo.setEnabled(true);
			System.out.println("here\n");
			Controller.pass_turn();
			texto1.setText(String.format("Jogador da vez:  %s", Controller.get_current_player().getCharacter(),
					SwingConstants.CENTER));
			texto2.setText(
					String.format("Proximo: %s  ", Controller.get_next_player().getCharacter(), SwingConstants.CENTER));

			repaint();
		}

		else if (e.getSource() == jogar_dados) {
			Controller.joga_dados();
			salvar_jogo.setEnabled(false);

			try {
				dado1 = new File(String.format("imagens/Tabuleiros/dado%d.jpg", Controller.pega_dados()[0]));
				dado2 = new File(String.format("imagens/Tabuleiros/dado%d.jpg", Controller.pega_dados()[1]));

				dado_resultado1 = ImageIO.read((dado1));
				dado_resultado2 = ImageIO.read((dado2));
			} catch (IOException exception) {
				System.out.println(exception.getMessage());
			}
			int x_coordenada = Controller.get_current_player().get_coord()[0];
			int y_coordenada = Controller.get_current_player().get_coord()[1];
			lista_quadrados = Controller.casas_disponiveis(x_coordenada, y_coordenada);

			repaint();

			System.out.printf(" ||| %d - ", Controller.pega_dados()[0]);
			System.out.printf("%d", Controller.pega_dados()[1]);
		} else if (e.getSource() == palpite && Controller.prepara_palpite() != null) {
			Palpite palpite = new Palpite(false, Controller.get_current_player(), Controller.prepara_palpite());

		}

		else if (e.getSource() == acusar) {
			Palpite palpite = new Palpite(true, Controller.get_current_player(), Controller.prepara_palpite());
		}

		else if (e.getSource() == mostrar_cartas) {
			PlayerCards cartas_jogador = new PlayerCards(Controller.get_current_player().get_card_by_type("comodo"),
					Controller.get_current_player().get_card_by_type("arma"),
					Controller.get_current_player().get_card_by_type("personagem"));

		}

		else if (e.getSource() == escolher_dados) {
			int result = 0, dado1_valor = 0, dado2_valor = 0;
			result = dados_escolha.getSelectedIndex() + 2;
			salvar_jogo.setEnabled(false);

			if (result % 2 == 0) {
				dado1_valor = result / 2;
				dado2_valor = result / 2;
			} else {
				dado1_valor = (result / 2) + 1;
				dado2_valor = (result / 2);
			}
			Controller.set_valores_dado(dado1_valor, dado2_valor);
			// System.out.printf("%d - %d \n",dado1_valor,dado2_valor);
			try {
				dado1 = new File(String.format("imagens/Tabuleiros/dado%d.jpg", dado1_valor));
				dado2 = new File(String.format("imagens/Tabuleiros/dado%d.jpg", dado2_valor));

				dado_resultado1 = ImageIO.read((dado1));
				dado_resultado2 = ImageIO.read((dado2));
			} catch (IOException exception) {
				System.out.println(exception.getMessage());
			}

			int x_coordenada = Controller.get_current_player().get_coord()[0];
			int y_coordenada = Controller.get_current_player().get_coord()[1];
			lista_quadrados = Controller.casas_disponiveis(x_coordenada, y_coordenada);
			repaint();

		} else if (e.getSource() == salvar_jogo) {
			Controller.salvaJogo();
			this.dispose();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (Controller.get_acoes()[0]) {
			return;
		}
		int x = e.getX();
		int y = e.getY();
		if (x > 700) {
			return;
		}
		for (int[] coord : lista_quadrados) {
			if (coord[0] == (675 - x) / 25 && coord[1] == (700 - y) / 25) {
				Controller.move(coord);
				lista_quadrados = null;
				repaint();
				Controller.atualiza_acoes(0);
				break;
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}
