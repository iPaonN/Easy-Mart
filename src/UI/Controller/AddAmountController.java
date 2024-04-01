
package UI.Controller;

import My_sql.ProjectData.*;
import UI.Model.BuyProduct;
import UI.View.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JPanel;


public class AddAmountController implements ActionListener{
    private String projectname, username, action;
    private Product product;
    private AddAmount main;
    private SubCashier sub;
    private JPanel panel;
    private CheckoutController outCheck;
    private ArrayList<BuyProduct> buylist;
    
    public AddAmountController(JPanel panel, SubCashier sub, String username, String projectname, String action, ArrayList<BuyProduct> buylist){
        this.projectname = projectname;
        this.username = username;
        this.action = action;
        this.buylist = buylist;
        
        main = new AddAmount();
        main.getBtn().addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(main.getBtn())){
            if(action.equals("+")){
                
            }
            else if(action.equals("-")){
                
            }
        }
    }
}
