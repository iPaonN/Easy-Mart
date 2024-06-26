package My_sql.ProjectData;

import java.sql.*;

public class Product {
    private int id;
    private String name;
    private String type;
    private double price;
    private double weight;
    private int quantity;
    private Blob image;
    
    public Product(){
    }

    public Product(int id, String name, String type, double price, double weight, int quantity, Blob image) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.weight = weight;
        this.quantity = quantity;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String product_name) {
        this.name = product_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }
    
    
}
