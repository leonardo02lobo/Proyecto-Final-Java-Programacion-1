package Juego.enemigos;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class NaveNodriza extends Alienigenas {
    
    private int movimientoX = 0;
    private final int movimientoY = 20;

    public NaveNodriza(int x, int y) {

        super(x, y);
        Image ImagenNave = new ImageIcon(getClass().getResource("../../source/enemigos/Platillo volador.png")).getImage();
        setIcon(new ImageIcon(ImagenNave.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
        setBounds(x, y, ancho, alto);
        Timer temporizador = new Timer(50, new ActionListener() { // cada 40 segundos
            public void actionPerformed(ActionEvent e) {
                update();
            }
        });
        temporizador.start();
    }

    public void update() {
        movimientoX+=movimiento;
        setLocation(movimientoX, movimientoY);
    }
}
