import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AddNewMedicine extends JFrame implements ActionListener
{

JFrame jf;

JTextField t1,t2,t3,t4,t5,t6,t8,t9,t10;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,ln;

JButton b0,b1,b2,b3;

JComboBox msname,tabtype;

String tabt;

Font f;

Date date1;
GregorianCalendar calendar;
String strDate;

Connection con;
PreparedStatement ps;
Statement stmt;
ResultSet rs;

DefaultTableModel model = new DefaultTableModel();

JTable tabGrid = new JTable(model);

JScrollPane scrlPane = new JScrollPane(tabGrid,
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

AddNewMedicine()
{

jf = new JFrame();

f = new Font("Segoe UI",Font.BOLD,15);

jf.setLayout(null);

jf.getContentPane().setBackground(new Color(210,220,230));

ln = new JLabel("New Medicine Details");
ln.setFont(new Font("Segoe UI",Font.BOLD,28));
ln.setBounds(650,20,400,40);
jf.add(ln);

l1 = new JLabel("Medicine Batch No");
l1.setBounds(420,120,200,30);
jf.add(l1);

t1 = new JTextField();
t1.setBounds(600,120,200,30);
jf.add(t1);

l2 = new JLabel("Medicine Name");
l2.setBounds(420,170,200,30);
jf.add(l2);

t2 = new JTextField();
t2.setBounds(600,170,200,30);
jf.add(t2);

l3 = new JLabel("Medicine Company");
l3.setBounds(420,220,200,30);
jf.add(l3);

t3 = new JTextField();
t3.setBounds(600,220,200,30);
jf.add(t3);

l4 = new JLabel("Medicine Quantity");
l4.setBounds(420,270,200,30);
jf.add(l4);

t4 = new JTextField();
t4.setBounds(600,270,200,30);
jf.add(t4);

l5 = new JLabel("Expiry Date");
l5.setBounds(420,320,200,30);
jf.add(l5);

t5 = new JTextField();
t5.setBounds(600,320,200,30);
jf.add(t5);

l6 = new JLabel("Purchase Date");
l6.setBounds(420,370,200,30);
jf.add(l6);

t6 = new JTextField();
t6.setBounds(600,370,200,30);
jf.add(t6);

date1 = new Date();
calendar = new GregorianCalendar();
calendar.setTime(date1);

strDate = calendar.get(Calendar.DATE)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.YEAR);

t6.setText(strDate);

l7 = new JLabel("Medicine Type");
l7.setBounds(850,120,200,30);
jf.add(l7);

tabtype = new JComboBox();
tabtype.addItem("--Select--");
tabtype.addItem("Tablet");
tabtype.addItem("Capsule");
tabtype.addItem("Syrup");
tabtype.addItem("Injection");
tabtype.addItem("Cream");
tabtype.addItem("Drop");

tabtype.setBounds(1030,120,200,30);
jf.add(tabtype);

tabtype.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
tabt = (String)tabtype.getSelectedItem();
}
});

l8 = new JLabel("Purchase Price");
l8.setBounds(850,170,200,30);
jf.add(l8);

t8 = new JTextField();
t8.setBounds(1030,170,200,30);
jf.add(t8);

l9 = new JLabel("Sale Price");
l9.setBounds(850,220,200,30);
jf.add(l9);

t9 = new JTextField();
t9.setBounds(1030,220,200,30);
jf.add(t9);

l10 = new JLabel("Rack No");
l10.setBounds(850,270,200,30);
jf.add(l10);

t10 = new JTextField();
t10.setBounds(1030,270,200,30);
jf.add(t10);

l11 = new JLabel("Supplier Name");
l11.setBounds(850,320,200,30);
jf.add(l11);

msname = new JComboBox();
msname.setBounds(1030,320,200,30);
jf.add(msname);

try
{

Class.forName("com.mysql.jdbc.Driver");

con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store","root","Vil@sShirke9822");

ps = con.prepareStatement("select sname from supplier");

rs = ps.executeQuery();

while(rs.next())
{

msname.addItem(rs.getString(1));

}

con.close();

}
catch(Exception e)
{

System.out.println(e);

}

b0 = new JButton("Save");
b0.setBounds(600,430,120,40);
jf.add(b0);
b0.addActionListener(this);

b1 = new JButton("Clear");
b1.setBounds(750,430,120,40);
jf.add(b1);
b1.addActionListener(this);

b2 = new JButton("View All");
b2.setBounds(900,430,120,40);
jf.add(b2);
b2.addActionListener(this);

b3 = new JButton("Back");
b3.setBounds(1050,430,120,40);
jf.add(b3);
b3.addActionListener(this);

scrlPane.setBounds(50,500,1450,300);

jf.add(scrlPane);

tabGrid.setRowHeight(25);
tabGrid.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

model.addColumn("Batch No");
model.addColumn("Name");
model.addColumn("Company");
model.addColumn("Qty");
model.addColumn("Exp Date");
model.addColumn("Pur Date");
model.addColumn("Type");
model.addColumn("Pur Price");
model.addColumn("Sale Price");
model.addColumn("Rack");
model.addColumn("Supplier ID");
model.addColumn("Supplier Name");

tabGrid.getColumnModel().getColumn(0).setPreferredWidth(120);
tabGrid.getColumnModel().getColumn(1).setPreferredWidth(150);
tabGrid.getColumnModel().getColumn(2).setPreferredWidth(150);
tabGrid.getColumnModel().getColumn(3).setPreferredWidth(80);
tabGrid.getColumnModel().getColumn(4).setPreferredWidth(120);
tabGrid.getColumnModel().getColumn(5).setPreferredWidth(120);
tabGrid.getColumnModel().getColumn(6).setPreferredWidth(100);
tabGrid.getColumnModel().getColumn(7).setPreferredWidth(100);
tabGrid.getColumnModel().getColumn(8).setPreferredWidth(100);
tabGrid.getColumnModel().getColumn(9).setPreferredWidth(80);
tabGrid.getColumnModel().getColumn(10).setPreferredWidth(120);
tabGrid.getColumnModel().getColumn(11).setPreferredWidth(150);

jf.setTitle("Add New Medicine");

jf.setExtendedState(JFrame.MAXIMIZED_BOTH);

jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

jf.setVisible(true);

}

public void actionPerformed(ActionEvent ae)
{

if(ae.getSource()==b3)
{
jf.dispose();
new MainMenu();
}

if(ae.getSource()==b1)
{

t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");
t8.setText("");
t9.setText("");
t10.setText("");

}

if(ae.getSource()==b0)
{

try
{

Class.forName("com.mysql.jdbc.Driver");

con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store","root","Vil@sShirke9822");

String batch = t1.getText();
String name = t2.getText();
String company = t3.getText();
String qty = t4.getText();
String exp = t5.getText();
String purdate = t6.getText();
String type = (String)tabtype.getSelectedItem();
String purprice = t8.getText();
String saleprice = t9.getText();
String rack = t10.getText();
String sname = (String)msname.getSelectedItem();

String sid="";

PreparedStatement ps1 = con.prepareStatement("select sid from supplier where sname=?");
ps1.setString(1,sname);

ResultSet rs1 = ps1.executeQuery();

if(rs1.next())
{
sid = rs1.getString(1);
}

ps = con.prepareStatement("insert into medicine values(?,?,?,?,?,?,?,?,?,?,?,?)");

ps.setString(1,batch);
ps.setString(2,name);
ps.setString(3,company);
ps.setString(4,qty);
ps.setString(5,exp);
ps.setString(6,purdate);
ps.setString(7,type);
ps.setString(8,purprice);
ps.setString(9,saleprice);
ps.setString(10,rack);
ps.setString(11,sid);
ps.setString(12,sname);

ps.executeUpdate();

JOptionPane.showMessageDialog(null,"Medicine Saved Successfully");

con.close();

}
catch(Exception e)
{
System.out.println(e);
}

}

if(ae.getSource()==b2)
{

int r=0;

model.setRowCount(0);

try
{

Class.forName("com.mysql.jdbc.Driver");

con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store","root","Vil@sShirke9822");

stmt = con.createStatement();

rs = stmt.executeQuery("select * from medicine");

while(rs.next())
{

model.insertRow(r++,new Object[]{
rs.getString(1),
rs.getString(2),
rs.getString(3),
rs.getString(4),
rs.getString(5),
rs.getString(6),
rs.getString(7),
rs.getString(8),
rs.getString(9),
rs.getString(10),
rs.getString(11),
rs.getString(12)
});

}

con.close();

}
catch(Exception e)
{
System.out.println(e);
}

}

}

public static void main(String args[])
{
new AddNewMedicine();
}

}