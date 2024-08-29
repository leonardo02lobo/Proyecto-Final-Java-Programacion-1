package GUI;

import Implementacion.App;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Instrucciones extends JPanel {

    public Instrucciones() {
        setLayout(null);
        setBackground(Color.BLACK);
        
       
        JLabel textoBienvenida = new JLabel("Instrucciones");
        textoBienvenida.setFont(new Font("cooper black", 3, 30));
        textoBienvenida.setBounds(125, 5, 400, 40);
        textoBienvenida.setForeground(Color.YELLOW);
        add(textoBienvenida);
        
        
        JTextArea textArea = new JTextArea(); // 10 filas, 20 columnas
        textArea.setText("Objetivo: Destruye todas las oleadas de alienígenas"+
                "antes de que\n lleguen a la parte inferior de la pantalla.\n" +
                "\nControles: Mover izquierda a derecha con: "+"'A' "+"y 'D'"+"\n"+
                "\nDisparar: Barra espaciadora\n" +
                
                "\nDinámica:" +
                "\n  *Los alienígenas se mueven de lado a lado y bajan lentamente.\n" +
                "  *Usa las barreras como protección, pero se desgastan con los disparos.\n" +
                "  *Derriba la nave nodriza para puntos extra.\n" +
                
                "\nPuntuación: \n" +
                "  *Más puntos por alienígenas en filas superiores.\n" +
                "  *La nave nodriza otorga puntos aleatorios.\n" +
                
                "\nGame Over: \n" +
                "\nLos alienígenas llegan abajo o pierdes todas tus vidas.\n" +
                "\n");
        textArea.setFont(new Font("arial",0,14));
        textArea.setBounds(18, 60, 450, 320);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        add(textArea);
        
       

        JButton boton = new JButton();
        CrearBoton(boton, 200, 420, 100, 30, "atras");
        
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.panel.removeAll();
                App.panel.add(App.menu, BorderLayout.CENTER);
                App.panel.revalidate();
                App.panel.repaint();
                App.menu.requestFocus();
            }
        });
        add(boton);
        
        
    }
    
    private void CrearBoton(JButton boton, int x, int y, int ancho, int alto, String texto) {
        boton.setText(texto);
        boton.setBackground(Color.BLACK);
        boton.setFocusable(false);
        boton.setForeground(Color.white);
        boton.setBounds(x, y, ancho, alto);
    }  
}
