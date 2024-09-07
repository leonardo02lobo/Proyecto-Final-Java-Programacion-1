package Juego;

import Implementacion.App;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import logica.musica;

public class GameOver extends JPanel {

    public GameOver() {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        setBorder(BorderFactory.createLineBorder(Color.white, 5));
        setBounds(100, 150, 350, 200);
        add(new TituloPerdido(), BorderLayout.CENTER);
        add(new Botones(), BorderLayout.SOUTH);
    }
}

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

class Botones extends JPanel {

    public Botones() {
        setBackground(Color.BLACK);
        CrearBoton(volver,"volver");
        CrearBoton(salir,"salir del Juego");
    }

    private void CrearBoton(JButton boton, String texto) {
        boton.setText(texto);
        boton.setFont(new Font("OCR A Extended", 1, 15));
        boton.setBackground(Color.BLACK);
        boton.setFocusable(false);
        boton.setForeground(Color.white);

        class Accion implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                new musica("src/source/music/clic.wav").reproducirClic();
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
