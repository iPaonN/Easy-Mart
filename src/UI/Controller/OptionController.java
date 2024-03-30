
package UI.Controller;

import Import_Export.*;
import My_sql.ProjectData.*;
import My_sql.UserData.*;
import UI.View.*;
import java.awt.*;
import java.awt.event.*;
//import java.io.*;
import javax.swing.*;
//WIP
public class OptionController implements ActionListener, MouseListener {
    private DoUserData manager;
    private DoProjectData pjm;
    private Option main;
    private String username, projectname;
    private ImportFile im;
    
    public OptionController(String username, String projectname){
        manager = new DoUserData();
        pjm = new DoProjectData();
        main = new Option();
        this.username = username;
        this.projectname = projectname;
        main.getSaveButton().addActionListener(this);
        main.getProfileicon().addMouseListener(this);
        main.getSaveButton2().addActionListener(this);
    }
    
    public Option getView(){
        return main;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(main.getSaveButton())){
            System.out.println(this.username + " clicked " + main.getSaveButton().getClass());
            
            if (e.getSource().equals(main.getTFprojectname().getText().equals(""))){}
            
        }
        else if (e.getSource().equals(main.getSaveButton2())){
            System.out.println(this.username + " clicked " + main.getSaveButton2().getClass());
            if (im.getPath().getAbsolutePath().equals("")){}
            else{
//                String imagePath = im.getPath().getAbsolutePath();
//                pjm.update_profile(this.username, (File)imagePath)
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
