package Source.bankManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FastCash extends JFrame implements ActionListener {
    JButton withdraw100, back, withdraw500, withdraw1000, withdraw2000, withdraw5000, withdraw10000;
    String pinNumber;

    FastCash(String pinNumber){
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
        JLabel transactionMsg = new JLabel("SELECT WITHDRAWAL AMOUNT");
        transactionMsg.setFont(new Font("System", Font.BOLD, 14));
        transactionMsg.setForeground(Color.WHITE);
        transactionMsg.setBounds(220,290,300,20);
        backgroundImage.add(transactionMsg);

        //Buttons
        withdraw100 = new JButton("Rs 100");
        withdraw100.addActionListener(this);
        withdraw100.setBounds(170,352,137,25);
        backgroundImage.add(withdraw100);

        withdraw1000 = new JButton("Rs 1000");
        withdraw1000.addActionListener(this);
        withdraw1000.setBounds(170,382,137,25);
        backgroundImage.add(withdraw1000);

        withdraw5000 = new JButton("Rs 5000");
        withdraw5000.addActionListener(this);
        withdraw5000.setBounds(170,412,137,25);
        backgroundImage.add(withdraw5000);

        withdraw500 = new JButton("Rs 500");
        withdraw500.addActionListener(this);
        withdraw500.setBounds(365,352,137,25);
        backgroundImage.add(withdraw500);

        withdraw2000 = new JButton("Rs 2000");
        withdraw2000.addActionListener(this);
        withdraw2000.setBounds(365,382,137,25);
        backgroundImage.add(withdraw2000);

        withdraw10000 = new JButton("Rs 10000");
        withdraw10000.addActionListener(this);
        withdraw10000.setBounds(365,412,137,25);
        backgroundImage.add(withdraw10000);

        back = new JButton("Back");
        back.addActionListener(this);
        back.setBounds(365,440,137,25);
        backgroundImage.add(back);


        setSize(900,720);
        setLocation(140,0);
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == back){
            setVisible(false);
            new TransactionHome(pinNumber).setVisible(true);
        } else {
            String withdraw = ((JButton)actionEvent.getSource()).getText().substring(3);
            setVisible(false);
            new PinCheck(pinNumber,withdraw).setVisible(true);
        }

    }


    public static void main(String[] args) {
        new FastCash("");
    }


}
