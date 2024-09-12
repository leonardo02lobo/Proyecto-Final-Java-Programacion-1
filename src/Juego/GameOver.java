package Juego;

import Implementacion.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import logica.*;

public class GameOver extends JPanel {
/**
 * Ventana que se refleja cuando el usuario pierde
 */
    public GameOver() {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        setBorder(BorderFactory.createLineBorder(Color.white, 5));
        setBounds(100, 150, 350, 200);
        add(new TituloPerdido(), BorderLayout.CENTER);
        add(new Botones(), BorderLayout.SOUTH);
    }
}
/**
 * Esta clase genera el JLabel del titulo Game Over
 * @author Moises
 */
class TituloPerdido extends JPanel {

    public TituloPerdido() {
        setBackground(Color.BLACK);
        titulo.setText("Game Over");
        titulo.setFont(new Font("OCR A Extended", Font.BOLD, 40));
        titulo.setForeground(Color.white);
        add(titulo);
    }
    JLabel titulo = new JLabel();
}
/**
 * Esta clase se encuentrar los botones que interactuan con la continuedad del usuario,
 * si quiere salir al menu pricipal o seguir jugando
 * @author Moises
 */
class Botones extends JPanel {

    public Botones() {
        setBackground(Color.BLACK);
        CrearBoton(volver,"volver");
        CrearBoton(salir,"salir del Juego");
    }
/**
 * Este metodo posee una clase local el cual implementa el ActionListener que detecta el
 * boton que presiona el usuario
 * 
 * @param boton
 * @param texto 
 */
    private void CrearBoton(JButton boton, String texto) {
        boton.setText(texto);
        boton.setFont(new Font("OCR A Extended", 1, 15));
        boton.setBackground(Color.BLACK);
        boton.setFocusable(false);
        boton.setForeground(Color.white);

        class Accion implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new musica("src/source/music/clic.wav").reproducirClic();
                } catch (Exception ex) {
                }
                if(e.getSource().equals(volver)){
                    App.ventana.setVisible(true);
                    Nivel_1.band_finalizar_Juego = true;
                    App.menu.requestFocus();
                }
                if(e.getSource().equals(salir)){
                    System.exit(0);
                }
            }
        }
        boton.addActionListener(new Accion());
        add(boton);
    }
    JButton volver = new JButton();
    JButton salir = new JButton();
}
