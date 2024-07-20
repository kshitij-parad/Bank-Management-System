
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class DeleteAccount implements ActionListener {

    JFrame frame = new JFrame("Delete Account");

    DeleteAccount() {

        if (true) {

            String dAccNoStr = JOptionPane.showInputDialog("Enter Account No To Delete");
            int dAccNo = Integer.parseInt(dAccNoStr);

            try {
                //    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");   
                //    Connection con=DriverManager.getConnection("jdbc:odbc:BankManagementProject");

                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankManagementProject", "root", "root@123");

                String sql = "delete from Account_Holders where acc_no = " + dAccNo;

                Statement stmt = con.createStatement();

                stmt.executeUpdate(sql);

                JOptionPane.showMessageDialog(null, "Account Deleted Successfully", "Information", JOptionPane.INFORMATION_MESSAGE);

                index ind = new index();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Close Frame Window

                frame.setLayout(null);

                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void actionPerformed(ActionEvent ae) {

    }

}
