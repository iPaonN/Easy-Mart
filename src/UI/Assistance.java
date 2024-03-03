package UI;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Assistance {
    private JFrame Assistance;
    private JPanel panelmain, panelsubmain;
    
    public Assistance(){
        
        //Create
        Assistance = new JFrame("Assistance");
        panelmain = new JPanel();
        panelsubmain = new JPanel();
        
        //Panelmain 
        panelmain.setLayout(new BorderLayout());
        panelmain.add(panelsubmain);
        panelmain.setLayout(new BorderLayout());
        panelmain.add(panelsubmain);
        panelmain.setBorder(new LineBorder(new Color(157,178,191), 25));
        
        //Panelsubmain
        panelsubmain.setBorder(new LineBorder(new Color(101, 113, 132), 5));
        panelsubmain.setBackground(Color.WHITE);
        
        //Assistance 
        Assistance.add(panelmain);
        Assistance.setSize(1280, 720);
        Assistance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Assistance.setVisible(true);
    }
    public static void main(String[] args) {
        new Assistance();
    }
}
