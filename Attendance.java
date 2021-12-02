package attendance.storage;

import attendance.template.*;
import java.util.*;

public class Attendance{
	private ArrayList<Listatt> attd;
	public Attendance(){
		attd = new ArrayList<Listatt>();
	}
	public void addEntry(Listatt ent){
		attd.add(ent);
	}
	
	public ArrayList<Listatt> getReg(){return attd;}
}