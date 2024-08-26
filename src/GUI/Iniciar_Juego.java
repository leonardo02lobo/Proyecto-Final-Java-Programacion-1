package GUI;

import Implementacion.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Iniciar_Juego extends JPanel{

    public Iniciar_Juego() {
        setBackground(Color.BLACK);
        
        JButton boton = new JButton("atras");
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.ventana.dispose();
                App.ventana.setVisible(true);
            }
        });
        add(boton);
    }
    
}
