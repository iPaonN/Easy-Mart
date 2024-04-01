
package UI.Controller;

import My_sql.ProjectData.*;
import UI.View.*;
import java.awt.event.*;


public class AddAmountController implements ActionListener{
    private String projectname;
    private Product product;
    private AddAmount main;
    private CheckoutController outCheck;
    
    public AddAmountController(String projectname, Product product, CheckoutController outCheck){
        this.projectname = projectname;
        this.product = product;
        
        main = new AddAmount();
        main.getBtn().addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(main.getBtn())){
            int add = Integer.parseInt(main.getAmountTF().getText());
            outCheck.updateProductQuantity(product.getName(), add);
            main.getFr().dispose();
        }
    }
}
