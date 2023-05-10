package main;
import java.sql.*;

public class sqlcon {

    private static final String URL = "jdbc:mysql://wayne.cs.uwec.edu/cs355g2";
    private static final String USERNAME = "CS355G2";
    private static final String PASSWORD = "SFM2BKLT";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}

