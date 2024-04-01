package UI.View;

import My_sql.ProjectData.DoProjectData;
import UI.Model.HistoryModel;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.*;

public class ViewHistory {
    private JFrame frame;
    private JTable table;
    private JScrollPane scrollPane;
    private DefaultTableModel model;
    private final Object[] columnName = {"History_ID", "Product_ID", "Product_Name",
        "Amount", "Type", "Action", "Date", "Time", "User"};
    private JPanel top, empty1, empty2, empty3;
    private JLabel header, date;
    private DefaultTableCellRenderer renderer;
    
    public ViewHistory(){
        frame = new JFrame();
        table = new JTable();
        scrollPane = new JScrollPane();
        model = new DefaultTableModel();
        top = new JPanel();
        header = new JLabel("<html><font color='#4F5A6C'>HIS</font><font color='#4A649D'>TORY AT</font></html>");
        date = new JLabel("3/3/2024");
        empty1 = new JPanel();
        empty2 = new JPanel();
        empty3 = new JPanel();
        renderer = new DefaultTableCellRenderer();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("History");
        
        scrollPane.setViewportView(table);
        table.setModel(model);
        table.setFont(new Font("Arial", Font.BOLD, 16));
        model.setColumnIdentifiers(columnName);
//        Object[][] dataRows = {
//            {"1", "101", "Coke", 100, "Drink", "Increase", "3/3/2024", "4:35 PM", "ZedBall"},
//            {"2", "102", "Banana", 50, "Fruit", "Decrease", "3/3/2024", "4:34 PM", "ZedBall"},
//            {"3", "103", "Pineapple", 30, "Fruit", "Remove", "3/3/2024", "4:33 PM", "ZedBall"}
//        };
//        for (Object[] dataRow : dataRows) {
//            model.insertRow(model.getRowCount(), dataRow);
//        }
        renderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultEditor(Object.class, null);
        table.setCellSelectionEnabled(false);
        table.setRowHeight(50);
        table.getColumnModel().getColumn(0).setPreferredWidth(150);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(250);
        table.getColumnModel().getColumn(3).setPreferredWidth(150);
        table.getColumnModel().getColumn(4).setPreferredWidth(200);
        table.getColumnModel().getColumn(5).setPreferredWidth(200);
        table.getColumnModel().getColumn(6).setPreferredWidth(200);
        table.getColumnModel().getColumn(7).setPreferredWidth(200);
        table.getColumnModel().getColumn(8).setPreferredWidth(200);
        table.getColumnModel().getColumn(0).setCellRenderer(renderer);
        table.getColumnModel().getColumn(1).setCellRenderer(renderer);
        table.getColumnModel().getColumn(2).setCellRenderer(renderer);
        table.getColumnModel().getColumn(3).setCellRenderer(renderer);
        table.getColumnModel().getColumn(4).setCellRenderer(renderer);
        table.getColumnModel().getColumn(5).setCellRenderer(renderer);
        table.getColumnModel().getColumn(6).setCellRenderer(renderer);
        table.getColumnModel().getColumn(7).setCellRenderer(renderer);
        table.getColumnModel().getColumn(8).setCellRenderer(renderer);
        table.getTableHeader().setForeground(new Color(69, 104, 159));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        table.setFont(new Font("Arial", Font.PLAIN, 16));
        table.setForeground(new Color(69, 104, 159));
        table.setBorder(new LineBorder(new Color(69, 104, 159), 2));
        table.setGridColor(new Color(69, 104, 159));
        scrollPane.setBorder(new LineBorder(new Color(69, 104, 159), 2));
        
        header.setFont(new Font("Arial", Font.BOLD, 28));
        date.setFont(new Font("Arial", Font.BOLD, 28));
        date.setForeground(new Color(69, 104, 159));
        top.setBorder(BorderFactory.createEmptyBorder(10,0,10,0));
        top.add(header);
        top.add(date);
        top.setBackground(Color.white);
        
        empty1.setBackground(Color.white);
        empty2.setBackground(Color.white);
        empty3.setBackground(Color.white);
        empty1.setPreferredSize(new Dimension(20,0));
        empty2.setPreferredSize(new Dimension(20,0));
        empty3.setPreferredSize(new Dimension(0,30));
        
        frame.add(top, BorderLayout.NORTH);
        frame.add(scrollPane);
        frame.add(empty1, BorderLayout.WEST);
        frame.add(empty2, BorderLayout.EAST);
        frame.add(empty3, BorderLayout.SOUTH);
        frame.setSize(950,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public ViewHistory(String username, String projectname, String time){
        this();
        this.removeAllRow();
        HistoryModel hm = new HistoryModel(username, projectname);
        this.addRow(hm.getDateHis(time));
        date.setText(time);
        this.table.repaint();
        this.table.revalidate();
    }
    public void addRow(ArrayList<Object []> list){
        if (list.contains(null) == true){
            list.remove(null);
        }
        for (Object[] l : list){
            model.insertRow(model.getRowCount(), l);
            System.out.println(l);
        }
    }
    public void removeAllRow(){
        model.setRowCount(0);
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


