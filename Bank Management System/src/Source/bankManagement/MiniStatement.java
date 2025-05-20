package Source.bankManagement;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {

    MiniStatement(String pinNumber){
        setTitle("Mini Statement");
        setLayout(null);

        //Bank name
        JLabel bankName = new JLabel("Indian Bank");
        bankName.setFont(new Font("System",Font.BOLD,19));
        bankName.setBounds(80,25,200,20);
        add(bankName);

        //Card
        JLabel card = new JLabel();
        card.setFont(new Font("System",Font.BOLD,12));
        card.setBounds(20,65,250,20);
        add(card);

        //Balance
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
        //Balance Text
        JLabel balanceText = new JLabel("Total available balance: Rs " + balance);
        balanceText.setFont(new Font("System", Font.BOLD,14));
        balanceText.setBounds(20,95,250,25);
        add(balanceText);

        //Mini Statement text heading
        JLabel miniText = new JLabel("Your last 10 transactions");
        miniText.setFont(new Font("System",Font.BOLD,15));
        miniText.setBounds(20,135,200,20);
        add(miniText);

        //Mini statement
        JLabel mini = new JLabel();
        mini.setFont(new Font("System",Font.BOLD,10));
        mini.setBounds(20,145,300,250);
        add(mini);


        ResultSet resultSet;
        try{
            resultSet = connection.statement.executeQuery("select * from login where PIN = '"+pinNumber+"'");
            while (resultSet.next()){
                card.setText("Card Number: " + resultSet.getString("Card_Number").
                        substring(0,4) + "XXXXXXXX" + resultSet.getString("Card_Number").
                        substring(12));
            }
        }catch (Exception e){
            System.out.println("Exception Occurred: " + e.getMessage());
        }

        //Mini Statement
        String miniStatement = "<html>";
        try{
            resultSet = connection.statement.
                    executeQuery("select * from bank where PIN = '"+pinNumber+"' order by dateOfTransaction desc limit 10");

            while (resultSet.next()) {
                miniStatement += resultSet.getString("dateOfTransaction") + "      " + resultSet.
                        getString("typeOfTransaction") + "   " +resultSet.getString("amount") + "<br><hr>";
            }
            miniStatement += "</html>";
        }catch (Exception e){
            System.out.println("Exception Occurred: " + e.getMessage());
        }
        mini.setForeground(Color.DARK_GRAY);
        mini.setText(miniStatement);



        getContentPane().setBackground(Color.WHITE);
        setSize(300,450);
        setLocation(30,40);
        setVisible(true);
    }




    public static void main(String[] args) {
        new MiniStatement("");
    }
}
