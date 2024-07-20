
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DepositWithdrawAccount implements ActionListener {

    JFrame frame = new JFrame("Deposit and Withdraw");

//Initializing Buttons
    JButton backBtn = new JButton("Back");

    JButton withBtn = new JButton("Withdraw");

    JButton depBtn = new JButton("Deposit");

    JLabel label = new JLabel("What do you want to do?");

    DepositWithdrawAccount() {

        if (true) {

            label.setBounds(70, 20, 400, 100);
            label.setFont(new Font("Verdana", Font.PLAIN, 25));
            label.setBackground(Color.black);
            label.setForeground(Color.red);

            backBtn.setBounds(30, 100, 100, 40);
            depBtn.setBounds(180, 100, 100, 40);
            withBtn.setBounds(310, 100, 100, 40);

            //Addinf ActionListener 
            backBtn.addActionListener(this);
            depBtn.addActionListener(this);
            withBtn.addActionListener(this);

            //Removing Focus From Button
            backBtn.setFocusable(false);
            depBtn.setFocusable(false);
            withBtn.setFocusable(false);

            //Frame Visible = true
            frame.setVisible(true);

            //Addign Buttons 
            frame.add(backBtn);
            frame.add(withBtn);
            frame.add(depBtn);
            frame.add(label);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Close Frame Window
            frame.setSize(500, 300);//window size

            frame.setLayout(null);
            frame.setVisible(true); //this is window visibility

        }

    }

    public void actionPerformed(ActionEvent ae) {

        //Actions for Buttons
        if (ae.getSource() == backBtn) {
            frame.dispose();
            index ind = new index();
        } else if (ae.getSource() == withBtn) {
            frame.dispose();
            Withdraw withd = new Withdraw();
        } else if (ae.getSource() == depBtn) {
            frame.dispose();
            Deposit dep = new Deposit();
        }

    }

}
