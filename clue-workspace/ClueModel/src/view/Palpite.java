package view;

import controller.Controller;
import models.Card;
import models.Componentes;
import models.InfoPalpite;
import models.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Palpite extends JFrame implements ActionListener {
    JRadioButton[] armas;
    JRadioButton[] personagens;
    JRadioButton[] comodos;
    ButtonGroup armas_group;
    ButtonGroup personagens_group;
    ButtonGroup comodos_group;
    JPanel[] panels;
    JButton palpite;
    Player guesser;
    Card[] cards;
    public Palpite(boolean acusacao, Player guesser){
        this.guesser = guesser;

        armas = new JRadioButton[Componentes.num_armas()];
        personagens = new JRadioButton[Componentes.num_personagens()];
        comodos = new JRadioButton[Componentes.num_comodos()];

        armas_group = new ButtonGroup();
        personagens_group = new ButtonGroup();
        comodos_group = new ButtonGroup();

        panels = new JPanel[4];
        if(acusacao){
            palpite = new JButton("Acusar");
        }
        else{
            palpite = new JButton("Palpitar");
        }

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 400);
        this.setVisible(true);
        this.setTitle("Tela de Palpite");
        this.setLayout(new GridLayout(1, 4));

        for(int i=0; i< 3; i++){
            panels[i] = new JPanel();
            panels[i].setLayout(new BoxLayout(panels[i], BoxLayout.PAGE_AXIS));
            this.add(panels[i]);
        }

        for(int i=0; i < Componentes.num_armas(); i++){
            armas[i] = new JRadioButton(Componentes.armas_cartas()[i].getName());
            this.panels[0].add(armas[i]);
            armas_group.add(armas[i]);
        }
        for(int i=0; i < Componentes.num_personagens(); i++){
            personagens[i] = new JRadioButton(Componentes.personagens_cartas()[i].getName());
            this.panels[1].add(personagens[i]);
            personagens_group.add(personagens[i]);
        }
        for(int i=0; i < Componentes.num_comodos(); i++){
            comodos[i] = new JRadioButton(Componentes.comodos_cartas()[i].getName());
            this.panels[2].add(comodos[i]);
            comodos_group.add(comodos[i]);
        }
        palpite.addActionListener(this);

        this.panels[3] = new JPanel();
        this.panels[3].setLayout(new BorderLayout());
        this.panels[3].add(palpite);
        this.add(panels[3]);
        this.pack();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        cards = new Card[3];
        if(e.getSource() == palpite){
            for(int i=0; i < armas.length; i++){
                if(armas[i].isSelected()){
                    cards[0] = Componentes.armas_cartas()[i];
                    break;
                }
            }

            for(int i=0; i < comodos.length; i++){
                if(comodos[i].isSelected()){
                    cards[2] = Componentes.comodos_cartas()[i];
                    break;
                }
            }

            for(int i=0; i < personagens.length; i++){
                if(personagens[i].isSelected()){
                    cards[1] = Componentes.armas_cartas()[i];
                    break;
                }
            }
            InfoPalpite info = Controller.guess(guesser, cards);

        }
    }
}
