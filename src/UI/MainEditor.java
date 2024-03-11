package UI;
import java.awt.event.*;
import javax.swing.*;

public class MainEditor extends DefaultCellEditor {

    private JButton optionBtn;

    public MainEditor(JCheckBox checkBox) {
        super(checkBox);
        checkBox.setVisible(false);
        optionBtn = new JButton("Option");
        optionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }
}
