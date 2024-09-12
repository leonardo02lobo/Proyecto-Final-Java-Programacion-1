package Juego.enemigos;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import logica.musica;

public class NaveNodriza extends Alienigenas {

    private int movimientoX;
    private final int movimientoY = 20;

    public NaveNodriza(int x, int y) {

        super(x, y);
        ancho = 50;
        alto = 30;
        Image ImagenNave = new ImageIcon(NaveNodriza.class.getResource("/source/enemigos/Platillo volador.png")).getImage();
        setIcon(new ImageIcon(ImagenNave.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
        setBounds(x, y, ancho, alto);
    }

    public void update() {
        int random = (int) (Math.random() * 2);
        int movimiento = 5;
        int direction;

        if (random == 0) {
            movimientoX = 0;
            direction = 1;
        } else {
            movimientoX = 550;
            direction = -1;
        }
        if (animacion != null) {
            animacion.stop();
            animacion = null;
        }

        animacion = new Timer(16, new ActionListener() {
            boolean final_Ciclo = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new musica("src/source/music/mysterykilled.wav").reproducirClic();
                } catch (Exception ex) {
                }
                try {
                    movimientoX += movimiento * direction;
                    if ((direction == 1 && movimientoX >= 600) || (direction == -1 && movimientoX <= -50)) {
                        final_Ciclo = true;
                    }
                } finally {
                    if (final_Ciclo) {
                        animacion.stop();
                    }
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
