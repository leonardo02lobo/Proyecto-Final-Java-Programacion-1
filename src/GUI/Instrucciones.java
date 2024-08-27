package GUI;

import Implementacion.App;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Instrucciones extends JPanel {

    public Instrucciones() {
        setBackground(Color.BLACK);

        JButton boton = new JButton("atras");
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
}
