package main;
import classes.*;
import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        
        try(Connection conn = sqlcon.getConnection()){
 
            System.out.println("wow it worked");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
