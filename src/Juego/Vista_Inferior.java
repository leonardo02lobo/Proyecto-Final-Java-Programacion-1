package Juego;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * En esta clase se encarga de pinta el panel de las vidas esta clase contiene
 * la cantidad de vidas del jugador
 */
public class Vista_Inferior extends JPanel {

    public Vista_Inferior() {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        //Intancia de los paneles que usaremos para organizarlo
        panelVidas.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        panelVidas.setBackground(Color.BLACK);
        add(panelVidas,BorderLayout.WEST);
        
        PanelCreditos.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        PanelCreditos.setBackground(Color.BLACK);
        add(PanelCreditos,BorderLayout.EAST);

        //agregamos la linea superior de color verde
        setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.GREEN));

        /**
         * representando el label de las vidas se agrego un estilo de letra
         * similar al arcade
         */
        vidas.setText("3");
        vidas.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        vidas.setForeground(Color.white);
        panelVidas.add(vidas);
        /**
         * Se instancia el arreglo de JLabel y se le agrega las vidas
         */
        for (int i = 0; i < vidasPersonaje.length; i++) {
            vidasPersonaje[i] = new JLabel();
            vidasPersonaje[i].setIcon(new ImageIcon(imagenesVidas[i].getScaledInstance(50, 25, Image.SCALE_SMOOTH)));
            panelVidas.add(vidasPersonaje[i]);
        }
        /**
         * En esta parte se agrega los creditos o las ranchas
         */
        creditos.setText("CREDIT 00");
        creditos.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        creditos.setForeground(Color.white);
        PanelCreditos.add(creditos);
    }
    
    //agregamos las variables privadas
    private JLabel vidas = new JLabel();
    private Image imagenesVidas[] = {
        new ImageIcon(getClass().getResource("../source/personaje/Disparador.png")).getImage(),
        new ImageIcon(getClass().getResource("../source/personaje/Disparador.png")).getImage(),};
    private JLabel vidasPersonaje[] = new JLabel[2];
    private JPanel panelVidas = new JPanel();
    //creditos
    private JLabel creditos = new JLabel();
    private JPanel PanelCreditos = new JPanel();
}
