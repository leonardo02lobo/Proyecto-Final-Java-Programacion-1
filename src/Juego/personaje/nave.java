package Juego.personaje;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class nave extends JLabel {

    private int ancho = 50;
    private int alto = 50;
    private int x = 250;
    private int y = 400;
    private Image imagenNave = new ImageIcon(getClass().getResource("../../source/personaje/Disparador.png")).getImage();

    public nave() {
        setIcon(new ImageIcon(imagenNave.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
        Timer movimientoNave = new Timer(15, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBounds(x, y, ancho, alto);
            }
        });
        movimientoNave.start();
    }

    public void mover(KeyEvent e) {
        System.out.println("aaa");
        if (e.getKeyCode() == KeyEvent.VK_D) {
            x += 20;
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            x -= 20;
        }
    }
}
