package Juego;

import Juego.personaje.nave;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Game extends JPanel {

    private nave minave = new nave();

    public Game() {
        setBackground(Color.BLACK);
        add(minave);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("aaa");
                minave.mover(e);
            }
        });
        minave.setFocusable(true);
        requestFocusInWindow();
    }
}
