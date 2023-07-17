package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JLabel label2;
    JButton b1;
    String pin;
    BalanceEnquiry(String pin)
    {
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);//scaling image
        ImageIcon i3 = new ImageIcon(i2);//reconverting to imageicon
        JLabel l3 = new JLabel(i3);//we cant directly set image on screen , we do it with jlabel
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel label1 = new JLabel("YOUR CURRENT BALANCE IS Rs");
        label1.setForeground(Color.white);
        label1.setFont(new Font("System",Font.BOLD,16));
        label1.setBounds(430,180,700,35);
        l3.add(label1); // add label1 on l3

        label2 = new JLabel();
        label2.setForeground(Color.white);
        label2.setFont(new Font("System",Font.BOLD,16));
        label2.setBounds(430,220,400,35);
        l3.add(label2); // add label1 on l3

        b1 = new JButton("BACK");
        b1.setBounds(700,406,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        int balance = 0;  //we will get the balance from db and show it on label2
        try {
            Con c = new Con();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM bank WHERE pin = '"+pin+"'");
            while(resultSet.next())
            {
                if(resultSet.getString("type").equals("Deposit")) //if type column has "Deposit" stored , add to balance
                {
                    balance = balance + Integer.parseInt(resultSet.getString("amount"));
                }
                else {    //if type column has "wihdrawal" stored then , subtrct from balance.
                    balance = balance - Integer.parseInt(resultSet.getString("amount"));
                }
            }

        }catch (Exception E)
        {
            E.printStackTrace();
        }

        label2.setText(""+balance); //show balance on label2


        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);//full screen
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {  //only one button back , so no need to check which button is clicked
        setVisible(false);
        new Main_Class(pin);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");

    }
}
