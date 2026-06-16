import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;

public class DailyPurchaseReport extends JFrame implements ActionListener {

    JFrame jf;
    JButton submit, clear, back;
    JLabel l1, ln;
    JTextField t1;
    Font f;

    Connection con;
    Statement stmt;
    ResultSet rs;

    DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);

    public DailyPurchaseReport() {

        jf = new JFrame();

        f = new Font("Times New Roman", Font.BOLD, 20);

        jf.setLayout(null);

        jf.getContentPane().setBackground(new Color(240,240,240));

        ln = new JLabel("Daily Purchase Report");
        ln.setFont(new Font("Times New Roman", Font.BOLD, 30));
        ln.setForeground(Color.blue);
        ln.setBounds(600,40,400,40);
        jf.add(ln);

        l1 = new JLabel("Enter purchase report date:");
        l1.setFont(f);
        l1.setBounds(450,130,250,30);
        jf.add(l1);

        t1 = new JTextField();
        t1.setBounds(700,130,200,30);
        jf.add(t1);

        submit = new JButton("Submit");
        submit.setBounds(520,200,150,40);
        jf.add(submit);
        submit.addActionListener(this);

        clear = new JButton("Clear");
        clear.setBounds(700,200,150,40);
        jf.add(clear);
        clear.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(880,200,150,40);
        jf.add(back);
        back.addActionListener(this);

        scrlPane.setBounds(100,300,1300,450);
        jf.add(scrlPane);

        tabGrid.setFont(new Font("Times New Roman",0,16));
        tabGrid.setRowHeight(25);

        model.addColumn("S_ID");
        model.addColumn("S_NAME");
        model.addColumn("M_BNO");
        model.addColumn("M_NAME");
        model.addColumn("M_EXPDATE");
        model.addColumn("M_QTY");
        model.addColumn("M_PURPRICE");
        model.addColumn("M_SALEPRICE");

        jf.setTitle("Daily Purchase Report");

        jf.setExtendedState(JFrame.MAXIMIZED_BOTH); // FULL SCREEN

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource()==submit)
        {
            int r = 0;

            model.setRowCount(0);   // prevent duplicate rows

            try {

                if(t1.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(this,
                    "Please enter purchase date !",
                    "Warning!!!",
                    JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    int foundrec = 0;

                    Class.forName("com.mysql.jdbc.Driver");

                    con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/medical_store",
                    "root",
                    "Vil@sShirke9822");

                    stmt = con.createStatement();

                    rs = stmt.executeQuery(
                    "SELECT sid,sname,mbno,mname,mexpdate,mqty,mpurprice,msaleprice " +
                    "FROM medicine WHERE mpurdate='"+t1.getText()+"'");

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
                        rs.getString(8)
                        });

                        foundrec = 1;
                    }

                    if(foundrec==0)
                    {
                        JOptionPane.showMessageDialog(null,
                        "Not any medicine purchase on given date",
                        "Dialog",
                        JOptionPane.WARNING_MESSAGE);
                    }
                }

                con.close();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Error:"+e);
            }
        }

        else if(ae.getSource()==clear)
        {
            t1.setText("");
            model.setRowCount(0);
        }

        else if(ae.getSource()==back)
        {
            jf.dispose();
            new MainMenu();
        }
    }

    public static void main(String args[])
    {
        new DailyPurchaseReport();
    }
}

