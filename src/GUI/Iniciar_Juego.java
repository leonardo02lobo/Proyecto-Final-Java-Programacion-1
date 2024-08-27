package GUI;

import Implementacion.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import logica.musica;

public class Iniciar_Juego extends JPanel {

    public Iniciar_Juego() {
        setLayout(null);
        setBackground(Color.BLACK);

        crearEtiquetas(new JLabel("Space Invader", SwingConstants.CENTER), 100, 50, 300, 70, 40);
        crearEtiquetas(etiquetaNombre, 100, 150, 200, 30, 20);
        Cajas(nombre, 120, 200, 200, 30);
        CrearBoton(iniciarJuego, 120, 300, 100, 30, "Iniciar");
        CrearBoton(volver, 270, 300, 100, 30, "volver");
    }

    private void crearEtiquetas(JLabel label, int x, int y, int ancho, int alto, int tam) {
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
                if(e.getSource().equals(iniciarJuego)){
                    
                }else{
                    Menu.ventana.dispose();
                    App.ventana.setVisible(true);
                }
            }
        }
        boton.addActionListener(new Accion());
        add(boton);
    }

    private JLabel etiquetaNombre = new JLabel("Ingrese su nombre:", SwingConstants.CENTER);
    private JTextField nombre = new JTextField();
    private JButton iniciarJuego = new JButton();
    private JButton volver = new JButton();
}
