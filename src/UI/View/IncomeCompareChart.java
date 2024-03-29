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

public class IncomeCompareChart extends JPanel implements ExampleChart<XYChart>{
    private JPanel IncomeComparechartPanel;
    private ArrayList<Integer> xhours, ymoneymonday, ymoneytuesday, ymoneywedenesday, ymoneythursday, ymoneyfriday, ymoneysaturday, ymoneysunday;
    @Override
    public XYChart getChart(){
        xhours = new ArrayList<>() {{ add(0); add(6); add(12); add(18); add(24);}};
        ymoneymonday = new ArrayList<>() {{ add(4000); add(4000); add(6000); add(8000); add(10000);}};
        ymoneytuesday = new ArrayList<>() {{ add(3000); add(5000); add(7000); add(9000); add(11000);}};
        ymoneywedenesday = new ArrayList<>() {{ add(8000); add(6000); add(8000); add(10000); add(12000);}};
        ymoneythursday = new ArrayList<>() {{ add(5000); add(7000); add(9000); add(11100); add(13000);}};
        ymoneyfriday = new ArrayList<>() {{ add(6000); add(8000); add(10000); add(12200); add(14000);}};
        ymoneysaturday = new ArrayList<>() {{ add(7000); add(9000); add(11000); add(13000); add(15000); }};
        ymoneysunday = new ArrayList<>() {{ add(8000); add(10000); add(12000); add(14000); add(16000);}};
        XYChart IncomeCompare = new XYChartBuilder()
            .width(600)
            .height(400)
            .title("Compare Income")
            .xAxisTitle("hours")
            .yAxisTitle("money")
            .build();
        IncomeComparechartPanel = new XChartPanel<>(IncomeCompare);
        
        //DocorateGraph
        IncomeCompare.getStyler().setLegendVisible(true);
        IncomeCompare.getStyler().setLegendBorderColor(new Color(101, 113, 132));
        IncomeCompare.getStyler().setLegendPadding(2);
        IncomeCompare.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        IncomeCompare.getStyler().setLegendFont(new Font("Aria", Font.BOLD, 13));
        IncomeCompare.getStyler().setPlotBorderColor(new Color(69, 104, 159));
        IncomeCompare.getStyler().setPlotBackgroundColor(new Color(101, 113, 132));
        IncomeCompare.getStyler().setAxisTickLabelsColor(new Color(69, 104, 159));
        IncomeCompare.getStyler().setPlotGridLinesColor(Color.WHITE);
        IncomeCompare.getStyler().setChartBackgroundColor(Color.WHITE);
        IncomeCompare.getStyler().setChartFontColor(new Color(101, 113, 132));
        IncomeCompare.getStyler().setChartTitleFont(new Font("Aria", Font.BOLD, 20));
        IncomeCompare.getStyler().setCursorEnabled(true);
        IncomeCompare.getStyler().setZoomEnabled(true);
        IncomeCompare.getStyler().setMarkerSize(7);
        IncomeCompare.getStyler().setToolTipsEnabled(false);
        
        //AddLineGraph
        XYSeries Linemonday = IncomeCompare.addSeries("Mo", xhours, ymoneymonday);
        XYSeries Linetuesday = IncomeCompare.addSeries("Tu", xhours, ymoneytuesday);
        XYSeries Linewedenesday = IncomeCompare.addSeries("We", xhours, ymoneywedenesday);
        XYSeries Linethurday = IncomeCompare.addSeries("Th", xhours, ymoneythursday);
        XYSeries Linefriday = IncomeCompare.addSeries("Fr", xhours, ymoneyfriday);
        XYSeries Linesaturday = IncomeCompare.addSeries("Sa", xhours, ymoneysaturday);
        XYSeries Linesunday = IncomeCompare.addSeries("Su", xhours, ymoneysunday);
        
        Linemonday.setLineColor(Color.YELLOW);
        Linemonday.setLineWidth(1);
        Linemonday.setShowInLegend(true);
        Linemonday.setMarkerColor(Color.BLACK);
        
        Linetuesday.setLineColor(Color.PINK);
        Linetuesday.setLineWidth(1);
        Linetuesday.setShowInLegend(true);
        Linetuesday.setMarkerColor(Color.BLACK);
        
        Linewedenesday.setLineColor(Color.GREEN);
        Linewedenesday.setLineWidth(1);
        Linewedenesday.setShowInLegend(true);
        Linewedenesday.setMarkerColor(Color.BLACK);
        
        Linethurday.setLineColor(Color.ORANGE);
        Linethurday.setLineWidth(1);
        Linethurday.setShowInLegend(true);
        Linethurday.setMarkerColor(Color.BLACK);
        
        Linefriday.setLineColor(Color.CYAN);
        Linefriday.setLineWidth(1);
        Linefriday.setShowInLegend(true);
        Linefriday.setMarkerColor(Color.BLACK);
        
        Linesaturday.setLineColor(Color.MAGENTA);
        Linesaturday.setLineWidth(1);
        Linesaturday.setShowInLegend(true);
        Linesaturday.setMarkerColor(Color.BLACK);
        
        Linesunday.setLineColor(Color.RED);
        Linesunday.setLineWidth(1);
        Linesunday.setShowInLegend(true);
        Linesunday.setMarkerColor(Color.BLACK);
        
        return IncomeCompare;
    }

    @Override
    public String getExampleChartName() {
        return getClass().getSimpleName() + " - Cursor";
    }
}