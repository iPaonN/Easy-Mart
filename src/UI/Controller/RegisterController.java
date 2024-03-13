package UI.Controller;
import UI.View.Register;
import My_sql.UserData.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.event.*;

public class RegisterController implements DocumentListener, MouseListener, FocusListener, ActionListener{
    private DoUserData model;
    private Register view;
    public RegisterController(){
        view = new Register();
        model = new DoUserData();
        
        //Add Event
        view.getJeyeconfirmword().addMouseListener(this);
        view.getJeyepassword().addMouseListener(this);
        view.getTfnewpassword().getDocument().addDocumentListener(this);
        view.getTfconfirmpassword().getDocument().addDocumentListener(this);
        view.getTfusername().addFocusListener(this);
        view.getTfemail().addFocusListener(this);
        view.getJcreate().addActionListener(this);
    }
    @Override
    public void mouseClicked(MouseEvent me){
        
    }
    @Override
    public void mouseEntered(MouseEvent me){
        
    }
    @Override
    public void mouseExited(MouseEvent me){
        
    }
    @Override
    public void mousePressed(MouseEvent me){
        if (me.getSource().equals(view.getJeyepassword())){
            view.getTfnewpassword().setEchoChar((char)0);
        }
        else if (me.getSource().equals(view.getJeyeconfirmword())){
            view.getTfconfirmpassword().setEchoChar((char)0);
        }
    }
    @Override
    public void mouseReleased(MouseEvent me){
        if (me.getSource().equals(view.getJeyepassword())){
            view.getTfnewpassword().setEchoChar('●');
        }
        else if (me.getSource().equals(view.getJeyeconfirmword())){
            view.getTfconfirmpassword().setEchoChar('●');
        }
    }
    @Override
    public void changedUpdate(DocumentEvent ae){
            
    }
    @Override
    public void insertUpdate(DocumentEvent e) {
        System.out.println("Test");
            if (Arrays.equals(view.getTfnewpassword().getPassword(), view.getTfconfirmpassword().getPassword()) == true){
                view.getJaletpassword().setText("correct");
            }
            else{
                view.getJaletpassword().setText("Your password not same.");
            }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        System.out.println("Test");
            if (Arrays.equals(view.getTfnewpassword().getPassword(), view.getTfconfirmpassword().getPassword()) == true){
                view.getJaletpassword().setText("correct");
            }
            else{
                view.getJaletpassword().setText("Your password not same.");
            }
    }
    @Override
    public void focusGained(FocusEvent e) {
        
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource().equals(view.getTfusername())){
            if (model.CheckUsername(view.getTfusername().getText()) == true){
                view.getJaletusername().setText("This username has used.");
            }
            else {
                view.getJaletusername().setText("");
            }
        }
        else if (e.getSource().equals(view.getTfemail())){
            if (view.getTfemail().getText().contains("@") == false){
                view.getJaletemail().setText("Please input your email again.");
            }
            else if (model.CheckEmail(view.getTfemail().getText()) == true){
                view.getJaletemail().setText("This email has used.");
            }
            else {
                view.getJaletemail().setText("");
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource().equals(view.getJcreate())){
        if (
                view.getTffirstname().getText().equals("") || view.getTflastname().getText().equals("") || 
                view.getTfnewpassword().getPassword().equals("") || view.getTfconfirmpassword().getPassword().equals("") ||
                view.getTfusername().getText().equals("") || model.CheckUsername(view.getTfusername().getText())==true || 
                (view.getTfemail().getText().equals("") || model.CheckEmail(view.getTfemail().getText()) == true) || 
                (Arrays.equals(view.getTfnewpassword().getPassword(), view.getTfnewpassword().getPassword()) == false))
        {
            System.out.println("Can't Create Accout.");
        }
        else {
            model.InsertData(view.getTfusername().getText(), view.getTfemail().getText(), new String(view.getTfnewpassword().getPassword()), view.getTffirstname().getText(), view.getTflastname().getText());
            view.getMainf().dispose();
        }
        }
        
    }
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            new RegisterController();
        });
    }
}
