package View;
import java.awt.event.*;
import javax.swing.*;

public class HistoryEditor extends DefaultCellEditor{
        private JButton viewBtn;

        public HistoryEditor(JCheckBox checkBox) {
            super(checkBox);
            checkBox.setVisible(false);
            viewBtn = new JButton("View");
            viewBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                }
            });
        }
}
