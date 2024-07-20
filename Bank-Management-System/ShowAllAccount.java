import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

public class ShowAllAccount implements ActionListener{
	
	JFrame frame = new JFrame("All Accounts Details");
	JTable table;
	JPanel panel= new JPanel();
	
	
	//Declaring Variables for Data
	String name;

	//Initializing Buttons
	
	JButton backBtn = new JButton("Back");
	
	
	   ShowAllAccount(){
		backBtn.setBounds(260,250,100,40);
		panel.setBounds(20,20,800,200);
		
		try{
			//    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");   
			//    Connection con=DriverManager.getConnection("jdbc:odbc:BankManagementProject");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankManagementProject", "root", "root@123");
				String s="select*from Account_Holders";
				 Statement s1=con.createStatement();
				 ResultSet rs=s1.executeQuery(s);
				 System.out.println("");
				
				 String[][] data;
			
				 String columnNames[] = new String[]{"Acc No","Name","Surname","Phone No","Aadhar No","Email","Balance Amount" };
				 DefaultTableModel dtm = new DefaultTableModel(0, 0);
					table = new JTable();
					 dtm.setColumnIdentifiers(columnNames);
				  table.setBounds(10, 10, 600, 300);
				  table.setEnabled(false);
				 // table.setSize(600,600);
				 
				 
				   table.setModel(dtm);

			 while(rs.next())
			 {
				 String AccNo = Integer.toString(rs.getInt("acc_no") );
				String fname = rs.getString("f_name");
				String surName = rs.getString("sur_name");
				String phoneNo =rs.getString("phone_no");
				String AadharNo =rs.getString("aadhar_no");
				String Email =rs.getString("email");
				String balAmt =rs.getString("balance_amt");
				 
				 System.out.println(AccNo+ fname+surName+phoneNo+AadharNo+Email+balAmt);
dtm.addRow(new Object[] {AccNo, fname,surName,phoneNo,AadharNo,Email,balAmt});
			
						
				   } 

						// adding it to JScrollPane
						JScrollPane sp = new JScrollPane(table);
						sp.setVisible(true);
			
						table.setPreferredScrollableViewportSize(new Dimension(450,190));
						table.setFillsViewportHeight(true);

						panel.add(sp);
						panel.setSize(700, 400);


						//Addinf ActionListener 
						backBtn.addActionListener(this);
						
						//Removing Focus From Button
						backBtn.setFocusable(false);
						
						
						//Frame Visible = true
						frame.setVisible(true); 
						
						//Addign Buttons 
						frame.add(backBtn);		
						frame.add(panel);
						 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Close Frame Window
						 frame.setSize(700,400); //window size
						 
						 frame.setLayout(null);
						 frame.setVisible(true); //this is window visibility
						 
						   con.close();
    }
    catch(Exception e)
    {
       System.out.println(e);  
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