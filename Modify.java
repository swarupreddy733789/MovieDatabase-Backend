// import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Modify extends JFrame implements ActionListener {
    Modify() {
        String url = "jdbc:mysql://localhost:3306/swarupbases";
        String user = "root";
        String pass = "Dzire@3789";
        try {
            setTitle("Remove Movie Details");
            setSize(500, 350);
            setVisible(true);
            setLayout(null);
            Connection con  = DriverManager.getConnection(url, user, pass);
            // Statement st1 = con.createStatement();


                            // First Label

            JLabel firstLabel = new JLabel();
            firstLabel.setBounds(20, 10, 250, 30);
            firstLabel.setFont(new Font(null, Font.PLAIN, 20));
            firstLabel.setText("Enter the movie name");


                            // Input Text Area

            JTextArea inputTextArea = new JTextArea();
            inputTextArea.setBounds(120, 60, 250, 40);
            inputTextArea.setFont(new Font(null, Font.PLAIN, 22));

            
                            // inputRequired

            JTextArea inputrequiredArea = new JTextArea();
            inputrequiredArea.setBounds(220, 130, 230, 55);
            inputrequiredArea.setFont(new Font(null, Font.PLAIN, 20));


                            // Select Section

            String[] arrColumns = {"Select Your Option", "movieName", "hero", "heroine", "director", "release Year"};
            JComboBox fieldDisplay = new JComboBox<>(arrColumns);
            fieldDisplay.setBounds(20, 130, 170, 55);
            

                            // Submit Button

            JButton submitButton = new JButton();
            submitButton.setBounds(100, 210, 100, 35);
            submitButton.setText("submit");
            submitButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    String movie = inputTextArea.getText();
                    if (fieldDisplay.getSelectedIndex() == 0)
                        JOptionPane.showMessageDialog(null, "Please Select Proper Column Name", "Warning", JOptionPane.WARNING_MESSAGE);
                    else {
                        
                    }
                }
            });
            

            add(firstLabel);
            add(inputTextArea);
            add(inputrequiredArea);
            add(fieldDisplay);
            add(submitButton);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } catch (SQLException se) {
            System.out.println(se);
        }
    }
    public void actionPerformed(ActionEvent e2) {
        e2.getSource();
    }
}
