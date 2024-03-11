package UI;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import My_sql.UserData.*;

public class Register implements DocumentListener, MouseListener, FocusListener, ActionListener{

    private JFrame mainf;
    private JPanel pnorth, pcenter, psouth, pmain;
    private JPanel pempty1, pempty2, pempty3, pempty4, pempty5, pempty6, pempty7, pempty8, pempty9;
    private JPanel pempty10, pempty11, pempty12, pempty13, pempty14, pempty15, pempty16, pempty17, pempty18, pempty19, pempty20;
    private JLabel jaccount, jusername, jemail, jfirstname, jlastname, jnewpassword, jconfirmpassword;
    private JLabel jaletusername, jaletpassword, jaletemail;
    private JTextField tfusername, tfemail, tffirstname, tflastname;
    private JPasswordField tfnewpassword, tfconfirmpassword;
    private JButton jcreate, jeyepassword, jeyeconfirmword;
    private ImageIcon itryusername, itryemail, itryfirstname, itrylastname, itrynewpassword, itryconfirmword;
    private ImageIcon iusername, iemail, ifirstname, ilastname, inewpassword, iconfirmpassword;
    private ImageIcon itryframe, iframe, itryeye, ieye;
    public Register() {

        //Create
        itryeye = new ImageIcon("src/UI/Image/eye.jpg");
        itryframe = new ImageIcon("src/UI/Image/eweweewew.jpg");
        itryusername = new ImageIcon("src/UI/Image/username.png");
        itryemail = new ImageIcon("src/UI/Image/image_6.png");
        itryfirstname = new ImageIcon("src/UI/Image/image_4.png");
        itrylastname = new ImageIcon("src/UI/Image/image_4.png");
        itrynewpassword = new ImageIcon("src/UI/Image/password.png");
        itryconfirmword = new ImageIcon("src/UI/Image/image_4.png");
        ieye = new ImageIcon(itryeye.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        iframe = new ImageIcon(itryframe.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        iusername = new ImageIcon(itryusername.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        iemail = new ImageIcon(itryemail.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        ifirstname = new ImageIcon(itryfirstname.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        ilastname = new ImageIcon(itrylastname.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        inewpassword = new ImageIcon(itrynewpassword.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        iconfirmpassword = new ImageIcon(itryconfirmword.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        mainf = new JFrame("Register");
        pnorth = new JPanel();
        pcenter = new JPanel();
        psouth = new JPanel();
        pmain = new JPanel();
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
        pempty20 = new JPanel();
        jaccount = new JLabel("Create Account");
        jusername = new JLabel("Username", iusername, SwingConstants.LEFT);
        jemail = new JLabel("Email", iemail, SwingConstants.LEFT);
        jfirstname = new JLabel("First Name", ifirstname, SwingConstants.LEFT);
        jlastname = new JLabel("Last Name", ilastname, SwingConstants.LEFT);
        jnewpassword = new JLabel("New Password", inewpassword, SwingConstants.LEFT);
        jconfirmpassword = new JLabel("Confirm Password", iconfirmpassword, SwingConstants.LEFT);
        jaletusername = new JLabel("");
        jaletpassword = new JLabel("");
        jaletemail = new JLabel("");
        jeyepassword = new JButton(ieye);
        jeyeconfirmword = new JButton(ieye);
        tfusername = new JTextField();
        tfemail = new JTextField();
        tffirstname = new JTextField();
        tflastname = new JTextField();
        tfconfirmpassword = new JPasswordField();
        tfnewpassword = new JPasswordField();
        jcreate = new JButton("Create");
        
        //Add Event
        tfusername.addFocusListener(this);
        tfemail.addFocusListener(this);
        tfconfirmpassword.getDocument().addDocumentListener(this);
        tfnewpassword.getDocument().addDocumentListener(this);
        jeyepassword.addMouseListener(this);
        jeyeconfirmword.addMouseListener(this);
        jcreate.addActionListener(this);
        

        //SetLayout
        mainf.setLayout(new BorderLayout());
        pnorth.setLayout(new BorderLayout());
        pcenter.setLayout(new GridLayout(20, 0));
        psouth.setLayout(new BorderLayout());
        pmain.setLayout(new BorderLayout());
        pempty1.setLayout(new BorderLayout());
        pempty2.setLayout(new BorderLayout());
        pempty3.setLayout(new BorderLayout());
        pempty4.setLayout(new BorderLayout());
        pempty5.setLayout(new BorderLayout());
        pempty6.setLayout(new BorderLayout());
        pempty7.setLayout(new BorderLayout());
        pempty8.setLayout(new BorderLayout());
        pempty9.setLayout(new BorderLayout());
        pempty10.setLayout(new BorderLayout());
        pempty11.setLayout(new BorderLayout());
        pempty12.setLayout(new BorderLayout());
        pempty13.setLayout(new BorderLayout());
        pempty14.setLayout(new BorderLayout());
        pempty15.setLayout(new BorderLayout());
        pempty16.setLayout(new BorderLayout());
        pempty17.setLayout(new BorderLayout());
        pempty18.setLayout(new BorderLayout());
        pempty19.setLayout(new BorderLayout());
        pempty20.setLayout(new BorderLayout());

        //Pmain
        pmain.add(pnorth, BorderLayout.NORTH);
        pmain.add(pcenter, BorderLayout.CENTER);
        pmain.add(psouth, BorderLayout.SOUTH);

        //Pnorth
        jaccount.setHorizontalAlignment(SwingConstants.CENTER);
        pnorth.add(jaccount);

        //Pcenter
        pcenter.add(new JLabel());

        pcenter.add(pempty1);
        pempty1.add(jusername);

        pcenter.add(pempty2);
        pempty2.add(tfusername);

        pcenter.add(pempty3);
        pempty3.add(jaletusername);

        pcenter.add(pempty4);
        pempty4.add(jemail);

        pcenter.add(pempty5);
        pempty5.add(tfemail);

        pcenter.add(pempty6);
        pempty6.add(jaletemail);

        pcenter.add(pempty7);
        pempty7.add(jfirstname);

        pcenter.add(pempty8);
        pempty8.add(tffirstname);

        pcenter.add(pempty9);
        pempty9.add(new JLabel());

        pcenter.add(pempty10);
        pempty10.add(jlastname);

        pcenter.add(pempty11);
        pempty11.add(tflastname);

        pcenter.add(pempty12);
        pempty12.add(new JLabel());

        pcenter.add(pempty13);
        pempty13.add(jnewpassword);

        pcenter.add(pempty14);
        pempty14.add(pempty19);
        jeyepassword.setPreferredSize(new Dimension(30, 20));
        pempty19.add(jeyepassword, BorderLayout.EAST);
        pempty19.add(tfnewpassword);
        
        pcenter.add(pempty15);
        pempty15.add(new JLabel());

        pcenter.add(pempty16);
        pempty16.add(jconfirmpassword);

        pcenter.add(pempty17);
        pempty17.add(pempty20);
        jeyeconfirmword.setPreferredSize(new Dimension(30, 20));
        pempty20.add(jeyeconfirmword, BorderLayout.EAST);
        pempty20.add(tfconfirmpassword);

        pcenter.add(pempty18);
        pempty18.add(jaletpassword);

        pcenter.add(new JLabel());
        //Psouth
        jcreate.setPreferredSize(new Dimension(20, 35));
        psouth.add(jcreate);

        //SetFont
        jaccount.setFont(new Font("Arial", Font.BOLD, 32));
        jaccount.setForeground(Color.WHITE);
        jusername.setFont(new Font("Arial", Font.BOLD, 16));
        jusername.setForeground(Color.WHITE);
        jemail.setFont(new Font("Arial", Font.BOLD, 16));
        jemail.setForeground(Color.WHITE);
        jfirstname.setFont(new Font("Arial", Font.BOLD, 16));
        jfirstname.setForeground(Color.WHITE);
        jlastname.setFont(new Font("Arial", Font.BOLD, 16));
        jlastname.setForeground(Color.WHITE);
        jnewpassword.setFont(new Font("Arial", Font.BOLD, 16));
        jnewpassword.setForeground(Color.WHITE);
        jconfirmpassword.setFont(new Font("Arial", Font.BOLD, 16));
        jconfirmpassword.setForeground(Color.WHITE);
        jaletusername.setFont(new Font("Arial", Font.BOLD, 12));
        jaletusername.setForeground(new Color(250, 199, 16));
        jaletpassword.setFont(new Font("Arial", Font.BOLD, 12));
        jaletpassword.setForeground(new Color(250, 199, 16));
        jaletemail.setFont(new Font("Arial", Font.BOLD, 12));
        jaletemail.setForeground(new Color(250, 199, 16));

        tfusername.setFont(new Font("Arial", Font.PLAIN, 14));
        tfusername.setForeground(Color.WHITE);
        tfusername.setBackground(new Color(101, 113, 132));
        tfusername.setBorder(new LineBorder(Color.WHITE, 3));
        tfemail.setFont(new Font("Arial", Font.PLAIN, 14));
        tfemail.setForeground(Color.WHITE);
        tfemail.setBackground(new Color(101, 113, 132));
        tfemail.setBorder(new LineBorder(Color.WHITE, 3));
        tffirstname.setFont(new Font("Arial", Font.PLAIN, 14));
        tffirstname.setForeground(Color.WHITE);
        tffirstname.setBackground(new Color(101, 113, 132));
        tffirstname.setBorder(new LineBorder(Color.WHITE, 3));
        tflastname.setFont(new Font("Arial", Font.PLAIN, 14));
        tflastname.setForeground(Color.WHITE);
        tflastname.setBackground(new Color(101, 113, 132));
        tflastname.setBorder(new LineBorder(Color.WHITE, 3));
        tfconfirmpassword.setFont(new Font("Arial", Font.PLAIN, 14));
        tfconfirmpassword.setForeground(Color.WHITE);
        tfconfirmpassword.setBackground(new Color(101, 113, 132));
        tfconfirmpassword.setBorder(new LineBorder(Color.WHITE, 3));
        tfnewpassword.setFont(new Font("Arial", Font.PLAIN, 14));
        tfnewpassword.setForeground(Color.WHITE);
        tfnewpassword.setBackground(new Color(101, 113, 132));
        tfnewpassword.setBorder(new LineBorder(Color.WHITE, 3));

        jcreate.setFont(new Font("Arial", Font.BOLD, 14));
        jcreate.setForeground(new Color(101, 113, 132));
        jcreate.setBackground(new Color(101, 113, 132));
        
        
        //SetBackGround
        mainf.setBackground(new Color(101, 113, 132));
        pnorth.setBackground(new Color(101, 113, 132));
        pcenter.setBackground(new Color(101, 113, 132));
        psouth.setBackground(new Color(101, 113, 132));
        pmain.setBackground(new Color(101, 113, 132));
        pmain.setBorder(new LineBorder(new Color(101, 113, 132), 20));
        pempty1.setBackground(new Color(101, 113, 132));
        pempty2.setBackground(new Color(101, 113, 132));
        pempty3.setBackground(new Color(101, 113, 132));
        pempty4.setBackground(new Color(101, 113, 132));
        pempty5.setBackground(new Color(101, 113, 132));
        pempty6.setBackground(new Color(101, 113, 132));
        pempty7.setBackground(new Color(101, 113, 132));
        pempty8.setBackground(new Color(101, 113, 132));
        pempty9.setBackground(new Color(101, 113, 132));
        pempty10.setBackground(new Color(101, 113, 132));
        pempty11.setBackground(new Color(101, 113, 132));
        pempty12.setBackground(new Color(101, 113, 132));
        pempty13.setBackground(new Color(101, 113, 132));
        pempty14.setBackground(new Color(101, 113, 132));
        pempty15.setBackground(new Color(101, 113, 132));
        pempty16.setBackground(new Color(101, 113, 132));
        pempty17.setBackground(new Color(101, 113, 132));
        pempty18.setBackground(new Color(101, 113, 132));
        pempty19.setBackground(new Color(101, 113, 132));
        pempty20.setBackground(new Color(101, 113, 132));

        //JFrame
        mainf.setIconImage(iframe.getImage());
        mainf.add(pmain);
        mainf.setSize(350, 700);
        mainf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainf.setVisible(true);
    }
    @Override
    public void mouseClicked(MouseEvent me){
        
    }
    @Override
    public void mouseEntered(MouseEvent me){
        
    }
    @Override
    public void mouseExited(MouseEvent me){
        
    }
    @Override
    public void mousePressed(MouseEvent me){
        if (me.getSource().equals(jeyepassword)){
            tfnewpassword.setEchoChar((char)0);
        }
        else if (me.getSource().equals(jeyeconfirmword)){
            tfconfirmpassword.setEchoChar((char)0);
        }
    }
    @Override
    public void mouseReleased(MouseEvent me){
        if (me.getSource().equals(jeyepassword)){
            tfnewpassword.setEchoChar('●');
        }
        else if (me.getSource().equals(jeyeconfirmword)){
            tfconfirmpassword.setEchoChar('●');
        }
    }
    @Override
    public void changedUpdate(DocumentEvent ae){
            
    }
    @Override
    public void insertUpdate(DocumentEvent e) {
        System.out.println("Test");
            if (Arrays.equals(tfnewpassword.getPassword(), tfconfirmpassword.getPassword()) == true){
                jaletpassword.setText("correct");
            }
            else{
                jaletpassword.setText("Your password not same.");
            }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        System.out.println("Test");
            if (Arrays.equals(tfnewpassword.getPassword(), tfconfirmpassword.getPassword()) == true){
                jaletpassword.setText("correct");
            }
            else{
                jaletpassword.setText("Your password not same.");
            }
    }
    @Override
    public void focusGained(FocusEvent e) {
        
    }

    @Override
    public void focusLost(FocusEvent e) {
        DoUserData user = new DoUserData();
        if (e.getSource().equals(tfusername)){
            if (user.CheckUsername(tfusername.getText()) == true){
                jaletusername.setText("This username has used.");
            }
            else {
                jaletusername.setText("");
            }
        }
        else if (e.getSource().equals(tfemail)){
            if (user.CheckEmail(tfemail.getText()) == true){
                jaletemail.setText("This email has used.");
            }
            else {
                jaletemail.setText("");
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource().equals(jcreate)){
            DoUserData user = new DoUserData();
        if(tffirstname.getText().equals("") || tflastname.getText().equals("") || tfnewpassword.getPassword().equals("") || tfconfirmpassword.getPassword().equals("") ||tfusername.getText().equals("") || user.CheckUsername(tfusername.getText())==true || (tfemail.getText().equals("") || user.CheckEmail(tfemail.getText()) == true) || (Arrays.equals(tfnewpassword.getPassword(), tfconfirmpassword.getPassword()) == false)){
            System.out.println("Can't Create Accout.");
        }
        else {
            user.InsertData(tffirstname.getText(), tfemail.getText(), new String(tfnewpassword.getPassword()), tffirstname.getText(), tflastname.getText());
            mainf.dispose();
        }
        }
        
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            new Register();
        });
    }
}
