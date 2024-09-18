import java.awt.*;
import java.sql.*;
// import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class search extends JFrame implements ActionListener {
    search() {
        String url = "jdbc:mysql://localhost:3306/swarupbases";
        String user = "root";
        String pass = "Dzire@3789";
        try {
            Connection con  = DriverManager.getConnection(url, user, pass);
            // Statement st1 = con.createStatement();
            setTitle("Search Movie Details");
            setSize(600, 600);
            setLayout(null);


                            // Full Display Button

            JButton fullDisplayButton = new JButton();
            fullDisplayButton.setText("Compelete Display");
            fullDisplayButton.setBounds(200, 80, 200, 60);
            fullDisplayButton.setFont(new Font("MV Boli", Font.BOLD, 15));
            fullDisplayButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent displayEvent) {
                    new display();
                }
            });
            fullDisplayButton.setFocusable(false);

                            // Second Label
            
            JLabel searchDisplay = new JLabel();
            searchDisplay.setBounds(100, 150, 300, 50);
            searchDisplay.setText("Choose one topic below to search");
            searchDisplay.setFont(new Font("MV Boli", Font.BOLD, 15));
            searchDisplay.setForeground(Color.red);

                        // Input Value

            JLabel inputString = new JLabel();
            inputString.setBounds(50, 260, 480, 30);
            inputString.setText("Please select the option in which you want to search.");
            inputString.setFont(new Font("MV Boli", Font.BOLD, 15));
            inputString.setForeground(Color.red);


                        // Topic wise Search
            
            String[] arrStrings = {"Select Your option", "movieName", "hero", "heroine", "director", "release Year"};
            JComboBox movieSearch = new JComboBox<>(arrStrings);
            movieSearch.setBounds(175, 200, 200, 50);
            movieSearch.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent selectEvent) {
                    int index = movieSearch.getSelectedIndex();
                    String str = arrStrings[index];
                    JTextArea searchTextArea = new JTextArea();
                    JButton displayButton = new JButton();
                    if (str == "movieName") {
                        inputString.setText("Please enter the name of the movie you want to search");
                        searchTextArea.setBounds(80, 310, 300, 50);
                        searchTextArea.setFont(new Font(null, Font.PLAIN, 24));
                        displayButton.setBounds(420, 310, 100, 50);
                        displayButton.setText("submit");
                        displayButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent ae1) {
                                String check = searchTextArea.getText();
                                if (check.length() == 0) 
                                    JOptionPane.showMessageDialog(null, "Please enter proper movie name", "Warning", JOptionPane.WARNING_MESSAGE);
                                else
                                    new topicDisplay(str, check);
                            }
                        });
                        searchTextArea.setText("");
                        add(searchTextArea);
                        add(displayButton);
                    }
                    else if (str == "hero") {
                        inputString.setText("Please enter the name of the hero you want to search");
                        searchTextArea.setBounds(80, 310, 300, 50);
                        searchTextArea.setFont(new Font(null, Font.PLAIN, 24));
                        displayButton.setBounds(420, 310, 100, 50);
                        displayButton.setText("submit");
                        displayButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent ae1) {
                                String check = searchTextArea.getText();
                                if (check.length() == 0) 
                                    JOptionPane.showMessageDialog(null, "Please enter proper hero name", "Warning", JOptionPane.WARNING_MESSAGE);
                                else
                                    new topicDisplay(str, check);
                            }
                        });
                        searchTextArea.setText("");
                        add(searchTextArea);
                        add(displayButton);
                    }
                    else if (str == "heroine") {
                        inputString.setText("Please enter the name of the heroine you want to search");
                        searchTextArea.setBounds(80, 310, 300, 50);
                        searchTextArea.setFont(new Font(null, Font.PLAIN, 24));
                        displayButton.setBounds(420, 310, 100, 50);
                        displayButton.setText("submit");
                        displayButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent ae1) {
                                String check = searchTextArea.getText();
                                if (check.length() == 0) 
                                    JOptionPane.showMessageDialog(null, "Please enter proper heroine name", "Warning", JOptionPane.WARNING_MESSAGE);
                                else
                                    new topicDisplay(str, check);
                            }
                        });
                        searchTextArea.setText("");
                        add(searchTextArea);
                        add(displayButton);
                    }
                    else if (str == "director") {
                        inputString.setText("Please enter the name of the director you want to search");
                        searchTextArea.setBounds(80, 310, 300, 50);
                        searchTextArea.setFont(new Font(null, Font.PLAIN, 24));
                        displayButton.setBounds(420, 310, 100, 50);
                        displayButton.setText("submit");
                        displayButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent ae1) {
                                String check = searchTextArea.getText();
                                if (check.length() == 0) 
                                    JOptionPane.showMessageDialog(null, "Please enter proper director name", "Warning", JOptionPane.WARNING_MESSAGE);
                                else
                                    new topicDisplay(str, check);
                            }
                        });
                        searchTextArea.setText("");
                        add(searchTextArea);
                        add(displayButton);
                    }
                    else if (str == "release Year") {
                        inputString.setText("Please enter the release year of the movie you want to search");
                        searchTextArea.setBounds(80, 310, 300, 50);
                        searchTextArea.setFont(new Font(null, Font.PLAIN, 24));
                        displayButton.setBounds(420, 310, 100, 50);
                        displayButton.setText("submit");
                        displayButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent ae1) {
                                String check = searchTextArea.getText();
                                if (check.length() == 0) 
                                    JOptionPane.showMessageDialog(null, "Please enter proper release Year", "Warning", JOptionPane.WARNING_MESSAGE);
                                else
                                    new topicDisplay(str, check);
                            }
                        });
                        searchTextArea.setText("");
                        add(searchTextArea);
                        add(displayButton);
                    }
                    else {
                        inputString.setText("Please select the option in which you want to search.");
                        remove(searchTextArea);
                        remove(displayButton);
                    }
                }
            });
            
            
            add(inputString);
            add(searchDisplay);
            add(movieSearch);
            add(fullDisplayButton);
            setVisible(true);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } catch (SQLException se) {
            System.out.println(se);
        }
    }
    public void actionPerformed(ActionEvent e1) {
        e1.getSource();
    }
}
