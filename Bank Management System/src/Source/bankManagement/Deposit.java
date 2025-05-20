package Source.bankManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    String pinNumber;
    JTextField depositAmount;
    JButton depositBtn, backBtn;

    Deposit(String pinNumber){
        this.pinNumber = pinNumber;

        setLayout(null);
        //Image
        ImageIcon i1 = new ImageIcon("C:\\Users\\HP\\Desktop\\Projects\\Bank Management System\\src\\Source\\icons\\atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(900,760,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel backgroundImage = new JLabel(i3);
        backgroundImage.setBounds(0,0,900,760);
        add(backgroundImage);

        //Text
        JLabel transactionMsg = new JLabel("Enter the amount you want to deposit");
        transactionMsg.setFont(new Font("System", Font.BOLD, 14));
        transactionMsg.setForeground(Color.WHITE);
        transactionMsg.setBounds(210,260,300,20);
        backgroundImage.add(transactionMsg);

        //Deposit amount text field
        depositAmount = new JTextField();
        depositAmount.setFont(new Font("System", Font.BOLD,17));
        depositAmount.setBounds(185,300,300,27);
        backgroundImage.add(depositAmount);

        //Buttons
        depositBtn = new JButton("Deposit");
        depositBtn.addActionListener(this);
        depositBtn.setBounds(425,405,80,25);
        backgroundImage.add(depositBtn);
        backBtn = new JButton("Back");
        backBtn.addActionListener(this);
        backBtn.setBounds(425,435,80,25);
        backgroundImage.add(backBtn);


        setSize(900,720);
        setLocation(140,0);
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == depositBtn){
            String deposit = depositAmount.getText();
            if (deposit.isEmpty()){
                JOptionPane.showMessageDialog(null,"Amount cannot be empty");
            }else {
                Date date = new Date();
                try {
                    ConnectionToSQL connection = new ConnectionToSQL();
                    String query = "insert into bank values('" + pinNumber + "', '" + date + "', 'Deposit', '" + deposit + "')";
                    connection.statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs. " + deposit + " deposited successfully!");
                    setVisible(false);
                    new TransactionHome(pinNumber).setVisible(true);
                }catch (Exception e){
                    System.out.println("Exception Occurred: " + e.getMessage());
                }
            }

        } else if (actionEvent.getSource() == backBtn) {
            setVisible(false);
            new TransactionHome(pinNumber).setVisible(true);
        }


    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
