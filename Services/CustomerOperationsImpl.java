package Services;

import DatabaseConnection.Utility;
import Entity.customer;
import TypeofDatabase.CustomerOperations;

import java.sql.*;
public class CustomerOperationsImpl implements CustomerOperations {
    @Override
    public String saveCustomer(customer c) {
        String status;
        try {
            Class.forName(Utility.Driver);
            Connection con = Utility.fetchConnection();
            String query = "insert into customer values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, c.getFullname());
            ps.setString(2, c.getEmailid());
            ps.setString(3, c.getAddress());
            ps.setLong(4, c.getMobile());
            ps.setDate(5, c.getDob());
            ps.setLong(6, c.getAccono());
            ps.setDouble(7, c.getInitialbal());
            ps.setString(8, c.getTypeofacc());
            ps.setString(9, c.getId());
            ps.setString(10, c.getPassword());
            int res = ps.executeUpdate();

            if (res > 0) {
                //System.out.println("Customer Details Saved Successfully");
                //System.out.println("your account number is "+ c.getAccono());
                status = "Customer Details Saved Successfully";
            } else {
                //System.out.println("****** Saving Customer Details Failed! ******");
                status = "****** Saving Customer Details Failed! ******";
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return status;
    }

    @Override
    public String updateCustomer(customer c, String q) {
        String status = " " ;
        try {
            Class.forName(Utility.Driver);
            Connection con = Utility.fetchConnection();
            Statement st = con.createStatement();
            int res = st.executeUpdate(q);

            if (res > 0) {
               // System.out.println("Customer Details Updated Successfully");
               status = "Customer Details Updated Successfully";
            } else {
               // System.out.println("****** Customer Details Update Failed!! ******");
               status = "****** Customer Details Update Failed!! ******";
            }
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public void fetchAllCustomer() {
        try {
            Class.forName(Utility.Driver);
            Connection con = Utility.fetchConnection();
            String fquery = "select fullname,accno,typeofacc,mobile,address,initialbal,id from customer";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(fquery);
            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
            System.out.println("fullname \t\t accno \t\t typeofacc \t\t mobile \t\t address \t\t initialbal \t\t id ");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
            while (rs.next()) {
                System.out.println(rs.getString("fullname") + "\t\t" + rs.getLong("accno") + "\t\t" + rs.getString("typeofacc") + "\t\t" + rs.getLong("mobile") + "\t\t" + rs.getString("address") + "\t\t" + rs.getLong("initialbal") + "\t\t" + rs.getString("id"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String deleteCustomer(long accno, String pwd) {
        String s;
        try {
            Class.forName(Utility.Driver);
            Connection con = Utility.fetchConnection();
            String dquery = "delete from customer where accno=? and password=?";
            PreparedStatement ps = con.prepareStatement(dquery);
            ps.setLong(1, accno);
            ps.setString(2, pwd);
            int res = ps.executeUpdate();
            if (res > 0) {
                //System.out.println("Customer Details Deleted successfully");
                s = "Customer Details Deleted successfully";
            } else {
                //System.out.println("Not Deleted   \n  !!Try Again!!");
                s = "Not Deleted   \n  !!Try Again!!";
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return s;
    }

    @Override
    public boolean fetchCustomer(long accno) {
        try {
            Class.forName(Utility.Driver);
            Connection con = Utility.fetchConnection();
            String fq = "select * from customer where accno=?";
            PreparedStatement ps = con.prepareStatement(fq);
            ps.setLong(1,accno);
            ResultSet rs = ps.executeQuery();
            boolean res = false;
            while (rs.next()) {
                res = true;
                break;
            }
            con.close();
            return res;

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
