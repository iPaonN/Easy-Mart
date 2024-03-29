package My_sql.ProjectData;

import java.time.*;
import java.time.format.*;

public class History {
    private int history_id;
    private int product_id;
    private String product_name;
    private int quantity;
    private String type;
    private String action;
    private LocalDateTime action_date;
    private String staff_user;
    private String time;

    public History(){
        
    }
    
    public History(int history_id, int product_id, String product_name, int quantity, String type, String action, LocalDateTime action_date, String staff_user, String time) {
        this.history_id = history_id;
        this.product_id = product_id;
        this.product_name = product_name;
        this.quantity = quantity;
        this.type = type;
        this.action = action;
        setAction_date(action_date);
        this.staff_user = staff_user;
        this.time = time;
    }
    
    public History(int history_id, int product_id, String product_name, int quantity, String type, String action, String action_date, String staff_user, String time) {
        this.history_id = history_id;
        this.product_id = product_id;
        this.product_name = product_name;
        this.quantity = quantity;
        this.type = type;
        this.action = action;
        setAction_date(action_date);
        this.staff_user = staff_user;
        this.time = time;
    }

    public int getHistory_id() {
        return history_id;
    }

    public void setHistory_id(int history_id) {
        this.history_id = history_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LocalDateTime getAction_date() {
        return this.action_date;
    }

    public void setAction_date(String action_date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY");
        this.action_date = LocalDateTime.parse(action_date, formatter);
    }

    public void setAction_date(LocalDateTime action_date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse("01-01-2022", formatter);

        this.action_date = action_date;
    }

    public String getStaff_user() {
        return staff_user;
    }

    public void setStaff_user(String staff_user) {
        this.staff_user = staff_user;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
}
