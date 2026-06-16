import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class UpdateMedicine extends JFrame implements ActionListener
{

JFrame jf;

JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;

JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,ln;

JButton b0,b1,b2,b3,b4;

JComboBox msname,tabtype;

String s,sid1,tabt;

Font f;

Connection con;
PreparedStatement ps;
Statement stmt;
ResultSet rs;

DefaultTableModel model = new DefaultTableModel();
JTable tabGrid = new JTable(model);
JScrollPane scrlPane = new JScrollPane(tabGrid);

UpdateMedicine()
{

jf=new JFrame();

f = new Font("Times New Roman",Font.BOLD,20);

jf.setLayout(null);

/* SCREEN SIZE */

Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
int width = d.width;
int height = d.height;

int centerX = width/2;
int startX = centerX - 450;
int startY = 120;


/* TITLE */

ln=new JLabel("Update Medicine");
ln.setFont(new Font("Times New Roman",Font.BOLD,35));
ln.setBounds(centerX-150,30,400,40);
jf.add(ln);


/* LEFT SIDE */

l1 = new JLabel("Medicine Batch no*");
l1.setBounds(startX,startY,200,30);
jf.add(l1);

t1 = new JTextField();
t1.setBounds(startX+200,startY,200,30);
jf.add(t1);


l2 = new JLabel("Medicine name*");
l2.setBounds(startX,startY+50,200,30);
jf.add(l2);

t2 = new JTextField();
t2.setBounds(startX+200,startY+50,200,30);
jf.add(t2);


l3 = new JLabel("Medicine company*");
l3.setBounds(startX,startY+100,200,30);
jf.add(l3);

t3 = new JTextField();
t3.setBounds(startX+200,startY+100,200,30);
jf.add(t3);


l4 = new JLabel("Medicine quantity*");
l4.setBounds(startX,startY+150,200,30);
jf.add(l4);

t4= new JTextField();
t4.setBounds(startX+200,startY+150,200,30);
jf.add(t4);


l5= new JLabel("Med expiry date*");
l5.setBounds(startX,startY+200,200,30);
jf.add(l5);

t5= new JTextField();
t5.setBounds(startX+200,startY+200,200,30);
jf.add(t5);


l6= new JLabel("Med purchase date*");
l6.setBounds(startX,startY+250,200,30);
jf.add(l6);

t6= new JTextField();
t6.setBounds(startX+200,startY+250,200,30);
jf.add(t6);


/* RIGHT SIDE */

l7 = new JLabel("Medicine type*");
l7.setBounds(startX+450,startY,200,30);
jf.add(l7);

t7 = new JTextField();
t7.setBounds(startX+700,startY,200,30);
jf.add(t7);


tabtype=new JComboBox();

tabtype.addItem("--type--");
tabtype.addItem("Tablet");
tabtype.addItem("Capsule");
tabtype.addItem("Syrup");
tabtype.addItem("Insulin");
tabtype.addItem("Cream");
tabtype.addItem("Balm");
tabtype.addItem("Drop");
tabtype.addItem("Granul");
tabtype.addItem("Oil");
tabtype.addItem("Powder");

tabtype.setBounds(startX+600,startY,90,30);
jf.add(tabtype);


tabtype.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
tabt =(String)tabtype.getSelectedItem();
t7.setText(tabt);
}
});


l8= new JLabel("Medicine purchase price*");
l8.setBounds(startX+450,startY+50,200,30);
jf.add(l8);

t8 = new JTextField();
t8.setBounds(startX+700,startY+50,200,30);
jf.add(t8);


l9 = new JLabel("Medicine sale price*");
l9.setBounds(startX+450,startY+100,200,30);
jf.add(l9);

t9 = new JTextField();
t9.setBounds(startX+700,startY+100,200,30);
jf.add(t9);


l10 = new JLabel("Medicine rack no*");
l10.setBounds(startX+450,startY+150,200,30);
jf.add(l10);

t10 = new JTextField();
t10.setBounds(startX+700,startY+150,200,30);
jf.add(t10);


l11 = new JLabel("Supplier name*");
l11.setBounds(startX+450,startY+200,200,30);
jf.add(l11);

t11 = new JTextField();
t11.setBounds(startX+700,startY+200,200,30);
jf.add(t11);


l12 = new JLabel("Supplier id");
l12.setBounds(startX+450,startY+250,200,30);
jf.add(l12);

t12 = new JTextField();
t12.setBounds(startX+700,startY+250,200,30);
jf.add(t12);


/* SUPPLIER COMBO */

msname=new JComboBox();
msname.setBounds(startX+600,startY+200,90,30);
jf.add(msname);

msname.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
s =(String)msname.getSelectedItem();
t11.setText(s);
}
});


/* DATABASE */

try
{
Class.forName("com.mysql.jdbc.Driver");

con=DriverManager.getConnection(
"jdbc:mysql://localhost:3306/medical_store",
"root",
"Vil@sShirke9822");

ps=con.prepareStatement("select sid,sname from supplier");
rs=ps.executeQuery();

while(rs.next())
{
sid1=rs.getString(1);
String sname1=rs.getString(2);
msname.addItem(sname1);
}

con.close();
}
catch(Exception e)
{
System.out.println(e);
}


/* BUTTONS */

b0 = new JButton("Open");
b0.setBounds(centerX-300,startY+320,120,40);
jf.add(b0);
b0.addActionListener(this);

b1 = new JButton("Update");
b1.setBounds(centerX-150,startY+320,120,40);
jf.add(b1);
b1.addActionListener(this);

b2= new JButton("Clear");
b2.setBounds(centerX,startY+320,120,40);
jf.add(b2);
b2.addActionListener(this);

b3 = new JButton("All");
b3.setBounds(centerX+150,startY+320,120,40);
jf.add(b3);
b3.addActionListener(this);

b4 = new JButton("Back");
b4.setBounds(centerX+300,startY+320,120,40);
jf.add(b4);
b4.addActionListener(this);


/* TABLE */

scrlPane.setBounds(centerX-600,startY+400,1200,350);
jf.add(scrlPane);


model.addColumn("M_BNO");
model.addColumn("M_NAME");
model.addColumn("M_COMPANY");
model.addColumn("M_QUANTITY");
model.addColumn("M_EXPDATE");
model.addColumn("M_PURDATE");
model.addColumn("M_TYPE");
model.addColumn("M_SALEPRICE");
model.addColumn("M_PURPRICE");
model.addColumn("M_RACKNO");
model.addColumn("M_SID");
model.addColumn("M_SNAME");


jf.setExtendedState(JFrame.MAXIMIZED_BOTH);

jf.setTitle("Update Medicine");

jf.getContentPane().setBackground(new Color(210,220,230));

jf.setVisible(true);

}


/* BUTTON ACTION */

public void actionPerformed(ActionEvent ae)
{

/* BACK */

if(ae.getSource()==b4)
{
jf.dispose();
new MainMenu();
}

/* OPEN */

if(ae.getSource()==b0)
{
try
{
Class.forName("com.mysql.jdbc.Driver");

con=DriverManager.getConnection(
"jdbc:mysql://localhost:3306/medical_store",
"root",
"Vil@sShirke9822");

ps=con.prepareStatement(
"select * from medicine where mname='"+t2.getText()+"' or mbno='"+t1.getText()+"'");

rs=ps.executeQuery();

while(rs.next())
{

t1.setText(rs.getString(1));
t2.setText(rs.getString(2));
t3.setText(rs.getString(3));
t4.setText(rs.getString(4));
t5.setText(rs.getString(5));
t6.setText(rs.getString(6));
t7.setText(rs.getString(7));
t8.setText(rs.getString(8));
t9.setText(rs.getString(9));
t10.setText(rs.getString(10));
t12.setText(rs.getString(11));
t11.setText(rs.getString(12));

}

con.close();
}
catch(Exception e)
{
System.out.println(e);
}
}


/* UPDATE */

if(ae.getSource()==b1)
{
try
{
Class.forName("com.mysql.jdbc.Driver");

con=DriverManager.getConnection(
"jdbc:mysql://localhost:3306/medical_store",
"root",
"Vil@sShirke9822");

stmt=con.createStatement();

String str="UPDATE medicine SET mname='"+t2.getText()+"',mcompany='"+t3.getText()+"',mqty='"+t4.getText()+"',mexpdate='"+t5.getText()+"',mpurdate='"+t6.getText()+"',mtype='"+t7.getText()+"',mpurprice='"+t8.getText()+"',msaleprice='"+t9.getText()+"',mrackno='"+t10.getText()+"',sid='"+t12.getText()+"',sname='"+t11.getText()+"' where mbno='"+t1.getText()+"'";

stmt.executeUpdate(str);

JOptionPane.showMessageDialog(null,"Record Updated");

con.close();
}
catch(Exception e)
{
System.out.println(e);
}
}


/* CLEAR */

if(ae.getSource()==b2)
{

t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");
t6.setText("");
t7.setText("");
t8.setText("");
t9.setText("");
t10.setText("");
t11.setText("");
t12.setText("");

}


/* ALL */

if(ae.getSource()==b3)
{
	
	 model.setRowCount(0); 

int r=0;

try
{
Class.forName("com.mysql.jdbc.Driver");

con=DriverManager.getConnection(
"jdbc:mysql://localhost:3306/medical_store",
"root",
"Vil@sShirke9822");

stmt=con.createStatement();

rs=stmt.executeQuery("select * from medicine");

while(rs.next())
{

model.insertRow(r++, new Object[]{

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
new UpdateMedicine();
}

}