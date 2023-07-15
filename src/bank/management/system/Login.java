//LOGIN PAGE
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Jframe so as to show a frame,actionslistener to listen to events
public class Login extends JFrame implements ActionListener {
    JLabel label1,label2,label3; //for labels
    JTextField textField2; //for textfields
    JPasswordField passwordField3;//for passwordfields

    JButton button1,button2,button3; //for buttons
    Login()
    {
        super("Vergab's Bank Management System");


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./icons/bank.png")); //to set image on login page ,
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);//scaling image
        ImageIcon i3 = new ImageIcon(i2); //to make image visible on frame we reconvert it
        JLabel image = new JLabel(i3); //displaying image as label
        image.setBounds(350,10,100,100);//where the image appears
        add(image);//adding image on frame

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("./icons/card.png")); //to set image on login page ,
        Image ii2 = ii1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);//scaling image
        ImageIcon ii3 = new ImageIcon(ii2); //to make image visible on frame
        JLabel iimage = new JLabel(ii3); //displaying image as label
        iimage.setBounds(635,350,100,100);//where the image appears
        add(iimage);//adding image on screen

        //setting label of text WELCOME...ATM.
        label1 = new JLabel("WELCOME TO MY ATM");//main work of jlabel is to show text on screen
        label1.setForeground(Color.WHITE);//setting colour white
        label1.setFont(new Font("AvantGarde",Font.BOLD,38));//setting font of text
        label1.setBounds(200,125,450,40); //distance from x ,y of frame not from screen.
        add(label1);//adding to frame

        //CARD NO
        label2 = new JLabel("Card no.");
        label2.setFont(new Font("Ralway",Font.BOLD,28));
        label2.setForeground(Color.WHITE);
        label2.setBounds(150,190,375,30);
        add(label2);

        //for user to enter text in textfield
        textField2 = new JTextField(15);
        textField2.setBounds(325,190,230,30);//y is same as it appears with card no
        textField2.setFont(new Font("Arial",Font.BOLD,14));
        add(textField2);


        //PIN
        label3 = new JLabel("PIN: ");
        label3.setFont(new Font("Ralway",Font.BOLD,28));
        label3.setForeground(Color.WHITE);
        label3.setBounds(150,250,375,30);
        add(label3);


        //setting so user may enter password
        passwordField3 = new JPasswordField(15);
        passwordField3.setBounds(325,250,230,30);
        passwordField3.setFont(new Font("Arial",Font.BOLD,14));
        add(passwordField3);

        //sign in button
        button1 = new JButton("SIGN IN");
        button1.setFont(new Font("Arial",Font.BOLD,14));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.black); //background colour of button
        button1.setBounds(300,300,100,30);
        button1.addActionListener(this);//whenever a button is clicked , this listener listens and tells the Actionevent e that is pased to actionPerformed()
        add(button1);

        //clear button
        button2 = new JButton("CLEAR");
        button2.setFont(new Font("Arial",Font.BOLD,14));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.black); //background colour of button
        button2.setBounds(430,300,100,30);
        button2.addActionListener(this);
        add(button2);

        //sign up button
        button3 = new JButton("SIGN UP");
        button3.setFont(new Font("Arial",Font.BOLD,14));
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.black); //background colour of button
        button3.setBounds(300,350,230,30);
        button3.addActionListener(this);
        add(button3);

        //NOTE :- THE POSITIONS OF ELEMENTS R SET BY HIT & TRIAL




        //setting background,setting it after setting all images as this is background
        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("./icons/backbg.png")); //to set image on login page ,
        Image iii2 = iii1.getImage().getScaledInstance(850,4800,Image.SCALE_DEFAULT);//scaling image
        ImageIcon iii3 = new ImageIcon(iii2); //to make image visible on frame
        JLabel iiimage = new JLabel(iii3); //displaying image as label
        iiimage.setBounds(0,0,850,480);//where the image appears
        add(iiimage);//adding image on screen



        setLayout(null);//setting default layout null
        setSize(850,480); // setting size of frame
        setLocation(450,200);//so that frame opens at 450 from left x axis & 200 from top (y axis)
        setVisible(true);//setting true so as to make frame visible, always keep setvisibility after setting whatever u want to be visible

    }

    //method to be overrided so as to implement actionslistener
    @Override
    public void actionPerformed(ActionEvent e) {

        try {  //there r many errors here hence we use try catch

            if(e.getSource()==button1)//if e notifies that action is performed on button1
            {


            } else if (e.getSource()==button2) {//if e notifies that action is performed on button2

                textField2.setText("");//setting text & password fields as empty strings,so that on pressing CLEAR button these fields become empty
                passwordField3.setText("");
            } else if (e.getSource()==button3) {//if e notifies that action is performed on button3

                new Signup();
                setVisible(false); //login frame closes
            }
        }catch (Exception E)
        {
            E.printStackTrace();

        }

    }

    public static void main(String[] args) {

        new Login();

    }
}
