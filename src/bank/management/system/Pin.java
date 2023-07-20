package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin extends JFrame implements ActionListener {
    JButton b1,b2;
    JPasswordField p1,p2;
    String pin;
    Pin(String pin)
    {
        this.pin = pin;
        //BACKGROUND IMAGE
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);//scaling image
        ImageIcon i3 = new ImageIcon(i2);//reconverting to imageicon
        JLabel l3 = new JLabel(i3);//we cant directly set image on screen , we do it with jlabel
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel label1 = new JLabel("CHANGE YOUR PIN");
        label1.setForeground(Color.white);
        label1.setFont(new Font("System",Font.BOLD,22));
        label1.setBounds(525,165,400,35);
        l3.add(label1); // add label1 on l3

        JLabel label2 = new JLabel("New Pin:");
        label2.setForeground(Color.white);
        label2.setFont(new Font("System",Font.BOLD,16));
        label2.setBounds(480,220,400,35);
        l3.add(label2); // add label1 on l3


        //PASSWORD
        p1 = new JPasswordField();
        p1.setBackground(new Color(86, 168, 172));
        p1.setForeground(Color.WHITE);
        p1.setBounds(580,220,200,35);
        p1.setFont(new Font("Raleway",Font.BOLD,22));
        l3.add(p1);

        JLabel label3 = new JLabel("Re-enter new Pin:");
        label3.setForeground(Color.white);
        label3.setFont(new Font("System",Font.BOLD,16));
        label3.setBounds(430,270,400,35);
        l3.add(label3); // add label1 on l3

        p2 = new JPasswordField();
        p2.setBackground(new Color(86, 168, 172));
        p2.setForeground(Color.WHITE);
        p2.setBounds(580,270,200,35);
        p2.setFont(new Font("Raleway",Font.BOLD,22));
        l3.add(p2);



        b1 = new JButton("CHANGE");
        b1.setBounds(700,362,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);


        b2 = new JButton("BACK");
        b2.setBounds(700,406,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);


        setSize(1550,1080);
        setLayout(null);
        setLocation(0,0);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==b1) {
            try {
                String pin1 = p1.getText(); //from enter pin
                String pin2 = p2.getText(); //from re enter pin
                if (!pin2.equals(pin1))  // if pin does not match
                {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                } else {
                    if (p1.getText().equals(""))//if user enter nothing in both Jpassword firld
                    {
                        JOptionPane.showMessageDialog(null, "Please enter your PIN");
                        return;
                    }

                    Con c = new Con();
                    String q1 = "UPDATE bank SET pin = '" + pin1 + "' WHERE pin ='" + pin + "'";  //changes pin in respective tables
                    String q2 = "UPDATE login SET pin = '" + pin1 + "' WHERE pin ='" + pin + "'";
                    String q3 = "UPDATE signup3 SET pin = '" + pin1 + "' WHERE pin ='" + pin + "'";

                    c.statement.executeUpdate(q1);
                    c.statement.executeUpdate(q2);
                    c.statement.executeUpdate(q3);

                    JOptionPane.showMessageDialog(null, "PIN changed successfully");
                    setVisible(false);
                    new Main_Class(pin1);


                }


            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource()==b2) {
            setVisible(false);
            new Main_Class(pin);

        }


    }

    public static void main(String[] args) {
        new Pin("");

    }
}
