package UI;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Stock {
    private JFrame Stock;
    private JPanel panelmain, panelsubmain;
    
    public Stock(){
        
        //Create
        Stock = new JFrame("Stock");
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
        
        //Stock 
        Stock.add(panelmain);
        Stock.setSize(1280, 720);
        Stock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Stock.setVisible(true);
    }
    public static void main(String[] args) {
        new Stock();
    }
}
