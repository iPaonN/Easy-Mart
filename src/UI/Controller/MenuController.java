package UI.Controller;

import My_sql.ProjectData.DoProjectData;
import My_sql.UserData.DoUserData;
import UI.View.Assistance;
import UI.View.DashBoard;
import UI.View.HistoryView;
import UI.View.MainMenu;
import UI.View.MemberView;
import UI.View.Option;
import UI.View.StockProduct;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.*;
import javax.swing.*;


public class MenuController implements ActionListener, MouseListener{
    private DoUserData manager;
    private DoProjectData pjm;
    private MainMenu main;
    private String username, projectname;
    private DashBoardController dashboard;
    private AssistanceController assistance;
    private StockProductController stock;
    private MemberController member;
    private HistoryController history;
    private OptionController option;
    private CardLayout cardcontroll;
    public MenuController(String username, String projectname){
        manager = new DoUserData();
        pjm = new DoProjectData();
        main = new MainMenu();
        this.username = username;
        this.projectname = projectname;
        
        cardcontroll = (CardLayout)main.getCardpanel().getLayout();
        dashboard = new DashBoardController(this.username, this.projectname);
        assistance = new AssistanceController(this.username, this.projectname);
        stock = new StockProductController(this.username, this.projectname);
        member = new MemberController(this.username, this.projectname);
        history = new HistoryController(this.username, this.projectname);
        option = new OptionController(this.username, this.projectname, this);
        main.getCardpanel().add(dashboard.getDashboard(), "DashBoard");
        main.getCardpanel().add(assistance.getView(), "Assistance");
        main.getCardpanel().add(stock.getView(), "Stock");
        main.getCardpanel().add(member.getView(), "Member");
        main.getCardpanel().add(history.getView(), "History");
        main.getCardpanel().add(option.getView(), "Option");
        
        //set inform
        main.getCp1().LoadImage(manager.GetProfileImage(this.username));
        main.getUns1().setText(this.username);
        
        
        //Add Event
        main.getEasyMart().addMouseListener(this);
        main.getBn1().addActionListener(this);
        main.getBn2().addActionListener(this);
        main.getBn3().addActionListener(this);
        main.getBn5().addActionListener(this);
        main.getBn6().addActionListener(this);
        main.getBn9().addActionListener(this);
        
    }
    
    public JFrame getFr(){
        return main.getFr();
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

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(main.getEasyMart())){
            new MainPageController(this.username);
            this.main.getFr().dispose();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
