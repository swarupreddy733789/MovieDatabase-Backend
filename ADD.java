import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ADD extends JFrame implements ActionListener {
    ADD() {
        String url = "jdbc:mysql://localhost:3306/swarupbases";
        String user = "root";
        String pass = "Dzire@3789";

        setTitle("Add Movie Details");
        setSize(600, 480);
        setResizable(false);
        setLayout(null);
        setVisible(true);

                       // Movie Name
        
        JLabel movieNameLabel = new JLabel("Movie Name");
        movieNameLabel.setBounds(10, 10, 200, 40);
        movieNameLabel.setFont(new Font(null, Font.PLAIN, 20));
        JTextField movieNameField = new JTextField();
        movieNameField.setBounds(170, 20, 300, 30);
        movieNameField.setFont(new Font(null, Font.PLAIN, 15));

                  
                      // Hero Name

        JLabel heroNameLabel = new JLabel("Actor Name");
        heroNameLabel.setBounds(10, 70, 200, 40);
        heroNameLabel.setFont(new Font(null, Font.PLAIN, 20));
        JTextField heroNameField = new JTextField();
        heroNameField.setBounds(170, 80, 300, 30);
        heroNameField.setFont(new Font(null, Font.PLAIN, 15));


                      // Heroine Name
        
        JLabel heroineNameLabel = new JLabel("Actress Name");
        heroineNameLabel.setBounds(10, 130, 210, 40);
        heroineNameLabel.setFont(new Font(null, Font.PLAIN, 20));
        JTextField heroineNameField = new JTextField();
        heroineNameField.setBounds(170, 140, 300, 30);
        heroineNameField.setFont(new Font(null, Font.PLAIN, 15));

        
                       // Director Name

        JLabel directorNameLabel = new JLabel("Director Name");
        directorNameLabel.setBounds(10, 190, 210, 40);
        directorNameLabel.setFont(new Font(null, Font.PLAIN, 20));
        JTextField directorNameField = new JTextField();
        directorNameField.setBounds(170, 200, 300, 30);
        directorNameField.setFont(new Font(null, Font.PLAIN, 15));


                       // Release Year

        JLabel releaseYearLabel = new JLabel("Released Year");
        releaseYearLabel.setBounds(10, 250, 210, 40);
        releaseYearLabel.setFont(new Font(null, Font.PLAIN, 20));
        JTextField releaseYearField = new JTextField();
        releaseYearField.setBounds(170, 260, 300, 30);
        releaseYearField.setFont(new Font(null, Font.PLAIN, 15));


                       // Submit Button

        JButton submitButton = new JButton();
        submitButton.setText("submit");
        submitButton.setBounds(170, 320, 100, 50);
        submitButton.setFont(new Font(null, Font.PLAIN, 20));
        submitButton.setFocusable(false);
        submitButton.addActionListener(new ActionListener() {
        public void actionPerformed (ActionEvent ae) {
            String movieName = movieNameField.getText();
            String heroName = heroNameField.getText();
            String heroineName = heroineNameField.getText();
            String directorName = directorNameField.getText();
            String releaseYear = releaseYearField.getText();
            if (movieName.isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "Enter Proper Movie Name", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            else if (heroName.isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "Enter Proper Hero Name", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            else if (heroineName.isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "Enter Proper Heroine Name", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            else if (directorName.isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "Enter Proper Director Name", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            else if (releaseYear.isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "Enter Proper Release Year", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            else {
                try {
                    Connection con = DriverManager.getConnection(url, user, pass);
                    if (con != null) System.out.println("Connected Sucessfully");
                    Statement st1 = con.createStatement();
                    String insertMovie = movieName.toUpperCase();
                    String insertHero = heroName.toUpperCase();
                    String insertHeroine = heroineName.toUpperCase();
                    String insertDirector = directorName.toUpperCase();
                    String insertreleaseYear = releaseYear.toUpperCase();
                    st1.executeUpdate("insert into movie values( " + "'" + insertMovie + "', '" + insertHero + "', '" + insertHeroine + "', '" + insertDirector + "', '" + insertreleaseYear + "');");
                    movieNameField.setText("");
                    heroNameField.setText("");
                    heroineNameField.setText("");
                    directorNameField.setText("");
                    releaseYearField.setText("");
                    JOptionPane.showMessageDialog(null, "Sucessfully Updated", "Warning", JOptionPane.WARNING_MESSAGE);
                } catch(SQLException e) {
                    System.out.println(e);
                }
                }
            }
        });

        add(movieNameField);
        add(movieNameLabel);
        add(heroNameField);
        add(heroNameLabel);
        add(heroineNameField);
        add(heroineNameLabel);
        add(directorNameField);
        add(directorNameLabel);
        add(releaseYearField);
        add(releaseYearLabel);
        add(submitButton);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e) {
        e.getSource();
    }
}