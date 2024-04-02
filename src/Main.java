
import UI.Controller.LoginController;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


public class Main {
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
