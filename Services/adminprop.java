package Services;

import DatabaseConnection.Utility;

import java.sql.*;

public class adminprop {

    public static void insertadmin(String uname, String pwd){

        try {
            Class.forName(Utility.Driver);
            Connection con = Utility.fetchConnection();
            PreparedStatement ps;
            ps = con.prepareStatement("insert into admin values(?,?)");
            ps.setString(1,uname);
            ps.setString(2,pwd);
            int res = ps.executeUpdate();
            if(res>0){
                System.out.println(res+"rows inserted");
            }
            else{
                System.out.println("not inserted");
            }
        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }
    public static boolean validateAdmin(String uname,String pwd){
        try {
            Class.forName(Utility.Driver);
            Connection con = Utility.fetchConnection();
            String vquery = "select * from admin ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(vquery);
            while(rs.next()){
                if( (rs.getString("username").equals(uname)) && (rs.getString("password").equals(pwd)) ){
                    System.out.println("Login Successful");

                }
                else{
                    System.out.println("Invalid Credentials");
                    return false;
                }
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
       return true;
    }
}
