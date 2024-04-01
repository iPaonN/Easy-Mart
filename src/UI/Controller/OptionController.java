package UI.Controller;

import Import_Export.*;
import My_sql.ProjectData.*;
import My_sql.UserData.*;
import UI.View.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
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
    private String oldpath = "", imagePath = "", namewithproject = "";
    
    
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
        
        namewithproject = this.username+"_"+main.getTFprojectname().getText();
        main.getProfileicon().LoadImage(pjm.Get_Profile(namewithproject));
        main.getProfileicon().repaint();
        
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
            if(oldpath.equals(imagePath)){
                JOptionPane.showMessageDialog(null, "Please Choose Your Image Before Save");
            }
            else{
                File imageFile = new File(imagePath);
                if (imageFile.exists() && imageFile.isFile()) {
                    long filesizeByte = imageFile.length();
                    double filesizeKB = filesizeByte / 1024.0;
                    if(filesizeKB <= 64){
                        namewithproject = this.username+"_"+main.getTFprojectname().getText();
                        System.out.println(imagePath);
                        System.out.println(namewithproject);
                        JOptionPane.showMessageDialog(null, "Saved");
                        pjm.update_profile(namewithproject, new File(imagePath));
                        new MainPageController(this.username);
                        this.out.getFr().dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Your Image Size is Bigger Than 64KB");
                    }
                    
                }
            } 
        }
        else if(e.getSource().equals(main.getDeleteButton())){
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
                JOptionPane.showMessageDialog(null, "Your confirm is wrong");
            }
            
            
            
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(main.getProfileicon())) {
            JOptionPane.showMessageDialog(null, "Your Image Size Must Less Than 64KB");
            im = new ImportFile("jpg");
            if (im != null && im.getPath() != null) {
                imagePath = im.getPath().getAbsolutePath();
            }

            try {
                File imageFile = new File(imagePath);
                if (imageFile.exists() && imageFile.isFile()) {
                    long filesizeByte = imageFile.length();
                    double filesizeKB = filesizeByte / 1024.0;
                    if(filesizeKB <= 64){
                        main.getProfileicon().LoadImage(imagePath);
                        main.getProfileicon().repaint();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Your Image Size is Bigger Than 64KB");
                    }
                    
                }
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
