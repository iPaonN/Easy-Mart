
package UI.Model;

public class BuyProduct {
    private String productname;
    private int amount;
    private double sumprice;

    public BuyProduct(String productname, int amount, double sumprice) {
        this.productname = productname;
        this.amount = amount;
        this.sumprice = sumprice;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getSumprice() {
        return sumprice;
    }

    public void setSumprice(double sumprice) {
        this.sumprice = sumprice;
    }
    
}
