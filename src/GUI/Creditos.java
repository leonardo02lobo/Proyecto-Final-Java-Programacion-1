package GUI;

import Implementacion.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Creditos extends JPanel {

    public Creditos() {
        
        setLayout(null);
        setBackground(Color.BLACK);
        
        JLabel Creditos = new JLabel("Creditos");
        Creditos.setFont(new Font("calibri", 1, 40));
        Creditos.setBounds(170, 5, 400, 50);
        Creditos.setForeground(Color.YELLOW);
        add(Creditos);
        
        JTextArea textArea = new JTextArea(); // 10 filas, 20 columnas
        textArea.setText("Creador: Tomohiro Nishikado.\n"
                + "Desarrollador: Taito Corporation y se lanzo en 1978. \nGénero: Shooter, Arcade.\n" 
                + "\n" 
                + "Historia: \n\n"
                + "   Space Invaders es un juego de naves espaciales que fue un éxito\n instantáneo"
                + " y se convirtió en uno de los juegos más populares de la\n época.\n "
                + "Fue diseñado por Tomohiro Nishikado, quien se inspiró en la novela\n de ciencia ficción"
                + "\"La guerra de los mundos\" y en la película \"Star Wars\". \n\n"
                + "   El juego ha tenido un gran impacto en la industria de los videojuegos,\n "
                + "ha sido objeto de numerosas secuelas, remakes y spin-offs,\n"
                + " y ha inspirado a muchos otros juegos de naves espaciales.\n\n"
                + "Creadores del proyecto de programacion 1:\n"
                + "\n    Leonardo lobo, CI 31.489.733"
                + "\n    Moises Becerra, CI 30.965.748 ");
        
        textArea.setFont(new Font("arial",0,14));
        textArea.setBounds(18, 60, 460, 350);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        textArea.setCursor(new Cursor(Cursor.DEFAULT_CURSOR) {
        });
        add(textArea);

        JButton boton = new JButton("atras");
        boton.setBounds(200, 420, 100, 30);
        boton.setBackground(Color.BLACK);
        boton.setFocusable(false);
        boton.setForeground(Color.WHITE);
        
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.panel.removeAll();
                App.panel.add(App.menu, BorderLayout.CENTER);
                App.panel.revalidate();
                App.panel.repaint();
                App.menu.requestFocus();
            }
        });
        add(boton);
    }
}
