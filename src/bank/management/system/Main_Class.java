package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Class extends JFrame implements ActionListener {
    JButton b1, b2, b3, b4, b5, b6, b7;
    String pin;

    Main_Class(String pin) {
        this.pin = pin;
        //BACKGROUND IMAGE
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);//scaling image
        ImageIcon i3 = new ImageIcon(i2);//reconverting to imageicon
        JLabel l3 = new JLabel(i3);//we cant directly set image on screen , we do it with jlabel
        l3.setBounds(0, 0, 1550, 830);
        add(l3);

        JLabel label = new JLabel("Please select your transaction");
        label.setBounds(430, 180, 700, 35);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System", Font.BOLD, 28));
        l3.add(label);

        b1 = new JButton("DEPOSIT");
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(65, 125, 128));
        b1.addActionListener(this);
        b1.setBounds(405, 270, 150, 35);
        l3.add(b1);


        b2 = new JButton("CASH WITHDRAW");
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(65, 125, 128));
        b2.addActionListener(this);
        b2.setBounds(705, 270, 150, 35);
        l3.add(b2);

        b3 = new JButton("FAST CASH");
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(65, 125, 128));
        b3.addActionListener(this);
        b3.setBounds(405, 316, 150, 35);
        l3.add(b3);


        b4 = new JButton("MINI STATEMENT");
        b4.setForeground(Color.WHITE);
        b4.setBackground(new Color(65, 125, 128));
        b4.addActionListener(this);
        b4.setBounds(705, 316, 150, 35);
        l3.add(b4);


        b5 = new JButton("PIN CHANGE");
        b5.setForeground(Color.WHITE);
        b5.setBackground(new Color(65, 125, 128));
        b5.addActionListener(this);
        b5.setBounds(405, 362, 150, 35);
        l3.add(b5);


        b6 = new JButton("BALANCE INQUIRY");
        b6.setForeground(Color.WHITE);
        b6.setBackground(new Color(65, 125, 128));
        b6.addActionListener(this);
        b6.setBounds(705, 362, 150, 35);
        l3.add(b6);


        b7 = new JButton("EXIT");
        b7.setForeground(Color.WHITE);
        b7.setBackground(new Color(65, 125, 128));
        b7.addActionListener(this);
        b7.setBounds(405, 408, 150, 35);
        l3.add(b7);


        setLayout(null);
        setSize(1550, 1080); //full screen size
        setLocation(0, 0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==b1)
        {
            new Deposit(pin); //open deposit obj.
            setVisible(false);
        } else if (e.getSource()==b7) {
            System.exit(0); // closes entire application


        } else if (e.getSource()==b2) {
            new Withdrawal(pin);
            setVisible(false);

        } else if (e.getSource()==b6) {
            setVisible(false);
            new BalanceEnquiry(pin);

        }

    }

    public static void main(String[] args) {
        new Main_Class("");

    }
}
