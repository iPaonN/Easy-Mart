package Controller;
import My_sql.UserData.*;
import UI.Login;
import UI.MainPage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
public class LoginController implements MouseListener, ActionListener{
    private DoUserData model;
    private Login view;
    
    public LoginController(){
        model = new DoUserData();
        view = new Login();
        
        //Add Event 
        view.getJ5().addMouseListener(this);
        view.getB2().addActionListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(view.getJ5())){
            new RegisterController();
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(view.getB2())){
            if(model.CheckLogin(view.getTf1().getText(), new String(view.getPf1().getPassword())) == true){
                new MainPage();
                view.getFr1().dispose();
            }
            else{
                view.getJaletusername().setText("Your username or password are wrong.");
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
            new LoginController();
        });
    }
}
