
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Deposit implements ActionListener {

    String accNo;
    String fname;
    String surName;
    String phoneNo;
    String AadharNo;
    String Email;
    String balAmt;

    JFrame frame = new JFrame("Deposit Amount");

    JButton backBtn = new JButton("Back");

    JButton depAmtBtn = new JButton("Deposit");

    String depAccNoStr;
    int depAccNo;

    JLabel accNoLbl = new JLabel("Account No");
    JLabel nameLbl = new JLabel("Name ");
    JLabel surNameLbl = new JLabel("Surname ");
    JLabel phoneLbl = new JLabel("Phone No ");
    JLabel AadharNoLbl = new JLabel("Aadhar Card No ");
    JLabel emailLbl = new JLabel("Email ");
    JLabel balLbl = new JLabel("Balance Amount ");
    JLabel depLbl = new JLabel("Deposit Amount ");

    //Initializing TextFields
    JTextField accNoTxt = new JTextField();
    JTextField nameTxt = new JTextField();
    JTextField surNameTxt = new JTextField();
    JTextField phoneTxt = new JTextField();
    JTextField AadharNoTxt = new JTextField();
    JTextField emailTxt = new JTextField();
    JTextField balTxt = new JTextField();
    JTextField depTxt = new JTextField();

    Deposit() {

        depAmtBtn.setBounds(250, 600, 100, 40);
        backBtn.setBounds(380, 600, 100, 40);

        accNoLbl.setBounds(250, 200, 200, 30);
        nameLbl.setBounds(250, 250, 200, 30);
        surNameLbl.setBounds(250, 300, 200, 30);
        phoneLbl.setBounds(250, 350, 200, 30);
        AadharNoLbl.setBounds(250, 400, 200, 30);
        emailLbl.setBounds(250, 450, 200, 30);
        balLbl.setBounds(250, 500, 200, 30);
        depLbl.setBounds(250, 550, 200, 30);

        //setting Label Font 
        accNoLbl.setFont(new Font("Verdana", Font.PLAIN, 15));
        nameLbl.setFont(new Font("Verdana", Font.PLAIN, 15));
        surNameLbl.setFont(new Font("Verdana", Font.PLAIN, 15));
        phoneLbl.setFont(new Font("Verdana", Font.PLAIN, 15));
        AadharNoLbl.setFont(new Font("Verdana", Font.PLAIN, 15));
        emailLbl.setFont(new Font("Verdana", Font.PLAIN, 15));
        balLbl.setFont(new Font("Verdana", Font.PLAIN, 15));
        depLbl.setFont(new Font("Verdana", Font.PLAIN, 15));

        //setting Txtfld Font 
        accNoTxt.setFont(new Font("Verdana", Font.PLAIN, 15));
        nameTxt.setFont(new Font("Verdana", Font.PLAIN, 15));
        surNameTxt.setFont(new Font("Verdana", Font.PLAIN, 15));
        phoneTxt.setFont(new Font("Verdana", Font.PLAIN, 15));
        AadharNoTxt.setFont(new Font("Verdana", Font.PLAIN, 15));
        emailTxt.setFont(new Font("Verdana", Font.PLAIN, 15));
        balTxt.setFont(new Font("Verdana", Font.PLAIN, 15));
        depTxt.setFont(new Font("Verdana", Font.PLAIN, 15));

        //Positioning TextFields
        accNoTxt.setBounds(380, 200, 200, 30);
        nameTxt.setBounds(380, 250, 200, 30);
        surNameTxt.setBounds(380, 300, 200, 30);
        phoneTxt.setBounds(380, 350, 200, 30);
        AadharNoTxt.setBounds(380, 400, 200, 30);
        emailTxt.setBounds(380, 450, 200, 30);
        balTxt.setBounds(380, 500, 200, 30);
        depTxt.setBounds(380, 550, 200, 30);

        //Disabling  TextFields
        accNoTxt.setEditable(false);
        nameTxt.setEditable(false);
        surNameTxt.setEditable(false);
        phoneTxt.setEditable(false);
        AadharNoTxt.setEditable(false);
        emailTxt.setEditable(false);
        balTxt.setEditable(false);
        depTxt.setEditable(true);

        String depAccNoStr = JOptionPane.showInputDialog("Enter Account No To Deposit Amount");
        depAccNo = Integer.parseInt(depAccNoStr);
        System.out.println(depAccNo + "  Hello");

        try {
            // 	   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");   
            // 	   Connection con=DriverManager.getConnection("jdbc:odbc:BankManagementProject");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankManagementProject", "root", "root@123");

            String s = "select * from Account_Holders where acc_no =" + depAccNo;
            Statement s1 = con.createStatement();
            ResultSet rs = s1.executeQuery(s);
            System.out.println("");

            if (rs.next()) {
                accNo = Integer.toString(rs.getInt("acc_no"));
                fname = rs.getString("f_name");
                surName = rs.getString("sur_name");
                phoneNo = rs.getString("phone_no");
                AadharNo = rs.getString("aadhar_no");
                Email = rs.getString("email");
                balAmt = rs.getString("balance_amt");

                System.out.println(accNo + fname + surName + phoneNo + AadharNo + Email + balAmt);

                //Setting Values to Textfields
                accNoTxt.setText(accNo);
                nameTxt.setText(fname);
                surNameTxt.setText(surName);
                phoneTxt.setText(phoneNo);
                AadharNoTxt.setText(AadharNo);
                emailTxt.setText(Email);
                balTxt.setText(balAmt);

                //Addinf ActionListener 
                backBtn.addActionListener(this);
                depAmtBtn.addActionListener(this);

                //Removing Focus From Button
                backBtn.setFocusable(false);
                depAmtBtn.setFocusable(false);

                //Frame Visible = true
                frame.setVisible(true);

                frame.add(accNoLbl);
                frame.add(nameLbl);
                frame.add(surNameLbl);
                frame.add(phoneLbl);
                frame.add(AadharNoLbl);
                frame.add(emailLbl);
                frame.add(balLbl);
                frame.add(depLbl);

                //Adding TextFields
                frame.add(accNoTxt);
                frame.add(nameTxt);
                frame.add(surNameTxt);
                frame.add(phoneTxt);
                frame.add(AadharNoTxt);
                frame.add(emailTxt);
                frame.add(balTxt);
                frame.add(depTxt);

                //Addign Buttons 
                frame.add(backBtn);
                frame.add(depAmtBtn);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Close Frame Window
                frame.setSize(1000, 1000);//window size

                frame.setLayout(null);
                frame.setVisible(true); //this is window visibility

                con.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backBtn) {
            frame.dispose();
            DepositWithdrawAccount depWithAcc = new DepositWithdrawAccount();
        }
        if (ae.getSource() == depAmtBtn) {

            String balAmtTxt = balTxt.getText();
            int balAmtUpdate = Integer.parseInt(balAmtTxt);

            String depAmtTxt = depTxt.getText();
            int depAmtUpdate = Integer.parseInt(depAmtTxt);
            System.out.println("deposit");

            int newAmt = depAmtUpdate + balAmtUpdate;
            String newAmtN = Integer.toString(newAmt);

            System.out.println(depAccNo);

            try {
                //   Class.forName("sun.jdbc.odbc.mysql");   
                //    Connection con=DriverManager.getConnection("jdbc:odbc:BankManagementProject");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankManagementProject", "root", "root@123");

                PreparedStatement ps = con.prepareStatement("update Account_Holders set balance_amt= ? where acc_no = " + depAccNo);
                ps.setString(1, newAmtN);//1 specifies the first parameter in the query i.e. name  

                ps.executeUpdate();
                System.out.println("Updated");
                JOptionPane.showMessageDialog(null, "Amount Deposited Successfully", "Information", JOptionPane.INFORMATION_MESSAGE);

                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

}