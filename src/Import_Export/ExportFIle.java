package Import_Export;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

public class ExportFIle {
    public JFileChooser fileChooser;
    public int val;
    public File choose;
    
    
    public void Myexport(File importfile){
        try {
            fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save As");
            fileChooser.setSelectedFile(new File(""));
            val = fileChooser.showSaveDialog(null);
            if (val == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                try (InputStream is = new FileInputStream(importfile); OutputStream os = new FileOutputStream(fileToSave)) {
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = is.read(buffer)) > 0) {
                        os.write(buffer, 0, length);
                    }
                }
                
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void Myexport(FileInputStream importfile){
        try {
            fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("XLSX Files", "xlsx");
            fileChooser.setFileFilter(filter);
            fileChooser.setDialogTitle("Save As");
            fileChooser.setSelectedFile(new File("UNITED.xlsx"));
            val = fileChooser.showSaveDialog(null);
            if (val == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                try (OutputStream os = new FileOutputStream(fileToSave)) {
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = importfile.read(buffer)) != -1) {
                        os.write(buffer, 0, length);
                    }
                }
                
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
