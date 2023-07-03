//SIGNUP CLASS
package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup extends JFrame implements ActionListener {
    JButton next;
    JRadioButton r1,r2,m1,m2,m3; //radiobutton

    JTextField textName,textFname,textEmail,textAdd,textCity,textPin,textState;//for taking name as i/p

    JDateChooser dateChooser; //for choosing dates by opening calender ; downloaded external jar file for it.
    Random ran = new Random();//util.random for random application no.
    long first4 = (ran.nextLong()%9000L)+1000L;//to keep max as 9999(4 digit) , coz divide by 9000 gives <9000 and add 1000

    String first = " " + Math.abs(first4);
    Signup()
    {
        super("VERGAB'S APPLICATION FORM");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./icons/bank.png")); //to set image on login page ,
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);//scaling image
        ImageIcon i3 = new ImageIcon(i2); //to make image visible on frame we reconvert it
        JLabel image = new JLabel(i3); //displaying image as label
        image.setBounds(25,10,100,100);//where the image appears
        add(image);//adding image on frame

        //APPL. NO
        JLabel label1 = new JLabel("APPLICATION FORM NO." +first);
        label1.setBounds(160,20,600,40);
        label1.setFont(new Font("Raleway",Font.BOLD,38));
        add(label1);


        //PAGE 1
        JLabel label2 = new JLabel("Page 1");
        label2.setBounds(380,70,600,30);
        label2.setFont(new Font("Raleway",Font.BOLD,22));
        add(label2);

        JLabel label3 = new JLabel("Personal Details");
        label3.setBounds(315,90,600,40);
        label3.setFont(new Font("Raleway",Font.BOLD,25));
        add(label3);

        //NAME
        JLabel labelName = new JLabel("Name : ");
        labelName.setFont(new Font("Raleway",Font.BOLD,20));
        labelName.setBounds(100,190,100,30);
        add(labelName);


        //NAME TEXTFIELD
        textName = new JTextField();
        textName.setFont(new Font("Raleway",Font.BOLD,14));
        textName.setBounds(300,190,400,30);
        add(textName);

        // FATHER'S NAME
        JLabel labelFName = new JLabel("Father's Name : ");
        labelFName.setFont(new Font("Raleway",Font.BOLD,20));
        labelFName.setBounds(100,240,200,35);
        add(labelFName);


        // FATHER NAME TEXTFIELD
        textFname = new JTextField();
        textFname.setFont(new Font("Raleway",Font.BOLD,14));
        textFname.setBounds(300,240,400,30);
        add(textFname);

        //DOB
        JLabel dob = new JLabel("Date of Birth : ");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,340,200,35);
        add(dob);

        //opens up calender
        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setBounds(300,340,400,30);
        add(dateChooser);

       //GENDER
        JLabel labelG  = new JLabel("Gender : ");
        labelG.setFont(new Font("Raleway",Font.BOLD,20));
        labelG.setBounds(100,290,200,30);
        add(labelG);

        //RADIOBUTTONS
        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway",Font.BOLD,14));
        r1.setBounds(300,290,60,30);
        r1.setBackground(new Color(222,255,228));
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway",Font.BOLD,14));
        r2.setBounds(450,290,90,30);
        r2.setBackground(new Color(222,255,228));
        add(r2);

        //we r adding the 2 buttons to a button group because we only want one  of them to be selected at a time
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);

        //EMAIL
        JLabel labelemail = new JLabel("Email Address : ");
        labelemail.setFont(new Font("Raleway",Font.BOLD,20));
        labelemail.setBounds(100,390,200,30);
        add(labelemail);


        textEmail = new JTextField();
        textEmail.setFont(new Font("Raleway",Font.BOLD,14));
        textEmail.setBounds(300,390,400,30);
        add(textEmail);

        //MARRAIGE STATUS
        JLabel labelms = new JLabel("Marital Status : ");
        labelms.setFont(new Font("Raleway",Font.BOLD,20));
        labelms.setBounds(100,440,200,30);
        add(labelms);

        //RADIOBUTTONS
        m1 = new JRadioButton("Married");
        m1.setFont(new Font("Raleway",Font.BOLD,14));
        m1.setBounds(300,440,100,30);
        m1.setBackground(new Color(222,255,228));
        add(m1);

        m2 = new JRadioButton("Unmarried");
        m2.setFont(new Font("Raleway",Font.BOLD,14));
        m2.setBounds(450,440,100,30);
        m2.setBackground(new Color(222,255,228));
        add(m2);

        m3 = new JRadioButton("Other");
        m3.setFont(new Font("Raleway",Font.BOLD,14));
        m3.setBounds(600,440,100,30);
        m3.setBackground(new Color(222,255,228));
        add(m3);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(m1);
        buttonGroup1.add(m2);
        buttonGroup1.add(m3);




        //ADDRESS
        JLabel labelADD = new JLabel("Address : ");
        labelADD.setFont(new Font("Raleway",Font.BOLD,20));
        labelADD.setBounds(100,490,200,30);
        add(labelADD);


        textAdd = new JTextField();
        textAdd.setFont(new Font("Raleway",Font.BOLD,14));
        textAdd.setBounds(300,490,400,30);
        add(textAdd);

        //CITY
        JLabel labelCity = new JLabel("City : ");
        labelCity.setFont(new Font("Raleway",Font.BOLD,20));
        labelCity.setBounds(100,540,200,30);
        add(labelCity);


        textCity = new JTextField();
        textCity.setFont(new Font("Raleway",Font.BOLD,14));
        textCity.setBounds(300,540,400,30);
        add(textCity);

        //PINCODE
        JLabel labelPin = new JLabel("Pin : ");
        labelPin.setFont(new Font("Raleway",Font.BOLD,20));
        labelPin.setBounds(100,590,200,30);
        add(labelPin);


        textPin = new JTextField();
        textPin.setFont(new Font("Raleway",Font.BOLD,14));
        textPin.setBounds(300,590,400,30);
        add(textPin);

        //STATE
        JLabel labelState = new JLabel("State : ");
        labelState.setFont(new Font("Raleway",Font.BOLD,20));
        labelState.setBounds(100,640,200,30);
        add(labelState);


        textState = new JTextField();
        textState.setFont(new Font("Raleway",Font.BOLD,14));
        textState.setBounds(300,640,400,30);
        add(textState);



        next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBackground(Color.BLACK); //background colour white
        next.setForeground(Color.WHITE); //text colour white
        next.setBounds(620,710,80,30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(new Color(222,255,228)); //setting background
        setLayout(null);
        setSize(850,800);//frame size
        setLocation(360,40);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {//we put the data in db

        //GETTING ALL THE DATA FROM SIGNUP PAGE
        String formno = first; //getting formno
        String name = textName.getText();//getting text from name textfield
        String fname = textFname.getText();//getting father's name

        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText(); //getting dob from calender

        String gender = null; //getting gender form radiobuttons
        if(r1.isSelected())
            gender = "Male";
        else if (r2.isSelected())
        {
            gender = "Female";
        }

        String email = textEmail.getText();

        String marital = null;//getting m status from radiobuttons
        if(m1.isSelected())
        {
            marital ="Married";
        }
        else if(m2.isSelected())
            marital="Unmarried";
        else if(m3.isSelected())
            marital="Other";

        String address = textAdd.getText();
        String city = textCity.getText();
        String pin = textPin.getText();
        String state = textState.getText();

        //PUTTING DATA IN DB.
        try {    //as we r putting info in db , we can encounter some exception.
            if(textName.getText().equals("")){ //if textfield is not fields
                JOptionPane.showMessageDialog(null,"Fill all the fields"); //displays dialog box
            }
            else{
                Con con1 = new Con();
                String q = "insert into signup values('"+formno+"','"+name+"','"+formno+"','"+dob+"','"+gender+"', '"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";//sql query
                con1.statement.executeUpdate(q);  //to execute and update db,to input value in table

                 new Signup2();
                 setVisible(false);
            }

        }catch (Exception E)
        {
            E.printStackTrace();
        }




    }

    public static void main(String[] args) {
        new Signup();
    }
}
