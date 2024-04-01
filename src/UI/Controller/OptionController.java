/*
delete buttun want to go to Mainpage after click delete
*/


package UI.Controller;

import Import_Export.*;
import My_sql.ProjectData.*;
import My_sql.UserData.*;
import UI.View.*;
import java.awt.*;
import java.awt.event.*;
//import java.io.*;
import javax.swing.*;
import java.util.*;
//WIP Made by Auto feat Pao
public class OptionController implements ActionListener, MouseListener {
    private DoUserData manager;
    private DoProjectData pjm;
    private Option main;
    private String username, oldprojectname, newname, projectname;
    private ImportFile im;
    private ArrayList<String> arraylist;
    private DeleteNotify dnotify;
    private MenuController out;
    
    
    public OptionController(String username, String projectname, MenuController out){
        String[] oldname= projectname.split("_");
        oldprojectname = oldname[1];
        this.projectname = projectname;
        this.out = out;
        dnotify = new DeleteNotify();
        dnotify.getDeleteButton().addActionListener(this);
        
        manager = new DoUserData();
        pjm = new DoProjectData();
        main = new Option();
        this.username = username;
        main.getSaveButton().addActionListener(this);
        main.getProfileicon().addMouseListener(this);
        main.getSaveButton2().addActionListener(this);
        main.getDeleteButton().addActionListener(this);
        main.getTFprojectname().setText(oldprojectname);
    }
    
    public Option getView(){
        return main;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String newprojectname = this.username+"_"+newname;
        
        if (e.getSource().equals(main.getSaveButton())){
            newname = main.getTFprojectname().getText();
            if (e.getSource().equals(main.getTFprojectname().getText().equals(""))){}
            if(main.getTFprojectname().getText().equals(main.getTFprojectnameC().getText())){
                main.getTFprojectnameC().setText("");
                JOptionPane.showMessageDialog(null, "Save Successfull");
                System.out.println(this.username + " clicked " + main.getSaveButton().getClass());
                pjm.rename_schema(username, oldprojectname, newname);
                manager.RenameProject(username, projectname, newprojectname);
                new MainPageController(this.username);
                this.out.getFr().dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Your Projectname and Confirmname do not match");
            }
            
        }
        else if (e.getSource().equals(main.getSaveButton2())){
            System.out.println(this.username + " clicked " + main.getSaveButton2().getClass());
            if (im.getPath().getAbsolutePath().equals("")){}
            else{
//                String imagePath = im.getPath().getAbsolutePath();
//                pjm.update_profile(this.username, (File)imagePath)
            }
        }
        else if(e.getSource().equals(main.getDeleteButton())){
            System.out.println(oldprojectname);
            System.out.println(projectname);
            
            dnotify.getFrame().setVisible(true);
            
            
        }
        else if(e.getSource().equals(dnotify.getDeleteButton())){
            if(dnotify.getTF().getText().equals(oldprojectname)){
                System.out.println(this.username + " clicked " + main.getSaveButton().getClass());
                System.out.println(projectname);
                manager.RemoveProject(this.username, projectname);
                pjm.delete_project(this.username, oldprojectname);
                JOptionPane.showMessageDialog(null, "Deleted"); 
                dnotify.getFrame().setVisible(false);
                new MainPageController(this.username);
                this.out.getFr().dispose();
            }
            else if(dnotify.getTF().getText().equals(projectname)){
                System.out.println(this.username + " clicked " + main.getSaveButton().getClass());
                System.out.println(projectname);
                manager.RemoveProject(this.username, projectname);
                pjm.delete_project(this.username, oldprojectname);
                JOptionPane.showMessageDialog(null, "Deleted");
                dnotify.getFrame().setVisible(false);
                new MainPageController(this.username);
                this.out.getFr().dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Your Confirm is wrong");
            }
            
            
            
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(main.getProfileicon())) {
            im = new ImportFile("jpg");
            String imagePath = im.getPath().getAbsolutePath();

            try {
                main.getProfileicon().LoadImage(imagePath);
                main.getProfileicon().repaint();
            } catch (Exception ex) {
                System.err.println("Error : " + ex.getMessage());
                ex.printStackTrace();
            }
        }
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
}
