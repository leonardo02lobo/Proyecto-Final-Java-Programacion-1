package Juego.personaje;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Este metodo se encarga de dibujar la nave (personaje principal), y genera sus
 * metodo y atributos
 *
 * @author equipo
 */
public class nave extends JLabel {

    private int ancho = 70;
    private int alto = 30;
    private int x = 250;
    private int y = 550;
    private final int movimiento = 10;
    private Image imagenNave;

    /**
     * Señala cual es el tipo de nave que se utilizara para el juego
     *
     * @param tipoJuego
     */
    public nave(byte tipoJuego) {
        if(tipoJuego == 0){
            imagenNave = new ImageIcon(nave.class.getResource("/source/personaje/Disparador.png")).getImage();
        }else{
            imagenNave = new ImageIcon(nave.class.getResource("/source/Sprites Color/ship.png")).getImage();
        }
        setIcon(new ImageIcon(imagenNave.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
        setBounds(x, y, ancho, alto);
    }

    /**
     * Este metodo obtiene un atributo de KeyEvent que nos genera que tecla fue
     * presionada y depende se movera de un lado o el otro
     *
     * @param e
     */
    public void mover(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D) {
            if (x != 510) {
                x += movimiento;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            if (x != 0) {
                x -= movimiento;
            }
        }
        setLocation(x, y);
    }

    /**
     * Este metodo nos genera un objeto de la clase rectangle, este metodo nos
     * ayuda luego para las colisiones
     *
     * @return
     */
    public Rectangle getRectangle() {
        return this.getBounds();
    }
}
