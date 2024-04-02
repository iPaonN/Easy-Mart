
package UI.Controller;

import My_sql.ProjectData.*;
import UI.Model.BuyProduct;
import UI.View.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class AddAmountController implements ActionListener{
    private String projectname, username, action;
    private Product product;
    private AddAmount main;
    private SubCashier sub;
    private JPanel panel;
    private DoProjectData manager;
    private CheckoutController outCheck;
    private ArrayList<BuyProduct> buylist;
    
    public AddAmountController(JPanel panel, SubCashier sub, String username, String projectname, String action, ArrayList<BuyProduct> buylist){
        this.projectname = projectname;
        this.username = username;
        this.action = action;
        this.buylist = buylist;
        this.manager = new DoProjectData();
        this.sub = sub;
        this.panel = panel;
        main = new AddAmount();
        main.getBtn().addActionListener(this);
        
    }
    public boolean isInt(String str) { 
    try {  
        Integer.parseInt(str);  
        return true;
        }catch(NumberFormatException e){  
            return false;  
        }  
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(main.getBtn())){
            if(action.equals("+")){
                Product p = sub.getProduct();
                int have = p.getQuantity();
                if(this.isInt(main.getAmountTF().getText()) == false){
                    JOptionPane.showMessageDialog(null, "Please input integer");
                    main.getText().setText("");
                }
                else if(have < Integer.parseInt(main.getAmountTF().getText())){
                    JOptionPane.showMessageDialog(null, "Not enough , have only: "+have);
                    main.getText().setText("");
                }
                else{
                    manager.decrease_product(this.projectname, username, p.getName(), Integer.parseInt(main.getAmountTF().getText()));
                    if(this.isInBas(p.getName()) == false){
                        buylist.add(new BuyProduct(p.getName(), Integer.parseInt(main.getAmountTF().getText()), Double.parseDouble(main.getAmountTF().getText())*p.getPrice()));
                        sub.setJnumamount(have-Integer.parseInt(main.getAmountTF().getText()));
                    }
                    else{
                        buylist.set(this.getNamelist(p.getName()).indexOf(p.getName()), new BuyProduct(p.getName(), have-Integer.parseInt(main.getAmountTF().getText()), (have-Integer.parseInt(main.getAmountTF().getText()))*p.getPrice()));
                        sub.setJnumamount(manager.get_product(this.projectname, p.getName()).getQuantity());
                    }
                    
                    main.getFr().dispose();
                    sub.repaint();
                    sub.revalidate();
                    panel.repaint();
                    panel.revalidate();
                }
            }
            else if(action.equals("-")){
                Product p = sub.getProduct();
                if(this.isInBas(p.getName()) == false){
                    JOptionPane.showMessageDialog(null, "Don't have is basket");
                    main.getFr().dispose();
                }
                else if(this.isInt(main.getAmountTF().getText()) == false){
                    JOptionPane.showMessageDialog(null, "Please input integer");
                    main.getText().setText("");
                }
                else if(this.getB(p.getName()).getAmount() < Integer.parseInt(main.getAmountTF().getText())){
                    JOptionPane.showMessageDialog(null, "Not enough , have only: "+this.getB(p.getName()).getAmount());
                    main.getText().setText("");
                }
                else{
                    manager.Increase_product(this.projectname, username, p.getName(), Integer.parseInt(main.getAmountTF().getText()));
                    buylist.set(this.getNamelist(p.getName()).indexOf(p.getName()), new BuyProduct(p.getName(), this.getB(p.getName()).getAmount()-Integer.parseInt(main.getAmountTF().getText()), (this.getB(p.getName()).getAmount()-Integer.parseInt(main.getAmountTF().getText()))*p.getPrice()));
                    sub.setJnumamount(manager.get_product(this.projectname, p.getName()).getQuantity());
                    
                    
                    main.getFr().dispose();
                    sub.repaint();
                    sub.revalidate();
                    panel.repaint();
                    panel.revalidate();
                }    
            }
        }
        
    }
    public BuyProduct getB(String productname){
        for (BuyProduct b: buylist){
            if(b.getProductname().equals(productname)){
                return b;
            }
        }
        return null;
    }
    public boolean isInBas(String productname){
        ArrayList<String> plist = new ArrayList<String>();
        for (BuyProduct b: buylist){
            plist.add(b.getProductname());
        }
        if(plist.contains(productname)){
            return true;
        }
        return false;
    }
    public ArrayList<String> getNamelist(String productname){
        ArrayList<String> plist = new ArrayList<String>();
        for (BuyProduct b: buylist){
            plist.add(b.getProductname());
        }
        return plist;
    }
}
