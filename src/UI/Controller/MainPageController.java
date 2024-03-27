package UI.Controller;

import My_sql.UserData.DoUserData;
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

public class MainPageController{
    private String username;
    private MainPage main;
    private MainRenderer render;
    private DoUserData manager;
    public MainPageController(String username){
        this.manager = new DoUserData();
        this.username = username;
        main = new MainPage();
        main.getCp1().LoadImage(manager.GetProfileImage(this.username));
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
