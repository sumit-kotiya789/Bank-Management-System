package Source.bankManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransactionHome extends JFrame implements ActionListener {
    JButton fastCash, exit, pinChange, miniStatement, cashWithdrawal, balanceEnquiry, deposit;
    String pinNumber;

    TransactionHome(String pinNumber){
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
        JLabel transactionMsg = new JLabel("Please select your Transaction");
        transactionMsg.setFont(new Font("System", Font.BOLD, 14));
        transactionMsg.setForeground(Color.WHITE);
        transactionMsg.setBounds(210,270,300,20);
        backgroundImage.add(transactionMsg);

        //Buttons
        deposit = new JButton("Deposit");
        deposit.addActionListener(this);
        deposit.setBounds(170,352,137,25);
        backgroundImage.add(deposit);

        fastCash = new JButton("Fast Cash");
        fastCash.addActionListener(this);
        fastCash.setBounds(170,382,137,25);
        backgroundImage.add(fastCash);

        pinChange = new JButton("Pin Change");
        pinChange.addActionListener(this);
        pinChange.setBounds(170,412,137,25);
        backgroundImage.add(pinChange);

        cashWithdrawal = new JButton("Cash Withdraw");
        cashWithdrawal.addActionListener(this);
        cashWithdrawal.setBounds(365,352,137,25);
        backgroundImage.add(cashWithdrawal);

        miniStatement = new JButton("Mini Statement");
        miniStatement.addActionListener(this);
        miniStatement.setBounds(365,382,137,25);
        backgroundImage.add(miniStatement);

        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.addActionListener(this);
        balanceEnquiry.setBounds(365,412,137,25);
        backgroundImage.add(balanceEnquiry);

        exit = new JButton("Exit");
        exit.addActionListener(this);
        exit.setBounds(365,440,137,25);
        backgroundImage.add(exit);
        

        setSize(900,720);
        setLocation(140,0);
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == exit){
            System.exit(0);
        } else if (actionEvent.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        } else if (actionEvent.getSource() == cashWithdrawal) {
            setVisible(false);
            new Withdraw(pinNumber).setVisible(true);
        } else if (actionEvent.getSource() == fastCash) {
            setVisible(false);
            new FastCash(pinNumber);
        } else if (actionEvent.getSource() == pinChange) {
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        } else if (actionEvent.getSource() == balanceEnquiry) {
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
        } else if (actionEvent.getSource() ==  miniStatement) {
            new MiniStatement(pinNumber).setVisible(true);
        }
    }
    
    
    public static void main(String[] args) {
        new TransactionHome("");
    }

    
}
