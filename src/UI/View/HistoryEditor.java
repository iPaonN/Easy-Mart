package UI.View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HistoryEditor extends DefaultCellEditor implements ActionListener{
    private JButton viewBtn;
    
    public HistoryEditor(JCheckBox checkBox) {
        super(checkBox);
        viewBtn = new JButton("View");
        viewBtn.addActionListener(this);
        viewBtn.setForeground(new Color(69, 104, 159));
        viewBtn.setFont(new Font("Arial", Font.BOLD, 16));
        viewBtn.setBackground(new Color(69, 104, 159));
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        return viewBtn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new ViewHistory();
    }
}
