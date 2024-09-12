package GUI;

import Implementacion.*;
import Juego.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import logica.Guardar_Datos_Partida;
import logica.musica;

public class Guardar_Partida extends JPanel {

    public Guardar_Partida() {
        setBackground(Color.BLACK);

        JButton boton = new JButton("atras");
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new musica("src/source/music/clic.wav").reproducirClic();
                } catch (Exception ex) {
                }
                volverMenu();
            }
        });
        add(boton);
        
        JButton boton2 = new JButton("cargar partida");
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Nivel_1 juego = (Nivel_1) new Guardar_Datos_Partida().obtenerPartida();
            }
        });
        add(boton2);
        
        App.panel.setFocusable(true);
        App.panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    volverMenu();
                }
            }
        });
        
    }

    private void volverMenu() {
        App.panel.removeAll();
        App.panel.add(App.menu, BorderLayout.CENTER);
        App.panel.revalidate();
        App.panel.repaint();
        App.menu.requestFocus();
    }
}
