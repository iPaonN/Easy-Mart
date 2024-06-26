package UI.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class HistoryView extends JPanel{

    private JFrame fr;
    private JLabel label, uns1, j1, j2;
    private JLabel Jicon1, Jicon2, Jicon3, history;
    private JButton bn1, bn2, bn3, bn4, bn5, bn6, bn9, bn10;
    private JPanel panel, panel2, panel3, pane14, panel5, panel6 , panel7, tablePanel;
    private JPanel bg1, bg2, bg3, bg4, white1, white2, white3, white4, mainbg;
    private ImageIcon icon1, icon2, icon3, icon4, icon5, icon6, icon7, icon8, icon9;
    private ImageIcon reicon1, reicon2, reicon3, reicon4, reicon5, reicon6, reicon9, reicon10, reicon11;
    private GridBagConstraints gb1;
    private JTable table;
    private JScrollPane scrollPane;
    private DefaultTableModel model;
    private final Object[] columnName = {"Date"};
    private Object[][] dataRows;
    public HistoryView() {

        fr = new JFrame("History");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gb1 = new GridBagConstraints();
        icon1 = new ImageIcon("src/UI/Image/eweweewew.jpg");
        icon2 = new ImageIcon("src/UI/Image/eweweewew.jpg");
        icon3 = new ImageIcon("src/UI/Image/eweweewew.jpg");
        icon4 = new ImageIcon("src/UI/Image/eweweewew.jpg");
        icon5 = new ImageIcon("src/UI/Image/eweweewew.jpg");
        icon6 = new ImageIcon("src/UI/Image/eweweewew.jpg");
        icon7 = new ImageIcon("src/UI/Image/eweweewew.jpg");
        icon8 = new ImageIcon("src/UI/Image/eweweewew.jpg");
        icon9 = new ImageIcon("src/UI/Image/username.png");
        reicon1 = new ImageIcon(icon1.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        reicon2 = new ImageIcon(icon2.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        reicon3 = new ImageIcon(icon3.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        reicon4 = new ImageIcon(icon4.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        reicon5 = new ImageIcon(icon5.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        reicon6 = new ImageIcon(icon6.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        reicon9 = new ImageIcon(icon7.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        reicon10 = new ImageIcon(icon8.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH));
        reicon11 = new ImageIcon(icon9.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        label = new JLabel("EASY MART", reicon10, 0);
        label.setBackground(new Color(255, 255, 255));
        label.setFont(new Font("Arial", Font.CENTER_BASELINE, 40)); // NOI18N
        label.setForeground(new Color(255, 255, 255));
        uns1 = new JLabel("Tibet Sawangkan");
        uns1.setFont(new Font("Arial", Font.PLAIN, 14)); // NOI18N
        uns1.setForeground(new Color(255, 255, 255));
        j1 = new JLabel("     ");
        j2 = new JLabel("   ");
        panel = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel5 = new JPanel();
        panel6 = new JPanel();
        panel7 = new JPanel();
        Jicon1 = new JLabel(reicon11);
        table = new JTable();
        scrollPane = new JScrollPane();
        model = new DefaultTableModel();
        tablePanel = new JPanel();
        bg1 = new JPanel();
        bg2 = new JPanel();
        bg3 = new JPanel();
        bg4 = new JPanel();
        white1 = new JPanel();
        white2 = new JPanel();
        white3 = new JPanel();
        white4 = new JPanel();
        mainbg = new JPanel();
        history = new JLabel("<html><font color='#4F5A6C'>HIS</font><font color='#4A649D'>TORY</font></html>");

        //Button
        bn1 = new JButton("Dashboard");
        bn1.setPreferredSize(new Dimension(200, 10));
        bn1.setForeground(new Color(69, 104, 159));
        bn1.setBackground(new Color(69, 104, 159));
        bn1.setFont(new Font("Arial", Font.BOLD, 14));
        bn2 = new JButton("Assistance");
        bn2.setForeground(new Color(69, 104, 159));
        bn2.setBackground(new Color(69, 104, 159));
        bn2.setFont(new Font("Arial", Font.BOLD, 14));
        bn3 = new JButton("Product");
        bn3.setForeground(new Color(69, 104, 159));
        bn3.setBackground(new Color(69, 104, 159));
        bn3.setFont(new Font("Arial", Font.BOLD, 14));
        bn4 = new JButton("Stock");
        bn4.setForeground(new Color(69, 104, 159));
        bn4.setBackground(new Color(69, 104, 159));
        bn4.setFont(new Font("Arial", Font.BOLD, 14));
        bn5 = new JButton("History");
        bn5.setForeground(new Color(69, 104, 159));
        bn5.setBackground(new Color(69, 104, 159));
        bn5.setFont(new Font("Arial", Font.BOLD, 14));
        bn6 = new JButton("Member");
        bn6.setForeground(new Color(69, 104, 159));
        bn6.setBackground(new Color(69, 104, 159));
        bn6.setFont(new Font("Arial", Font.BOLD, 14));
        bn9 = new JButton("Option");
        bn9.setForeground(new Color(69, 104, 159));
        bn9.setBackground(new Color(69, 104, 159));
        bn9.setFont(new Font("Arial", Font.BOLD, 14));
        bn10 = new JButton("Export");
        bn10.setForeground(new Color(69, 104, 159));
        bn10.setBackground(new Color(69, 104, 159));
        bn10.setFont(new Font("Arial", Font.BOLD, 14));

        //Panel
        panel.setLayout(new GridLayout(13, 0, 0, 5));
        panel.add(bn1);
        panel.add(bn2);
        panel.add(bn3);
        panel.add(bn4);
        panel.add(bn5);
        panel.add(bn6);
        panel.add(bn9);
        panel.add(bn10);
        panel.setBackground(new Color(69, 104, 159));
        panel2.setLayout(new BorderLayout());
        panel5.setLayout(new BorderLayout());
        panel6.setLayout(new BorderLayout());
        panel5.setPreferredSize(new Dimension(200, 5));
        panel6.setPreferredSize(new Dimension(200, 5));
        panel2.setBackground(new Color(69, 104, 159));
        panel5.setBackground(new Color(69, 104, 159));
        panel6.setBackground(new Color(69, 104, 159));
        panel7.setBackground(new Color(69, 104, 159));
        panel2.add(label, BorderLayout.WEST);
        panel2.add(panel7, BorderLayout.EAST);
        panel7.setLayout(new GridBagLayout());
        panel7.add(uns1);
        panel7.add(j2);
        panel7.add(Jicon1);
        panel7.add(j1);
        panel2.add(panel5, BorderLayout.NORTH);
        panel2.add(panel6, BorderLayout.SOUTH);
        panel3.setLayout(new BorderLayout());
        panel3.setBackground(new Color(101, 113, 132));
        bg1.setBackground(new Color(101, 113, 132));
        bg1.setPreferredSize(new Dimension(25, 0));
        bg2.setBackground(new Color(101, 113, 132));
        bg2.setPreferredSize(new Dimension(0, 25));
        bg3.setBackground(new Color(101, 113, 132));
        bg3.setPreferredSize(new Dimension(0, 25));
        bg4.setBackground(new Color(101, 113, 132));
        bg4.setPreferredSize(new Dimension(25, 0));
        white1.setBackground(Color.white);
        white1.setPreferredSize(new Dimension(60, 0));
        white2.setBackground(Color.white);
        white2.setPreferredSize(new Dimension(0, 90));
        white3.setBackground(Color.white);
        white3.setPreferredSize(new Dimension(0, 60));
        white4.setBackground(Color.white);
        white4.setPreferredSize(new Dimension(60, 0));
        history.setFont(new Font("Arial", Font.BOLD, 48));
        history.setForeground(new Color(69, 104, 159));
        white2.add(history);
        tablePanel.setBorder(BorderFactory.createEmptyBorder(30,0,0,0));
        scrollPane.setPreferredSize(new Dimension(500,500));
        tablePanel.setBackground(Color.white);
        mainbg.setBackground(Color.white);

        //TABLE
        scrollPane.setViewportView(table);
        table.setModel(model);
        table.setFont(new Font("Arial", Font.BOLD, 16));
        model.setColumnIdentifiers(columnName);
        //New
        Object[][] dataRows = {};
        //Old
//        Object[][] dataRows = {
//            {"3/3/2024"},
//            {"2/3/2024"},
//            {"1/3/2024"}
//        };
        for (Object[] dataRow : dataRows) {
            model.insertRow(model.getRowCount(), dataRow);
        }
        table.getColumnModel().getColumn(0).setPreferredWidth(650);
        table.setDefaultEditor(Object.class, null);
        table.setCellSelectionEnabled(false);
        table.setGridColor(new Color(69, 104, 159));
        table.setRowHeight(50);
        table.setForeground(new Color(69, 104, 159));
        table.setFont(new Font("Arial", Font.BOLD, 18));
        tablePanel.setLayout(new BorderLayout());
        this.setLayout(new BorderLayout());
        this.add(bg1, BorderLayout.WEST);
        this.add(bg2, BorderLayout.NORTH);
        this.add(bg3, BorderLayout.SOUTH);
        this.add(bg4, BorderLayout.EAST);
        mainbg.setLayout(new GridLayout());
        mainbg.add(tablePanel);
        this.add(mainbg);
        mainbg.setBorder(new LineBorder(new Color(69, 104, 159), 5));
        tablePanel.add(scrollPane);
        tablePanel.add(white1, BorderLayout.EAST);
        tablePanel.add(white2, BorderLayout.NORTH);
        tablePanel.add(white3, BorderLayout.SOUTH);
        tablePanel.add(white4, BorderLayout.WEST);
        scrollPane.setBorder(new LineBorder(new Color(69, 104, 159), 4));

        //JFrame
        fr.setIconImage(icon1.getImage());
        fr.setLayout(new BorderLayout());
        //fr.add(panel2, BorderLayout.NORTH);
        fr.add(this);
        //fr.add(panel, BorderLayout.WEST);
        fr.setSize(1280, 720);
        fr.setLocationRelativeTo(null);
        fr.setVisible(false);
    }
    public Object[][] getDataRows() {
        return dataRows;
    }

    public void setDataRows(Object[][] dataRows) {
        this.dataRows = dataRows;
    }
    public void addRow(ArrayList<String> list){
        if (list.contains(null) == true){
            list.remove(null);
        }
        for (int i = 0; i < list.size(); i++){
                Object[] adder = new Object[1];
                adder[0] = list.get(i);
                model.insertRow(i, adder);   
        }
    }
    public void removeAllRow(){
        model.setRowCount(0);
    }
    public void displaydata(Object[][] dataRows) {
        model.setColumnIdentifiers(columnName);
        for (Object[] dataRow : dataRows) {
            model.insertRow(model.getRowCount(), dataRow);
            table.getColumnModel().getColumn(0).setPreferredWidth(650);
            table.setDefaultEditor(Object.class, null);
            table.setCellSelectionEnabled(false);
            table.setGridColor(new Color(69, 104, 159));
            table.setRowHeight(50);
            table.setForeground(new Color(69, 104, 159));
            table.setFont(new Font("Arial", Font.BOLD, 18));
            tablePanel.setLayout(new BorderLayout());
            this.setLayout(new BorderLayout());
            this.add(bg1, BorderLayout.WEST);
            this.add(bg2, BorderLayout.NORTH);
            this.add(bg3, BorderLayout.SOUTH);
            this.add(bg4, BorderLayout.EAST);
            mainbg.setLayout(new GridLayout());
            mainbg.add(tablePanel);
            this.add(mainbg);
            mainbg.setBorder(new LineBorder(new Color(69, 104, 159), 5));
            tablePanel.add(scrollPane);
            tablePanel.add(white1, BorderLayout.EAST);
            tablePanel.add(white2, BorderLayout.NORTH);
            tablePanel.add(white3, BorderLayout.SOUTH);
            tablePanel.add(white4, BorderLayout.WEST);
            scrollPane.setBorder(new LineBorder(new Color(69, 104, 159), 4));
        }
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            new HistoryView();
        });
    }
}
