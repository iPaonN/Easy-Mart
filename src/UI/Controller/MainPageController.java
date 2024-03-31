package UI.Controller;

import My_sql.ProjectData.DoProjectData;
import My_sql.UserData.DoUserData;
import UI.View.Addproject;
import UI.View.MainMenu;
import UI.View.MainPage;
import UI.View.MainRenderer;
import java.awt.Color;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;


public class MainPageController implements MouseListener, ActionListener, DocumentListener, ListSelectionListener{
    private String username;
    private ArrayList<String> projectlist;
    private MainPage main;
    private MainRenderer render;
    private DoUserData manager;
    private DoProjectData pmanager;
    private JPopupMenu pop;
    private JMenuItem edit, change, logout;
    private PopEditProfile editpro;
    ArrayList<String> test;
    public MainPageController(String username){
        this.pmanager = new DoProjectData();
        this.manager = new DoUserData();
        this.username = username;
        this.projectlist = (ArrayList<String>)manager.GetProjectList(this.username);
        main = new MainPage();
        main.getCp1().LoadImage(manager.GetProfileImage(this.username));
        main.getUsername().setText(this.username);
        main.removeAllRow();
//        test = new ArrayList<String>();
//        test.add("a");
//        test.add("B");
        System.out.println(projectlist);
        main.addRow(this.projectlist);
        
        //Popup menu
        pop = new JPopupMenu();
        edit = new JMenuItem("Edit Profile");
        change = new JMenuItem("Change Password");
        logout = new JMenuItem("Log out");
        pop.add(edit);
        pop.add(change);
        pop.add(logout);
        main.getUsername().add(pop);
        
        //Popupmenu
        main.getUsername().addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                    pop.show(main.getUsername(), e.getX(), e.getY());   
            }
        });
        
        //AddListener
        main.getEasyMart().addMouseListener(this);
        edit.addActionListener(this);
        change.addActionListener(this);
        logout.addActionListener(this);
        main.getUsername().addMouseListener(this);
        main.getBtnNew().addActionListener(this);
        main.getEnter().addActionListener(this);
        main.getSearch().getDocument().addDocumentListener(this);
        main.getTable().getSelectionModel().addListSelectionListener(this);
        main.getTable().addMouseListener(this);
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

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource().equals(main.getTable())){
            int selectedRow = main.getTable().getSelectedRow();
            int selectedColum = main.getTable().getSelectedColumn();
//            System.out.println(selectedRow+" "+selectedColum);
            DefaultTableModel model = (DefaultTableModel)main.getTable().getModel();
            new MenuController(username, (String)model.getValueAt(selectedRow, 0));
            this.main.getFrame().dispose();
        }
        else if (e.getSource().equals(main.getEasyMart())){
           new MainPageController(this.username);
           this.main.getFrame().dispose();
        }
        
        
    }
    public boolean checkPJName(String pjn){
        for (char c : pjn.toCharArray()){
            if (Character.isLetterOrDigit(c) == false){
                return false;
            } 
        }
        return true;
    }
    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(main.getBtnNew())){
            main.getAddProject().setVisible(true);
        }
        else if (e.getSource().equals(main.getEnter())){
            String npj = main.getInsertname().getText();
            if (npj.equals("null")){
                JOptionPane.showMessageDialog(null, "Don't set null to Project name");
                main.getInsertname().setText("");
            }
            else if (this.projectlist.contains(npj) == true){
                JOptionPane.showMessageDialog(null, "You already have this projectname.");
                main.getInsertname().setText("");
            }
            else if (npj.equals("")){
                JOptionPane.showMessageDialog(null, "Input your project name");
                main.getInsertname().setText("");
            }
            else if (this.checkPJName(npj) == false){
                JOptionPane.showMessageDialog(null, "ProjectName must have only letter or digit");
                main.getInsertname().setText("");
            }
            else{
                manager.UpdateProjectList(username, projectlist, username+"_"+npj);
                pmanager.Createtemplate(username, npj);
                pmanager.insert_member(username+"_"+npj, this.username, "Owner");
                main.getInsertname().setText("");
                main.getAddProject().setVisible(false);
                projectlist = manager.GetProjectList(username);
                main.removeAllRow();
                main.addRow(this.projectlist);
            }
        }
        else if (e.getSource().equals(edit)){
            editpro = new PopEditProfile(this.username);
        }
//        else if (e.getSource().equals(this.change)){
//            editpass = new ChangePassword();
//        }
        else if (e.getSource().equals(this.logout)){
            new LoginController();
            this.main.getFrame().dispose();
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        String word = main.getSearch().getText();
        if (word.equals("") == false){
           ArrayList<String> issub = new ArrayList<String>();
        for (String n : this.projectlist){
            if(n.contains(word) == true){
                issub.add(n);
            }
        }
        main.removeAllRow();
        main.addRow(issub); 
        }
        else{
            main.removeAllRow();
            main.addRow(this.projectlist);
        }
        
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        String word = main.getSearch().getText();
        if (word.equals("") == false){
           ArrayList<String> issub = new ArrayList<String>();
        for (String n : this.projectlist){
            if(n.contains(word) == true){
                issub.add(n);
            }
        }
        main.removeAllRow();
        main.addRow(issub); 
        }
        else{
            main.removeAllRow();
            main.addRow(this.projectlist);
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        
    }
}
