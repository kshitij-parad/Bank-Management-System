
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class index implements ActionListener {

    JLabel label = new JLabel("BANK MANAGEMENT");
    Image img = Toolkit.getDefaultToolkit().getImage("indexImg.png");

    JFrame frame = new JFrame();
    JButton createAccButton = new JButton("Create Account");
    JButton showAccButton = new JButton("Show Account Details");
    JButton showAllAccButton = new JButton("Show All Account Details");
    JButton delButton = new JButton("Delete Account");
    JButton delAllButton = new JButton("Delete All Account");
    JButton depWithButton = new JButton("Deposit and Withdraw");
    JButton exitButton = new JButton("Exit");

    index() {

        label.setBounds(200, 100, 400, 80);
        label.setFont(new Font("poppins", Font.BOLD, 35));
        label.setForeground(Color.white);

        frame.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, null);
            }
        });

        createAccButton.setBounds(150, 200, 200, 40);

        showAllAccButton.setBounds(400, 200, 200, 40);

        showAccButton.setBounds(150, 300, 200, 40);

        delButton.setBounds(400, 300, 200, 40);

        delAllButton.setBounds(150, 400, 200, 40);

        depWithButton.setBounds(400, 400, 200, 40);

        exitButton.setBounds(250, 500, 200, 40);

        createAccButton.setFocusable(false);

        //Adding Action Listener to Buttons
        createAccButton.addActionListener(this);
        showAllAccButton.addActionListener(this);
        showAccButton.addActionListener(this);
        delButton.addActionListener(this);
        delAllButton.addActionListener(this);
        depWithButton.addActionListener(this);
        exitButton.addActionListener(this);

        //Removing Foucus From Button
        createAccButton.setFocusable(false);

        showAllAccButton.setFocusable(false);

        showAccButton.setFocusable(false);

        delButton.setFocusable(false);

        delAllButton.setFocusable(false);

        depWithButton.setFocusable(false);

        exitButton.setFocusable(false);

        //Adding Buttons to a frame
        frame.add(createAccButton);
        frame.add(showAccButton);
        frame.add(showAllAccButton);
        frame.add(delButton);
        frame.add(delAllButton);
        frame.add(depWithButton);
        frame.add(exitButton);

        frame.add(label);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Close Frame Window
        frame.setSize(700, 700); //window size

        frame.setLayout(null);
        frame.setVisible(true); //this is window visibility
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exitButton) {
            System.exit(0);
        } else if (ae.getSource() == createAccButton) {
            frame.dispose();
            CreateAccount crtAcc = new CreateAccount();
        } else if (ae.getSource() == showAllAccButton) {
            frame.dispose();
            ShowAllAccount shwAllAcc = new ShowAllAccount();
        } else if (ae.getSource() == showAccButton) {
            frame.dispose();
            ShowAccount shwAcc = new ShowAccount();
        } else if (ae.getSource() == delButton) {
            frame.dispose();
            DeleteAccount delAcc = new DeleteAccount();
        } else if (ae.getSource() == depWithButton) {
            frame.dispose();
            DepositWithdrawAccount depWithAcc = new DepositWithdrawAccount();
        } else if (ae.getSource() == delAllButton) {
            frame.dispose();
            DeleteAllAccount delAllAcc = new DeleteAllAccount();
        }

    }

}
