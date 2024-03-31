package UI.View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Cashier extends JPanel implements ActionListener {

    private JFrame frame;
    private JPanel background, bg1, bg2, bg3, bg4, main, textPanel, searchPanel, productPanel, bdwhite;
    private JPanel white1, white2, white3, white4, innerPanel, bigsearch, bigscroll, btnPanel, subPanel;
    private JLabel text;
    private JTextField search;
    private JButton filter, checkout;
    private JScrollPane scrollPane;
    private JComboBox sort;
    private CashierNotify cn1;

    public Cashier() {
        cn1 = new CashierNotify();
        frame = new JFrame();
        background = new JPanel();
        bg1 = new JPanel();
        bg2 = new JPanel();
        bg3 = new JPanel();
        bg4 = new JPanel();
        main = new JPanel();
        textPanel = new JPanel();
        text = new JLabel("Cashier");
        text.setForeground(new Color(69, 104, 159));
        searchPanel = new JPanel();
        search = new JTextField();
        filter = new JButton("FILTER");
        scrollPane = new JScrollPane();
        productPanel = new JPanel();
        bdwhite = new JPanel();
        white1 = new JPanel();
        white2 = new JPanel();
        white3 = new JPanel();
        white4 = new JPanel();
        innerPanel = new JPanel();
        bigsearch = new JPanel();
        bigscroll = new JPanel();
        sort = new JComboBox();
        checkout = new JButton("Check Out +");
        btnPanel = new JPanel();
        subPanel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        background.setLayout(new BorderLayout());
        main.setLayout(new BorderLayout());
        textPanel.setLayout(new BorderLayout());
        productPanel.setLayout(new BorderLayout());
        innerPanel.setLayout(new BorderLayout());
        searchPanel.setLayout(new FlowLayout());
        bigsearch.setLayout(new BorderLayout());
        bigscroll.setLayout(new GridLayout());
        btnPanel.setLayout(new FlowLayout());
        subPanel.setLayout(new GridLayout(0, 4));

        //Background
        bg1.setBackground(new Color(101, 113, 132));
        bg2.setBackground(new Color(101, 113, 132));
        bg3.setBackground(new Color(101, 113, 132));
        bg4.setBackground(new Color(101, 113, 132));
        bg1.setPreferredSize(new Dimension(0, 35));
        bg2.setPreferredSize(new Dimension(35, 0));
        bg3.setPreferredSize(new Dimension(0, 35));
        bg4.setPreferredSize(new Dimension(35, 0));
        bdwhite.setPreferredSize(new Dimension(0, 10));
        bdwhite.setBackground(Color.white);
        main.setBorder(new LineBorder(new Color(69, 104, 159), 8));
        main.setBackground(Color.white);
        bigsearch.setBackground(Color.white);

        //INNER
        white1.setPreferredSize(new Dimension(0, 25));
        white2.setPreferredSize(new Dimension(35, 0));
        white3.setPreferredSize(new Dimension(0, 40));
        white4.setPreferredSize(new Dimension(40, 0));
        white1.setBackground(Color.white);
        white2.setBackground(Color.white);
        white3.setBackground(Color.white);
        white4.setBackground(Color.white);
        scrollPane.setBorder(new LineBorder(new Color(69, 104, 159), 3));
        bigscroll.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
        bigscroll.setBackground(Color.white);
        text.setFont(new Font("Arial", Font.BOLD, 48));
        textPanel.setBackground(Color.white);
        search.setFont(new Font("Arial", Font.PLAIN, 16));
        search.setPreferredSize(new Dimension(400, 30));
        search.setForeground(new Color(69, 104, 159));
        search.setBorder(new LineBorder(new Color(69, 104, 159), 3));
        searchPanel.setBackground(Color.white);
        searchPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        filter.setPreferredSize(new Dimension(100, 30));
        filter.setBorder(new LineBorder(new Color(69, 104, 159), 3));
        filter.setForeground(new Color(69, 104, 159));
        filter.setFont(new Font("Arial", Font.BOLD, 12));
        filter.setFocusable(false);
        filter.setBackground(Color.white);
        sort.setPreferredSize(new Dimension(100, 30));
        sort.setBorder(new LineBorder(new Color(69, 104, 159), 3));
        sort.setFocusable(false);
        checkout.setPreferredSize(new Dimension(100, 30));
        checkout.setFont(new Font("Arial", Font.BOLD, 12));
        checkout.setBackground(Color.white);
        checkout.setForeground(new Color(69, 104, 159));
        checkout.setBorder(new LineBorder(new Color(69, 104, 159), 3));
        checkout.setFocusable(false);
        btnPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        btnPanel.setBackground(Color.white);
        checkout.addActionListener(this);

        //IN SCROLLPANE
        scrollPane.setViewportView(subPanel);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        //ADD
        background.add(bg1, BorderLayout.NORTH);
        background.add(bg2, BorderLayout.EAST);
        background.add(main);
        background.add(bg3, BorderLayout.SOUTH);
        background.add(bg4, BorderLayout.WEST);
        textPanel.add(bdwhite, BorderLayout.SOUTH);
        textPanel.add(text);
        searchPanel.add(search);
        searchPanel.add(filter);
        searchPanel.add(sort);
        bigsearch.add(searchPanel, BorderLayout.WEST);
        
        btnPanel.add(cn1);
        btnPanel.add(checkout);
        bigsearch.add(btnPanel, BorderLayout.EAST);
        productPanel.add(bigsearch, BorderLayout.NORTH);
        bigscroll.add(scrollPane);
        productPanel.add(bigscroll);
        innerPanel.add(textPanel, BorderLayout.NORTH);
        innerPanel.add(productPanel);
        main.add(white1, BorderLayout.NORTH);
        main.add(white2, BorderLayout.EAST);
        main.add(innerPanel);
        main.add(white3, BorderLayout.SOUTH);
        main.add(white4, BorderLayout.WEST);

        this.setLayout(new BorderLayout());
        this.add(background);
        frame.add(this);
        frame.setSize(1280, 720);
        frame.setLocationRelativeTo(null);
        frame.setVisible(false);
    }

    public static void main(String[] args) {
        new Cashier();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(checkout)) {
            subPanel.add(new SubCashier());
            subPanel.revalidate();
        }
    }
}
