package Juego.enemigos;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Calamar extends Alienigenas {

    private Image imagenCalamarBlanco[] = {
        new ImageIcon(getClass().getResource("../../source/enemigos/Calamar 1.png")).getImage(),
        new ImageIcon(getClass().getResource("../../source/enemigos/Calamar 2.png")).getImage(),};
    private Image imagenCalamarColor[] = {
        new ImageIcon(getClass().getResource("../../source/Sprites Color/enemy1_1.png")).getImage(),
        new ImageIcon(getClass().getResource("../../source/Sprites Color/enemy1_2.png")).getImage(),};
    private int i = 0;
    private Image imagen[] = null;

    public Calamar(int x, int y) {
        super(x, y);
        setBounds(x, y, ancho, alto);
    }

    @Override
    public Rectangle getRectangle() {
        return this.getBounds();
    }
    
    @Override
    public void AnimacionYSkin(byte tipo){
        if(tipo == 0){
            imagen = imagenCalamarBlanco;
        }else{
            imagen = imagenCalamarColor;
        }
        Timer AnimacionCalamar = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setIcon(new ImageIcon(imagen[i].getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
                i++;
                if (i >= imagen.length) {
                    i = 0;
                }
            }
        });
        AnimacionCalamar.start();
        
    }
}
