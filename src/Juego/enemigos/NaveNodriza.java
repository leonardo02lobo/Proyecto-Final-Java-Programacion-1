package Juego.enemigos;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import logica.musica;

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
        animacion = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (movimientoX < 600) {
                    new musica("src/source/music/mysterykilled.wav").reproducirClic();
                    movimientoX += movimiento;
                } else {
                    animacion.stop();
                }
                setLocation(movimientoX, movimientoY);
            }
        });
        animacion.start();
    }

    @Override
    public void AnimacionYSkin(byte tipo) {
        return;
    }

    @Override
    public int getPuntos() {
        return (int) (Math.random() * (100 - 50) + 50);
    }

    @Override
    public Rectangle getRectangle() {
        return this.getBounds();
    }

}
