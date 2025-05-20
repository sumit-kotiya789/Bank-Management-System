package Source.bankManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    String pinNumber;
    JTextField newPinF, reEnterPinF;
    JButton change, back;

    PinChange(String pinNumber){
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
        JLabel changePinText = new JLabel("CHANGE YOUR PIN");
        changePinText.setFont(new Font("System", Font.BOLD, 19));
        changePinText.setForeground(Color.WHITE);
        changePinText.setBounds(235,260,300,20);
        backgroundImage.add(changePinText);

        //New Pin Text
        JLabel newPinText = new JLabel("New PIN:");
        newPinText.setFont(new Font("System", Font.BOLD, 14));
        newPinText.setForeground(Color.WHITE);
        newPinText.setBounds(185,300,100,20);
        backgroundImage.add(newPinText);
        //Text field
        newPinF = new JTextField();
        newPinF.setFont(new Font("System", Font.BOLD, 16));
        newPinF.setBounds(340,300,165,25);
        backgroundImage.add(newPinF);


        //Re-enter New Pin Text
        JLabel reEnterText = new JLabel("Re-Enter New PIN:");
        reEnterText.setFont(new Font("System", Font.BOLD, 14));
        reEnterText.setForeground(Color.WHITE);
        reEnterText.setBounds(185,340,150,20);
        backgroundImage.add(reEnterText);
        //Text field
        reEnterPinF = new JTextField();
        reEnterPinF.setFont(new Font("System", Font.BOLD, 16));
        reEnterPinF.setBounds(340,340,165,25);
        backgroundImage.add(reEnterPinF);

        //Buttons
        change = new JButton("CHANGE");
        change.setBounds(413,413,100,20);
        change.addActionListener(this);
        backgroundImage.add(change);

        back = new JButton("BACK");
        back.setBounds(413,441,100,20);
        back.addActionListener(this);
        backgroundImage.add(back);



        setSize(900,720);
        setLocation(140,0);
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent){
        if(actionEvent.getSource() == change){
            String newPin = newPinF.getText();
            String reEnteredPin = reEnterPinF.getText();
            if (newPin.isEmpty()) {
                JOptionPane.showMessageDialog(null,"Please enter new PIN");
            } else if (reEnteredPin.isEmpty()) {
                JOptionPane.showMessageDialog(null,"Please Re-enter new PIN");
            } else if(newPin.equals(reEnteredPin)){
                ConnectionToSQL connection = new ConnectionToSQL();

                String query1 = "update bank set PIN = '"+newPin+"' where PIN = '"+pinNumber+"'";
                String query2 = "update login set PIN = '"+newPin+"' where PIN = '"+pinNumber+"'";
                String query3 = "update signup3 set PIN = '"+newPin+"' where PIN = '"+pinNumber+"'";

                try{
                    connection.statement.executeUpdate(query1);
                    connection.statement.executeUpdate(query2);
                    connection.statement.executeUpdate(query3);

                }catch (Exception e){
                    System.out.println("Exception Occurred: " + e.getMessage());
                }
                JOptionPane.showMessageDialog(null,"PIN change successful\nNew PIN: " + newPin);
                setVisible(false);
                new TransactionHome(newPin).setVisible(true);
            } else{
                JOptionPane.showMessageDialog(null,"PIN doesn't match");
                newPinF.setText("");
                reEnterPinF.setText("");
            }


        } else if (actionEvent.getSource() == back) {
            setVisible(false);
            new TransactionHome(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new PinChange("");
    }
}
