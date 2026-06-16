import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class RoundedButton extends JButton {

    private boolean hover = false;

    public RoundedButton(String text) {

        super(text);

        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setForeground(Color.WHITE);
        setFont(new Font("Segoe UI", Font.BOLD, 13));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setPreferredSize(new Dimension(190, 90));

        addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                hover = true;
                repaint();
            }

            public void mouseExited(MouseEvent e) {
                hover = false;
                repaint();
            }
        });
    }

    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        int padding = 6;

        /* Glass Background */

        if (hover)
            g2.setColor(new Color(0,0,0,160));   // darker glass on hover
        else
            g2.setColor(new Color(0,0,0,100));   // transparent glass

        g2.fillRoundRect(
                padding,
                padding,
                getWidth() - padding*2,
                getHeight() - padding*2,
                25,
                25
        );

        /* Glass Border */

        if (hover)
            g2.setColor(new Color(255,255,255,200));
        else
            g2.setColor(new Color(255,255,255,120));

        g2.setStroke(new BasicStroke(2));

        g2.drawRoundRect(
                padding,
                padding,
                getWidth() - padding*2 - 1,
                getHeight() - padding*2 - 1,
                25,
                25
        );

        /* Hover Glow */

        if(hover)
        {
            g2.setColor(new Color(255,255,255,40));
            g2.fillRoundRect(
                    padding+2,
                    padding+2,
                    getWidth() - padding*2 -4,
                    (getHeight()/2),
                    25,
                    25
            );
        }

        super.paintComponent(g);

        g2.dispose();
    }
}

class AnimatedTitle extends JLabel {

    public AnimatedTitle(String text) {

        super(text);

        setFont(new Font("Arial Black", Font.BOLD, 42));
        setHorizontalAlignment(JLabel.CENTER);
        setForeground(new Color(180, 255, 255));
    }

    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        int w = getWidth();
        int h = getHeight();

        g2.setColor(new Color(0, 0, 0, 120));
        g2.fillRoundRect(20, 10, w - 40, h - 20, 40, 40);

        String text = getText();
        FontMetrics fm = g2.getFontMetrics();

        int x = (w - fm.stringWidth(text)) / 2;
        int y = (h + fm.getAscent()) / 2 - 5;

        g2.setColor(new Color(0, 0, 0, 180));
        g2.drawString(text, x + 3, y + 3);

        g2.setColor(new Color(180, 255, 255));
        g2.drawString(text, x, y);

        g2.dispose();
    }
}


/* Circular Logout Button */

class CircularButton extends JButton {

    public CircularButton(String text) {

        super(text);

        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setForeground(Color.WHITE);
        setFont(new Font("Segoe UI", Font.BOLD, 12));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(new Color(220,50,50));
        g2.fillOval(0,0,getWidth(),getHeight());

        FontMetrics fm = g2.getFontMetrics();

        int x = (getWidth() - fm.stringWidth(getText())) / 2;
        int y = (getHeight() + fm.getAscent()) / 2 - 3;

        g2.setColor(Color.WHITE);
        g2.drawString(getText(),x,y);

        g2.dispose();
    }

    public Dimension getPreferredSize() {
        return new Dimension(50,50);
    }
}



public class MainMenu extends JFrame implements ActionListener {

    JMenuBar mbar;

    JMenu m1, m2, m3, m4, m5;

    JMenuItem m1_1, m1_2, m1_3, m1_4, m1_5;
    JMenuItem m2_1, m2_2, m2_3, m2_4, m2_5;
    JMenuItem m3_1, m3_2;
    JMenuItem m4_1, m5_1;

    JButton b1, b2, b3, b4, b5;
    JButton b6, b7, b8, b9, b10;

    JButton logoutBtn;

    JLabel background;
    AnimatedTitle title;

    public MainMenu() {

        setLayout(new BorderLayout());

        ImageIcon imageIcon = new ImageIcon(
                "C:\\Users\\Pratik S\\OneDrive\\Desktop\\Medical Store System JAVA\\Medical Store System\\src\\images\\Picture6.jpeg"
        );

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        Image image = imageIcon.getImage().getScaledInstance(
                screenSize.width,
                screenSize.height,
                Image.SCALE_SMOOTH
        );

        background = new JLabel(new ImageIcon(image));
        background.setLayout(new BorderLayout());
        add(background);

        title = new AnimatedTitle("MEDICAL STORE MANAGEMENT SYSTEM");
        title.setPreferredSize(new Dimension(100, 90));

        background.add(title, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(false);
        centerPanel.setLayout(new GridLayout(2, 1, 30, 30));
        centerPanel.setBorder(
                BorderFactory.createEmptyBorder(150, 150, 150, 150)
        );

        JPanel medicinePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JPanel supplierPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        medicinePanel.setOpaque(false);
        supplierPanel.setOpaque(false);

        b6 = new RoundedButton("Add Medicine");
        b7 = new RoundedButton("Search Medicine");
        b8 = new RoundedButton("Update Medicine");
        b9 = new RoundedButton("Delete Medicine");
        b10 = new RoundedButton("Medicine Stock");

        b1 = new RoundedButton("Add Supplier");
        b2 = new RoundedButton("Search Supplier");
        b3 = new RoundedButton("Update Supplier");
        b4 = new RoundedButton("Delete Supplier");
        b5 = new RoundedButton("Supplier List");

        JButton buttons[] = { b6,b7,b8,b9,b10,b1,b2,b3,b4,b5 };

        for (JButton b : buttons)
            b.addActionListener(this);

        medicinePanel.add(b6);
        medicinePanel.add(b7);
        medicinePanel.add(b8);
        medicinePanel.add(b9);
        medicinePanel.add(b10);

        supplierPanel.add(b1);
        supplierPanel.add(b2);
        supplierPanel.add(b3);
        supplierPanel.add(b4);
        supplierPanel.add(b5);

        centerPanel.add(medicinePanel);
        centerPanel.add(supplierPanel);

        background.add(centerPanel, BorderLayout.CENTER);


        /* Logout Button Bottom Right */

        logoutBtn = new CircularButton("⎋");

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,30,20));
        bottomPanel.setOpaque(false);

        bottomPanel.add(logoutBtn);

        background.add(bottomPanel, BorderLayout.SOUTH);

        logoutBtn.addActionListener(this);


        /* Menu Bar */

        mbar = new JMenuBar();
        setJMenuBar(mbar);

        Font menuFont = new Font("Segoe UI", Font.BOLD, 16);

        m1 = new JMenu("Supplier");
        m2 = new JMenu("Medicine");
        m3 = new JMenu("Report");
        m4 = new JMenu("About");
        m5 = new JMenu("Exit");

        m1.setFont(menuFont);
        m2.setFont(menuFont);
        m3.setFont(menuFont);
        m4.setFont(menuFont);
        m5.setFont(menuFont);

        mbar.add(m1);
        mbar.add(m2);
        mbar.add(m3);
        mbar.add(m4);
        mbar.add(m5);

        m1_1 = new JMenuItem("Add New Supplier");
        m1_2 = new JMenuItem("Search Supplier");
        m1_3 = new JMenuItem("Update Supplier");
        m1_4 = new JMenuItem("Delete Supplier");
        m1_5 = new JMenuItem("List of Supplier");

        m1.add(m1_1);
        m1.add(m1_2);
        m1.add(m1_3);
        m1.add(m1_4);
        m1.add(m1_5);

        m2_1 = new JMenuItem("Add New Medicine");
        m2_2 = new JMenuItem("Search Medicine");
        m2_3 = new JMenuItem("Update Medicine");
        m2_4 = new JMenuItem("Delete Medicine");
        m2_5 = new JMenuItem("Stock of Medicine");

        m2.add(m2_1);
        m2.add(m2_2);
        m2.add(m2_3);
        m2.add(m2_4);
        m2.add(m2_5);

        m3_1 = new JMenuItem("Daily Purchase Report");
        m3_2 = new JMenuItem("Supplier wise medicine Report");

        m3.add(m3_1);
        m3.add(m3_2);

        m4_1 = new JMenuItem("About System");
        m4.add(m4_1);

        m5_1 = new JMenuItem("Exit");
        m5.add(m5_1);

        m1_1.addActionListener(this);
        m1_2.addActionListener(this);
        m1_3.addActionListener(this);
        m1_4.addActionListener(this);
        m1_5.addActionListener(this);

        m2_1.addActionListener(this);
        m2_2.addActionListener(this);
        m2_3.addActionListener(this);
        m2_4.addActionListener(this);
        m2_5.addActionListener(this);

        m3_1.addActionListener(this);
        m3_2.addActionListener(this);
        m4_1.addActionListener(this);
        m5_1.addActionListener(this);

        setTitle("MedilQ Inventory Management System");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        Object obj = ae.getSource();

        if(obj == logoutBtn)
        {
            dispose();
            new Login();
        }

        else if (obj == m1_1 || obj == b1) new AddNewSupplier();
        else if (obj == m1_2 || obj == b2) new SearchSupplier();
        else if (obj == m1_3 || obj == b3) new UpdateSupplier();
        else if (obj == m1_4 || obj == b4) new DeleteSupplier();
        else if (obj == m1_5 || obj == b5) new SupplierList();

        else if (obj == m2_1 || obj == b6) new AddNewMedicine();
        else if (obj == m2_2 || obj == b7) new SearchMedicine();
        else if (obj == m2_3 || obj == b8) new UpdateMedicine();
        else if (obj == m2_4 || obj == b9) new DeleteMedicine();
        else if (obj == m2_5 || obj == b10) new MedicineList();

        else if (obj == m3_1) new DailyPurchaseReport();
        else if (obj == m3_2) new SupplierWiseMedList();
        else if (obj == m4_1) new About();
        else if (obj == m5_1) System.exit(0);
    }

    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch (Exception e) {}

        new MainMenu();
    }
}
