
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Option extends JPanel{
    private JFrame Option;
    private JPanel panelsubmain;
    
    public Option(){
        
        //Create
        Option = new JFrame("Option");
        panelsubmain = new JPanel();
        
        //Panelmain 
        this.setLayout(new BorderLayout());
        this.add(panelsubmain);
        this.setLayout(new BorderLayout());
        this.add(panelsubmain);
        this.setBorder(new LineBorder(new Color(101, 113, 132), 25));
        
        //Panelsubmain
        panelsubmain.setBorder(new LineBorder(new Color(69, 104, 159), 5));
        panelsubmain.setBackground(Color.WHITE);
        
        //Product
        Option.add(this);
        Option.setSize(1280, 720);
        Option.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Option.setVisible(true);
    }
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            new Option();
        });
    }
}
