package Import_Export;

import javax.swing.*;
import java.io.*;

public class ImportFile {
    public JFileChooser fileChooser;
    public int val;
    public File choose;
    public File path;
    
    public ImportFile(){
        fileChooser = new JFileChooser();
        val = fileChooser.showOpenDialog(null);
    }
    
    public void Myimport(){
        if (val == JFileChooser.APPROVE_OPTION) {
            choose = fileChooser.getSelectedFile();
            path = choose;
        }
    }
    
    public File getPath(){
        return path;
    }
}
