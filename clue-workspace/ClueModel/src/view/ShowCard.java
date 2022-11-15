package view;

import models.Card;
import models.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ShowCard extends JFrame {
    JLabel texto;
    Card card;

    ShowCard(Card carta, Player mostrador) throws IOException {
        card = carta;
        texto = new JLabel(String.format("%s te mostrou %s", mostrador.getName(), carta.getName()), SwingConstants.CENTER);
        texto.setBounds(0, 0, 400, 50);
        Image img = ImageIO.read(new File(String.format("Imagens/%s/%s")))
        this.add(texto);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 400);
        this.setVisible(true);
        this.setTitle("Receber Carta");
        this.setLayout(null);
    }

}
