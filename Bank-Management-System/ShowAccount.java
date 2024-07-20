import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class ShowAccount implements ActionListener{
	
	JFrame frame = new JFrame("Accounts Details");
	
	JLabel accNoLbl = new JLabel("Account No");
	JLabel nameLbl = new JLabel("Name ");
	JLabel surNameLbl = new JLabel("Surname ");
	JLabel phoneLbl = new JLabel("Phone No ");
	JLabel AadharNoLbl = new JLabel("Aadhar Card No ");
	JLabel emailLbl = new JLabel("Email ");
	JLabel balLbl = new JLabel("Balance Amount ");
	
	
	
	//Initializing TextFields
	JTextField accNoTxt = new JTextField();
	JTextField nameTxt = new JTextField();
	JTextField surNameTxt = new JTextField();
	JTextField phoneTxt = new JTextField();
	JTextField AadharNoTxt = new JTextField();
	JTextField emailTxt = new JTextField();
	JTextField balTxt = new JTextField();
	
	

	//Initializing Buttons
	
	JButton backBtn = new JButton("Back");
	
	
	   ShowAccount(){
		   
		 if(true){  
		   
		 accNoLbl.setBounds(250,200,200,30);
		 nameLbl.setBounds(250,250,200,30);
		surNameLbl.setBounds(250,300,200,30);
		phoneLbl.setBounds(250,350,200,30);
		AadharNoLbl.setBounds(250,400,200,30);
		emailLbl.setBounds(250,450,200,30);
		balLbl.setBounds(250,500,200,30);
		
		
		
		
		
		
		//setting Label Font 
		accNoLbl.setFont(new Font("Verdana", Font.PLAIN, 15));
		nameLbl.setFont(new Font("Verdana", Font.PLAIN, 15));
		surNameLbl.setFont(new Font("Verdana", Font.PLAIN, 15));
		phoneLbl.setFont(new Font("Verdana", Font.PLAIN, 15));
		AadharNoLbl.setFont(new Font("Verdana", Font.PLAIN, 15));
		emailLbl.setFont(new Font("Verdana", Font.PLAIN, 15));
		balLbl.setFont(new Font("Verdana", Font.PLAIN, 15));
		
		//setting Txtfld Font 
		accNoTxt.setFont(new Font("Verdana", Font.PLAIN, 15));
		nameTxt.setFont(new Font("Verdana", Font.PLAIN, 15));
		surNameTxt.setFont(new Font("Verdana", Font.PLAIN, 15));
		phoneTxt.setFont(new Font("Verdana", Font.PLAIN, 15));
		AadharNoTxt.setFont(new Font("Verdana", Font.PLAIN, 15));
		emailTxt.setFont(new Font("Verdana", Font.PLAIN, 15));
		balTxt.setFont(new Font("Verdana", Font.PLAIN, 15));
		
		
		
		
		//Positioning TextFields
		accNoTxt.setBounds(380,200,200,30);
		nameTxt.setBounds(380,250,200,30);
		surNameTxt.setBounds(380,300,200,30);
		phoneTxt.setBounds(380,350,200,30);
		AadharNoTxt.setBounds(380,400,200,30);
		emailTxt.setBounds(380,450,200,30);
		balTxt.setBounds(380,500,200,30);
		
		//Disabling  TextFields
		accNoTxt.setEditable(false);
		nameTxt.setEditable(false);
		surNameTxt.setEditable(false);
		phoneTxt.setEditable(false);
		AadharNoTxt.setEditable(false);
		emailTxt.setEditable(false);
		balTxt.setEditable(false);
		
		  String fAccNoStr = JOptionPane.showInputDialog( "Enter Account No" );
		 int fAccNo = Integer.parseInt(fAccNoStr);
		backBtn.setBounds(395,550,100,40);
		try{
			//    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");   
			//    Connection con=DriverManager.getConnection("jdbc:odbc:BankManagementProject");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankManagementProject", "root", "root@123");

				String s="select * from Account_Holders where acc_no =" +fAccNo;
				 Statement s1=con.createStatement();
				 ResultSet rs=s1.executeQuery(s);
				 System.out.println("");
				
			if(rs.next()){
				String accNo = Integer.toString(rs.getInt("acc_no") );
				String fname = rs.getString("f_name");
				String surName = rs.getString("sur_name");
				String phoneNo =rs.getString("phone_no");
				String AadharNo =rs.getString("aadhar_no");
				String Email =rs.getString("email");
				String balAmt =rs.getString("balance_amt");
				 
				 System.out.println(accNo+ fname+surName+phoneNo+AadharNo+Email+balAmt);
				 
				 
				 
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
						
						//Removing Focus From Button
						backBtn.setFocusable(false);
						
						
						//Frame Visible = true
						frame.setVisible(true); 
						
						
						
						
						frame.add(accNoLbl);
						frame.add(nameLbl);
						frame.add(surNameLbl);
						frame.add(phoneLbl);
						frame.add(AadharNoLbl);
						frame.add(emailLbl);
						frame.add(balLbl);
						
						//Adding TextFields
						frame.add(accNoTxt);
						frame.add(nameTxt);
						frame.add(surNameTxt);
						frame.add(phoneTxt);
						frame.add(AadharNoTxt);
						frame.add(emailTxt);
						frame.add(balTxt);
						
						//Addign Buttons 
						frame.add(backBtn);		
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Close Frame Window
						frame.setSize(1000,1000) ;//window size
						 
						 frame.setLayout(null);
						 frame.setVisible(true); //this is window visibility
						 
						   con.close();
			}
    }
	
    catch(Exception e)
    {
       System.out.println(e);  
    }

	   
		 
	}
		 }
	public void actionPerformed(ActionEvent ae){
		
		
		//Actions for Buttons
		if(ae.getSource()==backBtn){
			frame.dispose();
			index ind = new index();
		}
		
		
	}
	
}