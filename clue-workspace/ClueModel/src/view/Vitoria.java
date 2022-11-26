package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Vitoria extends JFrame{
    JLabel texto;

    Vitoria(){
        this.setLayout(new GridLayout(2, 1));
        texto = new JLabel("Você venceu!!! :D", SwingConstants.CENTER);
        this.add(texto);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 400);
        this.setVisible(true);
    }
}