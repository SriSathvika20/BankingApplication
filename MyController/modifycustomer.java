package MyController;

import Entity.customer;
import Services.CustomerOperationsImpl;

import java.sql.Date;
import  java.util.Scanner;
public class modifycustomer {
    public void modifydetails(customer c, long accno, int uo){
        CustomerOperationsImpl opp = new CustomerOperationsImpl();
        Scanner sc = new Scanner(System.in);

        if(uo == 1){
            System.out.println("Enter New Name for update : ");
            c.setFullname(sc.next());
            String q = "UPDATE customer SET fullname='" + c.getFullname() + "' WHERE accno=" + accno;
            System.out.println(opp.updateCustomer(c,q));
        }
        else
            if (uo == 2) {
                System.out.println("Enter New Email-Id for update : ");
                c.setEmailid(sc.next());
                String q = "UPDATE customer SET emailid='" + c.getEmailid() + "' WHERE accno=" + accno;
                System.out.println(opp.updateCustomer(c,q));
            }

        else
            if(uo == 3){
                System.out.println("Enter New Mobile Number for update : ");
                c.setMobile(sc.nextLong());
                String q = "UPDATE customer SET mobile='" + c.getMobile() + "' WHERE accno=" + accno;
                System.out.println(opp.updateCustomer(c,q));
            }

        else
            if(uo == 4){
                System.out.println("Enter New Address for update : ");
                c.setAddress(sc.next());
                String q = "UPDATE customer SET address='" + c.getAddress() + "' WHERE accno=" + accno;
                System.out.println(opp.updateCustomer(c,q));
            }
        else
            if(uo == 5){
                System.out.println("Enter New Date of Birth for update : ");
                c.setDob(Date.valueOf(sc.next()));
                String q = "UPDATE customer SET dob='" + c.getDob() + "' WHERE accno=" + accno;
                System.out.println(opp.updateCustomer(c,q));
            }
        else
            if(uo == 6){
                System.out.println("Exited Successfully");
            }
        else {
                System.out.println("Choose Right Option for Update ");
            }
    }
}
