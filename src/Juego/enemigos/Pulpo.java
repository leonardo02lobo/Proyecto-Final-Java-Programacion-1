package Juego.enemigos;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Pulpo extends Alienigenas {

    private Image imagenPulpoBlanco[] = {
        new ImageIcon(getClass().getResource("../../source/enemigos/Pulpo 1.png")).getImage(),
        new ImageIcon(getClass().getResource("../../source/enemigos/Pulpo 2.png")).getImage(),
        new ImageIcon(getClass().getResource("../../source/enemigos/Muerte enemigo.png")).getImage(),};
    private Image imagenPulpoColor[] = {
        new ImageIcon(getClass().getResource("../../source/Sprites Color/enemy3_1.png")).getImage(),
        new ImageIcon(getClass().getResource("../../source/Sprites Color/enemy3_2.png")).getImage(),
        new ImageIcon(getClass().getResource("../../source/Sprites Color/explosiongreen.png")).getImage(),};
    private int i = 0;
    private Image imagen[] = null;

    public Pulpo(int x, int y) {
        super(x, y);
        setBounds(x, y, ancho, alto);
    }

    @Override
    public Rectangle getRectangle() {
        return this.getBounds();
    }

    @Override
    public void AnimacionYSkin(byte tipo) {
        if (tipo == 0) {
            imagen = imagenPulpoBlanco;
        } else {
            imagen = imagenPulpoColor;
        }
        animacion = new Timer(getDataTime(), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setIcon(new ImageIcon(imagen[i].getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
                i++;
                if (i >= imagen.length - 1) {
                    i = 0;
                }
            }
        });
        animacion.start();
    }

    @Override
    public int getPuntos() {
        return 10;
    }
}
