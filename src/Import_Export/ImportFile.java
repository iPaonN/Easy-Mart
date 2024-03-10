package Import_Export;

import javax.swing.*;
import java.io.*;

public class ImportFile {
    private JFileChooser fileChooser;
    private File file;
    
    public ImportFile(){
        fileChooser = new JFileChooser();
        int val = fileChooser.showOpenDialog(null);
        if (val == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
        }
    }
    
    public File getPath(){
        return file;
    }
}
