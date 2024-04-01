package UI.Controller;
import UI.View.Assistance;
import My_sql.ProjectData.DoProjectData;
import java.util.*;
import My_sql.ProjectData.History;
import UI.View.AssistantTable;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class AssistanceController implements MouseListener{
    private String username, projectname, schema;
    private Assistance view;
    private DoProjectData history;
    private ArrayList arr;
    
    public AssistanceController(String username, String projectname){
        this.username = username;
        this.projectname = projectname;
        this.schema = this.projectname;
        view = new Assistance();
        history = new DoProjectData();
        view.getBn1().addMouseListener(this);
        view.getBn2().addMouseListener(this);
        
    }
    
    public UI.View.Assistance getView(){
        return view;
    }
    
    public int increaseorNot(HashMap<String, Integer> add, HashMap<String, Integer> decrease, String action){
        int increase = 0;
        int decrea = 0;
        int result = 0;
        for (String i : add.keySet()) {
            if (decrease.get(i) > (add.get(i) * 0.8)){
                increase += 1;
            } else if (decrease.get(i) < (add.get(i) * 0.2)){
                decrea += 1;
            }
        }
        
        if ("add".equals(action)){
            result = increase;
        } else if ("decrease".equals(action)){
            result = decrea;
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
    
    @Override
    public void mouseClicked(MouseEvent e) {
        Object[][] data = {
            {"3/3/2024", "4:35 PM", "Coke"},
            {"3/3/2024", "4:34 PM", "Banana"},
            {"3/3/2024", "4:33 PM", "Tomato"}
        };
        if (e.getSource().equals(view.getBn1())){
            new AssistantTable(data);
        } else if (e.getSource().equals(view.getBn2())){
            new AssistantTable(data);
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
    public static void main(String[] args) {
        new AssistanceController("Thanasit", "pro1");
    }
}
