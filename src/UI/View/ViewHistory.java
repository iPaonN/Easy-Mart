package UI.View;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.*;

public class ViewHistory {
    private JFrame frame;
    private JTable table;
    private JScrollPane scrollPane;
    private DefaultTableModel model;
    private final Object[] columnName = {"Date", "Time", "Name", "Amount", "Add", "Remove"};
    
    public ViewHistory(){
        frame = new JFrame();
        table = new JTable();
        scrollPane = new JScrollPane();
        model = new DefaultTableModel();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("History");
        
        scrollPane.setViewportView(table);
        table.setModel(model);
        table.setFont(new Font("Arial", Font.BOLD, 16));
        model.setColumnIdentifiers(columnName);
        Object[][] dataRows = {
            {"3/3/2024", "4:35 PM", "Cola", 500, true, false},
            {"3/3/2024", "4:25 PM", "Lays", 10, false, true}
        };
        for (Object[] dataRow : dataRows) {
            model.insertRow(model.getRowCount(), dataRow);
        }
        table.setDefaultEditor(Object.class, null);
        table.setCellSelectionEnabled(false);
        table.setRowHeight(50);
        table.getColumnModel().getColumn(0).setPreferredWidth(200);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(300);
        table.getColumnModel().getColumn(3).setPreferredWidth(200);
        table.getColumnModel().getColumn(0).setCellRenderer(new ViewRenderer());
        table.getColumnModel().getColumn(1).setCellRenderer(new ViewRenderer());
        table.getColumnModel().getColumn(2).setCellRenderer(new ViewRenderer());
        table.getColumnModel().getColumn(3).setCellRenderer(new ViewRenderer());
        table.getColumnModel().getColumn(4).setCellRenderer(new ViewRenderer());
        table.getColumnModel().getColumn(4).setCellEditor(new ViewEditor(new JCheckBox()));
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        table.getColumnModel().getColumn(5).setCellRenderer(new ViewRenderer());
        table.getColumnModel().getColumn(5).setCellEditor(new ViewEditor(new JCheckBox()));
        table.setFont(new Font("Arial", Font.PLAIN, 16));
        table.setForeground(new Color(69, 104, 159));
        table.setBorder(new LineBorder(new Color(69, 104, 159), 3));
        table.setGridColor(new Color(69, 104, 159));
        
        frame.add(scrollPane);
        frame.setSize(800,300);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            new ViewHistory();
        });
    }
}

