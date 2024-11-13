//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import AutoGeneratedValues.AccountNumGenerator;
import AutoGeneratedValues.PasswordGenerator;
import MyController.CustomerControl;
import MyController.admincontrol;
import Entity.customer;
import MyController.modifycustomer;
import MyController.transactionControl;
import TypeofDatabase.CustomerOperations;
import TypeofDatabase.customerfactory;

import java.util.*;
import java.sql.Date;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomerOperations opp = customerfactory.getImpl();
        customer c = new customer();

        int ch = 0;
        while (ch != 3) {
            System.out.println("----------------------------------");
            System.out.println("Welcome");
            System.out.println("1. Admin Login");
            System.out.println("2. User Login");
            System.out.println("3. Exit Application");
            System.out.println("----------------------------------");
            ch = sc.nextInt();
            if (ch == 1) {
                System.out.println("!! WELCOME !! --- PLEASE LOGIN");
                System.out.println("1.Login");
                System.out.println("2.Register as Admin");
                int l = sc.nextInt();
                if ( l == 1) {
                    System.out.println("Enter Username: ");
                    String uname = sc.next();
                    System.out.println("Enter Password: ");
                    String password = sc.next();
                    if(admincontrol.getAdminValidate(uname,password)) {
                        int op = 0;
                        while (op != 6) {
                            System.out.println("ADMIN PAGE");
                            System.out.println("----------------------------------");
                            System.out.println("1.create a new customer");
                            System.out.println("2.update a customer");
                            System.out.println("3.fetch all customers");
                            System.out.println("4.delete a customer");
                            System.out.println("5.fetch a transaction by ID");
                            System.out.println("6.logout");
                            System.out.println("----------------------------------");
                            op = sc.nextInt();
                            switch (op) {
                                case 1: {
                                    //customer c = new customer();
                                    System.out.println("Enter Customer Name: ");
                                    sc.nextLine();
                                    c.setFullname(sc.nextLine());
//                                    System.out.println("Enter Account Number: ");
                                    c.setAccono(Long.parseLong(AccountNumGenerator.generateAccountNum(7)));
                                   // sc.nextLine();
                                    System.out.println("Enter Address: ");
                                    c.setAddress(sc.nextLine());
                                    System.out.println("Enter Initial Balance: ");
                                    c.setInitialbal(sc.nextDouble());
                                    System.out.println("Enter Customer Mobile Number: ");
                                    c.setMobile(sc.nextLong());
                                    System.out.println("Enter Type of Account: ");
                                    c.setTypeofacc(sc.next());
//                                    System.out.println("Enter Your Password: ");
//                                    c.setPassword(sc.next());
                                    System.out.println("Enter ID Proof Number: ");
                                    c.setId(sc.next());
                                    System.out.println("Enter Date of Birth: ");
                                    c.setDob(Date.valueOf(sc.next()));
                                    System.out.println("Enter Customer Email-Id: ");
                                    c.setEmailid(sc.next());
                                    c.setPassword(PasswordGenerator.generateRandomPassword(8));
                                    System.out.println(opp.saveCustomer(c));

                                }
                                ;
                                break;
                                case 2: {
                                    //customer c = new customer();
                                    modifycustomer mc = new modifycustomer();
                                    System.out.println("Enter Customer Account number :  ");
                                    long accno = sc.nextLong();
                                    if(opp.fetchCustomer(accno)) {
                                        System.out.println("Customer Details Found Successfully");
                                        int uo = 0;
                                        while (uo != 6) {
                                            System.out.println("----------------------------------");
                                            System.out.println("1.Update Customer Name");
                                            System.out.println("2.Update Customer Email-Id");
                                            System.out.println("3.Update Customer Mobile Number");
                                            System.out.println("4.Update Customer Address");
                                            System.out.println("5.Update Customer Date of Birth");
                                            System.out.println("6.Exit Form Update");
                                            System.out.println("----------------------------------");
                                            uo = sc.nextInt();
                                            mc.modifydetails(c, accno, uo);

                                        }
                                    }
                                    else{
                                        System.out.println(" !! Customer Details Not Found !!");
                                    }
                                }
                                ;
                                break;
                                case 3: {
                                    System.out.println("****** Customer Details ******");
                                    opp.fetchAllCustomer();
                                }
                                ;
                                break;
                                case 4: {
                                    System.out.println("Enter Customer Account Number: ");
                                    long accno = sc.nextLong();
                                    System.out.println("Enter Customer Password: ");
                                    String pwd = sc.next();
                                    System.out.println(opp.deleteCustomer(accno, pwd));
                                }
                                ;
                                break;
                                case 5: {
                                    System.out.println("Enter Transaction ID : ");
                                    String tid = sc.next();
                                    transactionControl.getTransactionById(tid);
                                };
                                break;
                                case 6: {
                                    System.out.println("****** Admin Logout Successfully ******");
                                };
                                break;
                                default:
                                    System.out.println("******  Choose Right Option  ******");
                                    break;
                            }
                        }
                    }
                }
                if(l == 2){
                    System.out.println("Enter Username: ");
                    String uname = sc.next();
                    System.out.println("Enter Password: ");
                    String password = sc.next();
                    admincontrol.getAdminDetails(uname,password);
                }
            }
            if (ch == 2) {
                System.out.println("!!WELCOME1!! --- PLEASE LOGIN");
                System.out.println("Enter Account No :");
                long accno = sc.nextLong();
                System.out.println("Enter Password : ");
                String pass = sc.next();
                if(CustomerControl.getValidateCustomer(accno,pass)){
                    System.out.println("CUSTOMER PAGE");
                    int co = 0;
                    while (co!=7) {
                        System.out.println("----------------------------------");
                        System.out.println("1.Reset Password");
                        System.out.println("2.View Balance");
                        System.out.println("3.Deposit");
                        System.out.println("4.Withdraw");
                        System.out.println("5.Delete Account");
                        System.out.println("6.View Previous transactions");
                        System.out.println("7.logout");
                        System.out.println("----------------------------------");
                        co=sc.nextInt();
                        switch (co){
                            case 1 : {
                                System.out.println("Enter Your Account No and New-Password : ");
                                String res = CustomerControl.getPasswordChange(sc.nextLong(),sc.next());
                                System.out.println(res);
                            };
                            break;
                            case 2 : {
                                //System.out.println("Enter Your Account No and Password : ");
                                //customerprop.viewBalance();
                                c = CustomerControl.getBalance(accno);
                                System.out.println("Customer Details ");
                                System.out.println("--------------------------------------");
                                System.out.println("Full Name : "+ c.getFullname()
                                +"\nAddress : "+ c.getAddress()
                                +"\nMobile Number : "+ c.getMobile()
                                +"\nAccount No : "+ c.getAccono()
                                +"\nType Of Account : " + c.getTypeofacc()
                                +"\nBalance : "+ c.getInitialbal()
                                );
                                System.out.println("--------------------------------------");
                            };
                            break;
                            case 3 : {
                                System.out.println("Enter your Account No : ");
                                long a = sc.nextLong();
                                System.out.println("Enter Amount to be Deposited : ");
                                long b = sc.nextLong();
//                                customerprop.deposit(a,b);
//                                transactionControl.saveTransaction(a,b,"Deposit");
                                String s = CustomerControl.getDeposit(a,b);
                                System.out.println(s);
                            };
                            break;
                            case 4 : {
                                System.out.println("Enter your Account No : ");
                                long aa = sc.nextLong();
                                System.out.println("Enter Amount to be Withdraw : ");
                                long bb = sc.nextLong();
                                String ss = CustomerControl.getWithdraw(aa,bb);
                                System.out.println(ss);
                            };
                            break;
                            case 5 : {
                                System.out.println("Enter your Account No : ");
                                long acc = sc.nextLong();
//                                System.out.println("Enter Password : ");
//                                String pd = sc.next();
                                System.out.println(CustomerControl.getDelete(acc));
                            };
                            break;
                            case 6 : {
                                System.out.println("Enter your Account No : ");
                                long acc = sc.nextLong();
                                transactionControl.get10Transaction(acc);
                            };
                            break;
                            case 7 : {
                                System.out.println("****** Customer Logout Successfully ******");
                            };
                            break;
                            default :
                                System.out.println("******  Choose Right Option  ******");
                                break;
                        }
                    }

                }
                else{
                    System.out.println("!!!!    Invalid Credentials    !!!!");
                }
            }
            if (ch == 3) {
                System.out.println("******* Application Ends *******");
            }
        }


    }
}
