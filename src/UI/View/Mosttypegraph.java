
package UI.View;

import org.knowm.xchart.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.border.LineBorder;
import org.knowm.xchart.demo.charts.ExampleChart;
public class Mosttypegraph extends JPanel {
    private JFrame mainf;
    private JPanel psouth, pempty1, pempty2;
    private ExampleChart<CategoryChart> Exchart = new Mosttypechart();
    private CategoryChart chart = Exchart.getChart();
    private JPanel jchart = new XChartPanel<>(chart);
    private JButton bday, bweek, byear, bzoom;
    private ArrayList<String> product;
    private ArrayList<Double> price;
    private ImageIcon i1, i2;
    public Mosttypegraph() {
        
        //Create
        i1 = new ImageIcon("src/UI/Image/zoom.png");
        i2 = new ImageIcon(i1.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        mainf = new JFrame();
        psouth = new JPanel();
        pempty1 = new JPanel();
        pempty2 = new JPanel();
        bday = new JButton("    Day    ");
        bweek = new JButton("    Month    ");
        byear = new JButton("    Year    ");
        bzoom = new JButton();
        bzoom.setIcon(i2);
        
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
        this.setBorder(new LineBorder(new Color(69, 104, 159), 3));
        this.add(jchart, BorderLayout.CENTER);
        this.add(psouth, BorderLayout.SOUTH);
        mainf.add(this);
        mainf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainf.pack();
        mainf.setLocationRelativeTo(null);
        mainf.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            new Mosttypegraph();
        });
    }

    public JFrame getMainf() {
        return mainf;
    }

    public void setMainf(JFrame mainf) {
        this.mainf = mainf;
    }

    public JPanel getPsouth() {
        return psouth;
    }

    public void setPsouth(JPanel psouth) {
        this.psouth = psouth;
    }

    public JPanel getPempty1() {
        return pempty1;
    }

    public void setPempty1(JPanel pempty1) {
        this.pempty1 = pempty1;
    }

    public JPanel getPempty2() {
        return pempty2;
    }

    public void setPempty2(JPanel pempty2) {
        this.pempty2 = pempty2;
    }

    public JPanel getJchart() {
        return jchart;
    }

    public void setJchart(JPanel jchart) {
        this.jchart = jchart;
    }

    public JButton getBday() {
        return bday;
    }

    public void setBday(JButton bday) {
        this.bday = bday;
    }

    public JButton getBweek() {
        return bweek;
    }

    public void setBweek(JButton bweek) {
        this.bweek = bweek;
    }

    public JButton getByear() {
        return byear;
    }

    public void setByear(JButton byear) {
        this.byear = byear;
    }

    public JButton getBzoom() {
        return bzoom;
    }

    public void setBzoom(JButton bzoom) {
        this.bzoom = bzoom;
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

    public ImageIcon getI1() {
        return i1;
    }

    public void setI1(ImageIcon i1) {
        this.i1 = i1;
    }

    public ImageIcon getI2() {
        return i2;
    }

    public void setI2(ImageIcon i2) {
        this.i2 = i2;
    }

}
