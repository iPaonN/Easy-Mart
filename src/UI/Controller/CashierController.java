
package UI.Controller;

import My_sql.ProjectData.DoProjectData;
import My_sql.ProjectData.Product;
import My_sql.UserData.DoUserData;
import UI.View.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CashierController implements ActionListener, MouseListener{
    private DoUserData manager;
    private DoProjectData pjm;
    private Cashier cash;
    private MainMenuCashier main;
    private SubCashier subcashier;
    private String username, projectname;
    private CheckoutController Checkout;
    
    public CashierController(String username, String projectname){
        manager = new DoUserData();
        pjm = new DoProjectData();
        this.username = username;
        this.projectname = projectname;
        main = new MainMenuCashier();
        main.getUns1().setText(this.username);
        cash = new Cashier();
        main.getMainpanel().add(cash);
        Checkout = new CheckoutController(this.projectname, this);
        
        for (String t: pjm.getAll_Type(this.projectname)){
                cash.getSort().addItem(t);
        }
        cash.getSort().repaint();
        cash.getSort().revalidate();
        
        cash.getPanel().removeAll();
        this.showProduct(pjm.getAll_product(this.projectname));
        
        
        cash.getCashierPanel().addMouseListener(this);
        cash.getCheckout().addActionListener(this);
        cash.getCasherIcon().addActionListener(this);
    }
    
    public Cashier getView(){
        return cash;
    }
//    public static void cash(String[] args) {
//        new CashierController("DDD", "AAA");
//    }

    public void showProduct(ArrayList<Product> productlist){
        for (Product p: productlist){
            SubCashier sub = new SubCashier(p, username, projectname);
            cash.getPanel().add(sub);
            sub.getPlus().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddAmountController(projectname, p, Checkout);
            }
        });
        
        sub.getMinus().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
//                new AddAmountController(username, projectname, p, this, CheckoutController.this);
            }            
        });
    }
        cash.getPanel().repaint();
        cash.getPanel().revalidate();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(cash.getCasherIcon())){
            Checkout.getFr().setVisible(true);
        }
        else if (e.getSource().equals(cash.getCheckout())){
            cash.getPanel().removeAll();
            this.showProduct(pjm.getAll_product(this.projectname));
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(cash.getCashierPanel())){
            cash.getPanel().removeAll();
            this.showProduct(pjm.getAll_product(this.projectname));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
