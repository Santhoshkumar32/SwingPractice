package attendance;

import attendance.storage.*;
import attendance.template.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInput {
	public static Attendance reg;
	UserInput(){
		reg = new Attendance();
	}
    public static void main(String[] args){
		new UserInput();
		AttendanceLog obj=new AttendanceLog();
    }
}
class AttendanceLog extends JFrame
{
    Container c;
    JLabel l,l1,l2,l3,l4,l5;
    JTextField t1,t2;
    JRadioButton r1,r2;
    JButton b,k;
    JComboBox dept,date,month,year;
    String Dept[]
            ={
            "CSE","MECH","EEE","CIV","BIO-TECH"

    };
    String dates[]
            = { "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31" };
    String months[]
            = { "Jan", "feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sup", "Oct", "Nov", "Dec" };
     String years[]
            = {"2021","2022"};

    public AttendanceLog(){
        setTitle("Attendance Log");
        setBounds(250,250,100,100);
        c= getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));


        l=new JLabel("      ATTENDANCE LOG      ",SwingConstants.CENTER);
        l.setFont(new java.awt.Font("Arial",java.awt.Font.BOLD,25));

        l1=new JLabel(" Name :");
        t1=new JTextField(10);

        l2=new JLabel("Department :");
        dept = new JComboBox(Dept);

        l3=new JLabel("Date :");
        date = new JComboBox(dates);
        month = new JComboBox(months);
        year = new JComboBox(years);

        l4=new JLabel("Present/Absent :");
        r1=new JRadioButton("Present");
        r2=new JRadioButton("Absent");

        l5=new JLabel("RegNo :");
        t2=new JTextField(9);


        b=new JButton("ok");
        k=new JButton("View List");

        ButtonGroup bg=new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        JPanel panel=new JPanel(new GridLayout(1,2));
        panel.add(l);

        JPanel panel1=new JPanel(new GridLayout(3,2));
        panel1.add(l1);
        panel1.add(t1);
        panel1.add(l5);
        panel1.add(t2);
        panel1.add(l2);
        panel1.add(dept);


        JPanel panel2=new JPanel(new GridLayout(1,3));
        panel2.add(l4);
        panel2.add(r1);
        panel2.add(r2);

        JPanel panel3=new JPanel(new GridLayout(1,4,2,10));
        panel3.add(l3);
        panel3.add(date);
        month.setSelectedIndex(11);
        panel3.add(month);
        panel3.add(year);

        JPanel panel4=new JPanel(new GridLayout(1,2,10,10));
        panel4.add(b);
        panel4.add(k);

      

        c.add(panel);
        c.add(panel1);
        c.add(panel2);
        c.add(panel3);
        c.add(panel4);




        //ok
        b.addActionListener(e-> {
            if(t1.getText().equals("") || t2.getText().equals("") || (!r1.isSelected() && !r2.isSelected()) ) {
                JOptionPane.showConfirmDialog(null, "Please,enter your name and fill other details", "Attendance List", -1, JOptionPane.WARNING_MESSAGE);
            }
            else{

               String pr;
                if(r1.isSelected())
                     pr="Present";
                else
                     pr="Absent";

                 String Date=this.date.getSelectedItem()+"/"+(month.getSelectedIndex()+1)+"/"+year.getSelectedItem();
                 String dpmt=dept.getSelectedItem()+"";

                Listatt ent=new Listatt(t1.getText(),t2.getText(),dpmt,pr,Date);
                UserInput.reg.addEntry(ent);
				//list.display();

                JOptionPane.showConfirmDialog(null,"Attendance Log Updated","Attendance List",-1,JOptionPane.INFORMATION_MESSAGE,null);
            }

            }
        );
        //View List
       k.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //AttendanceLog al=new AttendanceLog();
                JFrame frame=new JFrame("List");
                frame.setBounds(250,250,500,500);
				
				Object regs[][] = new Object[UserInput.reg.getReg().size()][5];
				for (int i = 0; i < UserInput.reg.getReg().size() ; i++){
					regs[i] = UserInput.reg.getReg().get(i).getDetails();
				}
				String column[] = new String[5];
				column[0] = "Date";
				column[1] = "Name";
				column[2] = "Reg No";
				column[3] = "Dept";
				column[4] = "Present/Absent";
 				
                JTable table=new JTable(regs, column);
                JScrollPane pane=new JScrollPane(table);
                frame.add(pane);
                frame.setVisible(true);
            }
        });

        setVisible(true);
        setLayout(new FlowLayout());
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}