package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Mini extends JFrame implements ActionListener {
    String pin;
    JButton button;
    Mini(String pin)
    {
        this.pin = pin;


        getContentPane().setBackground(new Color(255,204,204));
        setSize(400,600);
        setLocation(20,20);
        setLayout(null);


        JLabel label1 = new JLabel();
        label1.setBounds(20,140,400,200);
        add(label1);

        JLabel label2 = new JLabel("Vergab");
        label2.setFont(new Font("System",Font.BOLD,15));
        label2.setBounds(150,20,200,20);
        add(label2);

        JLabel label3 = new JLabel();
        label3.setBounds(20,80,300,20);
        add(label3);


        JLabel label4 = new JLabel();
        label4.setBounds(20,400,300,20);
        add(label4);

        try {
            Con c = new Con();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM login WHERE PIN = '"+pin+"'");
            while (resultSet.next())
            {
                label3.setText("Card Number: "+resultSet.getString("card_number").substring(0,4)+"XXXXXXXX"+resultSet.getString("card_number").substring(12));//only getting the 1st 4 digits of card number.

            }
        }catch (Exception E)
        {
            E.printStackTrace();

        }


        try { //getting the balance from bank table
            Con c = new Con();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM bank WHERE pin = '"+pin+"'");
            int balance = 0;
            while (resultSet.next())
            {
                label1.setText(label1.getText()+"<html>"+resultSet.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
                        resultSet.getString("amount")+"<br><br><html>");

                if(resultSet.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));

                }
                else  //if "withdrawal"
                {
                    balance -= Integer.parseInt(resultSet.getString("amount"));

                }
            }
            label4.setText("Your total Balance is Rs"+balance);
        }catch (Exception E)
        {
            E.printStackTrace();
        }

        button = new JButton("Exit");
        button.setBounds(20,500,100,25);
        button.addActionListener(this);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        add(button);



        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) { //only one exit button
        setVisible(false);
    }

    public static void main(String[] args) {

        new Mini("");
    }
}
