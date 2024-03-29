import My_sql.My_sql;
import UI.Model.ProductModel;
import UI.View.ViewProduct;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.*;


public class ViewProductController implements ActionListener {
    Statement stmt = null;
    Connection conn = null;
    private ViewProduct view; 
    private ProductModel product;
    
    
    public ViewProductController() {
        view = new ViewProduct();
        product = new ProductModel();
        /// สร้าง ข้อมูล ใน SQL ใส่ comment ถ้าไม่สร้าง ใช้เพื่อเทส
        product.SetProducttype(1, "Book");
        product.SetProductdata(1, "ABC", 1, 199, 2, 1);
        displayProductData(1);
        displayImage(1);
        // Set product information to the view
//        view.setProductName(product.getProductName());
//        view.setType(product.getType());
//        view.setPricePerPiece(String.valueOf(product.getPricePerPiece()));
//        view.setWeight(String.valueOf(product.getWeight()));
//        view.setAmount(String.valueOf(product.getAmount()));
        view.settfamount(String.valueOf(product.getAmount()));
        // Add action listeners to view buttons (replace with your logic)
        view.getSaveButton().addActionListener(this);
        view.getOKButton().addActionListener(this);
        view.getSetButton().addActionListener(this);
        view.getPlusButton().addActionListener(this);
        view.getMinusButton().addActionListener(this);
        view.getDeleteButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            
            if (e.getSource() == view.getSaveButton()) {
                view.setPricePerPiece(view.gettfprice().getText());
            } else if (e.getSource() == view.getOKButton()) {
                product.UpdateProduct(1
                                    , Integer.parseInt(view.gettfprice().getText())
                                    , Integer.parseInt(view.gettfamount().getText()));
                displayProductData(1);
                JOptionPane.showMessageDialog(null, "Done!");
            } else if (e.getSource() == view.getSetButton()) {
                view.setAmount(view.gettfamount().getText());
            } else if (e.getSource() == view.getPlusButton()) {
                view.gettfamount().setText(String.valueOf(Integer.parseInt(view.gettfamount().getText()) + 1));
            } else if (e.getSource() == view.getMinusButton()) {
                view.gettfamount().setText(String.valueOf(Integer.parseInt(view.gettfamount().getText()) - 1));
            } else if (e.getSource() == view.getDeleteButton()) {
                product.DeleteProduct(1);
                view.setProductName("");
                view.setType("");
                view.setPricePerPiece(String.valueOf(""));
                view.setWeight(String.valueOf(""));
                view.setAmount(String.valueOf(""));
                view.settfamount(String.valueOf(""));
                JOptionPane.showMessageDialog(null, "Done!");
                view.close();
            } else if (e.getSource() == view.getSaveimage()) {
                
            } else if (e.getSource() == view.getImageLabel()) {
                JFileChooser fc = new JFileChooser();
                int result = fc.showOpenDialog(view.getmf()); // Use the main frame reference from the view
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fc.getSelectedFile();
                    // Do something with the selected file
                    // For example, display the selected file path in a text field
                    
                }
            }
    } catch (Exception ex){
        ex.printStackTrace();
    } finally {
            
        }
    }
    
    public ResultSet getProductByID(int id) {
        My_sql sql = new My_sql();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            sql.set_Schema("zedl3all_Project1");
            sql.connect();
            conn = sql.get_Connection();
            String query = "SELECT * FROM product WHERE product_id = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }
    
    public void displayProductData(int id) {
    ResultSet rs = getProductByID(id);
        try {
            if (rs.next()) {
                String productName = rs.getString("product_name");
                String type = rs.getString("type_id");
                double price = rs.getDouble("price");
                double weight = rs.getDouble("weight");
                int quantity = rs.getInt("quantity");
                
                view.setProductName(productName);
                view.setType(type);
                view.setPricePerPiece(String.valueOf(price));
                view.setWeight(String.valueOf(weight));
                view.setAmount(String.valueOf(quantity));
            } else {
                JOptionPane.showMessageDialog(null, "Error not Found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet getImageByID(int id) {
        My_sql sql = new My_sql();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            sql.set_Schema("zedl3all_Project1");
            sql.connect();
            conn = sql.get_Connection();
            String query = "SELECT * FROM project_icon WHERE Icon = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }
    
    public void displayImage(int id) {
        ResultSet rs = getImageByID(id);
        try {
            if (rs.next()) {
                Blob blob = rs.getBlob("Icon"); 
                if (blob != null) {
                    InputStream inputStream = blob.getBinaryStream();
                    BufferedImage image = ImageIO.read(inputStream); 
                    if (image != null) {
                        ImageIcon icon = new ImageIcon(image);
                        view.setImage(icon);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error displaying image!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null,"Error: Image not found!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error: Image not found!");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    } 
    
    public void saveImage(int id) {
    ResultSet rs = getImageByID(id);
        try {
            if (rs.next()) {
                
            } else {
                JOptionPane.showMessageDialog(null, "Error not Found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new ViewProductController();
    }
}
