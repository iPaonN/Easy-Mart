package UI.View;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class HistoryRenderer extends JButton implements TableCellRenderer{
    public HistoryRenderer() {
        super();
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        this.setText("View");
        this.setForeground(new Color(69, 104, 159));
        this.setFont(new Font("Arial", Font.BOLD, 16));
        this.setBackground(new Color(69, 104, 159));
        return this;
    }
}
