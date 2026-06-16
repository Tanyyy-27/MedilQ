import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class InvalidException extends Exception {}

class Login extends JFrame implements ActionListener {

    JButton b1, b2, b3;
    JTextField t1;
    JPasswordField p1;
    int cnt = 0;

    JLabel background;

    Login() {

        setLayout(new BorderLayout());

        /* ===== Background Image (Same Logic as MainMenu) ===== */

        ImageIcon imageIcon = new ImageIcon(
        "C:\\Users\\Pratik S\\OneDrive\\Desktop\\Medical Store System JAVA\\Medical Store System\\src\\images\\Picture4.jpeg"
        );

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        Image image = imageIcon.getImage().getScaledInstance(
                screenSize.width,
                screenSize.height,
                Image.SCALE_SMOOTH
        );

        background = new JLabel(new ImageIcon(image));
        background.setLayout(new GridBagLayout());

        add(background);

        /* ===== Login Panel ===== */

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setPreferredSize(new Dimension(600,400));
        panel.setBackground(new Color(255,255,255,220));
        panel.setBorder(BorderFactory.createLineBorder(new Color(200,200,200),2));

        GridBagConstraints p = new GridBagConstraints();

        JLabel title = new JLabel("ADMINISTRATOR LOGIN");
        title.setFont(new Font("Segoe UI",Font.BOLD,32));
        title.setForeground(new Color(50,50,50));
        p.gridx=0;
        p.gridy=0;
        p.gridwidth=2;
        p.insets=new Insets(20,0,40,0);
        panel.add(title,p);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setFont(new Font("Segoe UI",Font.BOLD,20));
        p.gridx=0;
        p.gridy=1;
        p.gridwidth=1;
        p.anchor=GridBagConstraints.LINE_END;
        p.insets=new Insets(10,10,10,10);
        panel.add(userLabel,p);

        t1 = new JTextField(20);
        t1.setFont(new Font("Segoe UI",Font.PLAIN,16));
        t1.setBorder(BorderFactory.createLineBorder(new Color(180,180,180),2));
        p.gridx=1;
        p.anchor=GridBagConstraints.LINE_START;
        panel.add(t1,p);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setFont(new Font("Segoe UI",Font.BOLD,20));
        p.gridx=0;
        p.gridy=2;
        p.anchor=GridBagConstraints.LINE_END;
        panel.add(passLabel,p);

        p1 = new JPasswordField(20);
        p1.setFont(new Font("Segoe UI",Font.PLAIN,16));
        p1.setBorder(BorderFactory.createLineBorder(new Color(180,180,180),2));
        p.gridx=1;
        p.anchor=GridBagConstraints.LINE_START;
        panel.add(p1,p);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,30,20));
        buttonPanel.setOpaque(false);

        b1 = createButton("Login",new Color(0,153,102));
        b2 = createButton("Clear",new Color(255,153,51));
        b3 = createButton("Exit",new Color(255,51,51));

        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);

        p.gridx=0;
        p.gridy=3;
        p.gridwidth=2;
        panel.add(buttonPanel,p);

        background.add(panel);

        setTitle("Login");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JButton createButton(String text, Color bgColor) {

        JButton btn = new JButton(text);
        btn.setPreferredSize(new Dimension(120,40));
        btn.setBackground(bgColor);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Segoe UI",Font.BOLD,16));
        btn.setBorder(BorderFactory.createEmptyBorder());
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.addActionListener(this);

        btn.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(bgColor.darker());
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(bgColor);
            }
        });

        return btn;
    }

    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource()==b1) {

            try {

                String s = t1.getText();
                String s1 = new String(p1.getPassword());

                if((s.compareTo("pratik")==0)&&(s1.compareTo("1234")==0)) {

                    JOptionPane.showMessageDialog(null,
                    "Welcome !!! You are valid user ...!!!",
                    "WELCOME",
                    JOptionPane.INFORMATION_MESSAGE);

                    new MainMenu();
                    dispose();
                }
                else {
                    throw new InvalidException();
                }
            }
            catch(Exception e1) {

                cnt++;

                JOptionPane.showMessageDialog(null,
                "Sorry !!! You are not valid user ...!!!",
                "WARNING",
                JOptionPane.ERROR_MESSAGE);

                t1.setText("");
                p1.setText("");

                if(cnt==3) {

                    JOptionPane.showMessageDialog(null,
                    "Sorry !!! Your 3 attempts are over ...!!!",
                    "WARNING",
                    JOptionPane.ERROR_MESSAGE);

                    System.exit(0);
                }
            }
        }

        else if(ae.getSource()==b2) {

            t1.setText("");
            p1.setText("");
        }

        else if(ae.getSource()==b3) {

            System.exit(0);
        }
    }

    public static void main(String[] args) {

        new Login();
    }
}

