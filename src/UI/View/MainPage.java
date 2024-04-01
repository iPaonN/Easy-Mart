package UI.View;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class MainPage implements MouseListener{
    private JFrame frame;
    private JPanel mainbg, top, bgwhite, bd1, bd2, bd3, bd4, bd5, searchPanel, tablePanel, topPanel;
    private JPanel profilePanel, white1, white2, white3, bottom, btnPanel, martPanel;
    private JPanel pempty1, mainPanel, innerPanel, enPanel;
    private JLabel martname, username, iconLabel, help, support, iconLabel2, nameLabel, supportText;
    private JLabel lb1, lb2, lb3, lb4;
    private JTextField search, insertname;
    private JButton btnNew, btnImport, enter;
    private JTable table;
    private JScrollPane scrollPane;
    protected DefaultTableModel model;
    protected int count = 0;
    private ImageIcon usericon, scaleicon, marticon, scaleicon2;
    private JInternalFrame helpFrame, supportFrame, addProject;
    private CircleProfile cp1;
    private final Object[] columnName = {"Name"};
    private ArrayList<String> projectlist;
    
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
        username = new JLabel();
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
        supportText = new JLabel("Contact Email : 66070082@kmitl.ac.th");
        helpFrame = new JInternalFrame("Help", false, true);
        supportFrame = new JInternalFrame("Support", false, true);
        addProject = new JInternalFrame("New Project", false, true);
        lb1 = new JLabel(" 1. Click new and enter projectname to create");
        lb2 = new JLabel(" 2. Enter your project that your create");
        lb3 = new JLabel(" 3. Add product and member");
        lb4 = new JLabel(" 4. Enjoy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //SET LAYOUT
        help.addMouseListener(this);
        support.addMouseListener(this);
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
        projectlist = new ArrayList<String>();
        projectlist.add("a");
        projectlist.add("b");
        for (int i = 0; i < projectlist.size(); i++){
            Object[] adder = new Object[1];
            adder[0] = projectlist.get(i);
            model.insertRow(i, adder);
        }
        table.setGridColor(new Color(69, 104, 159));
        table.setBackground(Color.white);
        table.setForeground(new Color(69, 104, 159));
        table.setRowHeight(50);
        table.setCellSelectionEnabled(false);
        table.setFont(new Font("Arial", Font.BOLD, 18));
        table.getColumnModel().getColumn(0).setPreferredWidth(800);
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
        supportText.setHorizontalAlignment(JLabel.CENTER);
        supportText.setFont(new Font("Arial", Font.BOLD, 20));
        supportText.setForeground(Color.white);
        supportFrame.add(supportText);
        supportFrame.setBackground(new Color(69, 104, 159));
        helpFrame.setBackground(new Color(69, 104, 159));
        helpFrame.setLayout(new GridLayout(4,0));
        helpFrame.add(lb1);
        lb1.setFont(new Font("Arial", Font.BOLD, 16));
        lb1.setForeground(Color.white);
        helpFrame.add(lb2);
        lb2.setFont(new Font("Arial", Font.BOLD, 16));
        lb2.setForeground(Color.white);
        helpFrame.add(lb3);
        lb3.setFont(new Font("Arial", Font.BOLD, 16));
        lb3.setForeground(Color.white);
        helpFrame.add(lb4);
        lb4.setFont(new Font("Arial", Font.BOLD, 16));
        lb4.setForeground(Color.white);
        frame.add(helpFrame);
        frame.add(supportFrame);
        
        mainPanel = new JPanel();
        insertname = new JTextField(20);
        nameLabel = new JLabel("PROJECT NAME");
        innerPanel = new JPanel();
        enter = new JButton("ENTER");
        enPanel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        nameLabel.setFont(new Font("Arial", Font.BOLD, 36));
        nameLabel.setForeground(Color.white);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(40,0,0,0));
        nameLabel.setBorder(BorderFactory.createEmptyBorder(0,0,25,0));
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        enter.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));
        insertname.setFont(new Font("Arial", Font.BOLD, 20));
        insertname.setBorder(new LineBorder(Color.white, 3));
        insertname.setBackground(new Color(101, 113, 132));
        insertname.setForeground(Color.white);
        innerPanel.setBackground(new Color(69, 104, 159));
        innerPanel.setLayout(new BorderLayout());
        innerPanel.add(nameLabel, BorderLayout.NORTH);
        innerPanel.add(insertname);
        enter.setPreferredSize(new Dimension(150,40));
        enter.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        enPanel.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
        enter.setBackground(new Color(69, 104, 159));
        enter.setForeground(new Color(69, 104, 159));
        enter.setBorder(new LineBorder(Color.white, 3));
        enter.setFont(new Font("Arial", Font.BOLD, 20));
        enter.setFocusPainted(false);
        enPanel.setLayout(new FlowLayout());
        enPanel.add(enter);
        enPanel.setBackground(new Color(69, 104, 159));
        innerPanel.add(enPanel, BorderLayout.SOUTH);
        mainPanel.add(innerPanel);
        mainPanel.setBackground(new Color(69, 104, 159));
        addProject.add(mainPanel);
        addProject.setSize(450,300);
        frame.add(addProject);
        
        
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
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
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
    public void removeRow(){
        if (model.getRowCount() != 0){
            for (int i = 0; i < (model.getRowCount() + 1); i++) {
                model.removeRow(0);
            }
        }
    }
    
    public JLabel getEasyMart(){
        return martname;
    }

    public JInternalFrame getAddProject() {
        return addProject;
    }

    public void setAddProject(JInternalFrame addProject) {
        this.addProject = addProject;
    }
    
    public void removeSelectedRow(int rowSelected){
        model.removeRow(rowSelected);
    }
    public void removeAllRow(){
        model.setRowCount(0);
    }

    public JTextField getSearch() {
        return search;
    }

    public void setSearch(JTextField search) {
        this.search = search;
    }
    
    public JTextField getInsertname() {
        return insertname;
    }

    public void setInsertname(JTextField insertname) {
        this.insertname = insertname;
    }

    public JButton getBtnNew() {
        return btnNew;
    }

    public void setBtnNew(JButton btnNew) {
        this.btnNew = btnNew;
    }

    public JButton getEnter() {
        return enter;
    }

    public void setEnter(JButton enter) {
        this.enter = enter;
    }

    public JInternalFrame getHelpFrame() {
        return helpFrame;
    }

    public void setHelpFrame(JInternalFrame helpFrame) {
        this.helpFrame = helpFrame;
    }
    
    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }
    
    public void showProject(ArrayList<String> projectlist){
    }
    public ArrayList<String> getProjectlist() {
        return projectlist;
    }

    public void setProjectlist(ArrayList<String> projectlist) {
        this.projectlist = projectlist;
    }
    
    public JLabel getUsername() {
        return username;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }
    
    public void setUsername(JLabel username) {
        this.username = username;
    }
    public CircleProfile getCp1() {
        return cp1;
    }

    public void setCp1(CircleProfile cp1) {
        this.cp1 = cp1;
    }
    @Override
      public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(help)){
            helpFrame.setVisible(true);
        }
        if (e.getSource().equals(support)){
            supportFrame.setVisible(true);
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        //
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource().equals(help)){
            help.setForeground(new Color(69, 104, 159));
            help.setFont(new Font("Arial", Font.BOLD, 14));
        }
        if (e.getSource().equals(support)){
            support.setForeground(new Color(69, 104, 159));
            support.setFont(new Font("Arial", Font.BOLD, 14));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(help)){
            help.setForeground(new Color(69, 104, 159));
            help.setFont(new Font("Arial", Font.BOLD, 12));
        }
        if (e.getSource().equals(support)){
            support.setForeground(new Color(69, 104, 159));
            support.setFont(new Font("Arial", Font.BOLD, 12));
        }
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
