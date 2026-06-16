import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;

public class SearchMedicine extends JFrame implements ActionListener
{
    JFrame jf;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,ln;
    JButton b0,b1,b2,b3;

    Connection con;
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;

    DefaultTableModel model = new DefaultTableModel();

    JTable tabGrid = new JTable(model);

    JScrollPane scrlPane = new JScrollPane(tabGrid,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

    SearchMedicine()
    {
        jf = new JFrame("Search Medicine");
        jf.setLayout(null);
        jf.getContentPane().setBackground(new Color(210,220,230));

        ln = new JLabel("SEARCH MEDICINE DETAILS");
        ln.setFont(new Font("Segoe UI",Font.BOLD,32));
        ln.setBounds(520,40,500,40);
        jf.add(ln);

        Font f = new Font("Segoe UI",Font.BOLD,16);

        int leftLabel = 350;
        int leftField = 550;

        int rightLabel = 800;
        int rightField = 1000;

        l1 = new JLabel("Medicine Batch No *");
        l1.setFont(f);
        l1.setBounds(leftLabel,140,200,30);
        jf.add(l1);

        t1 = new JTextField();
        t1.setBounds(leftField,140,200,30);
        jf.add(t1);

        l2 = new JLabel("Medicine Name *");
        l2.setFont(f);
        l2.setBounds(leftLabel,190,200,30);
        jf.add(l2);

        t2 = new JTextField();
        t2.setBounds(leftField,190,200,30);
        jf.add(t2);

        l3 = new JLabel("Medicine Company");
        l3.setFont(f);
        l3.setBounds(leftLabel,240,200,30);
        jf.add(l3);

        t3 = new JTextField();
        t3.setBounds(leftField,240,200,30);
        jf.add(t3);

        l4 = new JLabel("Medicine Quantity");
        l4.setFont(f);
        l4.setBounds(leftLabel,290,200,30);
        jf.add(l4);

        t4 = new JTextField();
        t4.setBounds(leftField,290,200,30);
        jf.add(t4);

        l5 = new JLabel("Expiry Date");
        l5.setFont(f);
        l5.setBounds(leftLabel,340,200,30);
        jf.add(l5);

        t5 = new JTextField();
        t5.setBounds(leftField,340,200,30);
        jf.add(t5);

        l6 = new JLabel("Purchase Date");
        l6.setFont(f);
        l6.setBounds(leftLabel,390,200,30);
        jf.add(l6);

        t6 = new JTextField();
        t6.setBounds(leftField,390,200,30);
        jf.add(t6);

        l7 = new JLabel("Medicine Type");
        l7.setFont(f);
        l7.setBounds(rightLabel,140,200,30);
        jf.add(l7);

        t7 = new JTextField();
        t7.setBounds(rightField,140,200,30);
        jf.add(t7);

        l8 = new JLabel("Purchase Price");
        l8.setFont(f);
        l8.setBounds(rightLabel,190,200,30);
        jf.add(l8);

        t8 = new JTextField();
        t8.setBounds(rightField,190,200,30);
        jf.add(t8);

        l9 = new JLabel("Sale Price");
        l9.setFont(f);
        l9.setBounds(rightLabel,240,200,30);
        jf.add(l9);

        t9 = new JTextField();
        t9.setBounds(rightField,240,200,30);
        jf.add(t9);

        l10 = new JLabel("Rack No");
        l10.setFont(f);
        l10.setBounds(rightLabel,290,200,30);
        jf.add(l10);

        t10 = new JTextField();
        t10.setBounds(rightField,290,200,30);
        jf.add(t10);

        l11 = new JLabel("Supplier Name");
        l11.setFont(f);
        l11.setBounds(rightLabel,340,200,30);
        jf.add(l11);

        t11 = new JTextField();
        t11.setBounds(rightField,340,200,30);
        jf.add(t11);

        l12 = new JLabel("Supplier ID");
        l12.setFont(f);
        l12.setBounds(rightLabel,390,200,30);
        jf.add(l12);

        t12 = new JTextField();
        t12.setBounds(rightField,390,200,30);
        jf.add(t12);

        b0 = new JButton("Search");
        b0.setBounds(520,470,130,40);
        jf.add(b0);
        b0.addActionListener(this);

        b1 = new JButton("Clear");
        b1.setBounds(670,470,130,40);
        jf.add(b1);
        b1.addActionListener(this);

        b2 = new JButton("View All");
        b2.setBounds(820,470,130,40);
        jf.add(b2);
        b2.addActionListener(this);

        b3 = new JButton("Back");
        b3.setBounds(970,470,130,40);
        jf.add(b3);
        b3.addActionListener(this);

        scrlPane.setBounds(50,550,1450,200);
        jf.add(scrlPane);

        tabGrid.setFont(new Font("Segoe UI",0,14));
        tabGrid.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabGrid.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,15));

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

        tabGrid.getColumnModel().getColumn(0).setPreferredWidth(120);
        tabGrid.getColumnModel().getColumn(1).setPreferredWidth(150);
        tabGrid.getColumnModel().getColumn(2).setPreferredWidth(150);
        tabGrid.getColumnModel().getColumn(3).setPreferredWidth(120);
        tabGrid.getColumnModel().getColumn(4).setPreferredWidth(120);
        tabGrid.getColumnModel().getColumn(5).setPreferredWidth(120);
        tabGrid.getColumnModel().getColumn(6).setPreferredWidth(100);
        tabGrid.getColumnModel().getColumn(7).setPreferredWidth(120);
        tabGrid.getColumnModel().getColumn(8).setPreferredWidth(120);
        tabGrid.getColumnModel().getColumn(9).setPreferredWidth(100);
        tabGrid.getColumnModel().getColumn(10).setPreferredWidth(120);
        tabGrid.getColumnModel().getColumn(11).setPreferredWidth(150);

        jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
                    JOptionPane.showMessageDialog(this,"Please enter medicine bno or name !","Warning!!!",JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    int foundrec = 0;

                    Class.forName("com.mysql.jdbc.Driver");
                    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store","root","Vil@sShirke9822");

                    ps=con.prepareStatement("select * from medicine where mname='"+t2.getText()+"' or mbno='"+t1.getText()+"'");
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
                        foundrec = 1;
                    }

                    if(foundrec==0)
                    {
                        JOptionPane.showMessageDialog(null,"Record is not available","Dialog",JOptionPane.WARNING_MESSAGE);
                    }
                }
                con.close();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Error."+e);
            }
        }

        else if(ae.getSource()==b1)
        {
            t1.setText(""); t2.setText(""); t3.setText(""); t4.setText("");
            t5.setText(""); t6.setText(""); t7.setText(""); t8.setText("");
            t9.setText(""); t10.setText(""); t11.setText(""); t12.setText("");
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
                rs = stmt.executeQuery("SELECT * from medicine");

                while(rs.next())
                {
                    model.insertRow(r++, new Object[]{
                        rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),
                        rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12)
                    });
                }

                con.close();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Error:"+e);
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
        new SearchMedicine();
    }
}