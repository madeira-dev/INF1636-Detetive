package view;

import controller.Controller;
import models.API;
import models.Componentes;
import models.InfoPalpite;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Palpite extends JFrame implements ActionListener {
    JRadioButton[] armas;
    JRadioButton[] comodos;
    JRadioButton[] personagens;
    ButtonGroup armas_group;
    ButtonGroup comodos_group;

    ButtonGroup personagens_group;
    JPanel[] panels;
    JButton palpite;
    String guesser;
    String[] cards;
    String room;
    boolean acusacao;
    public Palpite(boolean acusacao, String guesser, String room){
        this.guesser = guesser;
        this.room = room;
        this.acusacao = acusacao;
        armas = new JRadioButton[Componentes.num_armas()];
        personagens = new JRadioButton[Componentes.num_personagens()];
        comodos = new JRadioButton[Componentes.num_comodos()];

        armas_group = new ButtonGroup();
        personagens_group = new ButtonGroup();
        comodos_group = new ButtonGroup();

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 400);
        this.setVisible(true);
        this.setTitle("Tela de Palpite");
        int max;
        if(acusacao){
            palpite = new JButton("Acusar");
            this.setLayout(new GridLayout(1, 4));
            max = 3;
        }
        else {
            palpite = new JButton("Palpitar");
            this.setLayout(new GridLayout(1, 3));
            max = 2;
        }
        panels = new JPanel[max + 1];
        for(int i=0; i< max; i++){
            panels[i] = new JPanel();
            panels[i].setLayout(new BoxLayout(panels[i], BoxLayout.PAGE_AXIS));
            this.add(panels[i]);
        }
        for(int i=0; i < Componentes.num_armas(); i++){
            armas[i] = new JRadioButton(Componentes.nome_carta(i, "arma"));
            this.panels[0].add(armas[i]);
            armas_group.add(armas[i]);
        }
        for(int i=0; i < Componentes.num_personagens(); i++){
            personagens[i] = new JRadioButton(Componentes.nome_carta(i, "personagem"));
            this.panels[1].add(personagens[i]);
            personagens_group.add(personagens[i]);
        }
        if(acusacao){
            for(int i=0; i < Componentes.num_comodos(); i++){
                comodos[i] = new JRadioButton(Componentes.nome_carta(i, "comodo"));
                this.panels[2].add(comodos[i]);
                comodos_group.add(comodos[i]);
            }

        }
        palpite.addActionListener(this);

        this.panels[max] = new JPanel();
        this.panels[max].setLayout(new BorderLayout());
        this.panels[max].add(palpite);
        this.add(panels[max]);
        this.pack();
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		cards = new String[3];
		if (e.getSource() == palpite) {
			this.dispose();
			for (int i = 0; i < armas.length; i++) {
				if (armas[i].isSelected()) {
					cards[0] = Componentes.nome_carta(i, "arma");
					// System.out.printf("\ncards[0]-> %s", cards[0].getName());
					break;
				}
			}
			for (int i = 0; i < personagens.length; i++) {
				if (personagens[i].isSelected()) {
					cards[1] = Componentes.nome_carta(i, "personagem");
					// System.out.printf("\\ncards[1]-> %s", cards[1].getName());
					break;
				}
			}
			if (acusacao) {
				this.dispose();
				for (int i = 0; i < comodos.length; i++) {
					if (comodos[i].isSelected()) {
						cards[2] = Componentes.nome_carta(i,"comodo");
						break;
					}
				}
			} else {
				cards[2] = room;
			}
			if (acusacao) {
				boolean r = API.acusar(cards);
				FimDeJogo f = new FimDeJogo(r, guesser);
				if (!r) {
					API.remove_player();
                    Controller.alter_num_players(-1);
				}
			} else {
				InfoPalpite info = API.guess(guesser, cards);
				/* pode nao estar certo */
                if(info != null){
                    API.set_player_note(guesser, info.get_name(), info.get_type());
                }
				try {
                    if(info != null){
                        new ShowCard(info.get_character(), info.get_name(), info.get_folder(), info.getPlayer());
                    }
                    else{
                        new ShowCard(null, null, null, null);
                    }
				} catch (IOException ex) {
					throw new RuntimeException(ex);
				}
			}

		}
        }
}
