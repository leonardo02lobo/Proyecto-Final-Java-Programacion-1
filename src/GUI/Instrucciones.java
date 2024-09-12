package GUI;

import Implementacion.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import logica.musica;

public class Instrucciones extends JPanel {

    public Instrucciones() {
        setLayout(null);
        setBackground(Color.BLACK);
        
       
        JLabel textoBienvenida = new JLabel("Instrucciones");
        textoBienvenida.setFont(new Font("OCR A Extended", 1, 40));
        textoBienvenida.setBounds(90, 5, 400, 50);
        textoBienvenida.setForeground(Color.YELLOW);
        add(textoBienvenida);
        
        
        JTextArea textArea = new JTextArea(); // 10 filas, 20 columnas
        textArea.setText("\nObjetivo: Destruye todas las oleadas de alienígenas"+
                "antes de que\n lleguen a la parte inferior de la pantalla.\n" +
                "\nControles: Mover izquierda a derecha con: "+"'A' "+"y 'D'"+"\n"+
                "\nDisparar: Barra espaciadora\n" +
                
                "\nDinámica:" +
                "\n *Los alienígenas se mueven de lado a lado y bajan\n lentamente.\n" +
                " *Usa las barreras como protección, pero se desgastan \ncon los disparos.\n" +
                " *Derriba la nave nodriza para puntos extra.\n" +
                
                "\nPuntuación: \n" +
                " *Más puntos por alienígenas en filas superiores.\n" +
                " *La nave nodriza otorga puntos aleatorios.\n" +
                
                "\nGame Over: \n" +
                "  Los alienígenas llegan abajo o pierdes todas tus vidas.\n" +
                "\n ");
        textArea.setFont(new Font("OCR A Extended",0,14));
        textArea.setBounds(18, 60, 450, 320);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        add(textArea);
        
       

        JButton boton = new JButton();
        CrearBoton(boton, 200, 420, 100, 30, "atras");
        boton.setFont(new Font("OCR A Extended",1,18));
        
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new musica("src/source/music/clic.wav").reproducirClic();
                } catch (Exception ex) {
                }
                volverMenu();
            }
        });
        
        App.panel.setFocusable(true);
        App.panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                try {
                    new musica("src/source/music/clic.wav").reproducirClic();
                } catch (Exception ex) {
                }
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
    
    private void CrearBoton(JButton boton, int x, int y, int ancho, int alto, String texto) {
        boton.setText(texto);
        boton.setBackground(Color.BLACK);
        boton.setFocusable(false);
        boton.setForeground(Color.white);
        boton.setBounds(x, y, ancho, alto);
    }  
}
