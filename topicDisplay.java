// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
public class topicDisplay extends JFrame {
    topicDisplay(String search, String str) {
        String url = "jdbc:mysql://localhost:3306/swarupbases";
        String user = "root";
        String pass = "Dzire@3789";
        JTextArea dispTextArea = new JTextArea();
        JTextArea fullDisplayArea = new JTextArea();
        boolean flag = true;
        fullDisplayArea.append("MOVIE NAMES \t  HEROS \t  HEROINES \t  DIRECTORS \t  RELEASE YEAR" + "\n");
        try {
            Connection con  = DriverManager.getConnection(url, user, pass);
            Statement st1 = con.createStatement();
            System.out.println(search + "\n" + str);
            ResultSet searchValues = st1.executeQuery("SELECT * FROM movie where " + search + " = '" + str + "';");
            while (searchValues.next()) {
                flag = false;
                String s1 = searchValues.getString(2);
                String s2 = searchValues.getString(3);
                String s3 = searchValues.getString(4);
                ArrayList<String>arrHero = new ArrayList<>();
                ArrayList<String>arrHeroine = new ArrayList<>();
                ArrayList<String>arrDirector = new ArrayList<>();
                System.out.println(s1 + "\n" + s2 + "\n" + s3);
                String hero = "";
                String heroine = "";
                String director = "";
                for (int i = 0; i < s1.length(); i++) {
                    if (s1.charAt(i) != ',' && s1.charAt(i) != ' ')   
                        hero += s1.charAt(i);
                    else if (s1.charAt(i) == ',')    {
                        arrHero.add(hero);
                        hero = "";
                    }
                }
                // System.out.println(hero + "hi");
                arrHero.add(hero);
                for (int i = 0; i < s2.length(); i++) {
                    if (s2.charAt(i) != ',' && s2.charAt(i) != ' ') heroine += s2.charAt(i);
                    else if (s2.charAt(i) == ',')    {
                        arrHeroine.add(heroine);
                        heroine = "";
                    }
                }
                arrHeroine.add(heroine);
                for (int i = 0; i < s3.length(); i++) {
                    if (s3.charAt(i) != ',' && s3.charAt(i) != ' ') director += s3.charAt(i);
                    else if (s3.charAt(i) == ',')    {
                        arrDirector.add(director);
                        director = "";
                    }
                }
                arrDirector.add(director);
                
                // System.out.println(arrHero.get(0));
                // System.out.println(arrHeroine.get(0));
                // System.out.println(arrDirector.get(0));

                fullDisplayArea.append(searchValues.getString(1) + "\t ");
                fullDisplayArea.append(arrHero.get(0) + "\t ");
                fullDisplayArea.append(arrHeroine.get(0) + "\t ");
                fullDisplayArea.append(arrDirector.get(0) + "\t ");
                fullDisplayArea.append(searchValues.getString(5) + "\n");
                int i = 1, j = 1, k = 1, n = arrHero.size(), m = arrHeroine.size(), p = arrDirector.size();
                while (i < n || j < m || k < p) {
                    fullDisplayArea.append("\t");
                    if (i < n) {
                        fullDisplayArea.append(" " + arrHero.get(i) + "\t");
                        i++;
                    }
                    else fullDisplayArea.append("\t");
                    if (j < m) {
                        fullDisplayArea.append(" " + arrHeroine.get(j) + "\t");
                        j++;
                    }
                    else fullDisplayArea.append("\t");
                    if (k < p) {
                        fullDisplayArea.append(" " + arrDirector.get(k));
                        k++;
                    }
                    fullDisplayArea.append("\n");
                }
                arrHero.clear();
                arrHeroine.clear();
                arrDirector.clear();
            }
        }
        catch(SQLException e) {
            System.out.println(e);
        }
        add(dispTextArea);
        add(fullDisplayArea);
        pack();
        if (flag == true) {
            JOptionPane.showMessageDialog(null, "Match Not found in the database", "Warning", JOptionPane.WARNING_MESSAGE);
            setVisible(false);
        }
        else 
            setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
