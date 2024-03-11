package UI;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.TableCellRenderer;

public class MainRenderer extends JButton implements TableCellRenderer{

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText("Option");
            this.setBorder(new LineBorder(new Color(69, 104, 159), 2));
            this.setForeground(new Color(69, 104, 159));
            this.setFont(new Font("Arial", Font.BOLD, 18));
            return this;
        }
}
