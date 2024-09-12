package Juego;

import Implementacion.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pause extends JPanel {

    private JLabel VolverJuego = new JLabel("Volver al Juego", SwingConstants.CENTER);
    private JLabel SalirConGuardar = new JLabel("Salir y Guardar", SwingConstants.CENTER);
    private JLabel SalirSinGuardar = new JLabel("Salir sin Guardar", SwingConstants.CENTER);
    private JLabel volumen = new JLabel();
    private JPanel panelVolumen = new JPanel();
    private byte i = 0;
    public boolean bandera = false;
    public boolean detener = false;
    public boolean guardar_partida = false;

    public Pause() {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        setBorder(BorderFactory.createLineBorder(Color.white, 5));
        setBounds(150, 150, 300, 300);

        panel.setLayout(null);
        panel.setBackground(Color.BLACK);
        add(panel, BorderLayout.CENTER);

        panelVolumen.setLayout(new FlowLayout());
        panelVolumen.setBackground(Color.BLACK);
        add(panelVolumen, BorderLayout.SOUTH);

        crearEtiquetas(VolverJuego, 0, 50, 300, 70, 20, false, "");
        crearEtiquetas(SalirSinGuardar, 0, 100, 300, 70, 20, false, "");
        crearEtiquetas(SalirConGuardar, 0, 150, 300, 70, 20, false, "");
        crearEtiquetas(volumen, 210, 250, 50, 50, 0, true, "/source/extra/aumentar.jpeg");
    }

    JPanel panel = new JPanel();

    private void crearEtiquetas(JLabel label, int x, int y, int ancho, int alto, int tam, boolean band, String ruta) {
        if (band) {
            Image imagen = new ImageIcon(Pause.class.getResource(ruta)).getImage();
            label.setIcon(new ImageIcon(imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
        }
        label.setFont(new Font("OCR A Extended", 1, tam));
        label.setBounds(x, y, ancho, alto);
        label.setForeground(Color.white);
        class AccionBoton extends MouseAdapter {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource().equals(volumen)) {
                    i++;
                    Image imagen = null;
                    if (i % 2 == 0) {
                        App.Musica.reproducir();
                        imagen = new ImageIcon(Pause.class.getResource("/source/extra/aumentar.jpeg")).getImage();
                    } else {
                        App.Musica.detener();
                        imagen = new ImageIcon(Pause.class.getResource("/source/extra/silenciar.jpeg")).getImage();
                    }
                    volumen.setIcon(new ImageIcon(imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
                    if (i > 127) {
                        i = 0;
                    }
                } else if (e.getSource().equals(VolverJuego)) {
                    bandera = true;
                } else if (e.getSource().equals(SalirConGuardar) || e.getSource().equals(SalirSinGuardar)) {
                    if (e.getSource().equals(SalirConGuardar)) {
                        guardar_partida = true;
                    }
                    detener = true;
                    App.ventana.setVisible(true);
                    App.menu.requestFocus();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (!(label.equals(volumen))) {
                    e.getComponent().setFont(new Font("OCR A Extended", Font.TRUETYPE_FONT, tam));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!(label.equals(volumen))) {
                    e.getComponent().setFont(new Font("OCR A Extended", Font.BOLD, tam));
                }
            }

        }
        label.addMouseListener(new AccionBoton());
        if (label.equals(volumen)) {
            panelVolumen.add(label);
        } else {
            panel.add(label);
        }
    }

}
