package Source.bankManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.toedter.calendar.JDateChooser;

public class SignUp_1 extends JFrame implements ActionListener {
    int formNo;
    JTextField nameF, fatherNameF, emailF, addressF, cityF, stateF, pinCondF;
    JDateChooser dateChooser;
    JRadioButton male, female, married, unmarried, other;
    JButton next;

    SignUp_1(){
        setTitle("SIGN UP PAGE-1");
        setLayout(null);

        //Application Form number text
        formNo = (int) Math.round(Math.random()*10000);
        JLabel formNumText = new JLabel("APPLICATION FORM NO. " + formNo);
        formNumText.setFont(new Font("Railway",Font.BOLD,32));
        formNumText.setBounds(130,20,600,40);
        add(formNumText);

        //Page 1: Personal details Text
        JLabel personalDetails = new JLabel("Page 1: Personal details");
        personalDetails.setFont(new Font("Railway",Font.BOLD,20));
        personalDetails.setBounds(210,60,400,30);
        add(personalDetails);

        //Name text
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Railway",Font.BOLD,19));
        name.setBounds(70,125,100,30);
        add(name);
        //Name text field
        nameF = new JTextField();
        nameF.setFont(new Font("Railway",Font.BOLD,14));
        nameF.setBounds(290,125,300,27);
        add(nameF);


        //Father's name text
        JLabel fatherName = new JLabel("Father's Name:");
        fatherName.setFont(new Font("Railway",Font.BOLD,19));
        fatherName.setBounds(70,160,200,30);
        add(fatherName);
        //Father's name text field
        fatherNameF = new JTextField();
        fatherNameF.setFont(new Font("Railway",Font.BOLD,14));
        fatherNameF.setBounds(290,160,300,27);
        add(fatherNameF);

        //DOB text
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Railway",Font.BOLD,19));
        dob.setBounds(70,195,200,30);
        add(dob);
        //DOB date chooser
        dateChooser = new JDateChooser();
        dateChooser.setBounds(290,195,300,29);
        dateChooser.setBackground(new Color(105,105,105));
        add(dateChooser);


        //Gender Text
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Railway",Font.BOLD,19));
        gender.setBounds(70,230,200,30);
        add(gender);
        //Gender radio button
        //male
        male = new JRadioButton(" Male");
        male.setBounds(290,230,100,30);
        male.setFocusable(false);
        male.setBackground(Color.WHITE);
        add(male);
        //female
        female = new JRadioButton(" Female");
        female.setBounds(400,230,100,30);
        female.setFocusable(false);
        female.setBackground(Color.WHITE);
        add(female);
        //group male and female
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(male);
        buttonGroup.add(female);

        //Email Address Text
        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Railway",Font.BOLD,19));
        email.setBounds(70,265,200,30);
        add(email);
        //Email text field
        emailF = new JTextField();
        emailF.setFont(new Font("Railway",Font.BOLD,14));
        emailF.setBounds(290,265,300,27);
        add(emailF);

        //Marital Status text
        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Railway",Font.BOLD,19));
        marital.setBounds(70,300,200,30);
        add(marital);
        //Marital Status radio button
        //Married
        married = new JRadioButton(" Married");
        married.setBounds(290,300,100,30);
        married.setFocusable(false);
        married.setBackground(Color.WHITE);
        add(married);
        //unmarried
        unmarried = new JRadioButton(" Unmarried");
        unmarried.setBounds(390,300,100,30);
        unmarried.setFocusable(false);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        //Other
        other = new JRadioButton(" Other");
        other.setFocusable(false);
        other.setBounds(510,300,100,30);
        other.setBackground(Color.WHITE);
        add(other);
        //group married, unmarried and others
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);

        //Address text
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Railway",Font.BOLD,19));
        address.setBounds(70,335,200,30);
        add(address);
        //Address text field
        addressF = new JTextField();
        addressF.setFont(new Font("Railway",Font.BOLD,14));
        addressF.setBounds(290,335,300,27);
        add(addressF);

        //City text
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Railway",Font.BOLD,19));
        city.setBounds(70,370,200,30);
        add(city);
        //City text field
        cityF = new JTextField();
        cityF.setFont(new Font("Railway",Font.BOLD,14));
        cityF.setBounds(290,370,300,27);
        add(cityF);

        //State text
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Railway",Font.BOLD,19));
        state.setBounds(70,405,200,30);
        add(state);
        //State text field
        stateF = new JTextField();
        stateF.setFont(new Font("Railway",Font.BOLD,14));
        stateF.setBounds(290,405,300,27);
        add(stateF);

        //Pin Code text
        JLabel pinCode = new JLabel("Pin Code:");
        pinCode.setFont(new Font("Railway",Font.BOLD,19));
        pinCode.setBounds(70,440,200,30);
        add(pinCode);
        //Pin Code text field
        pinCondF = new JTextField();
        pinCondF.setFont(new Font("Railway",Font.BOLD,14));
        pinCondF.setBounds(290,440,300,27);
        add(pinCondF);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Railway",Font.BOLD,16));
        next.setFocusable(false);
        next.setBounds(520,490,70,27);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(700,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(320,50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        //Int
        String formNum = "" + formNo;
        //Text Fields
        String name = nameF.getText();
        String fatherName = fatherNameF.getText();
        String email = emailF.getText();
        String address = addressF.getText();
        String city = cityF.getText();
        String state = stateF.getText();
        String pinCode = pinCondF.getText();
        //Date (Datechooser)
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        //Radio buttons
        String gender = null;
        if (male.isSelected()){
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }
        String marital = null;
        if (married.isSelected()){
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (other.isSelected()) {
            marital = "Other";
        }

        try {
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(null,"Name cannot be empty");
            } else if (fatherName.isEmpty()) {
                JOptionPane.showMessageDialog(null,"Father's name cannot be empty");
            }else if (email.isEmpty()) {
                JOptionPane.showMessageDialog(null,"Email Required");
            }else if (address.isEmpty()) {
                JOptionPane.showMessageDialog(null,"Address Required");
            }else if (pinCode.isEmpty()) {
                JOptionPane.showMessageDialog(null,"PIN Code Required");
            }else if (state.isEmpty()) {
                JOptionPane.showMessageDialog(null,"State cannot be empty");
            }else if (city.isEmpty()) {
                JOptionPane.showMessageDialog(null,"City Required");
            }else if (dob.isEmpty()) {
                JOptionPane.showMessageDialog(null,"Date of Birth Required");
            }else {
                ConnectionToSQL connection = new ConnectionToSQL();
                String query = "insert into signup values('"+formNum+"', '"+name+"', '"+fatherName+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+pinCode+"', '"+state+"')";
                connection.statement.executeUpdate(query);
                //SignUp_2 Object
                setVisible(false);
                new SignUp_2(formNum).setVisible(true);
            }
        }catch (Exception e){
            System.out.println("Exception Occurred: " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        new SignUp_1();
    }
}
