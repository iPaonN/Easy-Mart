package UI.View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class MainPage {
    private JFrame frame;
    private JPanel mainbg, top, bgwhite, bd1, bd2, bd3, bd4, bd5, searchPanel, tablePanel, topPanel;
    private JPanel profilePanel, white1, white2, white3, bottom, btnPanel, martPanel;
    private JPanel pempty1;
    private JLabel martname, username, iconLabel, help, support, iconLabel2;
    private JTextField search;
    private JButton btnNew, btnImport;
    private JTable table;
    private JScrollPane scrollPane;
    protected DefaultTableModel model;
    protected int count = 0;
    private ImageIcon usericon, scaleicon, marticon, scaleicon2;
    private Addproject addproject;
    private JInternalFrame helpFrame, supportFrame, addProject;
    private CircleProfile cp1;
    private final Object[] columnName = {"Name", "Option"};

    public MainPage(){
        //CREATE OBJECT
        cp1 = new CircleProfile();
        cp1.LoadImage("src/UI/Image/3.jpg");
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
        pempty1 = new JPanel();
        iconLabel = new JLabel();
        iconLabel2 = new JLabel();
        bottom = new JPanel();
        martPanel = new JPanel();
        help = new JLabel("Help");
        support = new JLabel("Support");
        helpFrame = new JInternalFrame("Help", false, true);
        supportFrame = new JInternalFrame("Support", false, true);
        //addProject = new JInternalFrame(new Addproject());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //SET LAYOUT
        top.setLayout(new BorderLayout());
        mainbg.setLayout(new BorderLayout());
        bgwhite.setLayout(new BorderLayout());
        bd5.setLayout(new BorderLayout());
        searchPanel.setLayout(new FlowLayout());
        topPanel.setLayout(new BorderLayout());
        profilePanel.setLayout(new BorderLayout());
        tablePanel.setLayout(new BorderLayout());
        bottom.setLayout(new FlowLayout());
        white2.setLayout(new BorderLayout());
        btnPanel.setLayout(new FlowLayout());
        pempty1.setLayout(new BorderLayout());
        
        //TOP
        martname.setFont(new Font("Arial", Font.BOLD, 40));
        martname.setForeground(Color.white);
        username.setFont(new Font("Arial", Font.PLAIN, 14));
        username.setForeground(Color.white);
        top.setBackground(new Color(69, 104, 159));
        top.setPreferredSize(new Dimension(0, 80));
        profilePanel.setBackground(new Color(69, 104, 159));
        profilePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
        username.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        iconLabel.setIcon(scaleicon);
        iconLabel2.setIcon(scaleicon2);
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
        pempty1.setBackground(new Color(69, 104, 159));
        
        //INNER
        searchPanel.setBackground(Color.white);
        search.setFont(new Font("Arial", Font.PLAIN, 18));
        search.setBorder(new LineBorder(new Color(69, 104, 159), 3));
        search.setPreferredSize(new Dimension(350, 33));
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
        search.setFont(new Font("Arial", Font.PLAIN, 20));
        search.setForeground(new Color(69, 104, 159));
        
        //TABLE
        scrollPane.setViewportView(table);
        table.setModel(model);
        model.setColumnIdentifiers(columnName);
        Object[][] dataRows = {
            {"NutthawatInwza"},
            {"TibetInwza"},
            {"ThanapatInwza"}
        };
        model.setColumnIdentifiers(columnName);
        for (Object[] dataRow : dataRows) {
            model.insertRow(model.getRowCount(), dataRow);
        }
        table.setGridColor(new Color(69, 104, 159));
        table.setBackground(Color.white);
        table.setForeground(new Color(69, 104, 159));
        table.setRowHeight(50);
        table.setCellSelectionEnabled(false);
        table.setFont(new Font("Arial", Font.BOLD, 16));
        table.getColumnModel().getColumn(0).setPreferredWidth(800);
        table.getColumnModel().getColumn(1).setCellRenderer(new MainRenderer());
        table.getColumnModel().getColumn(1).setCellEditor(new MainEditor(new JCheckBox()));
        table.setTableHeader(null);
        table.setDefaultEditor(Object.class, null);
        tablePanel.add(scrollPane);
        tablePanel.setBackground(Color.white);
        scrollPane.setBorder(new LineBorder(new Color(69, 104, 159), 4));
        white1.setBackground(Color.white);
        white1.setPreferredSize(new Dimension(35,0));
        white2.setBackground(Color.white);
        white2.setPreferredSize(new Dimension(0,35));
        white3.setBackground(Color.white);
        white3.setPreferredSize(new Dimension(30,0));
        
        //HANDLER, HELP and SUPPOR
        helpFrame.setSize(400,250);
        helpFrame.setLocation(600, 320);
        supportFrame.setSize(400,250);
        supportFrame.setLocation(300, 300);
        frame.add(helpFrame);
        frame.add(supportFrame);
        
        //ADD
        top.add(martPanel, BorderLayout.WEST);
        martPanel.add(martname);
        profilePanel.add(username, BorderLayout.WEST);
        cp1.setPreferredSize(new Dimension(45, 50));
        profilePanel.add(pempty1);
        pempty1.add(cp1);
        pempty1.add(new JLabel("    "), BorderLayout.SOUTH);
        pempty1.add(new JLabel("    "), BorderLayout.NORTH);
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

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JPanel getMainbg() {
        return mainbg;
    }

    public void setMainbg(JPanel mainbg) {
        this.mainbg = mainbg;
    }

    public JPanel getTop() {
        return top;
    }

    public void setTop(JPanel top) {
        this.top = top;
    }

    public JPanel getBgwhite() {
        return bgwhite;
    }

    public void setBgwhite(JPanel bgwhite) {
        this.bgwhite = bgwhite;
    }

    public JPanel getBd1() {
        return bd1;
    }

    public void setBd1(JPanel bd1) {
        this.bd1 = bd1;
    }

    public JPanel getBd2() {
        return bd2;
    }

    public void setBd2(JPanel bd2) {
        this.bd2 = bd2;
    }

    public JPanel getBd3() {
        return bd3;
    }

    public void setBd3(JPanel bd3) {
        this.bd3 = bd3;
    }

    public JPanel getBd4() {
        return bd4;
    }

    public void setBd4(JPanel bd4) {
        this.bd4 = bd4;
    }

    public JPanel getBd5() {
        return bd5;
    }

    public void setBd5(JPanel bd5) {
        this.bd5 = bd5;
    }

    public JPanel getSearchPanel() {
        return searchPanel;
    }

    public void setSearchPanel(JPanel searchPanel) {
        this.searchPanel = searchPanel;
    }

    public JPanel getTablePanel() {
        return tablePanel;
    }

    public void setTablePanel(JPanel tablePanel) {
        this.tablePanel = tablePanel;
    }

    public JPanel getTopPanel() {
        return topPanel;
    }

    public void setTopPanel(JPanel topPanel) {
        this.topPanel = topPanel;
    }

    public JPanel getProfilePanel() {
        return profilePanel;
    }

    public void setProfilePanel(JPanel profilePanel) {
        this.profilePanel = profilePanel;
    }

    public JPanel getWhite1() {
        return white1;
    }

    public void setWhite1(JPanel white1) {
        this.white1 = white1;
    }

    public JPanel getWhite2() {
        return white2;
    }

    public void setWhite2(JPanel white2) {
        this.white2 = white2;
    }

    public JPanel getWhite3() {
        return white3;
    }

    public void setWhite3(JPanel white3) {
        this.white3 = white3;
    }

    public JPanel getBottom() {
        return bottom;
    }

    public void setBottom(JPanel bottom) {
        this.bottom = bottom;
    }

    public JPanel getBtnPanel() {
        return btnPanel;
    }

    public void setBtnPanel(JPanel btnPanel) {
        this.btnPanel = btnPanel;
    }

    public JPanel getMartPanel() {
        return martPanel;
    }

    public void setMartPanel(JPanel martPanel) {
        this.martPanel = martPanel;
    }

    public JPanel getPempty1() {
        return pempty1;
    }

    public void setPempty1(JPanel pempty1) {
        this.pempty1 = pempty1;
    }

    public JLabel getMartname() {
        return martname;
    }

    public void setMartname(JLabel martname) {
        this.martname = martname;
    }

    public JLabel getUsername() {
        return username;
    }

    public void setUsername(JLabel username) {
        this.username = username;
    }

    public JLabel getIconLabel() {
        return iconLabel;
    }

    public void setIconLabel(JLabel iconLabel) {
        this.iconLabel = iconLabel;
    }

    public JLabel getHelp() {
        return help;
    }

    public void setHelp(JLabel help) {
        this.help = help;
    }

    public JLabel getSupport() {
        return support;
    }

    public void setSupport(JLabel support) {
        this.support = support;
    }

    public JLabel getIconLabel2() {
        return iconLabel2;
    }

    public void setIconLabel2(JLabel iconLabel2) {
        this.iconLabel2 = iconLabel2;
    }

    public JTextField getSearch() {
        return search;
    }

    public void setSearch(JTextField search) {
        this.search = search;
    }

    public JButton getBtnNew() {
        return btnNew;
    }

    public void setBtnNew(JButton btnNew) {
        this.btnNew = btnNew;
    }

    public JButton getBtnImport() {
        return btnImport;
    }

    public void setBtnImport(JButton btnImport) {
        this.btnImport = btnImport;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ImageIcon getUsericon() {
        return usericon;
    }

    public void setUsericon(ImageIcon usericon) {
        this.usericon = usericon;
    }

    public ImageIcon getScaleicon() {
        return scaleicon;
    }

    public void setScaleicon(ImageIcon scaleicon) {
        this.scaleicon = scaleicon;
    }

    public ImageIcon getMarticon() {
        return marticon;
    }

    public void setMarticon(ImageIcon marticon) {
        this.marticon = marticon;
    }

    public ImageIcon getScaleicon2() {
        return scaleicon2;
    }

    public void setScaleicon2(ImageIcon scaleicon2) {
        this.scaleicon2 = scaleicon2;
    }

    public Addproject getAddproject() {
        return addproject;
    }

    public void setAddproject(Addproject addproject) {
        this.addproject = addproject;
    }

    public JInternalFrame getHelpFrame() {
        return helpFrame;
    }

    public void setHelpFrame(JInternalFrame helpFrame) {
        this.helpFrame = helpFrame;
    }

    public JInternalFrame getSupportFrame() {
        return supportFrame;
    }

    public void setSupportFrame(JInternalFrame supportFrame) {
        this.supportFrame = supportFrame;
    }

    public JInternalFrame getAddProject() {
        return addProject;
    }

    public void setAddProject(JInternalFrame addProject) {
        this.addProject = addProject;
    }

    public CircleProfile getCp1() {
        return cp1;
    }

    public void setCp1(CircleProfile cp1) {
        this.cp1 = cp1;
    }
    
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            new MainPage();
        });
    }

    
}
