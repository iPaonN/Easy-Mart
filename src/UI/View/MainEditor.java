package UI.View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MainEditor extends DefaultCellEditor implements ActionListener {
    private JButton optionBtn;

    public MainEditor(JCheckBox checkBox) {
        super(checkBox);
        optionBtn = new JButton("Option");
        optionBtn.addActionListener(this);
        optionBtn.setForeground(new Color(69, 104, 159));
        optionBtn.setFont(new Font("Arial", Font.BOLD, 16));
        optionBtn.setBackground(new Color(69, 104, 159));
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        return optionBtn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
