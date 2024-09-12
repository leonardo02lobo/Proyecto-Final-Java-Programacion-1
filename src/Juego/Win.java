package Juego;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Win extends JPanel {
/**
 * Constructor con parametros que llama a las clases internas 
 * @param band
 * @param tipoJuego 
 */
    public Win(boolean band,byte tipoJuego) {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        setBorder(BorderFactory.createLineBorder(Color.white, 5));
        setBounds(100, 150, 350, 200);
        add(new TituloGanador(), BorderLayout.CENTER);
        add(new Tiempo(band,tipoJuego), BorderLayout.SOUTH);
    }
}
/**
 * Clase interna que al ganar refleja un panel que dice que has avanzado de nivel
 * @author Moises
 */
class TituloGanador extends JPanel {

    public TituloGanador() {
        setBackground(Color.BLACK);
        titulo.setText("Haz Pasado al segundo nivel");
        titulo.setFont(new Font("OCR A Extended", Font.BOLD, 18));
        titulo.setForeground(Color.white);
        add(titulo);
    }
    JLabel titulo = new JLabel();
}
/**
 * Clase interna que contiene un timer de 5 segundos para poder mostrar o cargar el segundo nivel
 * @author Moises
 */
class Tiempo extends JPanel {

    public Tiempo(boolean band,byte tipoJuego) {
        setBackground(Color.BLACK);
        hiloTiempo = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (band) {
                    tiempo.setText(Integer.toString(segundos));
                    if (segundos == 0) {
                        Nivel_2 nivel_2 = new Nivel_2(tipoJuego);
                        nivel_2.inicializarFrame();
                        Logica_Juego.band_finalizar_Juego = true;
                        hiloTiempo.stop();
                    }
                    segundos--;
                }
            }
        });
        hiloTiempo.start();
        tiempo.setFont(new Font("OCR A Extended", Font.BOLD, 18));
        tiempo.setForeground(Color.white);
        add(tiempo);
    }
    //Atributos de la clase
    private JLabel tiempo = new JLabel();
    private int segundos = 5;
    private Timer hiloTiempo = null;
}
