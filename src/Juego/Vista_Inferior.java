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
        panelVidas.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panelVidas.setBackground(Color.BLACK);
        add(panelVidas, BorderLayout.WEST);

        PanelCreditos.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        PanelCreditos.setBackground(Color.BLACK);
        add(PanelCreditos, BorderLayout.EAST);

        //agregamos la linea superior de color verde
        setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.GREEN));

        /**
         * representando el label de las vidas se agrego un estilo de letra
         * similar al arcade
         */
        vidas.setText(Integer.toString(VidasTotales));
        vidas.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        vidas.setForeground(Color.white);
        panelVidas.add(vidas);

        InicializarVidas();
        /**
         * En esta parte se agrega los creditos o las ranchas
         */
        creditos.setText("CREDIT 00");
        creditos.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        creditos.setForeground(Color.white);
        PanelCreditos.add(creditos);
    }

    /**
     * Se instancia el arreglo de JLabel y se le agrega las vidas
     */
    public void InicializarVidas() {
        JLabel vidasPersonaje[] = new JLabel[VidasTotales - 1];
        for (int i = 0; i < vidasPersonaje.length; i++) {
            try {
                vidasPersonaje[i] = new JLabel();
                vidasPersonaje[i].setIcon(new ImageIcon(imagenesVidas.getScaledInstance(50, 25, Image.SCALE_SMOOTH)));
                panelVidas.add(vidasPersonaje[i]);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void QuitarVida() {
        if(VidasTotales > 0){
            VidasTotales--;
        }
        vidas.setText(Integer.toString(VidasTotales));
        panelVidas.removeAll();
        panelVidas.add(vidas);
        InicializarVidas();
    }

    public int getVidasTotales() {
        return VidasTotales;
    }

    //agregamos las variables privadas
    private JLabel vidas = new JLabel();
    public int VidasTotales = 3;
    private Image imagenesVidas = new ImageIcon(Vista_Inferior.class.getResource("/source/personaje/Disparador.png")).getImage();
    private JPanel panelVidas = new JPanel();
    //creditos
    private JLabel creditos = new JLabel();
    private JPanel PanelCreditos = new JPanel();
}
