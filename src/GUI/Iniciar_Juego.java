package GUI;

import Implementacion.*;
import Juego.Game;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import logica.*;

public class Iniciar_Juego extends JPanel {

    public Iniciar_Juego() {
        setLayout(null);
        setBackground(Color.BLACK);

        crearEtiquetas(new JLabel("Space Invader", SwingConstants.CENTER), 100, 50, 300, 70, 40, false, "");
        crearEtiquetas(etiquetaNombre, 140, 130, 200, 30, 20, false, "");
        crearEtiquetas(imagenBlancoNegro, 100, 250, 100, 100, 20, true, "../source/enemigos/Calamar 2.png");
        crearEtiquetas(imagenColor, 300, 250, 100, 100, 20, true, "../source/Sprites Color/enemy1_1.png");
        Cajas(nombre, 100, 180, 300, 30);
        CrearBoton(iniciarJuego, 120, 420, 100, 30, "Iniciar");
        CrearBoton(volver, 270, 420, 100, 30, "volver");
    }

    private void crearEtiquetas(JLabel label, int x, int y, int ancho, int alto, int tam, boolean band, String ruta) {
        if (band) {
            Image imagen = new ImageIcon(getClass().getResource(ruta)).getImage();
            label.setIcon(new ImageIcon(imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
            label.setBorder(BorderFactory.createLineBorder(Color.blue, 1));
        }
        label.setFont(new Font("calibri", Font.BOLD, tam));
        label.setBounds(x, y, ancho, alto);
        label.setForeground(Color.white);
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource().equals(imagenBlancoNegro)) {
                    imagenBlancoNegro.setBorder(BorderFactory.createLineBorder(Color.white, 3));
                    imagenColor.setBorder(BorderFactory.createLineBorder(Color.white, 0));
                } else if (e.getSource().equals(imagenColor)) {
                    imagenBlancoNegro.setBorder(BorderFactory.createLineBorder(Color.white, 0));
                    imagenColor.setBorder(BorderFactory.createLineBorder(Color.white, 3));
                }
                new musica("src/source/music/clic.wav").reproducirClic();
            }
        });
        add(label);
    }

    private void Cajas(JTextField caja, int x, int y, int ancho, int alto) {
        caja.setFont(new Font("calibri", Font.PLAIN, 25));
        caja.setBounds(x, y, ancho, alto);
        caja.setBackground(Color.BLACK);
        caja.setForeground(Color.white);
        caja.setOpaque(false);
        add(caja);
    }

    private void CrearBoton(JButton boton, int x, int y, int ancho, int alto, String texto) {
        boton.setText(texto);
        boton.setBackground(Color.BLACK);
        boton.setFocusable(false);
        boton.setForeground(Color.white);
        boton.setBounds(x, y, ancho, alto);

        class Accion implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                new musica("src/source/music/clic.wav").reproducirClic();
                if (e.getSource().equals(iniciarJuego)) {
                    JFrame frame = new JFrame("Space Invader");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(600, 600);
                    frame.setLocationRelativeTo(null);
                    frame.add(new Game());
                    frame.setVisible(true);
                    App.ventana.dispose();
                } else {
                    App.panel.removeAll();
                    App.panel.add(App.panel, BorderLayout.CENTER);
                    App.panel.revalidate();
                    App.panel.repaint();
                    App.menu.requestFocus();
                }
            }
        }
        boton.addActionListener(new Accion());
        add(boton);
    }

    private JLabel etiquetaNombre = new JLabel("Ingrese su nombre:", SwingConstants.CENTER);
    private JLabel imagenBlancoNegro = new JLabel();
    private JLabel imagenColor = new JLabel();
    private JTextField nombre = new JTextField();
    private JButton iniciarJuego = new JButton();
    private JButton volver = new JButton();
}
