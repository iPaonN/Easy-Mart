package UI.View;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Register{
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

    public void setMainf(JFrame mainf) {
        this.mainf = mainf;
    }

    public void setPnorth(JPanel pnorth) {
        this.pnorth = pnorth;
    }

    public void setPcenter(JPanel pcenter) {
        this.pcenter = pcenter;
    }

    public void setPsouth(JPanel psouth) {
        this.psouth = psouth;
    }

    public void setPmain(JPanel pmain) {
        this.pmain = pmain;
    }

    public void setPempty1(JPanel pempty1) {
        this.pempty1 = pempty1;
    }

    public void setPempty2(JPanel pempty2) {
        this.pempty2 = pempty2;
    }

    public void setPempty3(JPanel pempty3) {
        this.pempty3 = pempty3;
    }

    public void setPempty4(JPanel pempty4) {
        this.pempty4 = pempty4;
    }

    public void setPempty5(JPanel pempty5) {
        this.pempty5 = pempty5;
    }

    public void setPempty6(JPanel pempty6) {
        this.pempty6 = pempty6;
    }

    public void setPempty7(JPanel pempty7) {
        this.pempty7 = pempty7;
    }

    public void setPempty8(JPanel pempty8) {
        this.pempty8 = pempty8;
    }

    public void setPempty9(JPanel pempty9) {
        this.pempty9 = pempty9;
    }

    public void setPempty10(JPanel pempty10) {
        this.pempty10 = pempty10;
    }

    public void setPempty11(JPanel pempty11) {
        this.pempty11 = pempty11;
    }

    public void setPempty12(JPanel pempty12) {
        this.pempty12 = pempty12;
    }

    public void setPempty13(JPanel pempty13) {
        this.pempty13 = pempty13;
    }

    public void setPempty14(JPanel pempty14) {
        this.pempty14 = pempty14;
    }

    public void setPempty15(JPanel pempty15) {
        this.pempty15 = pempty15;
    }

    public void setPempty16(JPanel pempty16) {
        this.pempty16 = pempty16;
    }

    public void setPempty17(JPanel pempty17) {
        this.pempty17 = pempty17;
    }

    public void setPempty18(JPanel pempty18) {
        this.pempty18 = pempty18;
    }

    public void setPempty19(JPanel pempty19) {
        this.pempty19 = pempty19;
    }

    public void setPempty20(JPanel pempty20) {
        this.pempty20 = pempty20;
    }

    public void setJaccount(JLabel jaccount) {
        this.jaccount = jaccount;
    }

    public void setJusername(JLabel jusername) {
        this.jusername = jusername;
    }

    public void setJemail(JLabel jemail) {
        this.jemail = jemail;
    }

    public void setJfirstname(JLabel jfirstname) {
        this.jfirstname = jfirstname;
    }

    public void setJlastname(JLabel jlastname) {
        this.jlastname = jlastname;
    }

    public void setJnewpassword(JLabel jnewpassword) {
        this.jnewpassword = jnewpassword;
    }

    public void setJconfirmpassword(JLabel jconfirmpassword) {
        this.jconfirmpassword = jconfirmpassword;
    }

    public void setJaletusername(JLabel jaletusername) {
        this.jaletusername = jaletusername;
    }

    public void setJaletpassword(JLabel jaletpassword) {
        this.jaletpassword = jaletpassword;
    }

    public void setJaletemail(JLabel jaletemail) {
        this.jaletemail = jaletemail;
    }

    public void setTfusername(JTextField tfusername) {
        this.tfusername = tfusername;
    }

    public void setTfemail(JTextField tfemail) {
        this.tfemail = tfemail;
    }

    public void setTffirstname(JTextField tffirstname) {
        this.tffirstname = tffirstname;
    }

    public void setTflastname(JTextField tflastname) {
        this.tflastname = tflastname;
    }

    public void setTfnewpassword(JPasswordField tfnewpassword) {
        this.tfnewpassword = tfnewpassword;
    }

    public void setTfconfirmpassword(JPasswordField tfconfirmpassword) {
        this.tfconfirmpassword = tfconfirmpassword;
    }

    public void setJcreate(JButton jcreate) {
        this.jcreate = jcreate;
    }

    public void setJeyepassword(JButton jeyepassword) {
        this.jeyepassword = jeyepassword;
    }

    public void setJeyeconfirmword(JButton jeyeconfirmword) {
        this.jeyeconfirmword = jeyeconfirmword;
    }

    public void setItryusername(ImageIcon itryusername) {
        this.itryusername = itryusername;
    }

    public void setItryemail(ImageIcon itryemail) {
        this.itryemail = itryemail;
    }

    public void setItryfirstname(ImageIcon itryfirstname) {
        this.itryfirstname = itryfirstname;
    }

    public void setItrylastname(ImageIcon itrylastname) {
        this.itrylastname = itrylastname;
    }

    public void setItrynewpassword(ImageIcon itrynewpassword) {
        this.itrynewpassword = itrynewpassword;
    }

    public void setItryconfirmword(ImageIcon itryconfirmword) {
        this.itryconfirmword = itryconfirmword;
    }

    public void setIusername(ImageIcon iusername) {
        this.iusername = iusername;
    }

    public void setIemail(ImageIcon iemail) {
        this.iemail = iemail;
    }

    public void setIfirstname(ImageIcon ifirstname) {
        this.ifirstname = ifirstname;
    }

    public void setIlastname(ImageIcon ilastname) {
        this.ilastname = ilastname;
    }

    public void setInewpassword(ImageIcon inewpassword) {
        this.inewpassword = inewpassword;
    }

    public void setIconfirmpassword(ImageIcon iconfirmpassword) {
        this.iconfirmpassword = iconfirmpassword;
    }

    public void setItryframe(ImageIcon itryframe) {
        this.itryframe = itryframe;
    }

    public void setIframe(ImageIcon iframe) {
        this.iframe = iframe;
    }

    public void setItryeye(ImageIcon itryeye) {
        this.itryeye = itryeye;
    }

    public void setIeye(ImageIcon ieye) {
        this.ieye = ieye;
    }

    public JFrame getMainf() {
        return mainf;
    }

    public JPanel getPnorth() {
        return pnorth;
    }

    public JPanel getPcenter() {
        return pcenter;
    }

    public JPanel getPsouth() {
        return psouth;
    }

    public JPanel getPmain() {
        return pmain;
    }

    public JPanel getPempty1() {
        return pempty1;
    }

    public JPanel getPempty2() {
        return pempty2;
    }

    public JPanel getPempty3() {
        return pempty3;
    }

    public JPanel getPempty4() {
        return pempty4;
    }

    public JPanel getPempty5() {
        return pempty5;
    }

    public JPanel getPempty6() {
        return pempty6;
    }

    public JPanel getPempty7() {
        return pempty7;
    }

    public JPanel getPempty8() {
        return pempty8;
    }

    public JPanel getPempty9() {
        return pempty9;
    }

    public JPanel getPempty10() {
        return pempty10;
    }

    public JPanel getPempty11() {
        return pempty11;
    }

    public JPanel getPempty12() {
        return pempty12;
    }

    public JPanel getPempty13() {
        return pempty13;
    }

    public JPanel getPempty14() {
        return pempty14;
    }

    public JPanel getPempty15() {
        return pempty15;
    }

    public JPanel getPempty16() {
        return pempty16;
    }

    public JPanel getPempty17() {
        return pempty17;
    }

    public JPanel getPempty18() {
        return pempty18;
    }

    public JPanel getPempty19() {
        return pempty19;
    }

    public JPanel getPempty20() {
        return pempty20;
    }

    public JLabel getJaccount() {
        return jaccount;
    }

    public JLabel getJusername() {
        return jusername;
    }

    public JLabel getJemail() {
        return jemail;
    }

    public JLabel getJfirstname() {
        return jfirstname;
    }

    public JLabel getJlastname() {
        return jlastname;
    }

    public JLabel getJnewpassword() {
        return jnewpassword;
    }

    public JLabel getJconfirmpassword() {
        return jconfirmpassword;
    }

    public JLabel getJaletusername() {
        return jaletusername;
    }

    public JLabel getJaletpassword() {
        return jaletpassword;
    }

    public JLabel getJaletemail() {
        return jaletemail;
    }

    public JTextField getTfusername() {
        return tfusername;
    }

    public JTextField getTfemail() {
        return tfemail;
    }

    public JTextField getTffirstname() {
        return tffirstname;
    }

    public JTextField getTflastname() {
        return tflastname;
    }

    public JPasswordField getTfnewpassword() {
        return tfnewpassword;
    }

    public JPasswordField getTfconfirmpassword() {
        return tfconfirmpassword;
    }

    public JButton getJcreate() {
        return jcreate;
    }

    public JButton getJeyepassword() {
        return jeyepassword;
    }

    public JButton getJeyeconfirmword() {
        return jeyeconfirmword;
    }

    public ImageIcon getItryusername() {
        return itryusername;
    }

    public ImageIcon getItryemail() {
        return itryemail;
    }

    public ImageIcon getItryfirstname() {
        return itryfirstname;
    }

    public ImageIcon getItrylastname() {
        return itrylastname;
    }

    public ImageIcon getItrynewpassword() {
        return itrynewpassword;
    }

    public ImageIcon getItryconfirmword() {
        return itryconfirmword;
    }

    public ImageIcon getIusername() {
        return iusername;
    }

    public ImageIcon getIemail() {
        return iemail;
    }

    public ImageIcon getIfirstname() {
        return ifirstname;
    }

    public ImageIcon getIlastname() {
        return ilastname;
    }

    public ImageIcon getInewpassword() {
        return inewpassword;
    }

    public ImageIcon getIconfirmpassword() {
        return iconfirmpassword;
    }

    public ImageIcon getItryframe() {
        return itryframe;
    }

    public ImageIcon getIframe() {
        return iframe;
    }

    public ImageIcon getItryeye() {
        return itryeye;
    }

    public ImageIcon getIeye() {
        return ieye;
    }

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
