
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;

public class AddNewSupplier extends JFrame implements ActionListener {

    JTextField t2, t3, t4, t5;
    JButton bSave, bClear, bViewAll, bBack;

    DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);

    int rowIndex = 0;

    AddNewSupplier() {

        setTitle("Add New Supplier");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color bgColor = new Color(240,240,240);

        getContentPane().setBackground(bgColor);
        setLayout(new BorderLayout(10,10));

        JLabel lTitle = new JLabel("New Supplier Details");
        lTitle.setFont(new Font("Segoe UI", Font.BOLD, 32));
        lTitle.setForeground(new Color(0,102,204));
        lTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lTitle.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));
        add(lTitle, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(bgColor);
        add(centerPanel, BorderLayout.CENTER);

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(bgColor);
        formPanel.setBorder(BorderFactory.createEmptyBorder(20,40,20,40));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12,12,12,12);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Dimension fieldSize = new Dimension(250,30);

        JLabel l2 = new JLabel("Supplier Name *");
        l2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        l2.setHorizontalAlignment(SwingConstants.RIGHT);
        gbc.gridx=0; gbc.gridy=0;
        formPanel.add(l2,gbc);

        t2 = new JTextField();
        t2.setPreferredSize(fieldSize);
        t2.setFont(new Font("Segoe UI",Font.PLAIN,16));
        gbc.gridx=1; gbc.gridy=0;
        formPanel.add(t2,gbc);

        JLabel l3 = new JLabel("Supplier Address *");
        l3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        l3.setHorizontalAlignment(SwingConstants.RIGHT);
        gbc.gridx=0; gbc.gridy=1;
        formPanel.add(l3,gbc);

        t3 = new JTextField();
        t3.setPreferredSize(fieldSize);
        t3.setFont(new Font("Segoe UI",Font.PLAIN,16));
        gbc.gridx=1; gbc.gridy=1;
        formPanel.add(t3,gbc);

        JLabel l4 = new JLabel("Supplier Phone No *");
        l4.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        l4.setHorizontalAlignment(SwingConstants.RIGHT);
        gbc.gridx=0; gbc.gridy=2;
        formPanel.add(l4,gbc);

        t4 = new JTextField();
        t4.setPreferredSize(fieldSize);
        t4.setFont(new Font("Segoe UI",Font.PLAIN,16));
        gbc.gridx=1; gbc.gridy=2;
        formPanel.add(t4,gbc);

        JLabel l5 = new JLabel("Supplier Email ID *");
        l5.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        l5.setHorizontalAlignment(SwingConstants.RIGHT);
        gbc.gridx=0; gbc.gridy=3;
        formPanel.add(l5,gbc);

        t5 = new JTextField();
        t5.setPreferredSize(fieldSize);
        t5.setFont(new Font("Segoe UI",Font.PLAIN,16));
        gbc.gridx=1; gbc.gridy=3;
        formPanel.add(t5,gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,20,10));
        buttonPanel.setBackground(bgColor);

        bSave = createButton("Save");
        bClear = createButton("Clear");
        bViewAll = createButton("View All Suppliers");
        bBack = createButton("Back");

        buttonPanel.add(bSave);
        buttonPanel.add(bClear);
        buttonPanel.add(bViewAll);
        buttonPanel.add(bBack);

        gbc.gridx=0; gbc.gridy=4; gbc.gridwidth=2;
        formPanel.add(buttonPanel,gbc);

        centerPanel.add(formPanel);

        tabGrid.setFont(new Font("Segoe UI",Font.PLAIN,16));
        tabGrid.setRowHeight(25);
        tabGrid.setBackground(bgColor);

        scrlPane.setPreferredSize(new Dimension(1200,350));
        scrlPane.getViewport().setBackground(bgColor);

        add(scrlPane,BorderLayout.SOUTH);

        model.addColumn("S_ID");
        model.addColumn("S_NAME");
        model.addColumn("S_ADDRESS");
        model.addColumn("S_PHONENO");
        model.addColumn("S_EMAILID");

        bSave.addActionListener(this);
        bClear.addActionListener(this);
        bViewAll.addActionListener(this);
        bBack.addActionListener(this);

        setVisible(true);
    }

    private JButton createButton(String text){
        JButton btn = new JButton(text);
        btn.setPreferredSize(new Dimension(180,40));
        btn.setFont(new Font("Segoe UI",Font.BOLD,16));
        btn.setFocusPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return btn;
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==bSave){

            String email = t5.getText();
            Pattern p = Pattern.compile("[_a-zA-Z0-9]+[0-9]*@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+");
            Matcher m = p.matcher(email);
            boolean matchFound = m.matches();

            if(t2.getText().isEmpty() || t3.getText().isEmpty() || t4.getText().isEmpty() || t5.getText().isEmpty())
                JOptionPane.showMessageDialog(this,"* Detail are Missing !","Warning",JOptionPane.WARNING_MESSAGE);

            else if(!matchFound)
                JOptionPane.showMessageDialog(this,"Invalid email id!","Warning",JOptionPane.WARNING_MESSAGE);

            else{
                try{
                    Class.forName("com.mysql.jdbc.Driver");

                    Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/medical_store","root","Vil@sShirke9822");

                    PreparedStatement ps = con.prepareStatement(
                    "insert into supplier (sname,saddress,sphoneno,semailid) values(?,?,?,?)");

                    ps.setString(1,t2.getText());
                    ps.setString(2,t3.getText());
                    ps.setString(3,t4.getText());
                    ps.setString(4,t5.getText());

                    ps.executeUpdate();

                    JOptionPane.showMessageDialog(this,"Supplier Added Successfully");

                    con.close();
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(this,"Error:"+e);
                }
            }
        }

        else if(ae.getSource()==bClear){
            t2.setText(""); 
            t3.setText(""); 
            t4.setText(""); 
            t5.setText("");
        }

        else if(ae.getSource()==bBack){
            dispose();
            new MainMenu();
        }

        else if(ae.getSource()==bViewAll){

            rowIndex=0;
            model.setRowCount(0); // prevents duplicate records

            try{
                Class.forName("com.mysql.jdbc.Driver");

                Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/medical_store","root","Vil@sShirke9822");

                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from supplier");

                while(rs.next()){
                    model.insertRow(rowIndex++,new Object[]{
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                    });
                }

                con.close();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this,"Error:"+e);
            }
        }
    }

    public static void main(String args[]){
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception e){}
        new AddNewSupplier();
    }
}
