package GUI;

import Implementacion.*;
import Juego.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import logica.*;

/**
 * Esta clase nos genera el inicio del juego,aqui proporciona como se trabaja el
 * juego segun los datos que le proporcionemos(tipo de nave y enemigos)
 *
 * @author equipo
 */
public class Iniciar_Juego extends JPanel {

    public Iniciar_Juego() {
        setLayout(null);
        setBackground(Color.BLACK);

        //llamamos todos los componentes para ser pintados en el panel
        crearEtiquetas(new JLabel("Space Invader", SwingConstants.CENTER), 100, 50, 300, 70, 35, false, "");
        crearEtiquetas(etiquetaNombre, 140, 130, 200, 30, 15, false, "");
        crearEtiquetas(imagenBlancoNegro, 100, 250, 100, 100, 20, true, "/source/enemigos/Calamar 2.png");
        crearEtiquetas(imagenColor, 300, 250, 100, 100, 20, true, "/source/Sprites Color/enemy1_1.png");
        Cajas(nombre, 100, 180, 300, 30);
        CrearBoton(iniciarJuego, 120, 420, 100, 30, "Iniciar");
        CrearBoton(volver, 270, 420, 100, 30, "volver");
    }

    /**
     * Este metodo nos simplifica la llamada a los metodos de los componentes
     * label, con esto tambien agregamos las imagenes de los enemigos con los
     * cuales queremos jugar, este metodo posee una accion de mouse para mostrar
     * de manera visual cual fue el enemigo que el personaje eligio
     *
     * @param label
     * @param x
     * @param y
     * @param ancho
     * @param alto
     * @param tam
     * @param band
     * @param ruta
     */
    private void crearEtiquetas(JLabel label, int x, int y, int ancho, int alto, int tam, boolean band, String ruta) {
        if (band) {
            Image imagen = new ImageIcon(Iniciar_Juego.class.getResource(ruta)).getImage();
            label.setIcon(new ImageIcon(imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
            label.setBorder(BorderFactory.createLineBorder(Color.blue, 1));
        }
        label.setFont(new Font("OCR A Extended", Font.BOLD, tam));
        label.setBounds(x, y, ancho, alto);
        label.setForeground(Color.white);
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource().equals(imagenBlancoNegro)) {
                    imagenBlancoNegro.setBorder(BorderFactory.createLineBorder(Color.white, 3));
                    imagenColor.setBorder(BorderFactory.createLineBorder(Color.white, 0));
                    tipoJuego = 0;
                } else if (e.getSource().equals(imagenColor)) {
                    imagenBlancoNegro.setBorder(BorderFactory.createLineBorder(Color.white, 0));
                    imagenColor.setBorder(BorderFactory.createLineBorder(Color.white, 3));
                    tipoJuego = 1;
                }
                try {
                    new musica("src/source/music/clic.wav").reproducirClic();
                } catch (Exception ex) {
                }
            }
        });
        add(label);
    }

    /**
     * Este metodo al igual que el anterior nos simplifica el codigo llamando a
     * los metodos del componente
     *
     * @param caja
     * @param x
     * @param y
     * @param ancho
     * @param alto
     */
    private void Cajas(JTextField caja, int x, int y, int ancho, int alto) {
        caja.setFont(new Font("calibri", Font.PLAIN, 25));
        caja.setBounds(x, y, ancho, alto);
        caja.setBackground(Color.BLACK);
        caja.setForeground(Color.white);
        caja.setOpaque(false);
        add(caja);
    }

    /**
     * Este metodo se encarga de pintar los botones, a su vez posee una accion
     * de mouse para determinar cual seria la boton que se selecciono, si el
     * jugador seleciono jugar este valida si se introdujo y nombre para
     * continuar, y si presiona volver se regresa al otro panel
     *
     * @param boton
     * @param x
     * @param y
     * @param ancho
     * @param alto
     * @param texto
     */
    private void CrearBoton(JButton boton, int x, int y, int ancho, int alto, String texto) {
        boton.setText(texto);
        boton.setFont(new Font("OCR A Extended", 1, 15));
        boton.setBackground(Color.BLACK);
        boton.setFocusable(false);
        boton.setForeground(Color.white);
        boton.setBounds(x, y, ancho, alto);

        class Accion implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new musica("src/source/music/clic.wav").reproducirClic();
                } catch (Exception ex) {
                }
                if (e.getSource().equals(iniciarJuego)) {
                    validarJuego(e);
                } else if (e.getSource().equals(volver)) {
                    PanelMenu();
                }
            }

            /**
             * Valida si el usuario a introducido el nombre
             */
            private void validarJuego(ActionEvent e) {
                if (!(nombre.getText().equals("") && (tipoJuego != 0 || tipoJuego != 1))) {
                    Nivel_1 game = new Nivel_1(tipoJuego);
                    game.inicializarFrame();
                    PanelMenu();
                    App.ventana.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Ingresa el nombre y un tipo de enemigo para continuar");
                }
            }

            /**
             * Este metodo privado nos genera un cambio en el panel
             */
            private void PanelMenu() {
                App.panel.removeAll();
                App.panel.add(App.menu, BorderLayout.CENTER);
                App.panel.revalidate();
                App.panel.repaint();
                App.menu.requestFocus();
            }
        }
        boton.addActionListener(new Accion());

        App.panel.setFocusable(true);
        App.panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
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

    private JLabel etiquetaNombre = new JLabel("Ingrese su nombre:", SwingConstants.CENTER);
    private JLabel imagenBlancoNegro = new JLabel();
    private JLabel imagenColor = new JLabel();
    public static JTextField nombre = new JTextField();
    private JButton iniciarJuego = new JButton();
    private JButton volver = new JButton();
    private byte tipoJuego;
}
