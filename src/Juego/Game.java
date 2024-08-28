package Juego;

import Juego.personaje.Disparo_Personaje;
import Juego.personaje.nave;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Game extends JPanel {

    private nave minave = new nave();

    public Game() {
        setLayout(null);
        setBackground(Color.BLACK);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                minave.mover(e);
            }
        });

        add(new Disparo_Personaje(200, 200));
        add(minave);
        setFocusable(true);

    }
}
