package Juego;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Vista_Superior extends JPanel {
    public Vista_Superior(){
        setBackground(Color.BLACK);
        setLayout(new FlowLayout(FlowLayout.LEFT,20,20));
        
        JLabel Score = new JLabel();
        Score.setFont(new Font("OCR A Extended",2,20));
        Score.setText("SCORE: ");
        Score.setForeground(Color.WHITE);
        add(Score);
        
        JLabel Points = new JLabel();
        Points.setFont(new Font("OCR A Extended",2,20));
        Points.setText("    POINTS: ");
        Points.setForeground(Color.WHITE);
        add(Points);
    }
}
