
package UI.Controller;

import My_sql.ProjectData.DoProjectData;
import UI.View.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ExportController implements ActionListener {
    private ExportDocument main;
    private String username, projectname;
    private DoProjectData pjm;
    
    public ExportController(String username, String projectname){
        this.username = username;
        this.projectname = projectname;
        pjm = new DoProjectData();
        
        main = new ExportDocument();
        main.getBsave().addActionListener(this);
        main.getBbrowse().addActionListener(this);
    }
    
    private String chooseFilePath() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose Excel file location");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Excel Files", "xlsx"));

        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String fileName = fileToSave.getAbsolutePath();

            if (!fileName.toLowerCase().endsWith(".xlsx")) {
                fileName += ".xlsx";
            }

            return fileName;
        }
        return null;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(main.getBbrowse())){
            JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose csv file location");
        fileChooser.setFileFilter(new FileNameExtensionFilter("csv Files", "csv"));

        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String fileName = fileToSave.getAbsolutePath();

            if (!fileName.toLowerCase().endsWith(".csv")) {
                fileName += ".csv";
            }
            pjm.export_excel(this.username, this.projectname, fileName);
            main.getTF().setText(fileName);
            }
        }
        else if (e.getSource().equals(main.getBsave())){
            main.getMainf().setVisible(false);
        }
    }
}
