package UI.Controller;
import UI.View.Assistance;
import My_sql.ProjectData.DoProjectData;
import java.util.*;
import My_sql.ProjectData.History;
import UI.View.AssistantTable;
import java.awt.event.*;
import java.time.format.DateTimeFormatter;
import java.time.*;

public class AssistanceController implements ActionListener{
    private String username, projectname, schema;
    private Assistance view;
    private DoProjectData history;
    private ArrayList arr;
    private LocalDate today;
    private LocalTime time;
    
    public AssistanceController(String username, String projectname){
        this.username = username;
        this.projectname = projectname;
        this.schema = this.projectname;
        view = new Assistance();
        history = new DoProjectData();
        view.getBn1().addActionListener(this);
        view.getBn2().addActionListener(this);
        today = LocalDate.now();
        time = LocalTime.now();
    }
    
    public UI.View.Assistance getView(){
        return view;
    }
    //add
    public Object[][] increaseorNot(HashMap<String, Integer> add, HashMap<String, Integer> decrease){
        Object[][] namearray;
        int arraysize = add.size();
        int index = 0;
        namearray = new Object[arraysize][];

        for (String i : add.keySet()){
            if (decrease.get(i) >= (add.get(i) * 0.8)){
                namearray[index++] = new Object[]{today, getTime(), i};
            }
        }
        return namearray;
    }
    
    public Object[][] decreaseorNot(HashMap<String, Integer> add, HashMap<String, Integer> decrease){
        Object[][] namearray;
        int arraysize = add.size();
        int index = 0;
        namearray = new Object[arraysize][];

        for (String i : add.keySet()){
            if (decrease.get(i) < (add.get(i) * 0.2)){
                namearray[index++] = new Object[]{today, getTime(), i};
            }
        }
        return namearray;
    }
    
    public HashMap<String, Integer> addAmount(String schema, String month){
        ArrayList<History> arr = history.get_Historys_month(schema, month);
        HashMap<String, Integer> listall = new HashMap<String, Integer>();
        for (History i : arr){
            if ("add".equals(i.getAction())){
                if (listall.containsKey(i.getProduct_name())){
                    listall.put(i.getProduct_name(), listall.get(i.getProduct_name()) + i.getQuantity());
                } else {
                    listall.put(i.getProduct_name(), i.getQuantity());
                }
            } else if ("decrease".equals(i.getAction())) {
                if (!listall.containsKey(i.getProduct_name())) {
                    listall.put(i.getProduct_name(), 0);
                }
            }
        }
        return listall;
    }
    
    public HashMap<String, Integer> reduceAmount(String schema, String month){
        ArrayList<History> arr = history.get_Historys_month(schema, month);
        HashMap<String, Integer> listall = new HashMap<String, Integer>();
        for (History i : arr){
            if ("decrease".equals(i.getAction())){
                if (listall.containsKey(i.getProduct_name())){
                    listall.put(i.getProduct_name(), listall.get(i.getProduct_name()) + i.getQuantity());
                } else {
                    listall.put(i.getProduct_name(), i.getQuantity());
                }
            } else if ("add".equals(i.getAction())) {
                if (!listall.containsKey(i.getProduct_name())) {
                    listall.put(i.getProduct_name(), 0);
                }
            }
        }
        return listall;
    }
    
    public String getMonth(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM");
        String monthString = now.format(formatter);
        return monthString;
    }
    
    public String getTime(){
        int hour = time.getHour();
        int minute = time.getMinute();
        String amPm = (hour < 12) ? "AM" : "PM";
        hour = (hour == 0) ? 12 : (hour > 12) ? hour - 12 : hour;
        return String.format("%d:%02d %s\n", hour, minute, amPm);
    }
    public void actionPerformed(ActionEvent e) {
        HashMap<String, Integer> add = addAmount(schema, getMonth());
        HashMap<String, Integer> decrease = reduceAmount(schema, getMonth());
        if (e.getSource().equals(view.getBn2())){
            new AssistantTable(increaseorNot(add, decrease));
        } else if (e.getSource().equals(view.getBn1())){
            System.out.println(reduceAmount(schema, getMonth()));
            System.out.println(Arrays.toString(decreaseorNot(add, decrease)));
            new AssistantTable(decreaseorNot(add, decrease));
        }
    }
}
