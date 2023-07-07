//SIGNUP 2
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup2 extends JFrame implements ActionListener {
    JButton next;
    JRadioButton r1,r2,e1,e2;
    JTextField textpan,textaddhar;
    JComboBox comboBox,comboBox2,comboBox3,comboBox4,comboBox5,comboBox6;//drop down
    String formno; // to get form no from signup
    Signup2(String first)
    {
        super("VERGAB'S APPLICATION FROM");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./icons/bank.png")); //to set image on login page ,
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);//scaling image
        ImageIcon i3 = new ImageIcon(i2); //to make image visible on frame we reconvert it
        JLabel image = new JLabel(i3); //displaying image as label
        image.setBounds(150,10,100,100);//where the image appears
        add(image);//adding image on frame
        this.formno = first;  //form no from signup

        //PAGE 2
        JLabel l1 = new JLabel("Page 2 :-");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(300,30,600,40);
        add(l1);

        //ADDITIONAL DETAILS
        JLabel l2 = new JLabel("Additional Details");
        l2.setFont(new Font("Raleway",Font.BOLD,22));
        l2.setBounds(300,60,600,40);
        add(l2);

       //RELIGION
        JLabel l3 = new JLabel("Religion");
        l3.setFont(new Font("Raleway",Font.BOLD,18));
        l3.setBounds(100,120,100,30);
        add(l3);

        // RELIGION DROPDOWN
        String[] religion ={"Hinduism","Islam","Christianity","Sikhism","Others" };//array to be in dropdown
        comboBox = new JComboBox(religion);
        comboBox.setBackground(new Color(252,208,76));
        comboBox.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox.setBounds(350,120,320,30);
        add(comboBox);

        //CATEGORY
        JLabel l4 = new JLabel("Category :-");
        l4.setFont(new Font("Raleway",Font.BOLD,18));
        l4.setBounds(100,170,100,30);
        add(l4);


        //RESERVATION DROPDOWN
        String[] category ={"General","OBC","SC","ST"};//array to be in dropdown
        comboBox2 = new JComboBox(category);
        comboBox2.setBackground(new Color(252,208,76));
        comboBox2.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox2.setBounds(350,170,320,30);
        add(comboBox2);


        //INCOME
        JLabel l5 = new JLabel("Income :-");
        l5.setFont(new Font("Raleway",Font.BOLD,18));
        l5.setBounds(100,220,100,30);
        add(l5);


        //INCOME DROPDOWN
        String[] income ={"null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};//array to be in dropdown
        comboBox3 = new JComboBox(income);
        comboBox3.setBackground(new Color(252,208,76));
        comboBox3.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox3.setBounds(350,220,320,30);
        add(comboBox3);

        //EDUCATION
        JLabel l6 = new JLabel("Education :-");
        l6.setFont(new Font("Raleway",Font.BOLD,18));
        l6.setBounds(100,270,150,30);
        add(l6);


        //EDUCATIONAL DROPDOWN
        String[] education ={"Non-graduate","Graduate","Post graduate","Doctrate","Others"};//array to be in dropdown
        comboBox4 = new JComboBox(education);
        comboBox4.setBackground(new Color(252,208,76));
        comboBox4.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox4.setBounds(350,270,320,30);
        add(comboBox4);

        // occupation CATEGORY
        JLabel l7 = new JLabel("Occupation :-");
        l7.setFont(new Font("Raleway",Font.BOLD,18));
        l7.setBounds(100,320,150,30);
        add(l7);


        //OCCUPATION DROPDOWN
        String[] occupation ={"Salaried","Self-employed","Business","Student","Retired","Other"};//array to be in dropdown
        comboBox5 = new JComboBox(occupation);
        comboBox5.setBackground(new Color(252,208,76));
        comboBox5.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox5.setBounds(350,320,320,30);
        add(comboBox5);

        //PAN NO.:-
        JLabel l8 = new JLabel("PAN Number :-");
        l8.setFont(new Font("Raleway",Font.BOLD,18));
        l8.setBounds(100,390,150,30);
        add(l8);

        textpan = new JTextField();
        textpan.setFont(new Font("Raleway",Font.BOLD,18));
        textpan.setBounds(350,390,150,30);
        add(textpan);

        //ADDHAR NO
        JLabel l9 = new JLabel("ADHAR Number :-");
        l9.setFont(new Font("Raleway",Font.BOLD,18));
        l9.setBounds(100,440,200,30);
        add(l9);

        textaddhar = new JTextField();
        textaddhar.setFont(new Font("Raleway",Font.BOLD,18));
        textaddhar.setBounds(350,440,150,30);
        add(textaddhar);

        //senior citizen
        JLabel l10 = new JLabel("Senior Citizen :-");
        l10.setFont(new Font("Raleway",Font.BOLD,18));
        l10.setBounds(100,490,180,30);
        add(l10);

        //YES OR NO
        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Raleway",Font.BOLD,14));
        r1.setBackground(new Color(252,208,76));
        r1.setBounds(350,490,100,30);
        add(r1);

        r2 = new JRadioButton("No");
        r2.setFont(new Font("Raleway",Font.BOLD,14));
        r2.setBackground(new Color(252,208,76));
        r2.setBounds(460,490,100,30);
        add(r2);

        //EXISTING ACCOUNT
        JLabel l11 = new JLabel("Existing Account :-");
        l11.setFont(new Font("Raleway",Font.BOLD,18));
        l11.setBounds(100,540,180,30);
        add(l11);

        //YES OR NO
        e1 = new JRadioButton("Yes");
        e1.setFont(new Font("Raleway",Font.BOLD,14));
        e1.setBackground(new Color(252,208,76));
        e1.setBounds(350,540,100,30);
        add(e1);

        e2 = new JRadioButton("No");
        e2.setFont(new Font("Raleway",Font.BOLD,14));
        e2.setBackground(new Color(252,208,76));
        e2.setBounds(460,540,100,30);
        add(e2);


        //FROM NO
        JLabel l12 = new JLabel("Form No. :-");
        l12.setFont(new Font("Raleway",Font.BOLD,18));
        l12.setBounds(700,10,100,30);
        add(l12);

        JLabel l13 = new JLabel(formno);
        l13.setFont(new Font("Raleway",Font.BOLD,18));
        l13.setBounds(760,10,60,30);
        add(l13);



        //NEXT BUTTON
        next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBackground(Color.WHITE);
        next.setForeground(Color.black);
        next.setBounds(570,640,100,30);
        next.addActionListener(this);
        add(next);




        setLayout(null);
        setSize(850,750);
        setLocation(450,80);
        getContentPane().setBackground(new Color(252,208,76));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String rel = (String) comboBox.getSelectedItem();//get from combobox
        String cat = (String) comboBox2.getSelectedItem();
        String inc = (String) comboBox3.getSelectedItem();
        String edu = (String) comboBox4.getSelectedItem();
        String occ = (String) comboBox5.getSelectedItem();
        String pan = (String) textpan.getText();
        String aadhar = (String) textaddhar.getText();

        String scitizen = null; //for senior citizen
        if(r1.isSelected()){
            scitizen = "Yes";
        } else if (r2.isSelected()) {
            scitizen="No";
        }

        String eAccount = null; //for eaccount
        if(e1.isSelected())
            eAccount = "Yes";
        else if (e2.isSelected()) {
            eAccount = "No";

        }

        try {
            if(textpan.getText().equals("")|| textaddhar.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Fill all the fields");
            }
            else {
                Con c1 = new Con();
                String q = "INSERT INTO signup2 VALUES('"+formno+"','"+rel+"','"+cat+"','"+inc+"','"+edu+"','"+occ+"','"+pan+"','"+aadhar+"','"+scitizen+"','"+eAccount+"')";
                c1.statement.executeUpdate(q); //when we insert/update we used executeUpdate
                new Signup3(formno);//if data is not inserted then Signup3 page wont open .
                setVisible(false);
            }

        }catch (Exception E)
        {
            E.printStackTrace();;
        }


    }

    public static void main(String[] args) {
        new Signup2("");
    }
}
