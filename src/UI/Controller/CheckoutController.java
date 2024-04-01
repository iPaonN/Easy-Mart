
package UI.Controller;

import My_sql.ProjectData.*;
import UI.View.*;
import javax.swing.*;


public class CheckoutController {
    String username, projectname;
    private CashierController inCashier;
    private CheckoutPage main;
    
    
    public CheckoutController(String projectname, CashierController inCashier){
        this.projectname = projectname;
        this.inCashier = inCashier;
        this.main = main;
        
        main = new CheckoutPage();
        
    }
    
    public JFrame getFr(){
        return main.getMainf();
    }
    
    public void updateProductQuantity(String productName, int amountToAdd) {
        // Find the row index of the product in the table
        int rowIndex = main.findRowIndex(productName);

        // Update the quantity in the table
        if (rowIndex != -1) {
            int currentQuantity = (int) main.getValueAt(rowIndex, 1);
            int newQuantity = currentQuantity + amountToAdd;
            main.setValueAt(newQuantity, rowIndex, 1); // Update the quantity in the table
        }
    }
}
