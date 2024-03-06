
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class MainPage implements ActionListener{
    private JFrame frame;
    private JPanel mainbg, top, bgwhite, bd1, bd2, bd3, bd4, bd5, searchPanel, tablePanel, topPanel;
    private JPanel profilePanel, white1, white2, white3, bottom, btnPanel, martPanel;
    private JLabel martname, username, iconLabel, help, support, iconLabel2;
    private JTextField search;
    private JButton btnNew, btnImport;
    private JTable table;
    private JScrollPane scrollPane;
    private DefaultTableModel model;
    private int count = 0;
    private ImageIcon usericon, scaleicon, marticon, scaleicon2;
    public MainPage(){
        
        //CREATE OBJECT
        frame = new JFrame("PROJECT");
        mainbg = new JPanel();
        top = new JPanel();
        usericon = new ImageIcon("src/UI/Image/username.png");
        scaleicon = new ImageIcon(usericon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        marticon = new ImageIcon("src/UI/Image/eweweewew.jpg");
        scaleicon2 = new ImageIcon(marticon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH));
        martname = new JLabel("EASY MART", scaleicon2, 0);
        username = new JLabel("Nutthawat Chotpanjawong");
        bgwhite = new JPanel();
        bd1 = new JPanel();
        bd2 = new JPanel();
        bd3 = new JPanel();
        bd4 = new JPanel();
        bd5 = new JPanel(); //center bgwhite
        searchPanel = new JPanel();
        tablePanel = new JPanel();
        search = new JTextField();
        btnNew = new JButton("+ new");
        btnImport = new JButton("Import");
        btnPanel = new JPanel();
        scrollPane = new JScrollPane();
        table = new JTable();
        topPanel = new JPanel();
        model = new DefaultTableModel();
        profilePanel = new JPanel();
        white1 = new JPanel();
        white2 = new JPanel();
        white3 = new JPanel();
        iconLabel = new JLabel();
        iconLabel2 = new JLabel();
        bottom = new JPanel();
        martPanel = new JPanel();
        help = new JLabel("Help");
        support = new JLabel("Support");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //SET LAYOUT
        top.setLayout(new BorderLayout());
        mainbg.setLayout(new BorderLayout());
        bgwhite.setLayout(new BorderLayout());
        bd5.setLayout(new BorderLayout());
        searchPanel.setLayout(new BorderLayout());
        topPanel.setLayout(new BorderLayout());
        profilePanel.setLayout(new BorderLayout());
        tablePanel.setLayout(new BorderLayout());
        bottom.setLayout(new FlowLayout());
        white2.setLayout(new BorderLayout());
        btnPanel.setLayout(new BorderLayout());
        
        //TOP
        martname.setFont(new Font("Arial", Font.BOLD, 40));
        martname.setForeground(Color.white);
        martname.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        username.setFont(new Font("Arial", Font.PLAIN, 14));
        username.setForeground(Color.white);
        top.setBackground(new Color(69, 104, 159));
        top.setPreferredSize(new Dimension(0, 80));
        profilePanel.setBackground(new Color(69, 104, 159));
        profilePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
        username.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        iconLabel.setIcon(scaleicon);
        iconLabel2.setIcon(scaleicon2);
        //martPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
        martPanel.setBackground(new Color(69, 104, 159));
        
        //BACKGROUND
        mainbg.setBackground(new Color(157,178,191));
        bgwhite.setBackground(Color.white);
        bd1.setBackground(new Color(101, 113, 132));
        bd2.setBackground(new Color(101, 113, 132));
        bd3.setBackground(new Color(101, 113, 132));
        bd4.setBackground(new Color(101, 113, 132));
        bd5.setBackground(Color.white);
        bd1.setPreferredSize(new Dimension(0, 20));
        bd2.setPreferredSize(new Dimension(0, 20));
        bd3.setPreferredSize(new Dimension(20, 0));
        bd4.setPreferredSize(new Dimension(20, 0));
        bd5.setBorder(new LineBorder(new Color(69, 104, 159), 5));
        
        //INNER
        searchPanel.setBackground(Color.white);
        search.setFont(new Font("Arial", Font.PLAIN, 18));
        search.setBorder(new LineBorder(new Color(69, 104, 159), 2));
        search.setPreferredSize(new Dimension(300, 20));
        btnNew.setFont(new Font("Arial", Font.BOLD, 18));
        btnNew.setBackground(new Color(69, 104, 159));
        btnNew.setForeground(new Color(69, 104, 159));        
        btnImport.setFont(new Font("Arial", Font.BOLD, 18));
        btnImport.setBackground(new Color(69, 104, 159));
        btnImport.setForeground(new Color(69, 104, 159));
        btnPanel.setBackground(Color.white);
        topPanel.setBackground(Color.white);
        bottom.setBackground(Color.white);
        bottom.setBorder(BorderFactory.createEmptyBorder(5,0,0,25));
        help.setFont(new Font("Arial", Font.BOLD, 12));
        help.setForeground(new Color(69, 104, 159));
        help.setBorder(BorderFactory.createEmptyBorder(0,0,0,5));
        support.setFont(new Font("Arial", Font.BOLD, 12));
        support.setForeground(new Color(69, 104, 159));
        topPanel.setBorder(BorderFactory.createEmptyBorder(20,30,15,0));
        
        //TABLE
        scrollPane.setViewportView(table);
        table.setModel(model);
        model.addColumn("Name");
        model.addColumn("Option");
        table.setGridColor(new Color(69, 104, 159));
        table.setBorder(new LineBorder(new Color(69, 104, 159)));
        table.setBackground(Color.white);
        table.setForeground(new Color(69, 104, 159));
        table.setRowHeight(50);
        table.setFont(new Font("Aria^l", Font.BOLD, 16));
        table.getColumnModel().getColumn(0).setPreferredWidth(800);
        table.getColumnModel().getColumn(1).setCellRenderer(new MainRenderer());
        table.getColumnModel().getColumn(1).setCellEditor(new MainEditor(new JCheckBox()));
        table.setTableHeader(null);
        table.setDefaultEditor(Object.class, null);
        tablePanel.add(scrollPane);
        tablePanel.setBackground(Color.white);
        scrollPane.setBorder(new LineBorder(new Color(69, 104, 159), 2));
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        white1.setBackground(Color.white);
        white1.setPreferredSize(new Dimension(30,0));
        white2.setBackground(Color.white);
        white2.setPreferredSize(new Dimension(0,35));
        white3.setBackground(Color.white);
        white3.setPreferredSize(new Dimension(30,0));
        
        
        //HANDLER
        btnNew.addActionListener(this);
        
        //ADD
        top.add(martPanel, BorderLayout.WEST);
        
        //martPanel.add(iconLabel2);
        martPanel.add(martname);
        profilePanel.add(username, BorderLayout.WEST);
        profilePanel.add(iconLabel);
        top.add(profilePanel, BorderLayout.EAST);
        bgwhite.add(bd1, BorderLayout.SOUTH);
        bgwhite.add(bd2, BorderLayout.NORTH);
        bgwhite.add(bd3, BorderLayout.WEST);
        bgwhite.add(bd4, BorderLayout.EAST);
        bgwhite.add(bd5);
        searchPanel.add(search);
        btnPanel.add(btnNew);
        btnPanel.add(btnImport,BorderLayout.EAST);
        searchPanel.add(btnPanel, BorderLayout.EAST);
        topPanel.add(searchPanel, BorderLayout.WEST);
        bd5.add(topPanel, BorderLayout.NORTH);
        tablePanel.add(scrollPane);
        tablePanel.add(white1, BorderLayout.WEST);
        bottom.add(help);
        bottom.add(support);
        white2.add(bottom, BorderLayout.EAST);
        tablePanel.add(white2, BorderLayout.SOUTH);
        tablePanel.add(white3, BorderLayout.EAST);
        bd5.add(tablePanel);
        mainbg.add(top, BorderLayout.NORTH);
        mainbg.add(bgwhite, BorderLayout.CENTER);
        frame.add(mainbg);
        frame.setIconImage(scaleicon2.getImage());
        frame.setSize(1280,720);
        frame.setVisible(true);
        
    }
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            new MainPage();
        });
    }
    @Override
    public void actionPerformed(ActionEvent ev){
        model.addRow(new Object[0]);
        model.setValueAt(" Project Name", count, 0);
        count++;
    }
}