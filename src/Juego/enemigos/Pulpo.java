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
        new ImageIcon(getClass().getResource("../../source/enemigos/Pulpo 2.png")).getImage(),};
    private Image imagenPulpoColor[] = {
        new ImageIcon(getClass().getResource("../../source/Sprites Color/enemy3_1.png")).getImage(),
        new ImageIcon(getClass().getResource("../../source/Sprites Color/enemy3_2.png")).getImage(),};
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
        if(tipo == 0){
            imagen = imagenPulpoBlanco;
        }else{
            imagen = imagenPulpoColor;
        }
        Timer Animacionulpo = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setIcon(new ImageIcon(imagen[i].getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
                i++;
                if (i >= imagen.length) {
                    i = 0;
                }
            }
        });
        Animacionulpo.start();
    }
}
