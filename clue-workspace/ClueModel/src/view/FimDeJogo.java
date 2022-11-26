package view;

import javax.swing.*;
import java.awt.*;

public class FimDeJogo extends JFrame{
    JLabel texto;

    FimDeJogo(boolean result){
        this.setLayout(new GridLayout(2, 1));
        texto = new JLabel(String.format("Você %s", result ? "venceu! :D": "perdeu :("), SwingConstants.CENTER);
        this.add(texto);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 400);
        this.setVisible(true);
    }
}