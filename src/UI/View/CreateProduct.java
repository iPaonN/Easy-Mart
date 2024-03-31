package UI.View;
import UI.Model.StockProductModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class CreateProduct extends JPanel {
    private String username, projectname, schema;
    private JFrame mainf;
    private JPanel pnorth, psouth, pnorthleft, pnorthright, pnorthinleft, pID;
    private JPanel pempty1, pempty2, pempty3, pempty4, pempty5, pempty6, pempty7, pempty8, pempty9;
    private JPanel pempty10, pempty11, pempty12, pempty13, pempty14, pempty15, pempty16, pempty17, pempty18, pempty19;
    private JLabel jproduct, jtype, jprice, jweight, jamount, jID;
    private JButton jnew, jaddpic, jsave;
    private JComboBox jcbtype;
    private JTextField tfproduct, tfprice, tfweight, tfamount, tfID;
    private ImageIcon i1, i2;
    private StockProductModel model;
    public CreateProduct() {
        this.schema = this.username+"_"+this.projectname;
        model = new StockProductModel("zedl3all", "project1");
        //Create
        mainf = new JFrame("CreatProduct");
        i1 = new ImageIcon("src/UI/Image/eweweewew.jpg");
        i2 = new ImageIcon(i1.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        pnorth = new JPanel();
        psouth = new JPanel();
        pnorthleft = new JPanel();
        pnorthinleft = new JPanel();
        pnorthright = new JPanel();
        pempty1 = new JPanel();
        pempty2 = new JPanel();
        pempty3 = new JPanel();
        pempty4 = new JPanel();
        pempty5 = new JPanel();
        pempty6 = new JPanel();
        pempty7 = new JPanel();
        pempty8 = new JPanel();
        pempty9 = new JPanel();
        pempty10 = new JPanel();
        pempty11 = new JPanel();
        pempty12 = new JPanel();
        pempty13 = new JPanel();
        pempty14 = new JPanel();
        pempty15 = new JPanel();
        pempty16 = new JPanel();
        pempty17 = new JPanel();
        pempty18 = new JPanel();
        pempty19 = new JPanel();
        pID = new JPanel();
        jproduct = new JLabel("Product Name : ");
        jtype = new JLabel("Type : ");
        jprice = new JLabel("Price Per Piece : ");
        jweight = new JLabel("Weight : ");
        jamount = new JLabel("Amount : ");
        jnew = new JButton("+ new");
        jaddpic = new JButton("Add Picture");
        jsave = new JButton("    SAVE    ");
        jcbtype = new JComboBox();
        jcbtype.addItem(" Food ");
        jID = new JLabel("Product ID : ");
        tfproduct = new JTextField(12);
        tfproduct.setHorizontalAlignment(SwingConstants.CENTER);
        tfprice = new JTextField(12);
        tfprice.setHorizontalAlignment(SwingConstants.CENTER);
        tfweight = new JTextField(12);
        tfweight.setHorizontalAlignment(SwingConstants.CENTER);
        tfamount = new JTextField(15);
        tfamount.setHorizontalAlignment(SwingConstants.CENTER);
        tfID = new JTextField(12);
        tfID.setHorizontalAlignment(SwingConstants.CENTER);
        
        //PSetLayout
        pnorth.setLayout(new BorderLayout());
        pnorthleft.setLayout(new BorderLayout());
        pnorthinleft.setLayout(new BorderLayout());
        pnorthright.setLayout(new GridLayout(6, 0));
        this.setLayout(new BorderLayout());
        psouth.setLayout(new GridLayout(3, 0));
        pempty1.setLayout(new BorderLayout());
        pempty2.setLayout(new BorderLayout());
        pempty3.setLayout(new BorderLayout());
        pempty4.setLayout(new BorderLayout());
        pempty5.setLayout(new BorderLayout());
        pempty6.setLayout(new GridLayout(3, 0));
        pempty7.setLayout(new GridLayout(3, 0));
        pempty8.setLayout(new GridLayout(3, 0));
        pempty9.setLayout(new GridLayout(3, 0));
        pempty10.setLayout(new GridLayout(3, 0));
        pempty11.setLayout(new BorderLayout());
        pempty12.setLayout(new BorderLayout());
        pempty13.setLayout(new BorderLayout());
        pempty14.setLayout(new BorderLayout());
        pempty15.setLayout(new BorderLayout());
        pempty16.setLayout(new BorderLayout());
        pempty17.setLayout(new BorderLayout());
        pempty18.setLayout(new BorderLayout());
        pempty19.setLayout(new GridLayout(3,0));
        pID.setLayout(new BorderLayout());

        //Pproductname/ID
        pempty1.add(jproduct, BorderLayout.WEST);
        pempty1.add(pempty6);
        pempty6.add(new JLabel());
        pempty6.add(pempty11);
        pempty11.add(tfproduct, BorderLayout.WEST);
        pempty11.add(new JLabel("    "));
        pID.add(jID, BorderLayout.WEST);
        pID.add(pempty19);
        pempty18.add(tfID, BorderLayout.WEST);
        pempty19.add(new JLabel());
        pempty19.add(pempty18);

        //Ptype
        pempty2.add(jtype, BorderLayout.WEST);
        pempty2.add(pempty7);
        pempty7.add(new JLabel());
        pempty12.add(jcbtype, BorderLayout.WEST);
        pempty12.add(new JLabel("                                "), BorderLayout.EAST);
        pempty12.add(jnew);
        pempty7.add(pempty12);
        pempty7.add(new JLabel());

        //Pprice
        pempty3.add(jprice, BorderLayout.WEST);
        pempty3.add(pempty8);
        pempty8.add(new JLabel());
        pempty13.add(tfprice, BorderLayout.WEST);
        pempty13.add(new JLabel("     "));
        pempty8.add(pempty13);
        pempty8.add(new JLabel());

        //Pweight
        pempty4.add(jweight, BorderLayout.WEST);
        pempty4.add(pempty9);
        pempty9.add(new JLabel());
        pempty14.add(tfweight, BorderLayout.WEST);
        pempty14.add(new JLabel());
        pempty9.add(pempty14);
        pempty9.add(new JLabel());

        //Pamount
        pempty5.add(jamount, BorderLayout.WEST);
        pempty5.add(pempty10);
        pempty10.add(new JLabel());
        pempty15.add(tfamount, BorderLayout.WEST);
        pempty15.add(new JLabel());
        pempty10.add(pempty15);
        pempty10.add(new JLabel());
        pnorthright.add(pempty1);
        pnorthright.add(pID);
        pnorthright.add(pempty2);
        pnorthright.add(pempty3);
        pnorthright.add(pempty4);
        pnorthright.add(pempty5);

        //Pnorth
        pnorth.add(pnorthleft, BorderLayout.CENTER);
        pnorth.add(pnorthright, BorderLayout.EAST);

        //PSouth
        psouth.add(pempty16);
        pempty16.add(jaddpic);
        pempty16.add(new JLabel("                     "), BorderLayout.WEST);
        pempty16.add(new JLabel("                                                                                                                        "), BorderLayout.EAST);
        psouth.add(new JLabel());
        psouth.add(pempty17);
        pempty17.add(jsave, BorderLayout.EAST);

        //SetFont
        jproduct.setFont(new Font("Arial", Font.BOLD, 16));
        jproduct.setForeground(Color.WHITE);
        jtype.setFont(new Font("Arial", Font.BOLD, 16));
        jtype.setForeground(Color.WHITE);
        jprice.setFont(new Font("Arial", Font.BOLD, 16));
        jprice.setForeground(Color.WHITE);
        jweight.setFont(new Font("Arial", Font.BOLD, 16));
        jweight.setForeground(Color.WHITE);
        jamount.setFont(new Font("Arial", Font.BOLD, 16));
        jamount.setForeground(Color.WHITE);
        jnew.setFont(new Font("Arial", Font.BOLD, 14));
        jnew.setForeground(new Color(69, 104, 159));

        jaddpic.setFont(new Font("Arial", Font.BOLD, 16));
        jaddpic.setForeground(new Color(69, 104, 159));
        jaddpic.setBackground(Color.WHITE);
        jsave.setFont(new Font("Arial", Font.BOLD, 18));
        jsave.setForeground(new Color(69, 104, 159));
        jsave.setBackground(Color.WHITE);
        jsave.setBorder(new LineBorder(new Color(69, 104, 159), 4));
        jcbtype.setFont(new Font("Arial", Font.BOLD, 14));
        jcbtype.setForeground(new Color(69, 104, 159));
        jID.setFont(new Font("Arial", Font.BOLD, 16));
        jID.setForeground(Color.WHITE);
        
        //JTextFiel
        tfproduct.setFont(new Font("Arial", Font.BOLD, 13));
        tfproduct.setForeground(Color.WHITE);
        tfproduct.setBackground(new Color(69, 104, 159));
        tfproduct.setBorder(new LineBorder(Color.WHITE, 2));
        tfprice.setFont(new Font("Arial", Font.BOLD, 13));
        tfprice.setForeground(Color.WHITE);
        tfprice.setBackground(new Color(69, 104, 159));
        tfprice.setBorder(new LineBorder(Color.WHITE, 2));
        tfweight.setFont(new Font("Arial", Font.BOLD, 13));
        tfweight.setForeground(Color.WHITE);
        tfweight.setBackground(new Color(69, 104, 159));
        tfweight.setBorder(new LineBorder(Color.WHITE, 2));
        tfamount.setFont(new Font("Arial", Font.BOLD, 13));
        tfamount.setForeground(Color.WHITE);
        tfamount.setBorder(new LineBorder(Color.WHITE, 2));
        tfamount.setBackground(new Color(69, 104, 159));
        tfID.setBorder(new LineBorder(Color.WHITE, 2));
        tfID.setBackground(new Color(69, 104, 159));
        tfID.setFont(new Font("Arial", Font.BOLD, 13));
        tfID.setForeground(Color.WHITE);
        
        //SetBackground
        pnorth.setBackground(new Color(69, 104, 159));
        psouth.setBackground(new Color(69, 104, 159));
        this.setBackground(new Color(69, 104, 159));
        pnorthleft.setBackground(new Color(69, 104, 159));
        pnorthinleft.setBackground(Color.WHITE);
        pnorthinleft.setBorder(new LineBorder(new Color(101, 113, 132), 5));
        pnorthleft.add(pnorthinleft);
        pnorthleft.setBorder(new LineBorder(new Color(69, 104, 159), 15));
        pnorthright.setBackground(new Color(69, 104, 159));
        pempty1.setBackground(new Color(69, 104, 159));
        pempty2.setBackground(new Color(69, 104, 159));
        pempty3.setBackground(new Color(69, 104, 159));
        pempty4.setBackground(new Color(69, 104, 159));
        pempty5.setBackground(new Color(69, 104, 159));
        pempty6.setBackground(new Color(69, 104, 159));
        pempty7.setBackground(new Color(69, 104, 159));
        pempty8.setBackground(new Color(69, 104, 159));
        pempty9.setBackground(new Color(69, 104, 159));
        pempty10.setBackground(new Color(69, 104, 159));
        pempty11.setBackground(new Color(69, 104, 159));
        pempty12.setBackground(new Color(69, 104, 159));
        pempty13.setBackground(new Color(69, 104, 159));
        pempty14.setBackground(new Color(69, 104, 159));
        pempty15.setBackground(new Color(69, 104, 159));
        pempty16.setBackground(new Color(69, 104, 159));
        pempty17.setBackground(new Color(69, 104, 159));
        this.setBorder(new LineBorder(new Color(101, 113, 132), 5));
        pID.setBackground(new Color(69, 104, 159));
        pempty18.setBackground(new Color(69, 104, 159));
        pempty19.setBackground(new Color(69, 104, 159));
        
        jsave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = tfproduct.getText();
                String type = String.valueOf(jcbtype.getSelectedItem());
                Double price = Double.parseDouble(tfprice.getText());
                Double weight = Double.parseDouble(tfweight.getText());
                int amount = Integer.parseInt(tfamount.getText());
                model.SetProductdata( name, 1, price, weight, amount);
                JOptionPane.showMessageDialog(mainf, "Done!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        //JFrmae
        this.add(pnorth, BorderLayout.CENTER);
        this.add(psouth, BorderLayout.SOUTH);
        mainf.add(this);
        mainf.setIconImage(i2.getImage());
        mainf.setSize(600, 450);
        mainf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainf.setLocationRelativeTo(null);
        mainf.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            new CreateProduct();
        });
    }
    
    public void setTfproductText(String text) {
        tfproduct.setText(text);
    }

    public String getTfproductText() {
        return tfproduct.getText();
    }

    public void setTfpriceText(String text) {
        tfprice.setText(text);
    }

    public String getTfpriceText() {
        return tfprice.getText();
    }

    public void setTfweightText(String text) {
        tfweight.setText(text);
    }

    public String getTfweightText() {
        return tfweight.getText();
    }

    public void setTfamountText(String text) {
        tfamount.setText(text);
    }

    public String getTfamountText() {
        return tfamount.getText();
    }
    
    public JButton getSave(){
        return jsave;
    }
    
    public JComboBox getType(){
        return jcbtype;
    }
    
}