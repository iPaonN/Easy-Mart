package Import_Export;

import javax.swing.*;
import java.awt.event.*;

public class SimpleGUI implements ActionListener {
    private JFrame frame;
    private JButton button1;
    private JButton button2;
    private ImportFile im;
    private ExportFIle export;

    public SimpleGUI() {
        // Create a frame
        frame = new JFrame("Simple GUI Example");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create button1
        button1 = new JButton("Import");
        // Add action listener to button1
        button1.addActionListener(this);

        // Create button2
        button2 = new JButton("Export");
        // Add action listener to button2
        button2.addActionListener(this);

        // Create a panel to hold the buttons
        JPanel panel = new JPanel();
        panel.add(button1);
        panel.add(button2);

        // Add the panel to the frame
        frame.getContentPane().add(panel);

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);
    }

    // ActionListener implementation
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            // Action for button1
            im = new ImportFile();
            JOptionPane.showMessageDialog(frame, "Check"+ im.getPath().getAbsolutePath());
            
        } else if (e.getSource() == button2) {
            
            if (im != null && im.getPath() != null) {
                // Check if a file has been imported
                export = new ExportFIle(); // Create ExportFile object
                export.Myexport(im.getPath()); // Export the imported file
                JOptionPane.showMessageDialog(frame, "File exported successfully.");
            }else {
                
                JOptionPane.showMessageDialog(frame, "Please import a file first.");
            }
}
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Create an instance of the SimpleGUI class
        SimpleGUI gui = new SimpleGUI();
        // Set the frame visible
        gui.frame.setVisible(true);
    }
}

