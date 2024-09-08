package Juego.enemigos;

import java.awt.*;
import javax.swing.*;

public class NaveNodriza_Nivel_2 extends Alienigenas {

    private Image imagenNave = new ImageIcon(getClass().getResource("../../source/enemigos/Nave Nodriza.png")).getImage();
    public byte golpes = 0;
    
    public NaveNodriza_Nivel_2(int x, int y) {
        super(x, y);
        ancho = 100;
        alto = 50;
        setIcon(new ImageIcon(imagenNave.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
        setBounds(x, y, ancho, alto);
    }

    @Override
    public void AnimacionYSkin(byte tipo) {
        return;
    }

    public JLabel laser(int x, int y, int anchoIncrementado, int alto) {
        JLabel laser = new JLabel();
        Image imagenLaser = new ImageIcon(getClass().getResource("../../source/enemigos/Laser_Nave Nodirza.png")).getImage();
        laser.setIcon(new ImageIcon(imagenLaser.getScaledInstance(anchoIncrementado, alto, Image.SCALE_SMOOTH)));
        laser.setBounds(x, y, anchoIncrementado, alto);
        return laser;
    }

    @Override
    public int getPuntos() {
        return 100;
    }

}
