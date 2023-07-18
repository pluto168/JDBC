import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class Main {
    private static Connection c;
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        initializeDB();

        String name = JOptionPane.showInputDialog("Fined a javatab by name.");
        String sql_statement = "select * from javatab where javatabName = ? ; ";
        PreparedStatement pps = c.prepareStatement(sql_statement);
        pps.setString(1, name);
        ResultSet rs = pps.executeQuery();
        if(rs.next()){
            int title = Integer.parseInt(rs.getString("javatabId"));
            String jname = rs.getString("javatabName");
            int price = Integer.parseInt(rs.getString("price"));
            JOptionPane.showMessageDialog(null, new Javatab(title, jname,price));
        }else{
            JOptionPane.showMessageDialog(null, "not found...");
        }

        closeDB();
    }

    private static void initializeDB() throws SQLException {
        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaDB", "pluto", "lintonwin");
        if (c != null) {
            System.out.println("Connecting to the database");
        } else {
            System.out.println("Cannot connect to the database");
        }

    }

    private static void closeDB() throws SQLException{
        c.close();
    }
}

