package UI.Controller;

import My_sql.ProjectData.DoProjectData;
import My_sql.ProjectData.History;
import My_sql.ProjectData.Product;
import My_sql.UserData.DoUserData;
import UI.View.DashBoard;
import UI.Model.DashBoardModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import javax.swing.JOptionPane;



public class DashBoardController implements ActionListener {
    private DashBoard view;
    private DashBoardModel model;
    private String username, projectname, schema;
    private DoProjectData promanager;
    private DoUserData manager;
    private History his;
    
    public DashBoardController(String username, String projectname) {
        view = new DashBoard();
        view.setSubDashBoard1ActionListener(this);
        view.setSubDashBoard2ActionListener(this);
        view.setSubDashBoard3ActionListener(this);
        view.getmain().setVisible(true);
        model = new DashBoardModel(this.username, this.projectname);
        schema = username+"_"+projectname;
        promanager = new DoProjectData();
        manager = new DoUserData();
    }
 
    // SubProduct 1 Method
    
    public double day_income(String schema,String Date){
        double income = 0;
        ArrayList<History> history = promanager.get_Historys_date(schema,Date);
        for (History i : history){
            if (i.getAction() == "decrease") {
                    String productname = i.getProduct_name();
                    Product p1 = promanager.get_product(schema, productname);
                    income += p1.getPrice()*i.getQuantity();
            }
        }
        return income;
    }
    
    public double week_income(String schema, String today_date) {
        double income = 0;
        LocalDate today = LocalDate.parse(today_date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        for (int i = 0; i < 7; i++) {
            LocalDate currentDate = today.minusDays(i);
            String currentDateStr = currentDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            ArrayList<History> historyForDate = promanager.get_Historys_date(schema, currentDateStr);
            for (History j : historyForDate) {
                if (j.getAction().equals("decrease")) {
                    String productname = j.getProduct_name();
                    Product p1 = promanager.get_product(schema, productname);
                    income += p1.getPrice() * j.getQuantity();
                }
            }
        }
        return income;
    }

        
    public double year_income(String schema, int year) {
        double income = 0;
        LocalDate currentDate = LocalDate.now();
        LocalDate startDate = LocalDate.of(year, 1, 1);
        LocalDate endDate = LocalDate.of(year, 12, 31);


        while (!currentDate.isBefore(startDate) && !currentDate.isAfter(endDate)) {
            String currentDateStr = currentDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            ArrayList<History> historyForDate = promanager.get_Historys_date(schema, currentDateStr);
            for (History i : historyForDate) {
                if (i.getAction().equals("decrease")) {
                    String productname = i.getProduct_name();
                    Product p1 = promanager.get_product(schema, productname);
                    income += p1.getPrice() * i.getQuantity();
                }
            }
            currentDate = currentDate.minusDays(1);
        }
        return income;
    }
    
    // SubProduct 2  Method
    public String day_product(String schema, String Date) {
        String bestProduct = "";
        int maxQuantity = 0;
        ArrayList<History> history = promanager.get_Historys_date(schema, Date);
        HashMap<String, Integer> productQuantityMap = new HashMap<>();

        for (History i : history) {
            if (i.getAction().equals("decrease")) {
                String productName = i.getProduct_name();
                productQuantityMap.put(productName, productQuantityMap.getOrDefault(productName, 0) + i.getQuantity());
            }
        }

        for (Map.Entry<String, Integer> entry : productQuantityMap.entrySet()) {
            if (entry.getValue() > maxQuantity) {
                bestProduct = entry.getKey();
                maxQuantity = entry.getValue();
            }
        }

        return bestProduct;
    }
    
    public String week_product(String schema, String today_date) {
        LocalDate today = LocalDate.parse(today_date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate startOfWeek = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        String startOfWeekStr = startOfWeek.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        Map<String, Integer> productSalesMap = new HashMap<>();
        for (int i = 0; i < 7; i++) {
            LocalDate currentDate = startOfWeek.plusDays(i);
            String currentDateStr = currentDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            ArrayList<History> historyForDate = promanager.get_Historys_date(schema, currentDateStr);
            for (History j : historyForDate) {
                if (j.getAction().equals("decrease")) {
                    String productName = j.getProduct_name();
                    productSalesMap.put(productName, productSalesMap.getOrDefault(productName, 0) + j.getQuantity());
                }
            }
        }

        int maxQuantity = 0;
        String bestProduct = "";
        for (Map.Entry<String, Integer> entry : productSalesMap.entrySet()) {
            if (entry.getValue() > maxQuantity) {
                bestProduct = entry.getKey();
                maxQuantity = entry.getValue();
            }
        }

        return bestProduct;
    }
    
    public String year_product(String schema, int year) {
        LocalDate startDate = LocalDate.of(year, 1, 1);
        String startDateStr = startDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate endDate = LocalDate.of(year, 12, 31);
        String endDateStr = endDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        Map<String, Integer> productSalesMap = new HashMap<>();
        while (!startDate.isAfter(endDate)) {
            String currentDateStr = startDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            ArrayList<History> historyForDate = promanager.get_Historys_date(schema, currentDateStr);
            for (History i : historyForDate) {
                if (i.getAction().equals("decrease")) {
                    String productName = i.getProduct_name();
                    productSalesMap.put(productName, productSalesMap.getOrDefault(productName, 0) + i.getQuantity());
                }
            }
            startDate = startDate.plusDays(1);
        }

        int maxQuantity = 0;
        String bestProduct = "";
        for (Map.Entry<String, Integer> entry : productSalesMap.entrySet()) {
            if (entry.getValue() > maxQuantity) {
                bestProduct = entry.getKey();
                maxQuantity = entry.getValue();
            }
        }

        return bestProduct;
    }

    
    
    // SubProduct 3  Method
    public double day_compareincome(String schema, String today_date) {
        double today_income = day_income(schema, today_date);
        LocalDate yesterday = LocalDate.parse(today_date, DateTimeFormatter.ofPattern("dd-MM-yyyy")).minusDays(1);
        String yesterdayStr = yesterday.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        double yesterday_income = day_income(schema, yesterdayStr);
        double result = today_income - yesterday_income;
        if (result >= 0) {
            view.getSdb3().setsymbol("+");
        } else if (result < 0) {
            view.getSdb3().setsymbol("-");
            result *= -1;
        }
        return result;
    }
    
    public double week_compareincome(String schema, String today_date) {
        double thisWeekIncome = week_income(schema, today_date);
        double lastWeekIncome = 0;

        LocalDate today = LocalDate.parse(today_date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate lastWeekStart = today.minusDays(7);
        LocalDate lastWeekEnd = today.minusDays(1);

        for (LocalDate date = lastWeekStart; !date.isAfter(lastWeekEnd); date = date.plusDays(1)) {
            String currentDateStr = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            lastWeekIncome += day_income(schema, currentDateStr);
        }

        double result = thisWeekIncome - lastWeekIncome;
        if (result >= 0) {
            view.getSdb3().setsymbol("+");
        } else {
            view.getSdb3().setsymbol("-");
            result *= -1;
        }

        return result;
    }
    
    public double year_compareincome(String schema, int year) {
        double thisYearIncome = year_income(schema, year);
        double lastYearIncome = year_income(schema, year - 1);

        double result = thisYearIncome - lastYearIncome;
        if (result >= 0) {
            view.getSdb3().setsymbol("+");
        } else {
            view.getSdb3().setsymbol("-");
            result *= -1;
        }

        return result;
    }
    
    public static String getTodayDate() {
        LocalDate currentDate = LocalDate.now();
        return currentDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
    
    // Action Event
    @Override
    public void actionPerformed(ActionEvent e) {
        // SubProduct 1
        if (e.getSource().equals(view.getSdb1().getBday())){
            view.getSdb1().setprice(String.valueOf(day_income(schema,getTodayDate())) + "฿");
        } else if (e.getSource().equals(view.getSdb1().getBweek())) {
            view.getSdb1().setprice(String.valueOf(week_income(schema,getTodayDate())) + "฿");
        } else if (e.getSource().equals(view.getSdb1().getbYear())) {
            view.getSdb1().setprice(String.valueOf(year_income(schema,2024)) + "฿");
        }
        // SubProduct 2
        else if (e.getSource().equals(view.getSdb2().getBday())) {
            view.getSdb2().setproduct(day_product(schema,getTodayDate()));
        } else if (e.getSource().equals(view.getSdb2().getBweek())) {
            view.getSdb2().setproduct(week_product(schema,getTodayDate()));
        } else if (e.getSource().equals(view.getSdb2().getbYear())) {
            view.getSdb2().setproduct(year_product(schema,2024));
        }
        // SubProduct 3
        else if (e.getSource().equals(view.getSdb3().getBday())) {
            view.getSdb3().setcompareprice(String.valueOf(day_compareincome(schema,getTodayDate())) + "฿");
        } else if (e.getSource().equals(view.getSdb3().getBweek())) {
            view.getSdb3().setcompareprice(String.valueOf(week_compareincome(schema,getTodayDate())) + "฿");
        } else if (e.getSource().equals(view.getSdb3().getbYear())) {
            view.getSdb3().setcompareprice(String.valueOf(year_compareincome(schema,2024)) + "฿");
        }
    }
    
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void main(String[] args) {
        new DashBoardController("test","test");
    }
}
