package DatabaseConnection;

import java.sql.*;
public class Utility {
    public  static String Driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/bank";
    private static String username = "root";
    private static String password = "141503";
    private static Connection con;
    public static Connection fetchConnection(){
        try{
            con=DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
