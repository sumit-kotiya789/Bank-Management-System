package Source.bankManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String pinNumber;
    JButton back;

    BalanceEnquiry(String pinNumber){
        this.pinNumber = pinNumber;

        setLayout(null);
        //Image
        ImageIcon i1 = new ImageIcon("C:\\Users\\HP\\Desktop\\Projects\\Bank Management System\\src\\Source\\icons\\atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(900,760,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel backgroundImage = new JLabel(i3);
        backgroundImage.setBounds(0,0,900,760);
        add(backgroundImage);


        int balance = 0;
        String query = "select * from bank where PIN = '"+pinNumber+"'";
        ConnectionToSQL connection = new ConnectionToSQL();
        try{
            ResultSet resultSet = connection.statement.executeQuery(query);
            while (resultSet.next()){
                if (resultSet.getString("typeOfTransaction").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else if (resultSet.getString("typeOfTransaction").equals("Withdraw")) {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        }catch (Exception e){
            System.out.println("Exception Occurred: " + e.getMessage());
        }



        JLabel balanceText = new JLabel("Total available balance: Rs " + balance);
        balanceText.setFont(new Font("System", Font.BOLD,16));
        balanceText.setForeground(Color.WHITE);
        balanceText.setBounds(190,270,300,20);
        backgroundImage.add(balanceText);


        //button
        back = new JButton("BACK");
        back.setBounds(415,440,100,20);
        back.addActionListener(this);
        backgroundImage.add(back);



        setSize(900,720);
        setLocation(140,0);
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent activeEvent){
        setVisible(false);
        new TransactionHome(pinNumber).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }

}
