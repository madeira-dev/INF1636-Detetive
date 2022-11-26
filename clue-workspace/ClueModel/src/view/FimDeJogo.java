package view;

import javax.swing.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;



public class FimDeJogo extends JFrame implements ActionListener{
    JLabel texto;
    JButton novo_jogo = new JButton ("Nova partida");
    FimDeJogo(boolean result, String jogador){
        this.setLayout(new GridLayout(2, 1));
        
        texto = new JLabel(String.format("Você %s  %s", result ? "venceu! :D": "perdeu :(",jogador), SwingConstants.CENTER);
       
        novo_jogo.setBounds(700,50,400,45);
        novo_jogo.addActionListener(this);
        
        this.add(texto);
        this.add(novo_jogo);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 400);
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
    	
    	if (e.getSource() == novo_jogo) {
    		MenuClue personagens = new MenuClue();
    	}
    }
}