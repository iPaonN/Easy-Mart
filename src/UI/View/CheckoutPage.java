package UI.View;

import UI.Model.BuyProduct;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class CheckoutPage {
    private JFrame mainf;
    private JTable table;
    private JScrollPane scrollPane;
    private DefaultTableModel model;
    private JLabel view, total, totalamount, totalprice;
    private JPanel bottom, top, bigScroll, empty1, empty2;
    private Object[] dataRows;
    private final Object[] columnName = {"Name", "Amount", "Price"};
    private DefaultTableCellRenderer renderer;
    
    public CheckoutPage(){
        mainf = new JFrame();
        scrollPane = new JScrollPane();
        model = new DefaultTableModel(new Object[]{"Name", "Amount", "Price"}, 0);
        table = new JTable(model);
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
//        Object[][] dataRows = {
////            {"Cola", "500", "5"},
////            {"Lays", "10", "15"},
////            {"Cola", "500", "5"},
////            {"Lays", "10", "15"},
////            {"Cola", "500", "5"},
////            {"Lays", "10", "15"},
////            {"Cola", "500", "5"},
////            {"Lays", "10", "15"},
////            {"Cola", "500", "5"},
////            {"Lays", "10", "15"},
////            {"Cola", "500", "5"},
////            {"Lays", "10", "15"},
////            {"Cola", "500", "5"},
////            {"Lays", "10", "15"},
////            {"Cola", "500", "5"},
////            {"Lays", "10", "15"},
////            {"Cola", "500", "5"},
////            {"Lays", "10", "15"},
////            {"Cola", "500", "5"},
////            {"Lays", "10", "15"},
//        };
//        for (Object[] dataRow : dataRows) {
//            model.insertRow(model.getRowCount(), dataRow);
//        }
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
        table.setDefaultEditor(Object.class, null);
        table.setCellSelectionEnabled(false);
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
        mainf.setVisible(false);
    }
    public void showBuy(ArrayList<BuyProduct> list){
        this.removeAllRow();
        this.addRow(list);
        table.repaint();
        table.revalidate();
    }
    public void addRow(ArrayList<BuyProduct> list){
        if (list.contains(null) == true){
            list.remove(null);
        }
        for (BuyProduct l : list){
            if(l.getAmount() != 0){
                Object[] i = {l.getProductname(), l.getAmount(), l.getSumprice()};
                model.insertRow(model.getRowCount(), i);  
            }
            
        }
    }
    public void removeAllRow(){
        model.setRowCount(0);
    }
    
    public Object getValueAt(int rowIndex, int columnIndex) {
        return model.getValueAt(rowIndex, columnIndex);
    }

    
    public void updateRow(int rowIndex, Object[] rowData) {
        for (int i = 0; i < rowData.length; i++) {
            model.setValueAt(rowData[i], rowIndex, i);
        }
    }
    
    public int findRowIndex(String productName) {
        for (int i = 0; i < table.getRowCount(); i++) {
            String name = table.getValueAt(i, 0).toString();
            if (productName.equals(name)) {
                return i;
            }
        }
        return -1;
    }
    
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        model.setValueAt(value, rowIndex, columnIndex);
    }
    
    public void exportToCSV() {
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Export CSV File");
        fileChooser.setFileFilter(new FileNameExtensionFilter("CSV Files", "csv"));

        int userSelection = fileChooser.showSaveDialog(mainf);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String filePath = fileToSave.getAbsolutePath();

            if (!filePath.toLowerCase().endsWith(".csv")) {
                filePath += ".csv";
            }

            try (FileWriter writer = new FileWriter(filePath)) {
                for (int i = 0; i < model.getColumnCount(); i++) {
                    writer.write(model.getColumnName(i));
                    if (i < model.getColumnCount() - 1) {
                        writer.write(",");
                    } else {
                        writer.write("\n");
                    }
                }

                for (int row = 0; row < model.getRowCount(); row++) {
                    for (int col = 0; col < model.getColumnCount(); col++) {
                        writer.write(model.getValueAt(row, col).toString());
                        if (col < model.getColumnCount() - 1) {
                            writer.write(",");
                        } else {
                            writer.write("\n");
                        }
                    }
                }
                
                writer.write("Grand Total,");
                writer.write(totalamount.getText() + ",");
                writer.write(totalprice.getText()+ "\n");

                System.out.println(filePath);

            } catch (IOException e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public JFrame getMainf() {
        return mainf;
    }

    public JTable getTable() {
        return table;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public JLabel getView() {
        return view;
    }

    public JLabel getTotal() {
        return total;
    }

    public JLabel getTotalamount() {
        return totalamount;
    }

    public JLabel getTotalprice() {
        return totalprice;
    }

    public JPanel getBottom() {
        return bottom;
    }

    public JPanel getTop() {
        return top;
    }

    public JPanel getBigScroll() {
        return bigScroll;
    }

    public JPanel getEmpty1() {
        return empty1;
    }

    public JPanel getEmpty2() {
        return empty2;
    }

    public Object[] getColumnName() {
        return columnName;
    }

    public DefaultTableCellRenderer getRenderer() {
        return renderer;
    }
//    public static void main(String[] args) {
//        new CheckoutPage();
//    }
}
