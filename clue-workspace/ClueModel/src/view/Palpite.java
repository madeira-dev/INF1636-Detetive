package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Palpite  extends JFrame implements ActionListener {

    JCheckBox corda= new JCheckBox("Corda");
    JCheckBox scarlett= new JCheckBox("Mrs. Scarlett");
    JCheckBox study= new JCheckBox("Study");

    public Palpite(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 400);
        this.setVisible(true);
        this.setTitle("Tela de Palpite");
        this.setLayout(new GridLayout(1, 3));
        this.add(corda);
        this.add(scarlett);
        this.add(study);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
