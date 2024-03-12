package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Addproject implements ActionListener{
    private JFrame frame;
    private JPanel mainPanel, innerPanel, btnPanel;
    private JTextField insertname;
    private JLabel nameLabel;
    private JButton enter;
    public Addproject(){
        frame = new JFrame();
        mainPanel = new JPanel();
        insertname = new JTextField(20);
        nameLabel = new JLabel("PROJECT NAME");
        innerPanel = new JPanel();
        enter = new JButton("ENTER");
        btnPanel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        nameLabel.setFont(new Font("Arial", Font.BOLD, 36));
        nameLabel.setForeground(Color.white);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(40,0,0,0));
        nameLabel.setBorder(BorderFactory.createEmptyBorder(0,0,25,0));
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        enter.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));
        insertname.setFont(new Font("Arial", Font.BOLD, 20));
        insertname.setBorder(new LineBorder(Color.white, 3));
        insertname.setBackground(new Color(101, 113, 132));
        insertname.setForeground(Color.white);
        innerPanel.setBackground(new Color(69, 104, 159));
        innerPanel.setLayout(new BorderLayout());
        innerPanel.add(nameLabel, BorderLayout.NORTH);
        innerPanel.add(insertname);
        enter.setPreferredSize(new Dimension(150,40));
        enter.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btnPanel.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
        enter.setBackground(new Color(69, 104, 159));
        enter.setForeground(new Color(69, 104, 159));
        enter.setBorder(new LineBorder(Color.white, 3));
        enter.setFont(new Font("Arial", Font.BOLD, 20));
        enter.setFocusPainted(false);
        btnPanel.setLayout(new FlowLayout());
        btnPanel.add(enter);
        btnPanel.setBackground(new Color(69, 104, 159));
        innerPanel.add(btnPanel, BorderLayout.SOUTH);
        mainPanel.add(innerPanel);
        mainPanel.setBackground(new Color(69, 104, 159));
        enter.addActionListener(this);
        
        frame.add(mainPanel);
        frame.setSize(450,300);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new Addproject();
    }
    @Override
    public void actionPerformed(ActionEvent ev){
        
    }
}
