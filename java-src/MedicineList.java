import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;

public class MedicineList extends JFrame implements ActionListener
{

JFrame jf = new JFrame();

JLabel ln;

JButton b1;   // BACK BUTTON

Connection con;
PreparedStatement ps;
Statement stmt;
ResultSet rs;

DefaultTableModel model = new DefaultTableModel();
JTable tabGrid = new JTable(model);
JScrollPane scrlPane = new JScrollPane(tabGrid);

public MedicineList()
{

jf.setLayout(null);

/* SCREEN SIZE */

Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
int width = d.width;
int height = d.height;

int centerX = width/2;


/* TITLE */

ln = new JLabel("Stock Of Medicines", JLabel.CENTER);
ln.setFont(new Font("Segoe UI", Font.BOLD, 36));
ln.setForeground(new Color(0,102,204));
ln.setBounds(centerX-250,20,500,50);
jf.add(ln);


/* BACK BUTTON */

b1 = new JButton("Back");
b1.setFont(new Font("Segoe UI",Font.BOLD,16));
b1.setBounds(centerX+450,30,120,40);
jf.add(b1);

b1.addActionListener(this);


/* TABLE STYLE */

tabGrid.setFont(new Font("Segoe UI", Font.PLAIN, 15));
tabGrid.setRowHeight(30);
tabGrid.setGridColor(Color.LIGHT_GRAY);
tabGrid.setSelectionBackground(new Color(184,207,229));

JTableHeader header = tabGrid.getTableHeader();
header.setFont(new Font("Segoe UI", Font.BOLD, 16));
header.setBackground(new Color(0,120,215));
header.setForeground(Color.WHITE);


/* ALTERNATE ROW COLOR */

tabGrid.setDefaultRenderer(Object.class,new DefaultTableCellRenderer()
{
public Component getTableCellRendererComponent(JTable table,Object value,
boolean isSelected,boolean hasFocus,int row,int column)
{

Component c = super.getTableCellRendererComponent(
table,value,isSelected,hasFocus,row,column);

if(!isSelected)
{
if(row%2==0)
c.setBackground(new Color(245,245,245));
else
c.setBackground(Color.white);
}

return c;

}
});


/* SCROLLPANE FULLSCREEN */

scrlPane.setBounds(20,100,width-40,height-180);
scrlPane.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));

jf.add(scrlPane);


/* TABLE COLUMNS */

model.addColumn("Batchno");
model.addColumn("Name");
model.addColumn("Company");
model.addColumn("Quantity");
model.addColumn("Expirydate");
model.addColumn("Purchasedate");
model.addColumn("Type");
model.addColumn("Purchaseprice");
model.addColumn("Saleprice");
model.addColumn("Rackno");
model.addColumn("Supplierid");
model.addColumn("Suppliername");


int r = 0;

try
{

Class.forName("com.mysql.jdbc.Driver");

con = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/medical_store",
"root",
"Vil@sShirke9822");

System.out.println("Connected to database.");

stmt = con.createStatement(
ResultSet.TYPE_SCROLL_SENSITIVE,
ResultSet.CONCUR_UPDATABLE);

rs = stmt.executeQuery("select * from medicine");

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

catch(SQLException se)
{
System.out.println(se);
JOptionPane.showMessageDialog(null,"SQL Error:"+se);
}

catch(Exception e)
{
System.out.println(e);
JOptionPane.showMessageDialog(null,"Error:"+e);
}


/* FRAME SETTINGS */

jf.setTitle("Medicine List");

jf.setExtendedState(JFrame.MAXIMIZED_BOTH);   // FULLSCREEN

jf.getContentPane().setBackground(new Color(210,220,230));

jf.setVisible(true);

}


/* BUTTON ACTION */

public void actionPerformed(ActionEvent ae)
{

if(ae.getSource()==b1)
{
jf.dispose();
new MainMenu();
}

}


public static void main(String args[])
{
new MedicineList();
}

}