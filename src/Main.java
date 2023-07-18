import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String sql_statement = "select form JavaDB";
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaDB", "pluto", "lintonwin");
        if (c != null) {
            System.out.println("Connecting to the database");
        } else {
            System.out.println("Cannot connect to the database");
        }
    }
}

