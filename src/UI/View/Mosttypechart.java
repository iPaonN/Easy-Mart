
package UI.View;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.CategorySeries;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.style.CategoryStyler;
import org.knowm.xchart.style.Styler;

public class Mosttypechart extends JPanel implements ExampleChart<CategoryChart>{
    private ArrayList<String> product = new ArrayList<>(){{ add("Category 1"); add("Category 2"); add("Category 3"); add("Category 4"); add("Category 5");}};;
    private ArrayList<Double> price  = new ArrayList<>(){{ add(600.0); add(800.0); add(400.0); add(500.0); add(1000.0);}};
    @Override
    public CategoryChart getChart(){
        
        CategoryChart IncomeChart = new CategoryChartBuilder()
            .width(800)
            .height(600)
            .title("Most Type")
            .xAxisTitle("Product")
            .yAxisTitle("Sales")
            .build();
        
        //Add Line
        IncomeChart.addSeries("Product", product, price).setFillColor(new Color(69, 104, 159));
        IncomeChart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        JPanel IncomechartPanel = new XChartPanel<>(IncomeChart);
        
        //Decorate Chart
        CategoryStyler cs1 = IncomeChart.getStyler();
        cs1.setAvailableSpaceFill(0.4);
        cs1.setChartTitleFont(new Font("Aria", Font.BOLD, 20));
        cs1.setChartFontColor(new Color(101, 113, 132));
        cs1.setBaseFont(new Font("Aria", Font.BOLD, 14));
        cs1.setAxisTickLabelsColor(new Color(69, 104, 159));
        cs1.setPlotBackgroundColor(Color.WHITE);
        cs1.setPlotBorderColor(new Color(69, 104, 159));
        cs1.setPlotGridLinesColor(new Color(69, 104, 159));
        cs1.setChartBackgroundColor(Color.WHITE);
        cs1.setLegendFont(new Font("Aria", Font.BOLD, 13));
        cs1.setLegendVisible(false);
        cs1.setDefaultSeriesRenderStyle(CategorySeries.CategorySeriesRenderStyle.Bar);
        cs1.setStacked(true);
        cs1.setOverlapped(true);
        cs1.setShowStackSum(true);
        cs1.setToolTipsEnabled(true);
        cs1.setToolTipHighlightColor(new Color(101, 113, 132));
        cs1.setToolTipFont(new Font("Aria", Font.BOLD, 12));
        cs1.setYAxisTicksVisible(true);
        cs1.setAxisTitlesVisible(true);
        
        return IncomeChart;
    }

    @Override
    public String getExampleChartName() {
        return getClass().getSimpleName() + " - Cursor";
    }

    public ArrayList<String> getProduct() {
        return product;
    }

    public void setProduct(ArrayList<String> product) {
        this.product = product;
    }

    public ArrayList<Double> getPrice() {
        return price;
    }

    public void setPrice(ArrayList<Double> price) {
        this.price = price;
    }
    
}
