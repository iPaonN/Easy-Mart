
package UI.Controller;

import My_sql.ProjectData.*;
import UI.Model.BuyProduct;
import UI.View.*;
import java.util.ArrayList;
import javax.swing.*;


public class CheckoutController {
    String username, projectname;
    private ArrayList<BuyProduct> buylist;
    private CheckoutPage main;
    
    
    public CheckoutController(String projectname, ArrayList<BuyProduct> buylist){
        this.projectname = projectname;
        this.buylist = buylist;
        
        main = new CheckoutPage();
        main.showBuy(buylist);
    }

    public CheckoutPage getMain() {
        return main;
    }

    public void setMain(CheckoutPage main) {
        this.main = main;
    }
    
    public JFrame getFr(){
        return main.getMainf();
    }
    
//    public void updateProductQuantity(String productName, int amountToAdd) {
//        // Find the row index of the product in the table
//        int rowIndex = main.findRowIndex(productName);
//
//        // Update the quantity in the table
//        if (rowIndex != -1) {
//            int currentQuantity = (int) main.getValueAt(rowIndex, 1);
//            int newQuantity = currentQuantity + amountToAdd;
//            main.setValueAt(newQuantity, rowIndex, 1); // Update the quantity in the table
//        }
//    }
}
