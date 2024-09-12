package Juego.enemigos;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Cangrejo extends Alienigenas {
/**
 * Atributos privados encargados de pintar los personajes en el panel y tambien se encuentra su constructor 
 * que establece su posicion y recorrido
 */
    private Image imagenCangrejoBlanco[] = {
        new ImageIcon(Cangrejo.class.getResource("/source/enemigos/Cangrejo 1.png")).getImage(),
        new ImageIcon(Cangrejo.class.getResource("/source/enemigos/Cangrejo 2.png")).getImage(),};
    private Image imagenCangrejoColor[] = {
        new ImageIcon(Cangrejo.class.getResource("/source/Sprites Color/enemy2_1.png")).getImage(),
        new ImageIcon(Cangrejo.class.getResource("/source/Sprites Color/enemy2_1.png")).getImage(),};
    private int i = 0;
    private Image imagen[] = null;

    public Cangrejo(int x, int y) {
        super(x, y);
        setBounds(x, y, ancho, alto);
    }
//Genera las colisiones del mismo
    @Override
    public Rectangle getRectangle() {
        return this.getBounds();
    }
/**
 * Snimacion de los personajes 
 * @param tipo 
 */
    @Override
    public void AnimacionYSkin(byte tipo) {
        if (tipo == 0) {
            imagen = imagenCangrejoBlanco;
        } else {
            imagen = imagenCangrejoColor;
        }
        animacion = new Timer(getDataTime(), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setIcon(new ImageIcon(imagen[i].getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
                i++;
                if (i >= imagen.length) {
                    i = 0;
                }
            }
        });
        animacion.start();
    }
//Se aplica polimorfismo porque los alienigenas tienen diferentes puntos cada uno
    @Override
    public int getPuntos() {
        return 20;
    }

}
