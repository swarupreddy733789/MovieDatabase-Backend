import java.sql.*;
import java.awt.*;
import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class movieProject {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/swarupbases";
        String user = "root";
        String pass = "Dzire@3789";
        try {
                                // Database connection

            Connection con = DriverManager.getConnection(url, user, pass);
            if (con != null) System.out.println("sucessfully connected");

                                // Main Frame Creation            

            JFrame mainFrame = new JFrame();
            mainFrame.setTitle("Movie database");
            ImageIcon img = new ImageIcon("icon.jpg");
            mainFrame.setSize(500, 500);
            mainFrame.setResizable(false);
            mainFrame.setLayout(null);
                         
                                // ADD Butoon
            
            JButton addButton = new JButton();
            addButton.setBounds(200, 50, 120, 60);
            addButton.setText("ADD");
            addButton.setFont(new Font("MV Boli", Font.BOLD, 25));
            addButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent addEvent) {
                    new ADD();
                }
            });
            addButton.setFocusable(false);

                                // Search Button
                                
            JButton searchButton = new JButton();
            searchButton.setBounds(200, 180, 120, 60);
            searchButton.setText("Search");
            searchButton.setFont(new Font("MV Boli", Font.BOLD, 25));
            searchButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent searchEvent) {
                    new search();
                }
            });
            searchButton.setFocusable(false);

                                // modify Button
                                
            JButton removeButton = new JButton();
            removeButton.setBounds(200, 300, 120, 60);
            removeButton.setText("Modify");
            removeButton.setFont(new Font("MV Boli", Font.BOLD, 25));
            removeButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent removeEvent) {
                    new Modify();
                }
            });
            removeButton.setFocusable(false);

            
            mainFrame.add(removeButton);
            mainFrame.add(searchButton);
            mainFrame.add(addButton);
            mainFrame.setVisible(true);
            mainFrame.setIconImage(img.getImage());
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } catch (SQLException e) {
            System.out.println("error in connection");
        }
    }
    Image img = Toolkit.getDefaultToolkit().getImage("C:\\Users\\SWARUP REDDY\\OneDrive\\Documents\\java database\\main_background.avif");
    

    public class SwingDemo extends javax.swing.JFrame {
        public SwingDemo() throws IOException {
            this.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, null);
            }
        });
    }
}
}