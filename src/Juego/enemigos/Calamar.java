package Juego.enemigos;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Calamar extends Alienigenas {

    private Image imagenCalamar[] = {
        new ImageIcon(getClass().getResource("../../source/enemigos/Calamar 1.png")).getImage(),
        new ImageIcon(getClass().getResource("../../source/enemigos/Calamar 2.png")).getImage(),};
    private int i = 0;

    public Calamar(int x, int y) {
        super(x, y);
        Timer AnimacionCalamar = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setIcon(new ImageIcon(imagenCalamar[i].getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
                i++;
                if (i >= imagenCalamar.length) {
                    i = 0;
                }
            }
        });
        AnimacionCalamar.start();
        setBounds(x, y, ancho, alto);
    }

    public Rectangle getRectangle() {
        return this.getBounds();
    }
}
