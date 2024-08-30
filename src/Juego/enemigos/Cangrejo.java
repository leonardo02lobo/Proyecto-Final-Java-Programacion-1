package Juego.enemigos;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Cangrejo extends Alienigenas {
    private Image imagenCangrejo[] = {
        new ImageIcon(getClass().getResource("../../source/enemigos/Cangrejo 1.png")).getImage(),
        new ImageIcon(getClass().getResource("../../source/enemigos/Cangrejo 2.png")).getImage(),};
    private int i = 0;

    public Cangrejo(int x, int y) {
        super(x, y);
        Timer AnimacionCangrejo = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setIcon(new ImageIcon(imagenCangrejo[i].getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
                i++;
                if (i >= imagenCangrejo.length) {
                    i = 0;
                }
            }
        });
        AnimacionCangrejo.start();
        setBounds(x, y, ancho, alto);
    }

    @Override
    public Rectangle getRectangle() {
        return this.getBounds();
    }
}
