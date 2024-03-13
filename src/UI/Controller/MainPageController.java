package UI.Controller;

import UI.Model.Account;
import UI.View.Addproject;
import UI.View.MainPage;
import UI.View.MainRenderer;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class MainPageController implements ActionListener, MouseListener{
    private Account user;
    private MainPage main;
    private Addproject adder;
    private MainRenderer render;
    public MainPageController(Account user){
        this.user = user;
        main = new MainPage();
        main.getBtnNew().addActionListener(this);
        main.getHelp().addMouseListener(this);
        main.getSupport().addMouseListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource().equals(main.getBtnNew())){
            new Addproject();
        }
    }
    
    @Override
      public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(main.getHelp())){
            main.getHelpFrame().setVisible(true);
        }
        if (e.getSource().equals(main.getSupport())){
            main.getSupportFrame().setVisible(true);
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        //
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource().equals(main.getHelp())){
            main.getHelp().setForeground(new Color(69, 104, 159));
            main.getHelp().setFont(new Font("Arial", Font.BOLD, 14));
        }
        if (e.getSource().equals(main.getSupport())){
            main.getSupport().setForeground(new Color(69, 104, 159));
            main.getSupport().setFont(new Font("Arial", Font.BOLD, 14));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(main.getHelp())){
            main.getHelp().setForeground(new Color(69, 104, 159));
            main.getHelp().setFont(new Font("Arial", Font.BOLD, 12));
        }
        if (e.getSource().equals(main.getSupport())){
            main.getSupport().setForeground(new Color(69, 104, 159));
            main.getSupport().setFont(new Font("Arial", Font.BOLD, 12));
        }
    }
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            new MainPage();
        });
    }
    
}
