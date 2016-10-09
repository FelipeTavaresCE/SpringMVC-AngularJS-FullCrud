package cardealer.com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db {

    public static Connection getDb() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/cardealer", "root", "160491");
            return conexao;
        } catch (SQLException e) {
            System.out.println("ERROR" + e);
        }
        return getDb();
    }
}
