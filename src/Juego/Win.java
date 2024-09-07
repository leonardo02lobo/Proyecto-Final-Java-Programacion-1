package Juego;

import java.awt.*;
import javax.swing.*;

public class Win extends JPanel {

    public Win() {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        setBorder(BorderFactory.createLineBorder(Color.white, 5));
        setBounds(100, 150, 350, 200);
        add(new TituloGanador(),BorderLayout.CENTER);
    }
}

class TituloGanador extends JPanel {

    public TituloGanador() {
        setBackground(Color.BLACK);
        titulo.setText("Haz Pasado al segundo nivel");
        titulo.setFont(new Font("OCR A Extended", Font.BOLD, 18));
        titulo.setForeground(Color.white);
        add(titulo);
    }
    JLabel titulo = new JLabel();
}

