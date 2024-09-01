package Juego.enemigos;

import java.awt.Image;
import javax.swing.ImageIcon;

public class NaveNodriza extends Alienigenas {
    
    private int movimientoX = 0;
    private final int movimientoY = 20;

    public NaveNodriza(int x, int y) {

        super(x, y);
        ancho = 50;
        alto = 30;
        Image ImagenNave = new ImageIcon(getClass().getResource("../../source/enemigos/Platillo volador.png")).getImage();
        setIcon(new ImageIcon(ImagenNave.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
        setBounds(x, y, ancho, alto);
    }

    public void update() {
        movimientoX+=movimiento;
        setLocation(movimientoX, movimientoY);
    }

    @Override
    public void AnimacionYSkin(byte tipo) {
        return;
    }

    @Override
    public int getPuntos() {
        return (int)(Math.random()*(100-50)+50);
    }
}
