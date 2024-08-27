package GUI;

import Implementacion.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Creditos extends JPanel {

    public Creditos() {
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
