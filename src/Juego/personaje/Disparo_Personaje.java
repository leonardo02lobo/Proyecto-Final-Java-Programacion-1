package Juego.personaje;

import Juego.*;
import java.awt.*;
import javax.swing.*;

/**
 * Esta clase crea el label de disparo, ya que la clase Disparo hereda de ella
 *
 * @author equipo
 */
public class Disparo_Personaje extends Disparo {

    /**
     * Se obtiene por parametro las coordenadas en X y Y del disparo
     *
     * @param x
     * @param y
     */
    public Disparo_Personaje(int x, int y) {
        super(x, y);
        setIcon(new ImageIcon(imagenDisparo.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
        setBounds(x, y, ancho, alto);
    }

    /**
     * Este metodo hace el movimiento de animacion del personaje
     *
     * @return
     */
    public int movimientoDisparo() {
        return getY() - movimiento;
    }

    /**
     * Este metodo nos proporciona un objeto de la clase Rectangle que luehgo
     * nos ayudara para las colisiones
     *
     * @return
     */
    @Override
    public Rectangle getRectangle() {
        return this.getBounds();
    }

    private Image imagenDisparo = new ImageIcon(Disparo_Personaje.class.getResource("/source/personaje/Bala.png")).getImage();
}
