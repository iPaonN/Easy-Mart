package Import_Export;

import javax.swing.*;
import java.io.*;

public class ImportFile {
    private JFileChooser fileChooser;
    private File file;
    
    public ImportFile(){
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        fileChooser = new JFileChooser();
        int val = fileChooser.showOpenDialog(null);
        if (val == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
        }else {
            file = null;
        }
    }
    
    public File getPath(){
        return file;
    }
}
