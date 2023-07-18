import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String sql_statement = "select * from Javatab";
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaDB", "pluto", "lintonwin");
        if (c != null) {
            System.out.println("Connecting to the database");
        } else {
            System.out.println("Cannot connect to the database");
        }

        PreparedStatement pps = c.prepareStatement(sql_statement);
        ResultSet rs = pps.executeQuery();

        ArrayList<Javatab> result = new ArrayList<>();
        while (rs.next()){
            Javatab v = new Javatab(Integer.parseInt(rs.getString("javatabId")),rs.getString("javatabName"),Integer.parseInt(rs.getString("price")));
            result.add(v);
        }

        for (Javatab v : result){
            System.out.println(v.toString());
        }

        c.close();
    }
}

