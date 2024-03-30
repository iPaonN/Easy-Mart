package UI.View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.DefaultCellEditor;
import javax.swing.*;

public class AssistantEditor extends DefaultCellEditor implements ActionListener{
    private JButton viewBtn;
    
    public AssistantEditor(JCheckBox checkBox) {
        super(checkBox);
        viewBtn = new JButton("View");
        viewBtn.addActionListener(this);
        viewBtn.setForeground(new Color(69, 104, 159));
        viewBtn.setFont(new Font("Arial", Font.BOLD, 16));
        viewBtn.setBackground(Color.white);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        return viewBtn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Hello Welcome", "Message", JOptionPane.INFORMATION_MESSAGE);
    }
}
