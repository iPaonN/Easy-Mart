/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class CreateType implements ActionListener{
    private JFrame frame;
    private JLabel text;
    private JTextField typeTF;
    private JButton enterBtn;
    private JPanel center, mainP, bottom, top;
   
    public CreateType(){
        frame = new JFrame();
        text = new JLabel("ENTER TYPE");
        typeTF = new JTextField(18);
        enterBtn = new JButton("ADD");
        center = new JPanel();
        mainP = new JPanel();
        bottom = new JPanel();
        top = new JPanel();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        top.setLayout(new BorderLayout());
        top.setBackground(new Color(69, 104, 159));
        top.setBorder(BorderFactory.createEmptyBorder(0,0,20,0));
        mainP.setBorder(BorderFactory.createEmptyBorder(40,0,0,0));
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setFont(new Font("Arial", Font.BOLD, 36));
        text.setForeground(Color.WHITE);
        center.setBackground(new Color(69, 104, 159));
        typeTF.setPreferredSize(new Dimension(0,25));
        typeTF.setBackground(new Color(101, 113, 132));
        typeTF.setHorizontalAlignment(JLabel.CENTER);
        typeTF.setForeground(Color.white);
        typeTF.setFont(new Font("Arial", Font.BOLD, 20));
        typeTF.setBorder(new LineBorder(Color.white, 3));
        typeTF.setPreferredSize(new Dimension(0,35));
        bottom.setBackground(new Color(69, 104, 159));
        bottom.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        enterBtn.setBackground(new Color(69, 104, 159));
        enterBtn.setForeground(Color.white);
        enterBtn.setBorder(new LineBorder(Color.white, 3));
        enterBtn.setFont(new Font("Arial", Font.BOLD, 20));
        enterBtn.setPreferredSize(new Dimension(120,35));
        enterBtn.setFocusPainted(false);
        enterBtn.addActionListener(this);
        mainP.setLayout(new GridLayout(4,0));
        mainP.setBackground(new Color(69, 104, 159));
        
        top.add(text);
        mainP.add(top);
        
        center.add(typeTF);
        mainP.add(center);
        
        bottom.add(enterBtn);
        mainP.add(bottom);
        frame.add(mainP);
        frame.setSize(450,300);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new CreateType();
    }
    public String getType(){
        return typeTF.getText();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(enterBtn)){
            getType();
            System.out.println("GetType!");
        }
    }
}
