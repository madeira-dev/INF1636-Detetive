package view;
import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    public Image img;

    MyPanel(Image image) {
        img=image;
    }

    public void paintComponent(Graphics g2d) {
        super.paintComponent(g2d);
        g2d.drawImage(img, 0, 0, null);
    }
}
