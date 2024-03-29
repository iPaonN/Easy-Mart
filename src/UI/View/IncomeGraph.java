
package UI.View;

import org.knowm.xchart.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.style.*;

public class IncomeGraph extends JPanel {
    private JFrame mainf;
    private JPanel psouth;
    private JPanel jchart;
    private JButton bday, bweek, byear;
    private ArrayList<String> product;
    private ArrayList<Double> price;
    public IncomeGraph() {
        
        //Create
        mainf = new JFrame();
        psouth = new JPanel();
        bday = new JButton("    Day    ");
        bweek = new JButton("    Week    ");
        byear = new JButton("    Year    ");
        
        ExampleChart<CategoryChart> Exchart = new IncomeChart();
        CategoryChart chart = Exchart.getChart();
  
        jchart = new XChartPanel<>(chart);
        
        //SetFont
        bday.setForeground(new Color(69, 104, 159));
        bday.setBackground(Color.WHITE);
        bday.setBorder(new LineBorder(new Color(69, 104, 159), 2));
        bday.setFont(new Font("Aria", Font.BOLD, 14));
        bweek.setForeground(new Color(69, 104, 159));
        bweek.setBackground(Color.WHITE);
        bweek.setBorder(new LineBorder(new Color(69, 104, 159), 2));
        bweek.setFont(new Font("Aria", Font.BOLD, 14));
        byear.setForeground(new Color(69, 104, 159));
        byear.setBackground(Color.WHITE);
        byear.setBorder(new LineBorder(new Color(69, 104, 159), 2));
        byear.setFont(new Font("Aria", Font.BOLD, 14));
        
        //Psouth
        psouth.add(bday);
        psouth.add(bweek);
        psouth.add(byear);
        
        //JFrame
        this.setLayout(new BorderLayout());
        this.setBorder(new LineBorder(new Color(69, 104, 159), 3));
        this.add(jchart, BorderLayout.CENTER);
        this.add(psouth, BorderLayout.SOUTH);
        mainf.add(this);
        mainf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainf.pack();
        mainf.setLocationRelativeTo(null);
        mainf.setVisible(false);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            new IncomeGraph();
        });
    }
}
