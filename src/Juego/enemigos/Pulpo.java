package Juego.enemigos;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Pulpo extends Alienigenas {

    private Image imagenPulpo[] = {
        new ImageIcon(getClass().getResource("../../source/enemigos/Pulpo 1.png")).getImage(),
        new ImageIcon(getClass().getResource("../../source/enemigos/Pulpo 2.png")).getImage(),};
    private int i = 0;

    public Pulpo(int x, int y) {
        super(x, y);
        Timer Animacionulpo = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setIcon(new ImageIcon(imagenPulpo[i].getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
                i++;
                if (i >= imagenPulpo.length) {
                    i = 0;
                }
            }
        });
        Animacionulpo.start();
        setBounds(x, y, ancho, alto);
    }

    @Override
    public Rectangle getRectangle() {
        return this.getBounds();
    }
}
