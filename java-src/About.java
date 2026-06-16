import javax.swing.*;
import java.awt.*;

class About extends JFrame
{
    JFrame jf;
    JLabel l1,l2,l3,l5,l6,l7;
    JButton closeBtn;

    About()
    {
        jf = new JFrame();
        jf.setLayout(null);

        // TITLE
        l1 = new JLabel("MedilQ Stock Management System", JLabel.CENTER);
        l1.setFont(new Font("Segoe UI",Font.BOLD,32));
        l1.setForeground(new Color(0,102,204));
        l1.setBounds(150,30,600,50);
        jf.add(l1);

        // Developed by
        l2 = new JLabel("This System developed by");
        l2.setFont(new Font("Segoe UI",Font.PLAIN,20));
        l2.setBounds(120,150,400,40);
        jf.add(l2);

        l3 = new JLabel("Tanmay Yenpure");
        l3.setFont(new Font("Segoe UI",Font.BOLD,24));
        l3.setForeground(new Color(220,20,60));
        l3.setBounds(350,200,300,40);
        jf.add(l3);

        // Description
        l5 = new JLabel("• In this system we can add details of Medicines and Suppliers.");
        l5.setFont(new Font("Segoe UI",Font.PLAIN,18));
        l5.setBounds(120,320,700,30);
        jf.add(l5);

        l6 = new JLabel("• We can also update, delete and search the existing details.");
        l6.setFont(new Font("Segoe UI",Font.PLAIN,18));
        l6.setBounds(120,360,700,30);
        jf.add(l6);

        l7 = new JLabel("• It helps manage medicine stock and rack placement in the store.");
        l7.setFont(new Font("Segoe UI",Font.PLAIN,18));
        l7.setBounds(120,400,700,30);
        jf.add(l7);

        // CLOSE BUTTON
        closeBtn = new JButton("Close");
        closeBtn.setFont(new Font("Segoe UI",Font.BOLD,16));
        closeBtn.setBackground(new Color(0,120,215));
        closeBtn.setForeground(Color.WHITE);
        closeBtn.setBounds(380,500,120,40);
        closeBtn.setFocusPainted(false);
        jf.add(closeBtn);

        closeBtn.addActionListener(e -> jf.dispose());

        // FRAME SETTINGS
        jf.setTitle("About System");
        jf.setSize(900,700);
        jf.setLocationRelativeTo(null);
        jf.setResizable(true);
        jf.getContentPane().setBackground(new Color(230,240,250));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    public static void main(String args[])
    {
        new About();
    }
}
