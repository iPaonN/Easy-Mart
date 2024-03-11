package UI;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class ViewProduct extends JPanel {
    
    private JFrame mainf;
    private JPanel pnorth, psouth, pmain, pnorthleft, pnorthright, pinsouthlower, pinnorthleft, pinnorthcenter, pincenter;
    private JPanel pempty1, pempty2, pempty3, pempty4, pempty5, pempty6, pempty7, pempty8, pempty9, pempty10, pempty11, pempty12, pempty13;
    private JLabel pproduct, pproductname, ptype, ptypename, ppriceper, pnumpriceper, pweight, pnumweight, pamount, pnumamount, peditamount, peditprice;
    private JButton bsave, bok, bsavev2, bset, bplus, bminus, bdelete;
    private JTextField tfprice, tfamount;
    private ImageIcon i1, i2;
    
    public ViewProduct() {

        //Create
        i1 = new ImageIcon("src/UI/Image/eweweewew.jpg");
        i2 = new ImageIcon(i1.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        mainf = new JFrame("ViewProduct");
        pnorth = new JPanel();
        psouth = new JPanel();
        pmain = new JPanel();
        pnorthleft = new JPanel();
        pinnorthleft = new JPanel();
        pnorthright = new JPanel();
        pinsouthlower = new JPanel();
        pinnorthcenter = new JPanel();
        pincenter = new JPanel();
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
        pproduct = new JLabel("Product Name : ");
        pproductname = new JLabel("..............");
        ptype = new JLabel("Type : ");
        ptypename = new JLabel("..............");
        ppriceper = new JLabel("Price Per Piece : ");
        pnumpriceper = new JLabel("..............");
        pweight = new JLabel("Weight : ");
        pnumweight = new JLabel("..............");
        pamount = new JLabel("Amount : ");
        pnumamount = new JLabel("..............");
        peditamount = new JLabel("EDIT AMOUNT    ");
        peditprice = new JLabel("EDIT PRICE         ");
        bsave = new JButton("SAVE");
        bok = new JButton("      OK      ");
        bsavev2 = new JButton("SAVE");
        bset = new JButton("SET");
        bplus = new JButton("+");
        bminus = new JButton("-");
        tfprice = new JTextField(10);
        tfamount = new JTextField();
        bdelete = new JButton("   Delete   ");

        //SetLayer
        pnorth.setLayout(new BorderLayout());
        pmain.setLayout(new BorderLayout());
        pnorthleft.setLayout(new BorderLayout());
        pinnorthleft.setLayout(new BorderLayout());
        pinnorthcenter.setLayout(new BorderLayout());
        pincenter.setLayout(new BorderLayout());
        pnorthright.setLayout(new GridLayout(5, 0));
        psouth.setLayout(new GridLayout(5, 0));
        pinsouthlower.setLayout(new BorderLayout());
        pempty1.setLayout(new BorderLayout());
        pempty2.setLayout(new BorderLayout());
        pempty3.setLayout(new BorderLayout());
        pempty4.setLayout(new BorderLayout());
        pempty5.setLayout(new BorderLayout());
        pempty6.setLayout(new BorderLayout());
        pempty7.setLayout(new BorderLayout());
        pempty8.setLayout(new GridLayout(0, 2));
        pempty9.setLayout(new GridLayout(0, 2));
        pempty10.setLayout(new BorderLayout());
        pempty11.setLayout(new GridLayout(0, 2));
        pempty12.setLayout(new BorderLayout());
        pempty13.setLayout(new BorderLayout());

        //Pnorth
        pnorth.add(pnorthleft, BorderLayout.CENTER);
        pnorth.add(pnorthright, BorderLayout.EAST);

        //Pnorthright
        pnorthright.add(pempty1);
        pempty1.add(pproduct, BorderLayout.WEST);
        pempty1.add(pproductname);
        
        pnorthright.add(pempty2);
        pempty2.add(ptype, BorderLayout.WEST);
        pempty2.add(ptypename);
        
        pnorthright.add(pempty3);
        pempty3.add(ppriceper, BorderLayout.WEST);
        pempty3.add(pnumpriceper);
        
        pnorthright.add(pempty4);
        pempty4.add(pweight, BorderLayout.WEST);
        pempty4.add(pnumweight);
        
        pnorthright.add(pempty5);
        pempty5.add(pamount, BorderLayout.WEST);
        pempty5.add(pnumamount);

        //Pnorthleft
        pnorthleft.add(pinnorthleft, BorderLayout.EAST);
        pinnorthleft.add(new JLabel("    "));
        pnorthleft.add(pinnorthcenter);
        pinnorthcenter.add(pincenter);

        //PSouth
        psouth.add(pempty13); 
        pempty13.add(new JLabel("                 "), BorderLayout.WEST);
        pempty13.add(bsave); 
        pempty13.add(new JLabel("                                                                                   "), BorderLayout.EAST);
        
        psouth.add(pempty6);
        pempty6.add(pempty8, BorderLayout.WEST);
        pempty6.add(pempty10);
        pempty10.add(pempty11, BorderLayout.WEST);
        pempty11.add(bplus);
        pempty11.add(bminus);
        pempty10.add(bset);
        pempty8.add(peditamount);
        pempty8.add(tfamount);
        
        psouth.add(pempty7);
        pempty7.add(pempty9, BorderLayout.WEST);
        pempty7.add(pempty12);
        pempty12.add(bsavev2);
        pempty9.add(peditprice);
        pempty9.add(tfprice);
       
        psouth.add(new JLabel());
        
        psouth.add(pinsouthlower);
        pinsouthlower.add(bdelete, BorderLayout.WEST);
        pinsouthlower.add(bok, BorderLayout.EAST);

        //SetFont
        pproduct.setFont(new Font("Aria", Font.BOLD, 16));
        pproduct.setForeground(Color.WHITE);
        pproductname.setFont(new Font("Aria", Font.BOLD, 16));
        pproductname.setForeground(Color.WHITE);
        ptype.setFont(new Font("Aria", Font.BOLD, 16));
        ptype.setForeground(Color.WHITE);
        ptypename.setFont(new Font("Aria", Font.BOLD, 16));
        ptypename.setForeground(Color.WHITE);
        ppriceper.setFont(new Font("Aria", Font.BOLD, 16));
        ppriceper.setForeground(Color.WHITE);
        pnumpriceper.setFont(new Font("Aria", Font.BOLD, 16));
        pnumpriceper.setForeground(Color.WHITE);
        pweight.setFont(new Font("Aria", Font.BOLD, 16));
        pweight.setForeground(Color.WHITE);
        pnumweight.setFont(new Font("Aria", Font.BOLD, 16));
        pnumweight.setForeground(Color.WHITE);
        pamount.setFont(new Font("Aria", Font.BOLD, 16));
        pamount.setForeground(Color.WHITE);
        pnumamount.setFont(new Font("Aria", Font.BOLD, 16));
        pnumamount.setForeground(Color.WHITE);
        peditamount.setFont(new Font("Aria", Font.BOLD, 16));
        peditamount.setForeground(Color.WHITE);
        peditprice.setFont(new Font("Aria", Font.BOLD, 16));
        peditprice.setForeground(Color.WHITE);
        
        bsave.setBackground(Color.WHITE);
        bsave.setFont(new Font("Aria", Font.BOLD, 16));
        bsave.setForeground(new Color(69, 104, 159));
        bsave.setBorder(new LineBorder(new Color(69, 104, 159), 3));
        bok.setBackground(Color.WHITE);
        bok.setFont(new Font("Aria", Font.BOLD, 16));
        bok.setForeground(new Color(69, 104, 159));
        bok.setBorder(new LineBorder(new Color(69, 104, 159), 2));
        bsavev2.setBackground(Color.WHITE);
        bsavev2.setFont(new Font("Aria", Font.BOLD, 16));
        bsavev2.setForeground(new Color(69, 104, 159));
        bset.setBackground(Color.WHITE);
        bset.setFont(new Font("Aria", Font.BOLD, 16));
        bset.setForeground(new Color(69, 104, 159));
        bplus.setBackground(Color.WHITE);
        bplus.setFont(new Font("Aria", Font.BOLD, 16));
        bplus.setForeground(new Color(69, 104, 159));
        bminus.setBackground(Color.WHITE);
        bminus.setFont(new Font("Aria", Font.BOLD, 16));
        bminus.setForeground(new Color(69, 104, 159));
        bminus = new JButton("-");
        bdelete.setBackground(Color.WHITE);
        bdelete.setFont(new Font("Aria", Font.BOLD, 16));
        bdelete.setForeground(Color.RED);
        bdelete.setBorder(new LineBorder(Color.RED, 2));
        
        tfprice.setBackground(new Color(69, 104, 159));
        tfprice.setBorder(new LineBorder(Color.WHITE, 2));
        tfprice.setFont(new Font("Aria", Font.BOLD, 14));
        tfprice.setForeground(Color.WHITE);
        tfprice.setHorizontalAlignment(SwingConstants.CENTER);
        tfamount.setBackground(new Color(69, 104, 159));
        tfamount.setBorder(new LineBorder(Color.WHITE, 2));
        tfamount.setFont(new Font("Aria", Font.BOLD, 14));
        tfamount.setForeground(Color.WHITE);
        tfamount.setHorizontalAlignment(SwingConstants.CENTER);

        //SetBackGround
        pmain.setBackground(new Color(69, 104, 159));
        pnorth.setBackground(new Color(69, 104, 159));
        pnorthleft.setBackground(new Color(101, 113, 132));
        pinnorthleft.setBackground(new Color(69, 104, 159));
        pinnorthcenter.setBackground(new Color(101, 113, 132));
        pincenter.setBackground(Color.WHITE);
        pincenter.setBorder(new LineBorder(new Color(101, 113, 132), 5));
        pnorthright.setBackground(new Color(69, 104, 159));
        psouth.setBackground(new Color(69, 104, 159));
        psouth.setBorder(new LineBorder(new Color(69, 104, 159), 5));
        pinsouthlower.setBackground(new Color(69, 104, 159));
        pempty1.setBackground(new Color(69, 104, 159));
        pempty2.setBackground(new Color(69, 104, 159));
        pempty3.setBackground(new Color(69, 104, 159));
        pempty4.setBackground(new Color(69, 104, 159));
        pempty5.setBackground(new Color(69, 104, 159));
        pempty6.setBackground(new Color(69, 104, 159));
        pempty6.setBorder(new LineBorder(new Color(69, 104, 159), 2));
        pempty7.setBackground(new Color(69, 104, 159));
        pempty7.setBorder(new LineBorder(new Color(69, 104, 159), 2));
        pempty8.setBackground(new Color(69, 104, 159));
        pempty9.setBackground(new Color(69, 104, 159));
        pempty10.setBackground(new Color(69, 104, 159));
        pempty11.setBackground(new Color(69, 104, 159));
        pempty12.setBackground(new Color(69, 104, 159));
        pempty13.setBackground(new Color(69, 104, 159));

        //JFrame
        mainf.setIconImage(i2.getImage());
        pmain.add(pnorth, BorderLayout.CENTER);
        pmain.add(psouth, BorderLayout.SOUTH);
        pmain.setBorder(new LineBorder(new Color(69, 104, 159), 10));
        this.setLayout(new BorderLayout());
        this.add(pmain);
        this.setBackground(new Color(69, 104, 159));
        this.setBorder(new LineBorder(new Color(101, 113, 132), 5));
        mainf.add(this);
        mainf.setSize(470, 450);
        mainf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainf.setVisible(true);
    }
    
    public static void main(String[] args) {
       try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            new ViewProduct();
        });
    }
}
