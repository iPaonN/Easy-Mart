package UI.Controller;
import UI.View.Assistance;
import My_sql.ProjectData.DoProjectData;
import java.util.*;
import My_sql.ProjectData.History;
import UI.View.AssistantTable;
import java.awt.event.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class AssistanceController implements ActionListener{
    private String username, projectname, schema;
    private Assistance view;
    private DoProjectData history;
    private ArrayList arr, data1, data2, data3, data4;
    private ArrayList<Object> datalist1, datalist2;
    
    public AssistanceController(String username, String projectname){
        this.username = username;
        this.projectname = projectname;
        this.schema = this.projectname;
        view = new Assistance();
        history = new DoProjectData();
        view.getBn1().addActionListener(this);
        view.getBn2().addActionListener(this);  
//        data3 = increaseorNot(addAmount(schema, getMonth()), decreaseAmount(schema, getMonth()), "add");
//        data4 = increaseorNot(addAmount(schema, getMonth()), decreaseAmount(schema, getMonth()), "decrease");
        
    }
    
    public UI.View.Assistance getView(){
        return view;
    }
    
    public ArrayList increaseorNot(HashMap<String, Integer> add, HashMap<String, Integer> decrease, String action){
         ArrayList result = null;
        for (String i : add.keySet()) {
            if (decrease.get(i) > (add.get(i) * 0.8)){
                data1.add(i);
            } else if (decrease.get(i) < (add.get(i) * 0.2)){
                data2.add(i);
            }
        }
        
        if ("add".equals(action)){
            result = data1;
        } else if ("decrease".equals(action)){
            result = data2;
        }
        return result;
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
    
    public HashMap<String, Integer> decreaseAmount(String schema, String month){
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
    
    public void actionPerformed(ActionEvent e) {
        data3 = increaseorNot(addAmount(schema, getMonth()), decreaseAmount(schema, getMonth()), "add");
        data4 = increaseorNot(addAmount(schema, getMonth()), decreaseAmount(schema, getMonth()), "decrease");
        if (e.getSource().equals(view.getBn2())){
            for (int i = 0; i < data3.size(); i++){
                datalist1.add(new Object[]{getMonth(), "", data3.get(i)});
            }
            Object[][] dataarray = datalist1.toArray(new Object[datalist1.size()][]);
//            Object[][] dataarray ={
//                {"3/3/2024", "4:35 PM", "Coke"},
//                {"3/3/2024", "4:34 PM", "Banana"}
//             };
            new AssistantTable(dataarray);
        } else if (e.getSource().equals(view.getBn1())){
            for (int i = 0; i < data4.size(); i++){
                datalist2.add(new Object[]{getMonth(), "", data4.get(i)});
            }
            Object[][] dataarra = datalist2.toArray(new Object[datalist2.size()][]);
//            Object[][] dataarra ={
//                {"3/3/2024", "4:35 PM", "Coke"},
//                {"3/3/2024", "4:34 PM", "Banana"},
//                {"3/3/2024", "", "Tomato"}
//             };
            new AssistantTable(dataarra);
        }
    }
    public static void main(String[] args) {
        new AssistanceController("Thanasit", "pro1");
    }
}
