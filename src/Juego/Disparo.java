package Juego;

import javax.swing.*;

public abstract class Disparo extends JLabel{
    protected int ancho = 20;
    protected int alto = 40;
    private int x;
    private int y;
    
    public Disparo(int x,int y){
        this.x = x;
        this.y = y;
    }
    
}
