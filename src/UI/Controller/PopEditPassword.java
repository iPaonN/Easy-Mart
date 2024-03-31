
package UI.Controller;

import Import_Export.ImportFile;
import My_sql.UserData.DoUserData;
import UI.View.*;
import java.awt.event.*;
import javax.swing.*;

public class PopEditPassword implements ActionListener{
    private DoUserData manager;
    private ImportFile im;
    private ChangePassword main;
    private String username;
    
    public PopEditPassword(String username){
        manager = new DoUserData();
        main = new ChangePassword();
        this.username = username;
        
        main.getChangeButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(main.getChangeButton())) {
            if (new String(main.getPasswordField().getPassword()).equals("null")) {
                JOptionPane.showMessageDialog(null, "Don't set null to password");
            } else if (new String(main.getPasswordField().getPassword()).isEmpty()) {
                JOptionPane.showMessageDialog(null, "Input your password");
            }
            
            if (new String(main.getPasswordFieldConfirm().getPassword()).equals("null")) {
                JOptionPane.showMessageDialog(null, "Don't set null to confirm password");
            } else if (new String(main.getPasswordFieldConfirm().getPassword()).isEmpty()) {
                JOptionPane.showMessageDialog(null, "Input your confirm password");
            }
            
            else if (!new String(main.getPasswordField().getPassword()).equals(new String(main.getPasswordFieldConfirm().getPassword()))){
                JOptionPane.showMessageDialog(null, "Password are not match!");
            }
            
            else{
                manager.ChangePassword(this.username, new String(main.getPasswordField().getPassword()));
                JOptionPane.showMessageDialog(null, "Password is updated!");
                this.main.getFr().dispose();
            }
        }
    }
}
