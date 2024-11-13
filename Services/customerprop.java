package Services;

import DatabaseConnection.Utility;
import Entity.customer;


import java.sql.*;

public class customerprop {
    public static boolean validateCustomer(long accno, String cpwd) {
        try {
            Class.forName(Utility.Driver);
            Connection con = Utility.fetchConnection();
            String vquery = "select * from customer ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(vquery);
            while (rs.next()) {
                if ((rs.getLong("accno") == accno) && (rs.getString("password").equals(cpwd))) {
                    //System.out.println("Login Successful");
                    return true;

                }
//                else {
//                   // System.out.println("Invalid Credentials");
//                    return false;
//                }
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean resetPassword(long accno, String repwd) {
        try {
            Class.forName(Utility.Driver);
            Connection con = Utility.fetchConnection();
            String rquery = "update customer set password=? where accno=?";
            PreparedStatement ps = con.prepareStatement(rquery);
            ps.setString(1, repwd);
            ps.setLong(2, accno);
            int res = ps.executeUpdate();
            if (res > 0) {
                //System.out.println("Password Reset Successfully");
                return true;
            }
//            else {
//                System.out.println("****** Password Reset Failed! ******");
//            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public static customer viewBalance(long accno) {
        customer c = new customer();
        try {
            Class.forName(Utility.Driver);
            Connection con = Utility.fetchConnection();
            String vquery = "select * from customer";
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(vquery);

            while(res.next()){
                if(res.getLong("accno") == accno) {
//                System.out.println("Full Name : "+res.getString("fullname")
//                                +"\nAddress : "+res.getString("address")
//                                +"\nMobile Number : "+res.getLong("mobile")
//                                +"\nAccount No : "+res.getLong("accno")
//                                +"\nType Of Account : "+res.getString("typeofacc")
//                                +"\nBalance : "+res.getLong("initialbal")
//                );
                  c.setAccono(accno);
                  c.setFullname(res.getString("fullname"));
                  c.setAddress(res.getString("address"));
                  c.setMobile(res.getLong("mobile"));
                  c.setTypeofacc(res.getString("typeofacc"));
                  c.setInitialbal(res.getLong("initialbal"));
                  c.setDob(res.getDate("dob"));
                  c.setEmailid(res.getString("emailid"));
                  c.setId(res.getString("id"));
                  c.setPassword(res.getString("password"));

                }
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return c;
    }
    public static boolean deposit(long accno,long amo){
        try{
            Class.forName(Utility.Driver);
            Connection con = Utility.fetchConnection();
            String dquery = "update customer set initialbal= initialbal + ? where accno=?";
            PreparedStatement ps = con.prepareStatement(dquery);
            ps.setLong(1,amo);
            ps.setLong(2,accno);
            int res = ps.executeUpdate();

            if(res>0){
                //System.out.println("Deposited Successful");

                return true;
            }
//            else{
//                System.out.println("Deposit Failed");
//            }

        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public static boolean withdraw(long accno,long amo){
        try{
            Class.forName(Utility.Driver);
            Connection con = Utility.fetchConnection();
            String cquery = "update customer set initialbal= initialbal - ? where accno=?";
            PreparedStatement ps = con.prepareStatement(cquery);
            ps.setLong(1,amo);
            ps.setLong(2,accno);
            int res = ps.executeUpdate();
            if(res>0){
                //System.out.println("Withdraw Successful");
                return true;
            }
//            else{
//                System.out.println("withdraw Failed");
//            }

        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public static boolean deleteAcc(long accno) {
        try {
            Class.forName(Utility.Driver);
            Connection con = Utility.fetchConnection();
//            String dquery = "delete from transaction where where accno = ?";
//            PreparedStatement ps = con.prepareStatement(dquery);
//            ps.setLong(1, accno);
            String dtquery = "delete from customer where accno = ? and initialbal=0";
            PreparedStatement ps1 = con.prepareStatement(dtquery);
            ps1.setLong(1, accno);
            //ps.setString(2, pwd);
//            int res = ps.executeUpdate();
            int res1 = ps1.executeUpdate();
            if (res1>0) {
                //System.out.println("Customer Details Deleted successfully");
                return true;
            }
//            else {
//                System.out.println("Not Deleted   \n  !!Try Again!!");
//            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}