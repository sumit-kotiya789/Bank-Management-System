package Source.bankManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {
    String pinNumber;
    JTextField withdrawAmount;
    JButton nextBtn, backBtn;

    Withdraw(String pinNumber){
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
        JLabel transactionMsg = new JLabel("Enter the amount you want to withdraw");
        transactionMsg.setFont(new Font("System", Font.BOLD, 14));
        transactionMsg.setForeground(Color.WHITE);
        transactionMsg.setBounds(210,260,300,20);
        backgroundImage.add(transactionMsg);

        //Withdraw amount text field
        withdrawAmount = new JTextField();
        withdrawAmount.setFont(new Font("System", Font.BOLD,17));
        withdrawAmount.setBounds(185,300,300,27);
        backgroundImage.add(withdrawAmount);

        //Buttons
        nextBtn = new JButton("Next");
        nextBtn.setBounds(425,405,80,25);
        nextBtn.addActionListener(this);
        backgroundImage.add(nextBtn);
        backBtn = new JButton("Back");
        backBtn.addActionListener(this);
        backBtn.setBounds(425,435,80,25);
        backBtn.addActionListener(this);
        backgroundImage.add(backBtn);


        setSize(900,720);
        setLocation(140,0);
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String withdraw = withdrawAmount.getText();
        if(actionEvent.getSource() == nextBtn){
            if (withdraw.isEmpty()){
                JOptionPane.showMessageDialog(null,"Amount cannot be empty");
            }else {
                setVisible(false);
                new PinCheck(pinNumber,withdraw).setVisible(true);
            }
        } else if (actionEvent.getSource() == backBtn) {
            setVisible(false);
            new TransactionHome(pinNumber).setVisible(true);
        }


    }

    public static void main(String[] args) {
        new Withdraw("");
    }
}
