
package UI.View;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class ViewRenderer implements TableCellRenderer{
    public ViewRenderer() {
        super();
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        if ((column == 4) || (column == 5)) {
            JCheckBox checkBox = new JCheckBox();
            checkBox.setSelected((Boolean) value);
            checkBox.setHorizontalAlignment(SwingConstants.CENTER);
            checkBox.setBackground(Color.white);
            return checkBox;
        } else {
            DefaultTableCellRenderer TextRender = new DefaultTableCellRenderer();
            TextRender.setHorizontalAlignment(SwingConstants.CENTER);
            return TextRender.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }
}

