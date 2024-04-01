package UI.Controller;

import My_sql.ProjectData.DoProjectData;
import My_sql.ProjectData.History;
import My_sql.ProjectData.Product;
import My_sql.UserData.DoUserData;
import UI.View.DashBoard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.JOptionPane;
import java.time.*;
import java.time.temporal.*;


public class DashBoardController implements ActionListener {
    private DashBoard dashboard;
    private String username, projectname, schema;
    private DoProjectData DPD;
    private DoUserData DUD;
    
    public DashBoardController(String username, String projectname) {
        dashboard = new DashBoard();
        this.username = username;
        this.projectname = projectname;
        schema = username+"_"+projectname;
        DPD = new DoProjectData();
        DUD = new DoUserData();
        
        // SubDashBoard_1 //
        dashboard.getSdb1().getBday().addActionListener(this);
        dashboard.getSdb1().getBmonth().addActionListener(this);
        dashboard.getSdb1().getbYear().addActionListener(this);
        
        dashboard.getSdb1().getJprice().setText(dash1_day_income(schema)+""+"฿");
        // SubDashBoard_1 //
        
        // SubDashBoard_2 //
        dashboard.getSdb2().getBday().addActionListener(this);
        dashboard.getSdb2().getBmonth().addActionListener(this);
        dashboard.getSdb2().getbYear().addActionListener(this);
        
        dashboard.getSdb2().getJproduct().setText(dash2_day(schema));
        // SubDashBoard_2 //
        
        // SubDashBoard_3 //
        dashboard.getSdb3().getBday().addActionListener(this);
        dashboard.getSdb3().getBmonth().addActionListener(this);
        dashboard.getSdb3().getbYear().addActionListener(this);
        
        dash3_comepare(dash3_day(schema));
        // SubDashBoard_3 //
        
        dashboard.getMainf().setVisible(true);
    }
 
    // SubDashBoard_1 //
    
    public double dash1_day_income(String schema){
        double income = 0;
        
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = currentDateTime.format(formatter);
        
        ArrayList<History> history = DPD.get_Historys_date(schema,formattedDate);
        for (History i : history){
            if (i.getAction().equals("decrease")) {
                    String productname = i.getProduct_name();
                    Product p1 = DPD.get_product(schema, productname);
                    income += p1.getPrice()*i.getQuantity();
            }
        }
        return income;
    }
    
    public double dash1_month_income(String schema) {
        double income = 0;
        
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM");
        String formattedDate = currentDateTime.format(formatter);
        
        ArrayList<History> history = DPD.get_Historys_month(schema,formattedDate);
        ArrayList<History> usehistory = new ArrayList<>();

        for (History i : history){
            if(i.getAction_date().getYear()==currentDateTime.getYear()){
                usehistory.add(i);
            }
        }
        
        for (History i : usehistory){
            if (i.getAction().equals("decrease")) {
                    String productname = i.getProduct_name();
                    Product p1 = DPD.get_product(schema, productname);
                    income += p1.getPrice()*i.getQuantity();
            }
        }
        
        return income;
    }

        
    public double dash1_year_income(String schema) {
        double income = 0;
        
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
        String formattedDate = currentDateTime.format(formatter);
        
        ArrayList<History> history = DPD.get_Historys_year(schema,formattedDate);
        
        for (History i : history){
            if (i.getAction().equals("decrease")) {
                    String productname = i.getProduct_name();
                    Product p1 = DPD.get_product(schema, productname);
                    income += p1.getPrice()*i.getQuantity();
            }
        }
        
        return income;
    }
    
    // SubDashBoard_1 //
    
    // SubDashBoard_2 //
    public String dash2_day(String schema){
        String mostproduct = "You didn't sell any product.";
        
        Map<String, Integer> all_product = new HashMap<>();
        
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = currentDateTime.format(formatter);
        
        ArrayList<History> history = DPD.get_Historys_date(schema,formattedDate);
        for (History i : history){
            if (i.getAction().equals("decrease")) {
                    String productname = i.getProduct_name();
                    Product p1 = DPD.get_product(schema, productname);
                    if(all_product.containsKey(p1.getName())){
                        all_product.put(p1.getName(), all_product.get(p1.getName())+i.getQuantity());
                    }
                    else{
                        all_product.put(p1.getName(), i.getQuantity());
                    }
            }
        }
        int maxCount = 0;
        
        for (Map.Entry<String, Integer> entry : all_product.entrySet()) {
            String productName = entry.getKey();
            int count = entry.getValue();
            
            if (count > maxCount) {
                maxCount = count;
                mostproduct = productName;
            }
        }
        
        return mostproduct;
    }
    
    public String dash2_month(String schema){
        String mostproduct = "You didn't sell any product.";
        
        Map<String, Integer> all_product = new HashMap<>();
        
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM");
        String formattedDate = currentDateTime.format(formatter);
        
        ArrayList<History> history = DPD.get_Historys_month(schema,formattedDate);
        ArrayList<History> usehistory = new ArrayList<>();

        for (History i : history){
            if(i.getAction_date().getYear()==currentDateTime.getYear()){
                usehistory.add(i);
            }
        }
        
        for (History i : usehistory){
            if (i.getAction().equals("decrease")) {
                    String productname = i.getProduct_name();
                    Product p1 = DPD.get_product(schema, productname);
                    if(all_product.containsKey(p1.getName())){
                        all_product.put(p1.getName(), all_product.get(p1.getName())+i.getQuantity());
                    }
                    else{
                        all_product.put(p1.getName(), i.getQuantity());
                    }
            }
        }
        int maxCount = 0;
        
        for (Map.Entry<String, Integer> entry : all_product.entrySet()) {
            String productName = entry.getKey();
            int count = entry.getValue();
            
            if (count > maxCount) {
                maxCount = count;
                mostproduct = productName;
            }
        }
        
        return mostproduct;
    }
    
    public String dash2_year(String schema){
        
        String mostproduct = "You didn't sell any product.";
        
        Map<String, Integer> all_product = new HashMap<>();
        
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
        String formattedDate = currentDateTime.format(formatter);
        
        ArrayList<History> history = DPD.get_Historys_year(schema,formattedDate);
        
        for (History i : history){
            if (i.getAction().equals("decrease")) {
                    String productname = i.getProduct_name();
                    Product p1 = DPD.get_product(schema, productname);
                    if(all_product.containsKey(p1.getName())){
                        all_product.put(p1.getName(), all_product.get(p1.getName())+i.getQuantity());
                    }
                    else{
                        all_product.put(p1.getName(), i.getQuantity());
                    }
            }
        }
        int maxCount = 0;
        
        for (Map.Entry<String, Integer> entry : all_product.entrySet()) {
            String productName = entry.getKey();
            int count = entry.getValue();
            
            if (count > maxCount) {
                maxCount = count;
                mostproduct = productName;
            }
        }
        
        return mostproduct;
    }
    // SubDashBoard_2 //
    
    // SubDashBoard_3 //
    
    public void dash3_comepare(Double income){
        if (income > 0){
            dashboard.getSdb3().getJcompareprice().setText(income+"฿");
            dashboard.getSdb3().getPempty2().add(dashboard.getSdb3().getJincrease());
        }
        else if (income < 0){
            dashboard.getSdb3().getJcompareprice().setText(income+"฿");
            dashboard.getSdb3().getPempty2().add(dashboard.getSdb3().getJdecrease());
        }
        else{
            dashboard.getSdb3().getJcompareprice().setText(income+"฿");
            dashboard.getSdb3().getPempty2().add(dashboard.getSdb3().getJnormal());
        }
    }
    
    public double dash3_day(String schema){
        double income = 0.0;
        
        double today_income = 0;
        double yesterday_income = 0;
        
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime yesterdayDateTime = currentDateTime.minus(1, ChronoUnit.DAYS);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String currentformat = currentDateTime.format(formatter);
        String yesterdayformat = yesterdayDateTime.format(formatter);
        
        ArrayList<History> history = DPD.get_Historys_date(schema,currentformat);
        for (History i : history){
            if (i.getAction().equals("decrease")) {
                    String productname = i.getProduct_name();
                    Product p1 = DPD.get_product(schema, productname);
                    today_income += p1.getPrice()*i.getQuantity();
            }
        }
        history = DPD.get_Historys_date(schema,yesterdayformat);
        for (History i : history){
            if (i.getAction().equals("decrease")) {
                    String productname = i.getProduct_name();
                    Product p1 = DPD.get_product(schema, productname);
                    yesterday_income += p1.getPrice()*i.getQuantity();
            }
        }
        income = today_income-yesterday_income;
        
        return income;
    }
    
    public double dash3_month(String schema){
        double income = 0.0;
        
        double today_income = 0;
        double yestermonth_income = 0;
        
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime yestermonthDateTime = currentDateTime.minus(1, ChronoUnit.MONTHS);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM");
        String currentformat = currentDateTime.format(formatter);
        String yestermonthformat = yestermonthDateTime.format(formatter);
        
        ////////////////current
        ArrayList<History> history = DPD.get_Historys_month(schema,currentformat);
        ArrayList<History> usehistory = new ArrayList<>();

        for (History i : history){
            if(i.getAction_date().getYear()==currentDateTime.getYear()){
                usehistory.add(i);
            }
        }
        
        for (History i : usehistory){
            if (i.getAction().equals("decrease")) {
                    String productname = i.getProduct_name();
                    Product p1 = DPD.get_product(schema, productname);
                    today_income += p1.getPrice()*i.getQuantity();
            }
        }
        
        ////////////////yestermonth
        history = DPD.get_Historys_month(schema,yestermonthformat);
        usehistory.clear();

        for (History i : history){
            if(i.getAction_date().getYear()==currentDateTime.getYear()){
                usehistory.add(i);
            }
        }
        
        for (History i : usehistory){
            if (i.getAction().equals("decrease")) {
                    String productname = i.getProduct_name();
                    Product p1 = DPD.get_product(schema, productname);
                    yestermonth_income += p1.getPrice()*i.getQuantity();
            }
        }
        income = today_income-yestermonth_income;
        
        return income;
    }
    
    public double dash3_year(String schema){
        double income = 0.0;
        
        double today_income = 0;
        double yesterday_income = 0;
        
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime yesterdayDateTime = currentDateTime.minus(1, ChronoUnit.YEARS);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
        String currentformat = currentDateTime.format(formatter);
        String yesterdayformat = yesterdayDateTime.format(formatter);
        
        ArrayList<History> history = DPD.get_Historys_year(schema,currentformat);
        for (History i : history){
            if (i.getAction().equals("decrease")) {
                    String productname = i.getProduct_name();
                    Product p1 = DPD.get_product(schema, productname);
                    today_income += p1.getPrice()*i.getQuantity();
            }
        }
        history = DPD.get_Historys_year(schema,yesterdayformat);
        for (History i : history){
            if (i.getAction().equals("decrease")) {
                    String productname = i.getProduct_name();
                    Product p1 = DPD.get_product(schema, productname);
                    yesterday_income += p1.getPrice()*i.getQuantity();
            }
        }
        income = today_income-yesterday_income;
        
        return income;
    }
    
    // SubDashBoard_3 //

    @Override
    public void actionPerformed(ActionEvent e) {
        
        // SubDashBoard_1 //
        if(e.getSource().equals(dashboard.getSdb1().getBday())){
            dashboard.getSdb1().getJprice().setText(dash1_day_income(schema)+""+"฿");
            System.out.println("Day");
        }
        else if(e.getSource().equals(dashboard.getSdb1().getBmonth())){
            dashboard.getSdb1().getJprice().setText(dash1_month_income(schema)+""+"฿");
            System.out.println("Month");
        }
        else if(e.getSource().equals(dashboard.getSdb1().getbYear())){
            dashboard.getSdb1().getJprice().setText(dash1_year_income(schema)+""+"฿");
            System.out.println("Year");
        }
        // SubDashBoard_1 //
        
        // SubDashBoard_2 //
        else if(e.getSource().equals(dashboard.getSdb2().getBday())){
            dashboard.getSdb2().getJproduct().setText(dash2_day(schema));
            System.out.println("Day");
        }
        else if(e.getSource().equals(dashboard.getSdb2().getBmonth())){
            dashboard.getSdb2().getJproduct().setText(dash2_month(schema));
            System.out.println("Month");
        }
        else if(e.getSource().equals(dashboard.getSdb2().getbYear())){
            dashboard.getSdb2().getJproduct().setText(dash2_year(schema));
            System.out.println("Year");
        }
        // SubDashBoard_2 //
        
        // SubDashBoard_3 //
        else if(e.getSource().equals(dashboard.getSdb3().getBday())){
            dash3_comepare(dash3_day(schema));
            System.out.println("Day");
        }
        else if(e.getSource().equals(dashboard.getSdb3().getBmonth())){
            dash3_comepare(dash3_month(schema));
            System.out.println("Month");
        }
        else if(e.getSource().equals(dashboard.getSdb3().getbYear())){
            dash3_comepare(dash3_year(schema));
            System.out.println("Year");
        }
        // SubDashBoard_3 //
        
        
    }
    
    public static void main(String[] args) {
        new DashBoardController("zedl3all","pj2");
    }
}
