package Source.bankManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp_2 extends JFrame implements ActionListener {
    JTextField aadharF, panNoF;
    JRadioButton seniorYes, seniorNo, accountYes, accountNo;
    JButton next;
    JComboBox<String> religionF, categoryF, incomeF, educationF, occupationF;
    String formNum;

    SignUp_2(String formNo){
        this.formNum = formNo;
        setTitle("SIGN UP PAGE-2");
        setLayout(null);

        //Additional Details text
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Railway",Font.BOLD,20));
        additionalDetails.setBounds(165,35,600,40);
        add(additionalDetails);

        //Religion text
        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Railway", Font.BOLD,17));
        religion.setBounds(50,100,200,30);
        add(religion);
        //Religion Drop down using JComboBox
        String[] varReligion = {"Hindu", "Muslim", "Sikhs", "Jain", "Christian", "Other"};
        religionF = new JComboBox<>(varReligion);
        religionF.setBackground(Color.WHITE);
        religionF.setBounds(230,103,260,27);
        add(religionF);


        //category text
        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Railway", Font.BOLD,17));
        category.setBounds(50,135,200,30);
        add(category);
        //Category Drop down using JComboBox
        String[] varCategory = {"General", "SC", "ST", "OBC", "EWS","Other"};
        categoryF = new JComboBox<>(varCategory);
        categoryF.setBackground(Color.WHITE);
        categoryF.setBounds(230,138,260,27);
        add(categoryF);

        //Income text
        JLabel income = new JLabel("Income(p.a in Rs):");
        income.setFont(new Font("Railway", Font.BOLD,17));
        income.setBounds(50,170,200,30);
        add(income);
        //Income Drop Down
        String[] varIncome = {"Below 50,000", "50,000 - 8 Lakhs", "8 Lakhs - 20 Lakhs", "Above 20 Lakhs"};
        incomeF = new JComboBox<>(varIncome);
        incomeF.setBackground(Color.WHITE);
        incomeF.setBounds(230,173,260,27);
        add(incomeF);

        //Education Qualification text
        JLabel educational = new JLabel("Educational");
        educational.setFont(new Font("Railway", Font.BOLD,17));
        educational.setBounds(50,205,200,30);
        add(educational);
        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Railway", Font.BOLD,17));
        qualification.setBounds(50,222,200,30);
        add(qualification);
        //Education Qualification Drop Down
        String[] varEducation = {"PHD","Post Graduate", "Graduate", "Diploma", "Intermediate", "High School"};
        educationF = new JComboBox<>(varEducation);
        educationF.setBackground(Color.WHITE);
        educationF.setBounds(230,220,260,27);
        add(educationF);


        //Occupation text
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Railway", Font.BOLD,17));
        occupation.setBounds(50,270,200,30);
        add(occupation);
        //Occupation Drop Down
        String[] varOccupation = {"Self-Employed","Government job", "Teacher", "Doctor", "IT-Professional", "Other"};
        occupationF = new JComboBox<>(varOccupation);
        occupationF.setBackground(Color.WHITE);
        occupationF.setBounds(230,273,260,27);
        add(occupationF);

        //PAN Number text
        JLabel panNo = new JLabel("PAN Number:");
        panNo.setFont(new Font("Railway", Font.BOLD,17));
        panNo.setBounds(50,310,200,30);
        add(panNo);
        //PAN Number text
        panNoF = new JTextField();
        panNoF.setFont(new Font("Railway",Font.BOLD,14));
        panNoF.setBounds(230,313,260,27);
        add(panNoF);


        //Aadhar Number text
        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Railway", Font.BOLD,17));
        aadhar.setBounds(50,345,200,30);
        add(aadhar);
        //Aadhar Number text
        aadharF = new JTextField();
        aadharF.setFont(new Font("Railway",Font.BOLD,14));
        aadharF.setBounds(230,348,260,27);
        add(aadharF);



        //Senior Citizen text
        JLabel seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Railway", Font.BOLD,17));
        seniorCitizen.setBounds(50,380,200,30);
        add(seniorCitizen);
        //Senior Citizen Radio button
        seniorYes = new JRadioButton("Yes");
        seniorYes.setBackground(Color.WHITE);
        seniorYes.setBounds(230,380,100,30);
        add(seniorYes);
        seniorNo = new JRadioButton("No");
        seniorNo.setBackground(Color.WHITE);
        seniorNo.setBounds(360,380,100,30);
        add(seniorNo);
        ButtonGroup seniorBtn = new ButtonGroup();
        seniorBtn.add(seniorYes);
        seniorBtn.add(seniorNo);


        //Existing Account text
        JLabel existingAcc = new JLabel("Existing Account:");
        existingAcc.setFont(new Font("Railway", Font.BOLD,17));
        existingAcc.setBounds(50,415,200,30);
        add(existingAcc);
        //Existing Account Radio button
        accountYes = new JRadioButton("Yes");
        accountYes.setBackground(Color.WHITE);
        accountYes.setBounds(230,415,100,30);
        add(accountYes);
        accountNo = new JRadioButton("No");
        accountNo.setBackground(Color.WHITE);
        accountNo.setBounds(360,415,100,30);
        add(accountNo);
        ButtonGroup existingAccBtn = new ButtonGroup();
        existingAccBtn.add(accountYes);
        existingAccBtn.add(accountNo);

        //Next button
        next = new JButton("Next");
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.addActionListener(this);
        next.setBounds(450,485,80,30);
        add(next);


        setVisible(true);
        setSize(630,585);
        setLocation(320,50);
        getContentPane().setBackground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        //Text Fields
        String panNum = panNoF.getText();
        String aadharNum = aadharF.getText();

        //Radio Button
        String seniorCitizen = null;
        if(seniorYes.isSelected()){
            seniorCitizen = "Yes";
        } else if (seniorNo.isSelected()) {
            seniorCitizen = "NO";
        }
        String existingAccount = null;
        if(accountYes.isSelected()){
            existingAccount = "Yes";
        } else if (accountNo.isSelected()) {
            existingAccount = "No";
        }

        //Drop Down
        String religion = (String)religionF.getSelectedItem();
        String category = (String)categoryF.getSelectedItem();
        String income = (String)incomeF.getSelectedItem();
        String education = (String)educationF.getSelectedItem();
        String occupation = (String)occupationF.getSelectedItem();


        try{
            if(aadharNum.isEmpty()){
                JOptionPane.showMessageDialog(null,"Aadhar Number Required");
            } else if (panNum.isEmpty()) {
                JOptionPane.showMessageDialog(null, "PAN Number Required");
            }else{
                ConnectionToSQL connection = new ConnectionToSQL();
                String query = "insert into signup2 values('"+formNum+"', '"+religion+"', '"+category+"', '"+income+"', '"+education+"', '"+occupation+"', '"+aadharNum+"', '"+panNum+"', '"+seniorCitizen+"', '"+existingAccount+"')";
                connection.statement.executeUpdate(query);

                //SignUp_3 object
                setVisible(false);
                new SignUp_3(formNum).setVisible(true);
            }

        }catch (Exception exception){
            System.out.println("Exception Occurred: " + exception.getMessage());
        }

    }

    public static void main(String[] args) {
        new SignUp_2("");
    }


}
