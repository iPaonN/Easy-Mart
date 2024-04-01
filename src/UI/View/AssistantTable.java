package UI.View;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class AssistantTable {
    private JFrame frame;
    private JTable table;
    private JScrollPane scrollPane;
    private DefaultTableModel model;
    private final Object[] columnName = {"Date", "Time", "Name", "View"};
    private DefaultTableCellRenderer textRenderer;
    
    public AssistantTable(Object[][] data){
        frame = new JFrame();
        table = new JTable();
        scrollPane = new JScrollPane();
        model = new DefaultTableModel();
        textRenderer = new DefaultTableCellRenderer();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        scrollPane.setViewportView(table);
        model.setColumnIdentifiers(columnName);
        table.setModel(model);
        Object[][] dataRows = data;
//        Object[][] dataRows = {
//            {"3/3/2024", "4:35 PM", "Coke"},
//            {"3/3/2024", "4:34 PM", "Banana"},
//            {"3/3/2024", "4:33 PM", "Tomato"}
//        };
        for (Object[] dataRow : dataRows) {
            model.insertRow(model.getRowCount(), dataRow);
        }
        table.getColumnModel().getColumn(0).setPreferredWidth(200);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.setRowHeight(30);
        table.setForeground(new Color(69, 104, 159));
        table.setFont(new Font("Arial", Font.PLAIN, 16));
        textRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(textRenderer);
        table.getColumnModel().getColumn(1).setCellRenderer(textRenderer);
        table.getColumnModel().getColumn(2).setCellRenderer(textRenderer);
        table.getColumnModel().getColumn(3).setCellEditor(new AssistantEditor(new JCheckBox()));
        table.getColumnModel().getColumn(3).setCellRenderer(new AssistantRenderer());
        table.setBorder(new LineBorder(new Color(69, 104, 159), 2));
        table.setGridColor(new Color(69, 104, 159));
        table.getTableHeader().setForeground(new Color(69, 104, 159));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        table.setDefaultEditor(Object.class, null);
        table.setCellSelectionEnabled(false);
        
        frame.add(scrollPane);
        frame.setSize(700,250);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
//    public void displaydata(Object[][] dataRows) {
//        model.setColumnIdentifiers(columnName);
//        for (Object[] dataRow : dataRows) {
//            model.insertRow(model.getRowCount(), dataRow);
//        }
//        table.getColumnModel().getColumn(0).setPreferredWidth(200);
//        table.getColumnModel().getColumn(1).setPreferredWidth(200);
//        table.getColumnModel().getColumn(2).setPreferredWidth(200);
//        table.getColumnModel().getColumn(3).setPreferredWidth(100);
//        table.setRowHeight(30);
//        table.setForeground(new Color(69, 104, 159));
//        table.setFont(new Font("Arial", Font.PLAIN, 16));
//        textRenderer.setHorizontalAlignment(JLabel.CENTER);
//        table.getColumnModel().getColumn(0).setCellRenderer(textRenderer);
//        table.getColumnModel().getColumn(1).setCellRenderer(textRenderer);
//        table.getColumnModel().getColumn(2).setCellRenderer(textRenderer);
//        table.getColumnModel().getColumn(3).setCellEditor(new AssistantEditor(new JCheckBox()));
//        table.getColumnModel().getColumn(3).setCellRenderer(new AssistantRenderer());
//        table.setBorder(new LineBorder(new Color(69, 104, 159), 2));
//        table.setGridColor(new Color(69, 104, 159));
//        table.getTableHeader().setForeground(new Color(69, 104, 159));
//        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
//        table.setDefaultEditor(Object.class, null);
//        table.setCellSelectionEnabled(false);
//    }
    public static void main(String[] args) {
//        new AssistantTable();
    }
}
