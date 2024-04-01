package UI.View;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class AddAmount {
    private JFrame frame;
    private JLabel text;
    private JTextField amountTF;
    private JPanel top, center, bottom, mainp;
    private JButton btn;
    
    public AddAmount(){
        frame = new JFrame();
        text = new JLabel("Amount");
        amountTF = new JTextField(15);
        mainp = new JPanel();
        top = new JPanel();
        center = new JPanel();
        bottom = new JPanel();
        btn = new JButton("  Confirm  ");
        mainp.setLayout(new GridLayout(3,0));
        mainp.setBackground(new Color(69, 104, 159));
        
        top.add(text);
        top.setBackground(new Color(69, 104, 159));
        top.setBorder(BorderFactory.createEmptyBorder(15,0,0,0));
        text.setFont(new Font("Arial", Font.BOLD, 36));
        text.setForeground(Color.white);
        
        //TEXTFIELD
        center.add(amountTF);
        center.setBackground(new Color(69, 104, 159));
        center.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        amountTF.setFont(new Font("Arial", Font.BOLD, 20));
        amountTF.setBorder(new LineBorder(Color.white, 3));
        amountTF.setBackground(new Color(101, 113, 132));
        amountTF.setForeground(Color.white);
        amountTF.setHorizontalAlignment(JLabel.CENTER);
        
        //BUTTON
        bottom.add(btn);
        bottom.setBackground(new Color(69, 104, 159));
        btn.setPreferredSize(new Dimension(100,30));
        btn.setBackground(new Color(69, 104, 159));
        btn.setForeground(Color.white);
        btn.setBorder(new LineBorder(Color.white, 3));
        btn.setFont(new Font("Arial", Font.BOLD, 16));
        btn.setFocusPainted(false);
        
        mainp.add(top);
        mainp.add(center);
        mainp.add(bottom);
        frame.add(mainp);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(400,250);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new AddAmount();
    }
}
