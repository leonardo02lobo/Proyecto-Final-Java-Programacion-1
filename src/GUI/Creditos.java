package GUI;

import Implementacion.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import logica.musica;

public class Creditos extends JPanel {

    public Creditos() {

        setLayout(null);
        setBackground(Color.BLACK);

        JLabel Creditos = new JLabel("Creditos");
        Creditos.setFont(new Font("OCR A Extended", 1, 40));
        Creditos.setBounds(170, 5, 400, 50);
        Creditos.setForeground(Color.YELLOW);
        add(Creditos);

        JTextArea textArea = new JTextArea(); // 10 filas, 20 columnas
        textArea.setText("Creador: Tomohiro Nishikado.\n"
                + "Desarrollador: Taito Corporation y se lanzo en 1978. \nGénero: Shooter, Arcade.\n"
                + "\n"
                + "Historia: \n\n"
                + "   Space Invaders es un juego de naves espaciales que\n fue un éxito instantáneo"
                + " y se convirtió en uno de los \njuegos más populares de la época.\n "
                + "Fue diseñado por Tomohiro Nishikado, quien se inspiró en \nla novela de ciencia ficción "
                + "\"La guerra de los mundos\"\n y en la película \"Star Wars\". \n\n"
                + "   El juego ha tenido un gran impacto en la industria de\n los videojuegos, "
                + "ha sido objeto de numerosas secuelas,\n remakes y spin-offs, "
                + " y ha inspirado a muchos otros \njuegos de naves espaciales.\n\n"
                + "Creadores del proyecto de programacion 1:\n"
                + "\n    Leonardo lobo, CI 31.489.733"
                + "\n    Moises Becerra, CI 30.965.748 ");

        textArea.setFont(new Font("OCR A Extended", 0, 14));
        textArea.setBounds(18, 60, 460, 350);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        textArea.setCursor(new Cursor(Cursor.DEFAULT_CURSOR) {
        });
        add(textArea);

        JButton boton = new JButton("Atras");
        boton.setBounds(200, 420, 100, 30);
        boton.setFont(new Font("OCR A Extended", 1, 18));
        boton.setBackground(Color.BLACK);
        boton.setFocusable(false);
        boton.setForeground(Color.WHITE);

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
        App.panel.setFocusable(true);
        App.panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                try {
                    new musica("src/source/music/clic.wav").reproducirClic();
                } catch (Exception ex) {
                }
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    volverMenu();
                }
            }
        });
        add(boton);
    }

    private void volverMenu() {
        App.panel.removeAll();
        App.panel.add(App.menu, BorderLayout.CENTER);
        App.panel.revalidate();
        App.panel.repaint();
        App.menu.requestFocus();
    }
}
