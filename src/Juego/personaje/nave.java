package Juego.personaje;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class nave extends JLabel {

    private int ancho = 50;
    private int alto = 50;
    private int x = 250;
    private int y = 450;
    private final int movimiento = 10;
    private Image imagenNave = new ImageIcon(getClass().getResource("../../source/personaje/Disparador.png")).getImage();

    public nave() {
        setBorder(BorderFactory.createLineBorder(Color.white));
        setIcon(new ImageIcon(imagenNave.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
        setBounds(x, y, ancho, alto);
    }

    public void mover(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D) {
            if (x != 530) {
                x += movimiento;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            if (x != 0) {
                x -= movimiento;
            }
        }
        setLocation(x, y);
    }

    public Rectangle getRectangle() {
        return this.getBounds();
    }
}