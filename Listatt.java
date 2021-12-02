package attendance.template;

import javax.swing.*;
import java.util.ArrayList;

public class Listatt {
    String name;
    String regno;
    String dept;
    String pa;
    String date;

    public Listatt(){
        name=null;
        regno=null;
        dept=null;
        pa=null;
        date=null;
    }
    public Listatt(String name,String regno,String dept,String pa,String date) {
        this.name = name;
        this.regno = regno;
        this.dept = dept;
        this.pa = pa;
        this.date = date;

    }


    public String[] getDetails(){
        String details[] = new String[5];
		details[0] = date;
		details[1] = name;
		details[2] = regno;
		details[3] = dept;
		details[4] = pa;
		return details;
    }
}