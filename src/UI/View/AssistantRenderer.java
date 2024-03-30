package UI.View;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class AssistantRenderer extends JButton implements TableCellRenderer{
    public AssistantRenderer() {
        super();
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        this.setText("View");
        this.setForeground(new Color(69, 104, 159));
        this.setFont(new Font("Arial", Font.BOLD, 16));
        this.setBackground(Color.white);
        this.setBorder(new LineBorder(new Color(69, 104, 159), 0));
        return this;
    }
}
