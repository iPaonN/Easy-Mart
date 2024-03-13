package UI.View;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class ExportDocument {
    private JFrame mainf;
    private JPanel pnorth, pcenter, pmain, pinmain;
    private JPanel pempty1, pempty2, pempty3;
    private JButton bsave, bbrowse;
    private JComboBox jcbtax, jcbpath;
    private JLabel jDocument, jselect;
    private ImageIcon itryframe, iframe;
    public ExportDocument(){
        
        //Create
        itryframe = new ImageIcon("src/UI/Image/eweweewew.jpg");
        iframe = new ImageIcon(itryframe.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        mainf = new JFrame("ExportDocument");
        pnorth = new JPanel();
        pcenter = new JPanel();
        pmain = new JPanel();
        pinmain = new JPanel();
        pempty1 = new JPanel();
        pempty2 = new JPanel();
        pempty3 = new JPanel();
        bsave = new JButton("SAVE");
        bbrowse = new JButton("BROWSE");
        jcbtax = new JComboBox();
        jcbtax.addItem(" Tax");
        jcbpath = new JComboBox();
        jcbpath.addItem(" Path                                                      ");
        jDocument = new JLabel("Document");
        jselect = new JLabel("Select : ");
        
        //SetLayer
        mainf.setLayout(new BorderLayout());
        pnorth.setLayout(new BorderLayout());
        pcenter.setLayout(new GridLayout(6, 0));
        pmain.setLayout(new BorderLayout());
        pinmain.setLayout(new BorderLayout());
        pempty1.setLayout(new BorderLayout());
        pempty2.setLayout(new BorderLayout());
        pempty3.setLayout(new BorderLayout());
        
        //SetBackGround
        mainf.setBackground(new Color(69, 104, 159));
        pnorth.setBackground(new Color(69, 104, 159));
        pcenter.setBackground(new Color(69, 104, 159));
        pmain.setBackground(new Color(69, 104, 159));
        pmain.setBorder(new LineBorder(new Color(101, 113, 132), 5));
        pinmain.setBackground(new Color(69, 104, 159));
        pinmain.setBorder(new LineBorder(new Color(69, 104, 159), 15));
        pempty1.setBackground(new Color(69, 104, 159));
        pempty2.setBackground(new Color(69, 104, 159));
        pempty3.setBackground(new Color(69, 104, 159));
        
        //Pinmain
        pinmain.add(pnorth, BorderLayout.NORTH);
        pinmain.add(pcenter);
        
        //Pnorth
        jDocument.setHorizontalAlignment(SwingConstants.CENTER);
        pnorth.add(jDocument);
        
        //Pcenter
        pcenter.add(new JLabel());
        pcenter.add(pempty1);
        pempty1.add(jselect, BorderLayout.WEST);
        pempty1.add(jcbtax);
        pempty1.add(new JLabel("                                                                     "), BorderLayout.EAST);
        
        pcenter.add(new JLabel());
        pcenter.add(pempty2);
        pempty2.add(jcbpath, BorderLayout.WEST);
        pempty2.add(bbrowse);
        
        pcenter.add(new JLabel());
        pcenter.add(pempty3);
        pempty3.add(new JLabel("                                                "), BorderLayout.WEST);
        pempty3.add(bsave);
        pempty3.add(new JLabel("                                                "), BorderLayout.EAST);
        
        //SetFont
        bsave.setFont(new Font("Arial", Font.BOLD, 16));
        bsave.setForeground(new Color(69, 104, 159));
        bsave.setBackground(Color.WHITE);
        bbrowse.setFont(new Font("Arial", Font.BOLD, 16));
        bbrowse.setForeground(new Color(69, 104, 159));
        bbrowse.setBackground(Color.WHITE);
        jcbtax.setFont(new Font("Arial", Font.BOLD, 14));
        jcbtax.setForeground(new Color(69, 104, 159));
        jcbtax.setBackground(Color.WHITE);
        jcbpath.setFont(new Font("Arial", Font.BOLD, 14));
        jcbpath.setForeground(new Color(69, 104, 159));
        jDocument.setFont(new Font("Arial", Font.BOLD, 40));
        jcbpath.setBackground(Color.WHITE);
        jDocument.setForeground(Color.WHITE);
        jselect.setFont(new Font("Arial", Font.BOLD, 16));
        jselect.setForeground(Color.WHITE);
        
        
        //JFrame
        mainf.setIconImage(iframe.getImage());
        pmain.add(pinmain);
        mainf.add(pmain);
        mainf.setSize(450, 300);
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
            new ExportDocument();
        });
    }
}
