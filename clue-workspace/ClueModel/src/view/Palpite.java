package view;

import models.Card;
import models.Componentes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Palpite  extends JFrame implements ActionListener {

    JRadioButton[] armas;
    JRadioButton[] personagens;
    JRadioButton[] comodos;

    ButtonGroup armas_group;
    ButtonGroup personagens_group;
    ButtonGroup comodos_group;
    JPanel[] panels;

    public Palpite(){

        armas = new JRadioButton[Componentes.num_armas()];
        personagens = new JRadioButton[Componentes.num_personagens()];
        comodos = new JRadioButton[Componentes.num_comodos()];

        armas_group = new ButtonGroup();
        personagens_group = new ButtonGroup();
        comodos_group = new ButtonGroup();

        panels = new JPanel[3];

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 400);
        this.setVisible(true);
        this.setTitle("Tela de Palpite");
        this.setLayout(new GridLayout(1, 3));

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

        this.pack();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
