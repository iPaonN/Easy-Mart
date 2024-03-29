
package UI.View;

import org.knowm.xchart.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.border.LineBorder;
import org.knowm.xchart.style.*;

public class TopProductGraph extends JPanel {
    private JFrame mainf;
    private JPanel psouth;
    private JButton bday, bweek, byear;
    private ArrayList<String> product;
    private ArrayList<Double> price;
    public TopProductGraph() {
        
        //Create
        mainf = new JFrame();
        psouth = new JPanel();
        bday = new JButton("    Day    ");
        bweek = new JButton("    Week    ");
        byear = new JButton("    Year    ");
        product = new ArrayList<>(){{ add("Category 1"); add("Category 2"); add("Category 3"); add("Category 4"); add("Category 5");}};
        price  = new ArrayList<>(){{ add(600.0); add(800.0); add(400.0); add(500.0); add(1000.0);}};
        CategoryChart IncomeChart = new CategoryChartBuilder()
            .width(800)
            .height(600)
            .title("Top 5 Product")
            .xAxisTitle("Product")
            .yAxisTitle("Sales")
            .build();
        
        //Add Line
        IncomeChart.addSeries("Product", product, price).setFillColor(Color.WHITE);
        IncomeChart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        JPanel IncomechartPanel = new XChartPanel<>(IncomeChart);
        
        //Decorate Chart
        CategoryStyler cs1 = IncomeChart.getStyler();
        cs1.setLegendBorderColor(new Color(101, 113, 132));
        cs1.setLegendBackgroundColor(Color.GREEN);
        cs1.setAvailableSpaceFill(0.4);
        cs1.setChartTitleFont(new Font("Aria", Font.BOLD, 20));
        cs1.setChartFontColor(new Color(101, 113, 132));
        cs1.setBaseFont(new Font("Aria", Font.BOLD, 14));
        cs1.setAxisTickLabelsColor(new Color(69, 104, 159));
        cs1.setPlotBackgroundColor(new Color(101, 113, 132));
        cs1.setPlotBorderColor(new Color(69, 104, 159));
        cs1.setPlotGridLinesColor(Color.WHITE);
        cs1.setChartBackgroundColor(Color.WHITE);
        cs1.setLegendFont(new Font("Aria", Font.BOLD, 13));
        
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
        this.add(IncomechartPanel, BorderLayout.CENTER);
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
            new TopProductGraph();
        });
    }
}


