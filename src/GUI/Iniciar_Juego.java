package GUI;

import Implementacion.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import logica.*;

public class Iniciar_Juego extends JPanel {

    public Iniciar_Juego() {
        setLayout(null);
        setBackground(Color.BLACK);

        crearEtiquetas(new JLabel("Space Invader", SwingConstants.CENTER), 100, 50, 300, 70, 40,false,"");
        crearEtiquetas(etiquetaNombre, 100, 100, 200, 30, 20,false,"");
        Cajas(nombre, 120, 150, 200, 30);
//        crearEtiquetas(imagenBlancoNegro, 70, 250, 100, 100, 0,false,"../source/enemigos/Calamar2.png");
        crearEtiquetas(imagenColor, 300, 250, 100, 100, 20,true,"../source/Sprites Color/enemy1_1.png");
        CrearBoton(iniciarJuego, 120, 420, 100, 30, "Iniciar");
        CrearBoton(volver, 270, 420, 100, 30, "volver");
    }

    private void crearEtiquetas(JLabel label, int x, int y, int ancho, int alto, int tam,boolean band,String ruta) {
        if(band){
            Image imagen = new ImageIcon(getClass().getResource(ruta)).getImage();
            label.setIcon(new ImageIcon(imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
            label.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        }
        label.setFont(new Font("calibri", Font.BOLD, tam));
        label.setBounds(x, y, ancho, alto);
        label.setForeground(Color.white);
        add(label);
    }

    private void Cajas(JTextField caja, int x, int y, int ancho, int alto) {
        caja.setFont(new Font("calibri", Font.PLAIN, 20));
        caja.setBounds(x, y, ancho, alto);
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

                } else {
                    App.panel.removeAll();
                    App.panel.add(App.menu, BorderLayout.CENTER);
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
