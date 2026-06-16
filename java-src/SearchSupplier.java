import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class SearchSupplier extends JFrame implements ActionListener
{
    JFrame jf;
    JTextField t1,t2,t3,t4,t5;
    JLabel l1,l2,l3,l4,l5,l6;
    JButton b0,b1,b2,b3;
    Font f;

    Connection con;
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;

    DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);

    SearchSupplier()
    {
        jf=new JFrame();
        jf.setLayout(null);

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screen.width;
        int height = screen.height;

        int centerX = width/2;

        f = new Font("Times New Roman",Font.BOLD,20);

        l6=new JLabel("Search Supplier");
        l6.setFont(new Font("Times New Roman",Font.BOLD,28));
        l6.setBounds(centerX-120,40,300,40);
        l6.setForeground(Color.blue);
        jf.add(l6);

        int labelX = centerX - 220;
        int textX = centerX - 40;

        l1= new JLabel("Search by id *");
        l1.setBounds(labelX,140,150,25);
        jf.add(l1);

        t1=new JTextField(20);
        t1.setBounds(textX,140,120,25);
        jf.add(t1);

        l2 = new JLabel("Search by name *");
        l2.setBounds(labelX,180,150,25);
        jf.add(l2);

        t2=new JTextField(20);
        t2.setBounds(textX,180,220,25);
        jf.add(t2);

        l3 = new JLabel("Supplier address");
        l3.setBounds(labelX,220,150,25);
        jf.add(l3);

        t3=new JTextField(20);
        t3.setBounds(textX,220,300,25);
        jf.add(t3);

        l4 = new JLabel("Supplier phone no");
        l4.setBounds(labelX,260,150,25);
        jf.add(l4);

        t4=new JTextField(20);
        t4.setBounds(textX,260,150,25);
        jf.add(t4);

        l5 = new JLabel("Supplier email id");
        l5.setBounds(labelX,300,150,25);
        jf.add(l5);

        t5=new JTextField(20);
        t5.setBounds(textX,300,250,25);
        jf.add(t5);

        int buttonY = 360;

        b0 = new JButton("Search");
        b0.setBounds(centerX-220,buttonY,120,40);
        jf.add(b0);
        b0.addActionListener(this);

        b1 = new JButton("Clear");
        b1.setBounds(centerX-80,buttonY,120,40);
        jf.add(b1);
        b1.addActionListener(this);

        b2= new JButton("All");
        b2.setBounds(centerX+60,buttonY,120,40);
        jf.add(b2);
        b2.addActionListener(this);

        b3 = new JButton("Back");
        b3.setBounds(centerX+200,buttonY,120,40);
        jf.add(b3);
        b3.addActionListener(this);

        scrlPane.setBounds(100,440,width-200,height-520);
        jf.add(scrlPane);

        tabGrid.setFont(new Font ("Times New Roman",0,15));

        model.addColumn("S_ID");
        model.addColumn("S_NAME");
        model.addColumn("S_ADDRESS");
        model.addColumn("S_PHONENO");
        model.addColumn("S_EMAILID");

        jf.setTitle("Search Supplier");
        jf.setSize(width,height);
        jf.setLocation(0,0);
        jf.setResizable(true);

        jf.getContentPane().setBackground(new Color(240,240,240));

        jf.setVisible(true);
    }

 public void actionPerformed(ActionEvent ae)
 {

    if(ae.getSource()==b0)
    {
        try
        {
            if(((t1.getText()).equals(""))&&((t2.getText()).equals("")))
            {
                JOptionPane.showMessageDialog(this,"Please enter supplier id or name !","Warning!!!",JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                int foundrec = 0;

                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store","root","Vil@sShirke9822");

                ps=con.prepareStatement("select * from supplier where sid='"+t1.getText()+"' or sname='"+t2.getText()+"'");
                rs=ps.executeQuery();

                while(rs.next())
                {
                    t1.setText(rs.getString(1));
                    t2.setText(rs.getString(2));
                    t3.setText(rs.getString(3));
                    t4.setText(rs.getString(4));
                    t5.setText(rs.getString(5));
                    foundrec = 1;
                }

                if (foundrec == 0)
                {
                    JOptionPane.showMessageDialog(null,"Record is not available","Dialog",JOptionPane.WARNING_MESSAGE);
                }
            }

            con.close();
        }

        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error:"+e);
        }
    }

    else if(ae.getSource()==b1)
    {
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
    }

    else if(ae.getSource()==b2)
    {
    	 model.setRowCount(0); 
        int r = 0;

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store","root","Vil@sShirke9822");

            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * from supplier");

            while(rs.next())
            {
                model.insertRow(r++, new Object[]{
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                });
            }

            con.close();
        }

        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error :"+e);
        }
    }

    else if(ae.getSource()==b3)
    {
        jf.dispose();
        new MainMenu();
    }

 }

 public static void main(String args[])
 {
     new SearchSupplier();
 }

}