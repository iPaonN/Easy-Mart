package UI.View;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class CheckoutPage {
    private JFrame mainf;
    private JTable table;
    private JScrollPane scrollPane;
    private DefaultTableModel model;
    private JLabel view, total, totalamount, totalprice;
    private JPanel bottom, top, bigScroll, empty1, empty2;
    private final Object[] columnName = {"Name", "Amount", "Price"};
    private DefaultTableCellRenderer renderer;
    
    public CheckoutPage(){
        mainf = new JFrame();
        table = new JTable();
        scrollPane = new JScrollPane();
        model = new DefaultTableModel();
        view = new JLabel("View");
        total = new JLabel("Total");
        totalamount = new JLabel("510 Piece");
        totalprice = new JLabel("15 Bath");
        bottom = new JPanel();
        top = new JPanel();
        bigScroll = new JPanel();
        empty1 = new JPanel();
        empty2 = new JPanel();
        renderer = new DefaultTableCellRenderer();
        mainf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainf.setLayout(new BorderLayout());
        mainf.setTitle("Receipt");
        bottom.setLayout(new GridLayout());
        bigScroll.setLayout(new BorderLayout());
        
        view.setFont(new Font("Arial", Font.PLAIN, 24));
        view.setHorizontalAlignment(SwingConstants.CENTER);
        view.setBorder(BorderFactory.createEmptyBorder(10,0,10,0));
        view.setForeground(new Color(69, 104, 159));
        table.setModel(model);
        scrollPane.setViewportView(table);
        scrollPane.setBorder(new LineBorder(Color.white, 0));
        model.setColumnIdentifiers(columnName);
        Object[][] dataRows = {
            {"Cola", "500", "5"},
            {"Lays", "10", "15"},
            {"Cola", "500", "5"},
            {"Lays", "10", "15"},
            {"Cola", "500", "5"},
            {"Lays", "10", "15"},
            {"Cola", "500", "5"},
            {"Lays", "10", "15"},
            {"Cola", "500", "5"},
            {"Lays", "10", "15"},
            {"Cola", "500", "5"},
            {"Lays", "10", "15"},
            {"Cola", "500", "5"},
            {"Lays", "10", "15"},
            {"Cola", "500", "5"},
            {"Lays", "10", "15"},
            {"Cola", "500", "5"},
            {"Lays", "10", "15"},
            {"Cola", "500", "5"},
            {"Lays", "10", "15"},
        };
        for (Object[] dataRow : dataRows) {
            model.insertRow(model.getRowCount(), dataRow);
        }
        //table.setBorder(new LineBorder(new Color(69, 104, 159), 2));
        table.setFont(new Font("Arial", Font.PLAIN, 16));
        table.setForeground(new Color(69, 104, 159));
        table.setRowHeight(30);
        table.setBorder(new LineBorder(new Color(69, 104, 159), 1));
        table.setGridColor(new Color(69, 104, 159));
        renderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(renderer);
        table.getColumnModel().getColumn(1).setCellRenderer(renderer);
        table.getColumnModel().getColumn(2).setCellRenderer(renderer);
        table.getTableHeader().setForeground(new Color(69, 104, 159));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        table.getTableHeader().setBackground(Color.white);
        scrollPane.setBorder(new LineBorder(new Color(69, 104, 159), 2));
        scrollPane.setForeground(Color.red);
        empty1.setBackground(Color.white);
        empty1.setPreferredSize(new Dimension(20,0));
        empty2.setBackground(Color.white);
        empty2.setPreferredSize(new Dimension(20,0));
        
        total.setBorder(new LineBorder(new Color(69, 104, 159), 2));
        totalamount.setBorder(new LineBorder(new Color(69, 104, 159), 2));
        totalprice.setBorder(new LineBorder(new Color(69, 104, 159), 2));
        total.setFont(new Font("Arial", Font.PLAIN, 18));
        totalamount.setFont(new Font("Arial", Font.PLAIN, 18));
        totalprice.setFont(new Font("Arial", Font.PLAIN, 18));
        total.setForeground(new Color(69, 104, 159));
        totalamount.setForeground(new Color(69, 104, 159));
        totalprice.setForeground(new Color(69, 104, 159));
        total.setHorizontalAlignment(SwingConstants.CENTER);
        totalamount.setHorizontalAlignment(SwingConstants.CENTER);
        totalprice.setHorizontalAlignment(SwingConstants.CENTER);
        bottom.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
        bottom.add(total);
        bottom.add(totalamount);
        bottom.add(totalprice);
        bottom.setBackground(Color.white);
        top.setBackground(Color.white);
        
        top.add(view);
        mainf.add(top, BorderLayout.NORTH);
        bigScroll.add(scrollPane);
        bigScroll.add(empty1, BorderLayout.WEST);
        bigScroll.add(empty2, BorderLayout.EAST);
        mainf.add(bigScroll);
        mainf.add(bottom, BorderLayout.SOUTH);
        mainf.setSize(450,600);
        mainf.setVisible(true);
    }
    public static void main(String[] args) {
        new CheckoutPage();
    }
}
