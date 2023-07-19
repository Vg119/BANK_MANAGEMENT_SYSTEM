package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Fast_cash extends JFrame implements ActionListener {
    JButton b1, b2, b3, b4, b5, b6, b7;
    String pin;
    Fast_cash(String pin)
    {
        this.pin = pin;
        //BACKGROUND IMAGE
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);//scaling image
        ImageIcon i3 = new ImageIcon(i2);//reconverting to imageicon
        JLabel l3 = new JLabel(i3);//we cant directly set image on screen , we do it with jlabel
        l3.setBounds(0, 0, 1550, 830);
        add(l3);

        JLabel label = new JLabel("SELECT WITHDRAWAL AMOUNT");
        label.setBounds(439, 180, 700, 35);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System", Font.BOLD, 24));
        l3.add(label);

        b1 = new JButton("Rs. 100");
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(65, 125, 128));
        b1.addActionListener(this);
        b1.setBounds(405, 270, 150, 35);
        l3.add(b1);


        b2 = new JButton("Rs. 500");
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(65, 125, 128));
        b2.addActionListener(this);
        b2.setBounds(705, 270, 150, 35);
        l3.add(b2);

        b3 = new JButton("Rs. 1000");
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(65, 125, 128));
        b3.addActionListener(this);
        b3.setBounds(405, 316, 150, 35);
        l3.add(b3);


        b4 = new JButton("Rs. 2000");
        b4.setForeground(Color.WHITE);
        b4.setBackground(new Color(65, 125, 128));
        b4.addActionListener(this);
        b4.setBounds(705, 316, 150, 35);
        l3.add(b4);


        b5 = new JButton("Rs. 5000");
        b5.setForeground(Color.WHITE);
        b5.setBackground(new Color(65, 125, 128));
        b5.addActionListener(this);
        b5.setBounds(405, 362, 150, 35);
        l3.add(b5);


        b6 = new JButton("Rs. 10000");
        b6.setForeground(Color.WHITE);
        b6.setBackground(new Color(65, 125, 128));
        b6.addActionListener(this);
        b6.setBounds(705, 362, 150, 35);
        l3.add(b6);


        b7 = new JButton("BACK");
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
        if (e.getSource()==b7)
        {
            setVisible(false);
            new Main_Class(pin);
        }
        else {
            String amount = ((JButton)e.getSource()).getText().substring(4);//gets text from button. Now e.getSource() gives back an object but we need to convert than
            // object to Jbutton to get its text. Substring to get the number
            Con c = new Con();
            Date date = new Date();
            try {
                ResultSet resultSet = c.statement.executeQuery("SELECT * FROM bank WHERE pin = '"+pin+"'");
                int balance = 0;
                while (resultSet.next())
                {
                    if(resultSet.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(resultSet.getString("amount"));

                    }
                    else  //if "withdrawal"
                    {
                        balance -= Integer.parseInt(resultSet.getString("amount"));

                    }
                }
                String num = "17";
                if(e.getSource()!=b7 && balance<Integer.parseInt(amount)) //if withdrawal amount is more than sum in bank table
                {
                    JOptionPane.showMessageDialog(null,"Insufficient balance");
                    return;
                }

                c.statement.executeUpdate("INSERT INTO bank VALUES('"+pin+"','"+date+"','withdrawal','"+amount+"')");
                JOptionPane.showMessageDialog(null,"Rs."+amount+" debited successfully");







            }catch (Exception E)
            {
                E.printStackTrace();
            }

            setVisible(false);
            new Main_Class(pin);
        }

    }

    public static void main(String[] args) {
        new Fast_cash("");

    }
}
