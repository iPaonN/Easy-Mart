package View;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.*;

public class Member extends JPanel{
    private JFrame fr;
    private JLabel label, uns1, j1, j2;
    private JLabel Jicon1, Jicon2, Jicon3, member;
    private JButton bn1, bn2, bn3, bn4, bn5, bn6, bn9, bn10, add;
    private JPanel panel, panel2, panel3, pane14, panel5, panel6 , panel7, tablePanel;
    private JPanel bg1, bg2, bg3, bg4, white1, white2, white3, white4, mainbg, empty, searchPanel;
    private ImageIcon icon1, icon2, icon3, icon4, icon5, icon6, icon7, icon8, icon9;
    private ImageIcon reicon1, reicon2, reicon3, reicon4, reicon5, reicon6, reicon9, reicon10, reicon11;
    private GridBagConstraints gb1;
    private JTable table;
    private JScrollPane scrollPane;
    private DefaultTableModel model;
    private JTextField search;
    private DefaultTableCellRenderer renderer;
    private final Object[] columnName = {"Name", "Role"};
    
    public Member() {
        fr = new JFrame("menu");
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
        member = new JLabel("MEMBER");
        empty = new JPanel();
        search = new JTextField(30);
        searchPanel = new JPanel();
        add = new JButton("+Add Member");
        renderer = new DefaultTableCellRenderer();

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
        white1.setPreferredSize(new Dimension(65, 0));
        white2.setBackground(Color.white);
        white2.setPreferredSize(new Dimension(300, 160));
        white3.setBackground(Color.white);
        white3.setPreferredSize(new Dimension(0, 60));
        white4.setBackground(Color.white);
        white4.setPreferredSize(new Dimension(60, 0));
        tablePanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        scrollPane.setPreferredSize(new Dimension(500,500));
        tablePanel.setBackground(Color.white);
        tablePanel.setLayout(new BorderLayout());
        tablePanel.add(scrollPane);
        tablePanel.setBorder(new LineBorder(new Color(69, 104, 159),4));
        this.setBackground(Color.red);
        this.setLayout(new BorderLayout());
        this.add(bg1, BorderLayout.WEST);
        this.add(bg2, BorderLayout.NORTH);
        this.add(bg3, BorderLayout.SOUTH);
        this.add(bg4, BorderLayout.EAST);
        this.add(tablePanel);
        
        //Inner
        tablePanel.add(white1, BorderLayout.WEST);
        tablePanel.add(white2, BorderLayout.NORTH);
        tablePanel.add(white3, BorderLayout.SOUTH);
        tablePanel.add(white4, BorderLayout.EAST);
        empty.setBackground(Color.white);
        white2.add(member);
        white2.add(searchPanel);
        white2.setLayout(new GridLayout(2,0));
        member.setFont(new Font("Arial", Font.BOLD, 48));
        white2.setBorder(BorderFactory.createEmptyBorder(20,60,0,0));
        searchPanel.setLayout(new BorderLayout());
        searchPanel.setBackground(Color.white);
        searchPanel.add(empty, BorderLayout.WEST);
        search.setPreferredSize(new Dimension(300,30));
        add.setPreferredSize(new Dimension(120,30));
        add.setBackground(Color.white);
        empty.add(search);
        empty.add(add);
        empty.setBackground(Color.white);
        member.setForeground(new Color(69, 104, 159));
        add.setForeground(new Color(69, 104, 159));
        add.setHideActionText(true);
        search.setBorder(new LineBorder(new Color(69, 104, 159) ,3));
        add.setBorder(new LineBorder(new Color(69, 104, 159) ,3));
        add.setFont(new Font("Arial", Font.BOLD, 12));
        
        //TABLE
        scrollPane.setViewportView(table);
        table.setModel(model);
        model.setColumnIdentifiers(columnName);
        Object[][] dataRows = {
            {"NutthawatInwza", "hai kum rung jai"},
            {"TibetInwza", "zuzu zaza"},
            {"ThanapatInwza", "tuainw"}
        };
        model.setColumnIdentifiers(columnName);
        for (Object[] dataRow : dataRows) {
            model.insertRow(model.getRowCount(), dataRow);
        }
        table.setDefaultEditor(Object.class, null);
        table.setFont(new Font("Arial", Font.BOLD, 20));
        table.setRowHeight(50);
        table.setCellSelectionEnabled(false);
        table.setForeground(new Color(69, 104, 159));
        table.setGridColor(new Color(69, 104, 159));
        table.getColumnModel().getColumn(0).setPreferredWidth(500);
        table.getColumnModel().getColumn(1).setCellRenderer(renderer);
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        search.setFont(new Font("Arial", Font.PLAIN, 20));
        search.setForeground(new Color(69, 104, 159));
        scrollPane.setBorder(new LineBorder(new Color(69, 104, 159), 4));
        
        //JFrame
        fr.setIconImage(icon1.getImage());
        fr.setLayout(new BorderLayout());
        //fr.add(panel2, BorderLayout.NORTH);
        fr.add(this);
        //fr.add(panel, BorderLayout.WEST);
        fr.setSize(1280, 720);
        fr.setVisible(true);
    }
    
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            new Member();
        });
}
}
