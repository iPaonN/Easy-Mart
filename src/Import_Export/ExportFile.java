package Import_Export;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

public class ExportFile {
    public JFileChooser fileChooser;
    public int check;
    
    
    public void Myexport(String File_Extension, File importfile){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(File_Extension.toUpperCase()+" Files", File_Extension);
            fileChooser.setFileFilter(filter);
            fileChooser.setDialogTitle("Save As");
            fileChooser.setSelectedFile(new File("UNITED."+File_Extension));
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            check = fileChooser.showSaveDialog(null);
            if (check == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                try (InputStream is = new FileInputStream(importfile); 
                        OutputStream os = new FileOutputStream(fileToSave)) {
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = is.read(buffer)) != -1) {
                        os.write(buffer, 0, length);
                    }
                }
            }   
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    //For Path Directory
    public void Myexport(String File_Extension, String path){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(File_Extension.toUpperCase()+" Files", File_Extension);
            fileChooser.setFileFilter(filter);
            fileChooser.setDialogTitle("Save As");
            fileChooser.setSelectedFile(new File("UNITED."+File_Extension));
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            check = fileChooser.showSaveDialog(null);
            if (check == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                try (FileInputStream importfile = new FileInputStream(path);
                        OutputStream os = new FileOutputStream(fileToSave)) {
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = importfile.read(buffer)) != -1) {
                        os.write(buffer, 0, length);
                    }
                }catch (IOException ex) {
                    ex.printStackTrace();
                }
            }   
        }catch(Exception e){
            e.printStackTrace();
        }
    }   



    
}