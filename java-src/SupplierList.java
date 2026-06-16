import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class SupplierList extends JFrame implements ActionListener
{
    JFrame jf=new JFrame();
    JLabel ln;
    JButton back;

    Connection con;
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;

    DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);

    public SupplierList()
    {
        jf.setLayout(null);

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screen.width;
        int height = screen.height;

        int centerX = width/2;

        ln = new JLabel("List Of Supplier Details");
        ln.setFont(new Font("Times New Roman",Font.BOLD,28));
        ln.setForeground(Color.blue);
        ln.setBounds(centerX-170,40,350,30);
        jf.add(ln);

        back = new JButton("Back");
        back.setBounds(centerX-60,90,120,35);
        jf.add(back);
        back.addActionListener(this);

        scrlPane.setBounds(100,150,width-200,height-250);
        jf.add(scrlPane);

        tabGrid.setFont(new Font("Times New Roman",0,15));

        model.addColumn("S_ID");
        model.addColumn("S_NAME");
        model.addColumn("S_Address");
        model.addColumn("S_PhNo");
        model.addColumn("S_EmailId");

        int r = 0;

        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/medical_store",
                    "root",
                    "Vil@sShirke9822");

            System.out.println("Connected to database.");

            stmt = con.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            rs = stmt.executeQuery("select * from supplier");

            while(rs.next())
            {
                model.insertRow(r++,new Object[]{
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
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

        jf.setTitle("Supplier List");
        jf.setSize(width,height);
        jf.setLocation(0,0);
        jf.setResizable(true);

        jf.getContentPane().setBackground(new Color(240,240,240));

        jf.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            jf.dispose();
            new MainMenu();
        }
    }

    public static void main(String args[])
    {
        new SupplierList();
    }
}