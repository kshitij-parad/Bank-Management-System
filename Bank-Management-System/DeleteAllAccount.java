
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class DeleteAllAccount implements ActionListener {

    JFrame frame = new JFrame("Delete All Acounts");

    DeleteAllAccount() {

        int opt = JOptionPane.showConfirmDialog(null, "Do you really want to delete all Account?", "Delete All Account", JOptionPane.YES_NO_CANCEL_OPTION);
        System.out.println(opt);
        if (opt == 0) {
            try {
                //    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");   
                //    Connection con=DriverManager.getConnection("jdbc:odbc:BankManagementProject");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankManagementProject", "root", "root@123");

                String s = "delete * from Account_Holders";
                Statement s1 = con.createStatement();
                ResultSet rs = s1.executeQuery(s);
                System.out.println("");

                //Frame Visible = true
                frame.setVisible(true);

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Close Frame Window
                frame.setSize(1000, 1000);//window size

                frame.setLayout(null);
                frame.setVisible(true); //this is window visibility

                con.close();

            } catch (Exception e) {
                System.out.println(e);
            }

        } else {
            index ind = new index();
        }

    }

    public void actionPerformed(ActionEvent ae) {

    }

}
