
package UI.View;

import org.knowm.xchart.*;
import org.knowm.xchart.style.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.border.LineBorder;

public class IncomeCompareGraph extends JPanel {
    private JFrame mainf;
    private JPanel psouth;
    private JButton bday, bweek, byear;
    private ArrayList<Integer> xhours, ymoneymonday, ymoneytuesday, ymoneywedenesday, ymoneythursday, ymoneyfriday, ymoneysaturday, ymoneysunday;
    public IncomeCompareGraph() {
        
        mainf = new JFrame();
        psouth = new JPanel();
        bday = new JButton("    Day    ");
        bweek = new JButton("    Week    ");
        byear = new JButton("    Year    ");
        xhours = new ArrayList<>() {{ add(0); add(6); add(12); add(18); add(24);}};
        ymoneymonday = new ArrayList<>() {{ add(2000); add(4000); add(6000); add(8000); add(10000);}};
        ymoneytuesday = new ArrayList<>() {{ add(3000); add(5000); add(7000); add(9000); add(11000);}};
        ymoneywedenesday = new ArrayList<>() {{ add(4000); add(6000); add(8000); add(10000); add(12000);}};
        ymoneythursday = new ArrayList<>() {{ add(5000); add(7000); add(9000); add(11100); add(13000);}};
        ymoneyfriday = new ArrayList<>() {{ add(6000); add(8000); add(10000); add(12200); add(14000);}};
        ymoneysaturday = new ArrayList<>() {{ add(7000); add(9000); add(11000); add(13000); add(15000); }};
        ymoneysunday = new ArrayList<>() {{ add(8000); add(10000); add(12000); add(14000); add(16000);}};
        XYChart IncomeCompare = new XYChartBuilder()
            .width(600)
            .height(400)
            .title("Sample Line Chart")
            .xAxisTitle("hours")
            .yAxisTitle("money")
            .build();
        JPanel IncomeComparechartPanel = new XChartPanel<>(IncomeCompare);
        
        //AddLineGraph
        XYSeries Linemonday = IncomeCompare.addSeries("Monday", xhours, ymoneymonday);
        XYSeries Linetuesday = IncomeCompare.addSeries("Tuesday", xhours, ymoneytuesday);
        XYSeries Linewedenesday = IncomeCompare.addSeries("Wednesday", xhours, ymoneywedenesday);
        XYSeries Linethurday = IncomeCompare.addSeries("Thursday", xhours, ymoneythursday);
        XYSeries Linefriday = IncomeCompare.addSeries("Friday", xhours, ymoneyfriday);
        XYSeries Linesaturday = IncomeCompare.addSeries("Saturay", xhours, ymoneysaturday);
        XYSeries Linesunday = IncomeCompare.addSeries("Sunday", xhours, ymoneysunday);
        
        Linemonday.setLineColor(Color.GREEN.darker());
        Linemonday.setLineWidth(3);
        Linemonday.setShowInLegend(true);
        Linemonday.setMarkerColor(Color.BLACK);
        
        Linetuesday.setLineColor(Color.GREEN);
        Linetuesday.setLineWidth(3);
        Linetuesday.setShowInLegend(true);
        Linetuesday.setMarkerColor(Color.BLACK);
        
        Linewedenesday.setLineColor(Color.WHITE);
        Linewedenesday.setLineWidth(3);
        Linewedenesday.setShowInLegend(true);
        Linewedenesday.setMarkerColor(Color.BLACK);
        
        Linethurday.setLineColor(Color.yellow.darker());
        Linethurday.setLineWidth(3);
        Linethurday.setShowInLegend(true);
        Linethurday.setMarkerColor(Color.BLACK);
        
        Linefriday.setLineColor(Color.yellow);
        Linefriday.setLineWidth(3);
        Linefriday.setShowInLegend(true);
        Linefriday.setMarkerColor(Color.BLACK);
        
        Linesaturday.setLineColor(Color.CYAN.darker());
        Linesaturday.setLineWidth(3);
        Linesaturday.setShowInLegend(true);
        Linesaturday.setMarkerColor(Color.BLACK);
        
        Linesunday.setLineColor(Color.CYAN);
        Linesunday.setLineWidth(3);
        Linesunday.setShowInLegend(true);
        Linesunday.setMarkerColor(Color.BLACK);
        
        
        //DocorateGraph
        IncomeCompare.getStyler().setLegendVisible(true);
        IncomeCompare.getStyler().setLegendBorderColor(new Color(101, 113, 132));
        IncomeCompare.getStyler().setLegendPadding(2);
        IncomeCompare.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        IncomeCompare.getStyler().setLegendFont(new Font("Aria", Font.BOLD, 13));
        IncomeCompare.getStyler().setPlotBorderColor(new Color(69, 104, 159));
        IncomeCompare.getStyler().setPlotBackgroundColor(new Color(69, 104, 159));
        IncomeCompare.getStyler().setAxisTickLabelsColor(new Color(69, 104, 159));
        IncomeCompare.getStyler().setPlotGridLinesColor(Color.WHITE);
        IncomeCompare.getStyler().setChartBackgroundColor(Color.WHITE);
        IncomeCompare.getStyler().setChartFontColor(new Color(101, 113, 132));
        IncomeCompare.getStyler().setChartTitleFont(new Font("Aria", Font.BOLD, 20));
        IncomeCompare.getStyler().setBaseFont(new Font("Aria", Font.BOLD, 14));

        
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
        this.add(IncomeComparechartPanel, BorderLayout.CENTER);
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
            new IncomeCompareGraph();
        });
    }
}
