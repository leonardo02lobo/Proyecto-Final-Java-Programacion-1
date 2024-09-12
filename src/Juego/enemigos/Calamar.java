package Juego.enemigos;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Calamar extends Alienigenas {
/**
 * En estos atributos privados su funcion es pintar los personajes en el panel asignandole su posicion tanto en X como en Y
 * 
 */
    private Image imagenCalamarBlanco[] = {
        new ImageIcon(Calamar.class.getResource("/source/enemigos/Calamar 1.png")).getImage(),
        new ImageIcon(Calamar.class.getResource("/source/enemigos/Calamar 2.png")).getImage(),};
    private Image imagenCalamarColor[] = {
        new ImageIcon(Calamar.class.getResource("/source/Sprites Color/enemy1_1.png")).getImage(),
        new ImageIcon(Calamar.class.getResource("/source/Sprites Color/enemy1_2.png")).getImage(),};
    private int i = 0;
    private Image imagen[] = null;

    public Calamar(int x, int y) {
        super(x, y);
        setBounds(x, y, ancho, alto);
    }
//Genera las colisiones
    @Override
    public Rectangle getRectangle() {
        return this.getBounds();
    }
/**
 * El siguiente metodo se encarga de la animacion de los personajes
 * @param tipo 
 */    
    @Override
    public void AnimacionYSkin(byte tipo){
        if(tipo == 0){
            imagen = imagenCalamarBlanco;
        }else{
            imagen = imagenCalamarColor;
        }
        animacion = new Timer(getDataTime(), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setIcon(new ImageIcon(imagen[i].getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
                i++;
                if (i >= imagen.length) {
                    i = 0;
                }
            }
        });
        animacion.start();
        
    }
//En el siguiente metodo publico aplicamos polimorfismo ya que los alienigenas trabajan con diferentes puntos
    @Override
    public int getPuntos() {
        return 30;
    }

}
