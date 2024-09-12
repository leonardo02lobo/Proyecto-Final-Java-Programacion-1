package Juego;

import GUI.Iniciar_Juego;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Vista_Superior extends JPanel {
    /**
     * Metodo constructor que contiene JLabels y JPanel encargados de mostar el nombre 
     * de usuario, puntos, tambien muestra el boton llamado menu que muestra un panel 
     * que le permite al usuario tener varias opcciones como volver al juegos, guardar y salir
     * y salir sin guardar
     */
    public Vista_Superior(){
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        panelPuntos.setBackground(Color.BLACK);
        add(panelPuntos,BorderLayout.WEST);
        
        panelBoton.setBackground(Color.BLACK);
        add(panelBoton,BorderLayout.EAST);
        
        
        Score.setFont(new Font("OCR A Extended",2,20));
        Score.setForeground(Color.WHITE);
        panelPuntos.add(Score);
        
        Points.setFont(new Font("OCR A Extended",2,20));
        Points.setText("    POINTS: "+puntos);
        Score.setText("NAME: "+Iniciar_Juego.nombre.getText());
        Points.setForeground(Color.WHITE);
        panelPuntos.add(Points);
        
        JButton boton = new JButton();
        boton.setForeground(Color.WHITE);
        boton.setBackground(Color.BLACK);
        boton.setFont(new Font("OCR A Extended",2,20));
        boton.setText("Menu");
        boton.setBounds(400, 10, 100,30);
        boton.setFocusable(false);
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                band = true;
            }
        });
        panelBoton.add(boton);
        
    }
    //Metodo publico que muestra el puntaje obtenido por el usuario
    public void SumarPuntos(int suma){
        puntos += suma;
        Points.setText("    POINTS: "+puntos);
    }

    public int getPuntos() {
        return puntos;
    }    
    //Atributos de esta clase
    private JLabel Points = new JLabel();
    public static int puntos = 0;
    private JPanel panelPuntos = new JPanel();
    private JPanel panelBoton = new JPanel();
    public boolean band = false;
    private JLabel Score = new JLabel();
}
