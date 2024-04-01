
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
    private Cashier main;
    private SubCashier subcashier;
    private String username, projectname;
    private CheckoutController Checkout;
    
    public CashierController(String username, String projectname){
        manager = new DoUserData();
        pjm = new DoProjectData();
        this.username = username;
        this.projectname = projectname;
        main = new Cashier();
        Checkout = new CheckoutController(this.projectname, this);
        
        for (String t: pjm.getAll_Type(this.projectname)){
                main.getSort().addItem(t);
        }
        main.getSort().repaint();
        main.getSort().revalidate();
        
        main.getPanel().removeAll();
        this.showProduct(pjm.getAll_product(this.projectname));
        
        
        main.getCashierPanel().addMouseListener(this);
        main.getCheckout().addActionListener(this);
        main.getCasherIcon().addActionListener(this);
    }
    
    public Cashier getView(){
        return main;
    }
//    public static void main(String[] args) {
//        new CashierController("DDD", "AAA");
//    }

    public void showProduct(ArrayList<Product> productlist){
        for (Product p: productlist){
            SubCashier sub = new SubCashier(p, username, projectname);
            main.getPanel().add(sub);
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
        main.getPanel().repaint();
        main.getPanel().revalidate();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(main.getCasherIcon())){
            Checkout.getFr().setVisible(true);
        }
        else if (e.getSource().equals(main.getCheckout())){
            main.getPanel().removeAll();
            this.showProduct(pjm.getAll_product(this.projectname));
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(main.getCashierPanel())){
            main.getPanel().removeAll();
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
