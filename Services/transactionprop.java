package Services;

import DatabaseConnection.Utility;
import Entity.transaction;

import java.sql.*;

public class transactionprop {



    public static boolean saveTransaction(transaction tc){

        try {
            Class.forName(Utility.Driver);
            Connection con = Utility.fetchConnection();
            String tquery = "insert into transaction values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(tquery);
            ps.setLong(1,tc.getAccno());
            ps.setString(2,tc.getTtype());
            ps.setLong(3,tc.getTamount());
            ps.setDate(4, tc.getTdate());
            ps.setString(5,tc.getTid());
            int res = ps.executeUpdate();
            if (res > 0) {
               // System.out.println("Transaction Details Saved Successfully");
                return true;
            }
//            else {
//                System.out.println("****** Saving Transaction Details Failed! ******");
//            }


        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    public static void fetchTransaction(String tid){
        try {
            Class.forName(Utility.Driver);
            Connection con = Utility.fetchConnection();
            String tquery = "select * from transaction where tid = ?";
            PreparedStatement ps = con.prepareStatement(tquery);
            ps.setString(1,tid);
            ResultSet rs = ps.executeQuery();
            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
            System.out.println(" accno \t\t ttype  \t\t tamount \t\t date \t\t tid ");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
            while (rs.next()) {
                System.out.println(rs.getLong("accno") + "\t\t"
                        + rs.getString("ttype") + "\t\t"
                        + rs.getLong("tamount") + "\t\t"
                        + rs.getDate("tdate") + "\t\t"
                        + rs.getString("tid") );
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void fetch10Transaction(long accno){
        try {
            Class.forName(Utility.Driver);
            Connection con = Utility.fetchConnection();
            String tquery = "select * from transaction where accno = ?";
            PreparedStatement ps = con.prepareStatement(tquery);
            ps.setLong(1,accno);
            ResultSet rs = ps.executeQuery();
            int ct=0;
            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
            System.out.println(" accno \t\t ttype \t\t tamount \t\t date \t\t tid ");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
            while (rs.next()) {
                if(ct<10) {
                    System.out.println(rs.getLong("accno") + "\t\t"
                            + rs.getString("ttype") + "\t\t"
                            + rs.getLong("tamount") + "\t\t"
                            + rs.getDate("tdate") + "\t\t"
                            + rs.getString("tid"));
                    ct = ct + 1;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
