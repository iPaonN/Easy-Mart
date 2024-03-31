
package UI.Controller;

import Import_Export.ImportFile;
import My_sql.UserData.*;
import UI.View.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

//Made by Pao WIP CAN'T SET **Initiate User's profile
public class PopEditProfile implements ActionListener, MouseListener{
    private DoUserData manager;
    private ImportFile im;
    private EditProfile main;
    private String username;
    
    public PopEditProfile(String username){
        manager = new DoUserData();
        main = new EditProfile();
        this.username = username;
//        Image pic = manager.GetProfileImage(this.username);
//        main.getProfileIcon().LoadImage(manager.GetProfileImage(String.valueOf(pic)));
        
        main.getSaveButton().addActionListener(this);
        main.getProfileIcon().addMouseListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(main.getSaveButton())){
            if (main.getUsernameField().getText().equals("null")){
                JOptionPane.showMessageDialog(null, "Don't set null to username");
                main.getUsernameField().setText("");
            }
            else if (main.getUsernameField().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Input your username");
                main.getUsernameField().setText("");
            }
            else if (this.checkPJName(main.getUsernameField().getText()) == false){
                JOptionPane.showMessageDialog(null, "Username must have only letter or digit");
                main.getUsernameField().setText("");
            }
            
            if (main.getFirstNameField().getText().equals("null")){
                JOptionPane.showMessageDialog(null, "Don't set null to firstname");
                main.getFirstNameField().setText("");
            }
            else if (main.getFirstNameField().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Input your firstname");
                main.getFirstNameField().setText("");
            }
            else if (this.checkPJName(main.getFirstNameField().getText()) == false){
                JOptionPane.showMessageDialog(null, "Firstname must have only letter or digit");
                main.getFirstNameField().setText("");
            }
            
            if (main.getLastNameField().getText().equals("null")){
                JOptionPane.showMessageDialog(null, "Don't set null to lastname");
                main.getLastNameField().setText("");
            }
            else if (main.getLastNameField().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Input your lastname");
                main.getLastNameField().setText("");
            }
            else if (this.checkPJName(main.getLastNameField().getText()) == false){
                JOptionPane.showMessageDialog(null, "Lastname must have only letter or digit");
                main.getLastNameField().setText("");
            }
            
            
            else{
                manager.ChangeFirstname(manager.Get_User(this.username).getFirst_name(), main.getFirstNameField().getText());
                manager.ChangeLastname(manager.Get_User(this.username).getLast_name(), main.getLastNameField().getText());
                manager.ChangeUsername(this.username, main.getUsernameField().getText());
                System.out.println(manager.Get_User(this.username).getFirst_name());
                this.main.getFr().dispose();
            }
        }
    }
    
    public boolean checkPJName(String pjn){
        for (char c : pjn.toCharArray()){
            if (Character.isLetterOrDigit(c) == false){
                return false;
            } 
        }
        return true;
    }  

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(main.getProfileIcon())){
            im = new ImportFile("jpg");
            String imagePath = im.getPath().getAbsolutePath();
            File f = new File(imagePath);

            try {
                main.getProfileIcon().LoadImage(imagePath);
                manager.ChangeProfileImage(this.username, f);
                main.getProfileIcon().repaint();
            } catch (Exception ex) {
                System.err.println("Error : " + ex.getMessage());
                ex.printStackTrace();
            }
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
