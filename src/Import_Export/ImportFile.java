package Import_Export;

import javax.swing.*;
import javax.swing.filechooser.*;
import java.io.*;

public class ImportFile {
    private JFileChooser fileChooser;
    private File file;
    
    public ImportFile(String File_Extension){
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(File_Extension.toUpperCase()+" File", File_Extension);
        fileChooser.setFileFilter(filter);
        int check = fileChooser.showOpenDialog(null);
        if (check == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
        }else {
            file = null;
        }
    }
    
    public File getPath(){
        return file;
    }
}
