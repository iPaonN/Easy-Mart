package Event.Controller;
import Event.Model.LoginModel;
import My_sql.UserData.*;
import View.Login;
import View.MainPage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
public class LoginController implements MouseListener, ActionListener{
    private DoUserData model;
    private Login view;
    
    public LoginController(){
        model = new DoUserData();
        view = new Login();
        this.loadData();
        //Add Event 
        view.getJ5().addMouseListener(this);
        view.getB2().addActionListener(this);
        view.getJ3().addMouseListener(this);
    }
    public void loadData(){
        File f = new File("LoginData.dat");
        if (f.exists()){
            try (FileInputStream fin = new FileInputStream("LoginData.dat"); ObjectInputStream in = new ObjectInputStream(fin);){
                LoginModel data = (LoginModel)in.readObject();
                view.getTf1().setText(data.getUsername());
                view.getJb1().setSelected(data.isStatuscheck());
                fin.close();
                in.close();
            } 
            catch (IOException ex) {
                ex.printStackTrace();
            }
            catch (ClassNotFoundException c){
                c.printStackTrace();
            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(view.getJ5())){
            new RegisterController();
        }
        else if (e.getSource().equals(view.getJ3())){
            JOptionPane.showMessageDialog(null, "Please contact admin 66070082@kmitl.ac.th");
            System.out.println("forget");
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
            if (view.getJb1().isSelected() == false){
                try (FileOutputStream fout = new FileOutputStream("LoginData.dat"); ObjectOutputStream out = new ObjectOutputStream(fout);){
                    out.writeObject(new LoginModel("", false));
                    fout.close();
                    out.close();
                }
                catch (IOException i){
                    i.printStackTrace();
                }
                }
            if(model.CheckLogin(view.getTf1().getText(), new String(view.getPf1().getPassword())) == true){
                if (view.getJb1().isSelected() == true){
                try (FileOutputStream fout = new FileOutputStream("LoginData.dat"); ObjectOutputStream out = new ObjectOutputStream(fout);){
                    out.writeObject(new LoginModel(view.getTf1().getText(), view.getJb1().isSelected()));
                    fout.close();
                    out.close();
                    }
                catch (IOException i){
                    i.printStackTrace();
                }
                }
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
