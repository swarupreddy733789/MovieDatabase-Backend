import java.sql.*;
import java.util.ArrayList;
// import java.awt.*;
import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
import javax.swing.*;
public class display extends JFrame {
    display() {
        // setLayout(null);
        setTitle("Display Movie Details");
        JTextArea fullDisplayArea = new JTextArea();
        fullDisplayArea.append("MOVIE NAMES \t  HEROS \t  HEROINES \t  DIRECTORS \t  RELEASE YEAR" + "\n");
        try {
            String url = "jdbc:mysql://localhost:3306/swarupbases";
        String user = "root";
        String pass = "Dzire@3789";
            Connection con  = DriverManager.getConnection(url, user, pass);
            Statement st1 = con.createStatement();
            ResultSet fullDisplay = st1.executeQuery("select * from movie");
            while (fullDisplay.next()) {
                String s1 = fullDisplay.getString(2);
                String s2 = fullDisplay.getString(3);
                String s3 = fullDisplay.getString(4);
                ArrayList<String>arrHero = new ArrayList<>();
                ArrayList<String>arrHeroine = new ArrayList<>();
                ArrayList<String>arrDirector = new ArrayList<>();
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

                fullDisplayArea.append(fullDisplay.getString(1) + "\t ");
                fullDisplayArea.append(arrHero.get(0) + "\t ");
                fullDisplayArea.append(arrHeroine.get(0) + "\t ");
                fullDisplayArea.append(arrDirector.get(0) + "\t ");
                fullDisplayArea.append(fullDisplay.getString(5) + "\n");
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
        } catch(SQLException exp) {
            System.out.println(exp);
        }
        
        add(fullDisplayArea);
        setVisible(true);
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent displayevent) {
        
    }
}
