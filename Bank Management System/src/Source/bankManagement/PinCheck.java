package Source.bankManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class PinCheck extends JFrame implements ActionListener {
    String pinNumber, withdraw;
    JPasswordField pinText;
    JButton next, cancel;

    PinCheck(String pinNumber, String withdraw){
        this.pinNumber = pinNumber;
        this.withdraw = withdraw;

        setLayout(null);

        JLabel text = new JLabel("Enter PIN");
        text.setFont(new Font("System", Font.BOLD, 28));
        text.setBounds( 120,30,180,30);
        add(text);

        pinText = new JPasswordField();
        pinText.setFont(new Font("System", Font.BOLD, 20));
        pinText.setBounds( 75,80,230,30);
        add(pinText);

        next = new JButton("Continue");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("System", Font.BOLD, 13));
        next.addActionListener(this);
        next.setBounds( 250,140,100,25);
        add(next);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("System", Font.BOLD, 13));
        cancel.addActionListener(this);
        cancel.setBounds( 250,170,100,25);
        add(cancel);



        setSize(400,210);
        getContentPane().setBackground(Color.WHITE);
        setLocation(410,270);
        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String enteredPin = pinText.getText();
        int balance = 0;
        ConnectionToSQL connection = new ConnectionToSQL();
        if(actionEvent.getSource() == next){
            if(enteredPin.equals(pinNumber)){

                try{
                    ResultSet resultSet = connection.statement.executeQuery("select*from bank where PIN = '"+pinNumber+"'");
                    //Check Balance in account
                    while (resultSet.next()){
                        if(resultSet.getString("typeOfTransaction").equals("Deposit")){
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        }else {
                            balance -= Integer.parseInt(resultSet.getString("amount"));
                        }
                    }
                    if(balance < Integer.parseInt(withdraw)){
                        JOptionPane.showMessageDialog(null,"Insufficient Balance");
                        setVisible(false);
                        new TransactionHome(pinNumber).setVisible(true);
                    }else {
                        //Withdrawal
                        Date date = new Date();
                        String query = "insert into bank values('" + pinNumber + "', '" + date + "', 'Withdraw', '" + withdraw + "')";
                        connection.statement.executeUpdate(query);
                        JOptionPane.showMessageDialog(null,"Rs. " + withdraw + " withdraw successfully!");
                        setVisible(false);
                        //Access caller class
                        new TransactionHome(pinNumber).setVisible(true);
                    }

                } catch (Exception e){
                    System.out.println("Exception Occurred: " + e.getMessage());
                }
            }else {
                JOptionPane.showMessageDialog(null,"Incorrect PIN!");
                setVisible(false);
                new PinCheck(pinNumber, withdraw).setVisible(true);
            }
        } else if (actionEvent.getSource() == cancel) {
            setVisible(false);
            new TransactionHome(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new PinCheck("","");
    }


}
