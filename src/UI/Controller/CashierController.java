
package UI.Controller;

import My_sql.ProjectData.DoProjectData;
import My_sql.ProjectData.Product;
import My_sql.UserData.DoUserData;
import UI.Model.BuyProduct;
import UI.View.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CashierController implements ActionListener, MouseListener, DocumentListener, ItemListener{
    private DoUserData manager;
    private DoProjectData pjm;
    private Cashier cash;
    private MainMenuCashier main;
    private ArrayList<BuyProduct> basket;
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
        basket = new ArrayList<BuyProduct>();
        Checkout = new CheckoutController(this.projectname, this.basket);
        cash.getSort().addItem("All");
        for (String t: pjm.getAll_Type(this.projectname)){
                cash.getSort().addItem(t);
        }
        cash.getSort().repaint();
        cash.getSort().revalidate();
        
        cash.getPanel().removeAll();
        this.showProduct(pjm.getAll_product(this.projectname));
        
        main.getEasyMartLabel().addMouseListener(this);
        main.getCp1().LoadImage(pjm.Get_Profile(this.projectname));
        main.getUns1().setText(this.projectname);
        cash.getCashierPanel().addMouseListener(this);
        cash.getCheckout().addActionListener(this);
        cash.getCasherIcon().addActionListener(this);
        cash.getSearch().getDocument().addDocumentListener(this);
        cash.getSort().addItemListener(this);
    }
    
    public Cashier getView(){
        return cash;
    }
//    public static void cash(String[] args) {
//        new CashierController("DDD", "AAA");
//    }

    public void showProduct(ArrayList<Product> productlist){
        cash.getPanel().removeAll();
        for (Product p: productlist){
            SubCashier sub = new SubCashier(p, username, projectname);
            cash.getPanel().add(sub);
            sub.getPlus().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddAmountController(cash.getPanel(), sub, username, projectname, "+", basket);
            }
        });
        
        sub.getMinus().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddAmountController(cash.getPanel(), sub, username, projectname, "-", basket);
            }            
        });
    }
        cash.getPanel().repaint();
        cash.getPanel().revalidate();
    }
    public ArrayList<String> filterType(String type){
        ArrayList<Product> productlist = pjm.getAll_product(this.projectname);
        ArrayList<String> result = new ArrayList<String>();
        for (Product p: productlist){
            if (type.equals("All")){
                result.add(p.getName());
            }
            else if(p.getType().equals(type) == true){
                result.add(p.getName());
            }
        }
        return result;
    }
    public ArrayList<Product> filterName(String productname, String type){
        ArrayList<String> listtype = this.filterType(type);
        ArrayList<Product> result = new ArrayList<Product>();
        if(productname.equals("")){
            for (String lt: listtype){
                result.add(pjm.get_product(this.projectname, lt));
            }
        }
        else{
            for (String lt: listtype){
                if (lt.contains(productname) == true){
                   result.add(pjm.get_product(this.projectname, lt)); 
                }
            }
        }
        return result;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(cash.getCasherIcon())){
            Checkout.getMain().showBuy(basket);
            Checkout.getTotalamountLabel().setText(String.valueOf(Checkout.getTotalAmount()));
            Checkout.getTotalpriceLabel().setText(String.valueOf(Checkout.getTotalPrice()));
            Checkout.getFr().setVisible(true);
        }
        else if (e.getSource().equals(cash.getCheckout())){
            basket = new ArrayList<BuyProduct>();
            Checkout = new CheckoutController(this.projectname, this.basket);
            Checkout.getTotalamountLabel().setText(String.valueOf(0));
            Checkout.getTotalpriceLabel().setText(String.valueOf(0.0));
            Checkout.getTotalamountLabel().repaint();
            Checkout.getTotalamountLabel().revalidate();
            Checkout.getTotalpriceLabel().repaint();
            Checkout.getTotalpriceLabel().repaint();
            Checkout.getFr().repaint();
            Checkout.getFr().revalidate();
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(cash.getCashierPanel())){
            cash.getPanel().removeAll();
            this.showProduct(pjm.getAll_product(this.projectname));
            Checkout.getFr().repaint();
            Checkout.getFr().revalidate();
//            Checkout.setTotalAmount(Checkout.getTotalAmount());
//            Checkout.getTotalPrice()(Checkout.getTotalPrice());
            
        }
        else if (e.getSource().equals(main.getEasyMartLabel())){
            new MainPageController(this.username);
            main.getFr().dispose();
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

    @Override
    public void insertUpdate(DocumentEvent e) {
        cash.getCashierPanel().removeAll();
        this.showProduct(this.filterName(cash.getSearch().getText(), (String)cash.getSort().getSelectedItem()));
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        cash.getCashierPanel().removeAll();
        this.showProduct(this.filterName(cash.getSearch().getText(), (String)cash.getSort().getSelectedItem()));
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        cash.getCashierPanel().removeAll();
        this.showProduct(this.filterName(cash.getSearch().getText(), (String)cash.getSort().getSelectedItem()));
    }
}
