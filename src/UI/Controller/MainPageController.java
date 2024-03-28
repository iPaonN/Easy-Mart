package UI.Controller;

import My_sql.UserData.DoUserData;
import UI.View.Addproject;
import UI.View.MainPage;
import UI.View.MainRenderer;
import java.awt.Color;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class MainPageController implements MouseListener{
    private String username;
    private ArrayList<String> projectlist;
    private MainPage main;
    private MainRenderer render;
    private DoUserData manager;
    public MainPageController(String username){
        this.manager = new DoUserData();
        this.username = username;
        this.projectlist = manager.GetProjectList(this.username);
        main = new MainPage();
        main.getCp1().LoadImage(manager.GetProfileImage(this.username));
        main.getUsername().setText(this.username);
        
        main.getUsername().addMouseListener(this);
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

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(main.getUsername())){
            
        }
        
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
