
package UI.View;

import org.knowm.xchart.*;
import org.knowm.xchart.style.*;
import org.knowm.xchart.style.Styler.*;
import org.knowm.xchart.demo.charts.ExampleChart;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.border.LineBorder;
import org.knowm.xchart.internal.chartpart.Chart;

public class IncomeCompareGraph extends JPanel{
    private JFrame mainf;
    private JPanel psouth, pempty1, pempty2;
    private JButton bday, bweek, byear, bzoom;
    private JPanel jchart;
    private ImageIcon i1, i2;
    
    public IncomeCompareGraph() {
        
        i1 = new ImageIcon("src/UI/Image/zoom.png");
        i2 = new ImageIcon(i1.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        mainf = new JFrame();
        psouth = new JPanel();
        pempty1 = new JPanel();
        pempty2 = new JPanel();
        bday = new JButton("    Day    ");
        bweek = new JButton("    Week    ");
        byear = new JButton("    Year    ");
        bzoom = new JButton();
        bzoom.setIcon(i2);
        ExampleChart<XYChart> Exchart = new IncomeCompareChart();
        XYChart chart = Exchart.getChart();
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
        bzoom.setForeground(new Color(69, 104, 159));
        bzoom.setBackground(Color.WHITE);
        bzoom.setFont(new Font("Aria", Font.BOLD, 14));
        
        //SetLayout
        psouth.setLayout(new BorderLayout());
        
        //Psouth
        psouth.add(pempty1);
        psouth.add(pempty2, BorderLayout.EAST);
        pempty1.add(bday);
        pempty1.add(bweek);
        pempty1.add(byear);
        pempty2.add(bzoom);
        
        //JFrame
        psouth.setBackground(Color.WHITE);
        pempty1.setBackground(Color.WHITE);
        pempty2.setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());
        this.add(jchart, BorderLayout.CENTER);
        this.add(psouth, BorderLayout.SOUTH);
        this.setBorder(new LineBorder(new Color(69, 104, 159), 3));
        mainf.add(this);
        mainf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainf.pack();
        mainf.setLocationRelativeTo(null);
        mainf.setVisible(false);
    }
    public static void main(String[] args) {
        new IncomeCompareGraph();
    }
}
