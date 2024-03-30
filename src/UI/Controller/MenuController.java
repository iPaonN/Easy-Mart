package UI.Controller;

import My_sql.ProjectData.DoProjectData;
import My_sql.UserData.DoUserData;
import UI.View.Assistance;
import UI.View.DashBoard;
import UI.View.History;
import UI.View.MainMenu;
import UI.View.Member;
import UI.View.Option;
import UI.View.StockProduct;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.*;


public class MenuController implements ActionListener{
    private DoUserData manager;
    private DoProjectData pjm;
    private MainMenu main;
    private String username, projectname;
    private DashBoard dashboard;
    private Assistance assistance;
    private StockProduct stock;
    private Member member;
    private History history;
    private OptionController option;
    private CardLayout cardcontroll;
    public MenuController(String username, String projectname){
        manager = new DoUserData();
        pjm = new DoProjectData();
        main = new MainMenu();
        this.username = username;
        this.projectname = projectname;
        
        cardcontroll = (CardLayout)main.getCardpanel().getLayout();
        dashboard = new DashBoard();
        assistance = new Assistance();
        stock = new StockProduct();
        member = new Member();
        history = new History();
        option = new OptionController(this.username, this.projectname);
        main.getCardpanel().add(dashboard, "DashBoard");
        main.getCardpanel().add(assistance, "Assistance");
        main.getCardpanel().add(stock, "Stock");
        main.getCardpanel().add(member, "Member");
        main.getCardpanel().add(history, "History");
        main.getCardpanel().add(option, "Option");
        
        //set inform
        main.getCp1().LoadImage(manager.GetProfileImage(this.username));
        main.getUns1().setText(this.username);
        
        
        //Add Event
        main.getBn1().addActionListener(this);
        main.getBn2().addActionListener(this);
        main.getBn3().addActionListener(this);
        main.getBn5().addActionListener(this);
        main.getBn6().addActionListener(this);
        main.getBn9().addActionListener(this);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(main.getBn1())){
            cardcontroll.show(main.getCardpanel(), "DashBoard");
        }
        else if (e.getSource().equals(main.getBn2())){
            cardcontroll.show(main.getCardpanel(), "Assistance");
        }
        else if (e.getSource().equals(main.getBn3())){
            cardcontroll.show(main.getCardpanel(), "Stock");
        }
        else if (e.getSource().equals(main.getBn5())){
            cardcontroll.show(main.getCardpanel(), "History");
        }
        else if (e.getSource().equals(main.getBn6())){
            cardcontroll.show(main.getCardpanel(), "Member");
        }
        else if (e.getSource().equals(main.getBn9())){
            cardcontroll.show(main.getCardpanel(), "Option");
        }
    }
    
}
