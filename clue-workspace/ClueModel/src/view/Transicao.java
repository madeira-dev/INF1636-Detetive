package view;

import controller.Controller;

import javax.sound.midi.ControllerEventListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Transicao extends JFrame implements ActionListener{
    JLabel texto;
    JButton ok;

    Transicao(String character){
        this.setLayout(new GridLayout(2, 1));
        texto = new JLabel(String.format("Passe o turno para %s (%s)", character, Objects.requireNonNull(Controller.get_player_by_character(character)).getName()), SwingConstants.CENTER);
        ok = new JButton("OK");
        ok.addActionListener(this);
        this.add(texto);
        this.add(ok);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 400);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ok){
            System.out.println("here");
            this.dispose();
        }
    }
}
