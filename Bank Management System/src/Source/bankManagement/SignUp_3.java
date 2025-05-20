package Source.bankManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp_3 extends JFrame implements ActionListener {
    JRadioButton saving, FD, current, RD;
    JCheckBox ATMCard, internetBanking, mobileBanking, emailAndSMS, chequeBook, EStatement, declaration;
    JButton submit, cancel;
    String formNum;

    SignUp_3(String formNum){
        this.formNum = formNum;
        setTitle("SIGN UP PAGE-3");
        setLayout(null);

        //Account Details text
        JLabel accountDetails = new JLabel("Page 3: Account Details");
        accountDetails.setFont(new Font("Railway",Font.BOLD,20));
        accountDetails.setBounds(165,25,600,40);
        add(accountDetails);

        //Account Type text
        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Railway",Font.BOLD,20));
        type.setBounds(50,80,300,40);
        add(type);
        //Account Type Radio buttons
        //Saving
        saving = new JRadioButton("Saving Account");
        saving.setBackground(Color.WHITE);
        saving.setFont(new Font("Railway",Font.BOLD,14));
        saving.setBounds(55,115,150,30);
        add(saving);
        //Current
        current = new JRadioButton("Current Account");
        current.setBackground(Color.WHITE);
        current.setFont(new Font("Railway",Font.BOLD,14));
        current.setBounds(55,145,150,30);
        add(current);
        //FD
        FD = new JRadioButton("Fixed Deposit Account");
        FD.setBackground(Color.WHITE);
        FD.setFont(new Font("Railway",Font.BOLD,14));
        FD.setBounds(290,115,200,30);
        add(FD);
        //RD
        RD = new JRadioButton("Recurring Deposit Account");
        RD.setBackground(Color.WHITE);
        RD.setFont(new Font("Railway",Font.BOLD,14));
        RD.setBounds(290,145,250,30);
        add(RD);
        //Group
        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(saving);
        accountGroup.add(current);
        accountGroup.add(FD);
        accountGroup.add(RD);

        //Card Number
        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Railway",Font.BOLD,20));
        card.setBounds(50,190,200,40);
        add(card);
        //Dummy Card Number
        JLabel dummyCard = new JLabel("XXXX-XXXX-XXXX-8756");
        dummyCard.setFont(new Font("Railway",Font.BOLD,17));
        dummyCard.setBounds(270,190,300,40);
        add(dummyCard);
        //Card Number details
        JLabel cardDetail = new JLabel("Your 16-Digit card number");
        cardDetail.setFont(new Font("Railway",Font.BOLD,11));
        cardDetail.setBounds(53,217,200,20);
        add(cardDetail);

        //PIN
        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Railway",Font.BOLD,20));
        pin.setBounds(50,240,200,40);
        add(pin);
        //Dummy Card Number
        JLabel dummyPin = new JLabel("XXXX");
        dummyPin.setFont(new Font("Railway",Font.BOLD,17));
        dummyPin.setBounds(270,240,300,40);
        add(dummyPin);
        //PIN details
        JLabel pinDetail = new JLabel("Your 4-Digit Password");
        pinDetail.setFont(new Font("Railway",Font.BOLD,11));
        pinDetail.setBounds(53,267,200,20);
        add(pinDetail);


        //Services Required
        JLabel services = new JLabel("Services Required");
        services.setFont(new Font("Railway",Font.BOLD,18));
        services.setBounds(50,305,200,40);
        add(services);
        //Check Boxes
        ATMCard = new JCheckBox("ATM Card");
        ATMCard.setBackground(Color.WHITE);
        ATMCard.setFont(new Font("Railway",Font.BOLD,13));
        ATMCard.setBounds(53,340,200,30);
        add(ATMCard);

        internetBanking = new JCheckBox("Internet Banking");
        internetBanking.setBackground(Color.WHITE);
        internetBanking.setFont(new Font("Railway",Font.BOLD,13));
        internetBanking.setBounds(270,340,200,30);
        add(internetBanking);

        mobileBanking = new JCheckBox("Mobile Banking");
        mobileBanking.setBackground(Color.WHITE);
        mobileBanking.setFont(new Font("Railway",Font.BOLD,13));
        mobileBanking.setBounds(53,370,200,30);
        add(mobileBanking);

        emailAndSMS = new JCheckBox("Email & SMS Alert");
        emailAndSMS.setBackground(Color.WHITE);
        emailAndSMS.setFont(new Font("Railway",Font.BOLD,13));
        emailAndSMS.setBounds(270,370,300,30);
        add(emailAndSMS);

        chequeBook = new JCheckBox("Cheque Book");
        chequeBook.setBackground(Color.WHITE);
        chequeBook.setFont(new Font("Railway",Font.BOLD,13));
        chequeBook.setBounds(53,400,200,30);
        add(chequeBook);

        EStatement = new JCheckBox("E-Statement");
        EStatement.setBackground(Color.WHITE);
        EStatement.setFont(new Font("Railway",Font.BOLD,13));
        EStatement.setBounds(270,400,200,30);
        add(EStatement);


        //Declaration check Box
        declaration = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
        declaration.setBackground(Color.WHITE);
        declaration.setFont(new Font("Railway",Font.BOLD,11));
        declaration.setBounds(55,465,600,30);
        add(declaration);

        //Buttons
        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Railway",Font.BOLD,12));
        submit.addActionListener(this);
        submit.setBounds(180,500,80,27);
        add(submit);
        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Railway",Font.BOLD,12));
        cancel.addActionListener(this);
        cancel.setBounds(310,500,85,27);
        add(cancel);


        getContentPane().setBackground(Color.WHITE);
        setSize(630,600);
        setLocation(320,50);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == submit){
            //Account Type
            String accountType = null;
            if(saving.isSelected()){
                accountType = "Saving Account";
            } else if (FD.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (current.isSelected()) {
                accountType = "Current Account";
            } else if (RD.isSelected()) {
                accountType = "Recurring Deposit Account";
            }

            //Random Card Number and PIN
            String cardNum = "" + Math.round(Math.random()*100000000 + 1234000000000000L);
            String pin = "" + Math.round(Math.random()*10000 + 1000);

            //Services
            String services = "";
            if (ATMCard.isSelected()){
                services = services + " ATM Card";
            }
            if (internetBanking.isSelected()) {
                services = services + " Internet Banking";
            }
            if (mobileBanking.isSelected()) {
                services = services + " Mobile Banking";
            }
            if (emailAndSMS.isSelected()) {
                services = services + " Email & SMS Alert";
            }
            if (chequeBook.isSelected()) {
                services = services + " Cheque Book";
            }
            if (EStatement.isSelected()) {
                services = services + " E-Statement";
            }

            //Save data to Database
            try{
                if (!(declaration.isSelected())) {
                    JOptionPane.showMessageDialog(null,"Declaration not selected");
                } else {
                    ConnectionToSQL connection = new ConnectionToSQL();
                    String query1 = "insert into signup3 values('"+formNum+"', '"+accountType+"', '"+cardNum+"', '"+pin+"', '"+services+"')";
                    String query2 = "insert into login values('"+formNum+"', '"+cardNum+"', '"+pin+"')";

                    connection.statement.executeUpdate(query1);
                    connection.statement.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Your Card NUmber: " + cardNum + "\nPIN: " + pin);
                    setVisible(false);
                    new Deposit(pin).setVisible(true);
                }
            }catch (Exception e){
                System.out.println("Exception Occurred: " + e.getMessage());
            }

        } else if (actionEvent.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }


    public static void main(String[] args) {
        new SignUp_3("");
    }


}
