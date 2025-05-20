package Source.bankManagement;

import javax.swing.*;       //javaX means Extended package of java
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton signInBtn, clearBtn, signUpBtn;         //button declared globally to be accessed by different functions
    JTextField cardTextField;         //Text fields
    JPasswordField pinTextField;



    Login(){
        setTitle("Sumit's ATM");            //Set the title of frame
        setLayout(null);            //default layout center(koi bhi new cheej ko default center mai place kr deta hai); so null

        //Bank logo
        ImageIcon logo = new ImageIcon("C:\\Users\\HP\\Desktop\\Projects\\Bank\\src\\Source\\icons\\logo.jpg");   //creates image(logo) object
        Image logoImg = logo.getImage().getScaledInstance(85, 80, Image.SCALE_DEFAULT); //we cannot pass Image obj to JLabel
        ImageIcon finalLogo = new ImageIcon(logoImg);
        JLabel label1 = new JLabel(finalLogo);          //JLabel use to write any content on frame
        label1.setBounds(80,20,85,80);          //Set position w.r.t frame
        add(label1);            //Add any label to frame

        //Welcome text
        JLabel welcome = new JLabel("Welcome to ATM");      //JLabel use to write any content on frame
        welcome.setFont(new Font("Osward",Font.BOLD,38));       //To set font
        welcome.setBounds(200,30,350,60);
        add(welcome);

        //Card Number text
        JLabel card = new JLabel("Card No.");      //JLabel use to write any content on frame
        card.setFont(new Font("Railway",Font.BOLD,28));
        card.setBounds(120,140,150,30);
        add(card);

        //Card Text Field
        cardTextField = new JTextField();
        cardTextField.setBounds(300,140,210,33);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 17));
        add(cardTextField);

        //Pin text
        JLabel pin = new JLabel("PIN");      //JLabel use to write any content on frame
        pin.setFont(new Font("Railway",Font.BOLD,28));
        pin.setBounds(120,220,200,30);
        add(pin);

        //PIN text field
        pinTextField = new JPasswordField();         //To create text field
        pinTextField.setBounds(300,220,210,33);
        pinTextField.setFont(new Font("Railway", Font.BOLD, 17));
        add(pinTextField);

        //Sign in button
        signInBtn = new JButton("LOG IN");         //To create a button
        signInBtn.setBackground(new Color(37, 87, 7));
        signInBtn.setForeground(Color.WHITE);
        signInBtn.setFocusable(false);
        signInBtn.setBounds(300,300, 100,30);
        signInBtn.addActionListener(this);                  //notify when button clicked
        add(signInBtn);

        //Clear Button
        clearBtn = new JButton("CLEAR");
        clearBtn.setBackground(new Color(181,9,9));
        clearBtn.setForeground(Color.WHITE);
        clearBtn.setFocusable(false);
        clearBtn.setBounds(410,300,100,30);
        clearBtn.addActionListener(this);
        add(clearBtn);

        //Sign up button
        signUpBtn = new JButton("REGISTER");
        signUpBtn.setBackground(Color.BLACK);
        signUpBtn.setForeground(Color.WHITE);
        signUpBtn.setFocusable(false);
        signUpBtn.setBounds(300,350,210,30);
        signUpBtn.addActionListener(this);
        add(signUpBtn);




        getContentPane().setBackground(Color.WHITE);       //Set color of frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 480);      //Set the size of frame
        setVisible(true);               //make frame visible to user
        setLocation(250,130);       //Set the location from (left,top)
    }


    @Override
    public void actionPerformed(ActionEvent action){        //action is obj of action performed
        if (action.getSource() == signInBtn){       //getSource return the source of action performed(button clicked)
            String cardNumber =  cardTextField.getText();
            String pinNumber = pinTextField.getText();

            ConnectionToSQL connection = new ConnectionToSQL();
            String query = "select * from login where Card_Number = '"+cardNumber+"' and PIN = '"+pinNumber+"'";
            try{
                ResultSet res = connection.statement.executeQuery(query);
                if(res.next()){
                    setVisible(false);
                    new TransactionHome(pinNumber).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid Card Number or Pin");
                }
            }catch (Exception e){
                System.out.println("Exception Occurred: " + e.getMessage());
            }
        } else if (action.getSource() == clearBtn) {
            cardTextField.setText("");         //setText ->sets the text
            pinTextField.setText("");
        } else if (action.getSource() == signUpBtn) {
            setVisible(false);
            new SignUp_1().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
