package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    String pin;
    TextField textField;

    JButton b1,b2;
    Deposit(String pin)
    {
        this.pin = pin;

        //BACKGROUND IMAGE
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);//scaling image
        ImageIcon i3 = new ImageIcon(i2);//reconverting to imageicon
        JLabel l3 = new JLabel(i3);//we cant directly set image on screen , we do it with jlabel
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel label1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        label1.setForeground(Color.white);
        label1.setFont(new Font("System",Font.BOLD,16));
        label1.setBounds(460,180,400,35);
        l3.add(label1); // add label1 on l3


        textField = new TextField();
        textField.setBackground(new Color(86, 168, 172));
        textField.setForeground(Color.WHITE);
        textField.setBounds(460,230,320,25);
        textField.setFont(new Font("Raleway",Font.BOLD,22));
        l3.add(textField);

        b1 = new JButton("DEPOSIT");
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








        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);//full screen
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String amount = textField.getText();
            Date date = new Date();
            if(e.getSource()==b1){   //deposit button press action
                if(textField.getText().equals(""))  //if amount is not entered and used clicks deposit
                {
                    JOptionPane.showMessageDialog(null,"Please enter the amount");

                }
                else {
                    Con c = new Con();
                    c.statement.executeUpdate("INSERT INTO bank VALUES('"+pin+"','"+date+"','Deposit','"+amount+"')");//anything in single quotes is put into table as is.
                    JOptionPane.showMessageDialog(null,"Rs. "+amount+" deposit successfully");
                    setVisible(false);
                }
            } else if (e.getSource()==b2) {  //back button press action
                setVisible(false);

            }

        }catch (Exception E)
        {
            E.printStackTrace();
        }


    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
