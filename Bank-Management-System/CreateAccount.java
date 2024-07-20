
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.sql.*;
import javax.swing.*;

public class CreateAccount implements ActionListener {

    JFrame frame = new JFrame("Create Account");

    //Declaring Variables for Data
    String name;
    String surName;
    String phoneNo;
    String AadharNo;
    String email;
    String depAmt;
    int accNo = 0;

    //Initializing Label
    JLabel nameLbl = new JLabel("Name ");
    JLabel surNameLbl = new JLabel("Surname ");
    JLabel phoneLbl = new JLabel("Phone No ");
    JLabel AadharNoLbl = new JLabel("Aadhar Card No ");
    JLabel emailLbl = new JLabel("Email ");
    JLabel depLbl = new JLabel("Deposit Amount ");

    //Initializing TextFields
    JTextField nameTxt = new JTextField();
    JTextField surNameTxt = new JTextField();
    JTextField phoneTxt = new JTextField();
    JTextField AadharNoTxt = new JTextField();
    JTextField emailTxt = new JTextField();
    JTextField depTxt = new JTextField();

    //Initializing Buttons
    JButton submitBtn = new JButton("Submit");
    JButton backBtn = new JButton("Back");

    CreateAccount() {

        //Positioning Labels
        nameLbl.setBounds(250, 250, 200, 30);
        surNameLbl.setBounds(250, 300, 200, 30);
        phoneLbl.setBounds(250, 350, 200, 30);
        AadharNoLbl.setBounds(250, 400, 200, 30);
        emailLbl.setBounds(250, 450, 200, 30);
        depLbl.setBounds(250, 500, 200, 30);

        //setting Label Font 
        nameLbl.setFont(new Font("Verdana", Font.PLAIN, 15));
        surNameLbl.setFont(new Font("Verdana", Font.PLAIN, 15));
        phoneLbl.setFont(new Font("Verdana", Font.PLAIN, 15));
        AadharNoLbl.setFont(new Font("Verdana", Font.PLAIN, 15));
        emailLbl.setFont(new Font("Verdana", Font.PLAIN, 15));
        depLbl.setFont(new Font("Verdana", Font.PLAIN, 15));

        //Positioning TextFields
        nameTxt.setBounds(380, 250, 200, 30);
        surNameTxt.setBounds(380, 300, 200, 30);
        phoneTxt.setBounds(380, 350, 200, 30);
        AadharNoTxt.setBounds(380, 400, 200, 30);
        emailTxt.setBounds(380, 450, 200, 30);
        depTxt.setBounds(380, 500, 200, 30);

        //Positioning Buttons
        submitBtn.setBounds(270, 550, 100, 40);
        backBtn.setBounds(395, 550, 100, 40);

        //Frame
        frame.setForeground(new Color(25, 26, 25));

        //Adding Components to frame
        //Adding Labels
        frame.add(nameLbl);
        frame.add(surNameLbl);
        frame.add(phoneLbl);
        frame.add(AadharNoLbl);
        frame.add(emailLbl);
        frame.add(depLbl);

        //Adding TextFields
        frame.add(nameTxt);
        frame.add(surNameTxt);
        frame.add(phoneTxt);
        frame.add(AadharNoTxt);
        frame.add(emailTxt);
        frame.add(depTxt);

        //Addign Buttons 
        frame.add(backBtn);
        frame.add(submitBtn);

        //Addinf ActionListener 
        backBtn.addActionListener(this);
        submitBtn.addActionListener(this);

        //Removing Focus From Button
        submitBtn.setFocusable(false);
        backBtn.setFocusable(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Close Frame Window
        frame.setSize(800, 800); //window size

        frame.setLayout(null);
        frame.setVisible(true); //this is window visibility

    }

    public int getAccNo() {
        int accNoInt = 0;
        int maxNO = 0;
        try {
            //   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");   
            //   Connection con=DriverManager.getConnection("jdbc:odbc:BankManagementProject");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankManagementProject", "root", "root@123");

            System.out.println("Getting  max acc no");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery("select acc_no from Account_Holders");
            while (resultSet.last()) {
                accNoInt = resultSet.getInt("acc_no");
                break;
            }
            System.out.println(accNoInt);

            System.out.println("Retrieved");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return accNoInt + 1;

    }

    public void actionPerformed(ActionEvent ae) {

        //Actions for Buttons
        if (ae.getSource() == backBtn) {
            frame.dispose();
            index ind = new index();
        } else if (ae.getSource() == submitBtn) {
            name = nameTxt.getText();
            surName = surNameTxt.getText();
            phoneNo = phoneTxt.getText();
            AadharNo = AadharNoTxt.getText();
            email = emailTxt.getText();
            depAmt = depTxt.getText();
            System.out.println(name + surName + phoneNo + email + AadharNo);

            try {
                //    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");   
                //    Connection con=DriverManager.getConnection("jdbc:odbc:BankManagementProject");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankManagementProject", "root", "root@123");

                int accNoN = getAccNo();
                PreparedStatement ps = con.prepareStatement("insert into Account_Holders(acc_no,f_name,sur_name,phone_no,aadhar_no,email,balance_amt)values(?,?,?,?,?,?,?)");
                ps.setInt(1, accNoN);
                ps.setString(2, name);
                ps.setString(3, surName);
                ps.setString(4, phoneNo);
                ps.setString(5, AadharNo);
                ps.setString(6, email);
                ps.setString(7, depAmt);
                ps.executeUpdate();
                System.out.println("inserted");
                JOptionPane.showMessageDialog(null, "Account Created Successfully", "Information", JOptionPane.INFORMATION_MESSAGE);
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }

        }

    }

}
