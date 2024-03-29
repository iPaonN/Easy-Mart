
package UI.View;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class ViewEditor extends DefaultCellEditor{
    
    public ViewEditor(JCheckBox checkBox) {
        super(checkBox);
        checkBox.setHorizontalAlignment(SwingConstants.CENTER);
    }
}

