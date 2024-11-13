package MyController;

import Entity.customer;
import Services.customerprop;

public class CustomerControl {

    public static boolean getValidateCustomer(long accno, String cpwd){
        if(customerprop.validateCustomer(accno, cpwd)){
            return true;
        }
        else{
            return false;
        }
    }

    public static String getPasswordChange(long accno, String repwd){
        String status;
        if(customerprop.resetPassword(accno, repwd)){
             status = "Password Reset Successfully";
        }
        else{
             status = "****** Password Reset Failed! ******";
        }
        return status;
    }

    public static customer getBalance(long accno){
        customer c;
        c = customerprop.viewBalance(accno);
        return c;
    }

    public static String getDeposit(long acc,long amo){
        String status;
        String trantype = "Deposit";
        if(customerprop.deposit(acc,amo)){
            if(transactionControl.saveTransaction(acc,amo,trantype)) {
                status = "Deposited Successful and Transaction Details Saved Successfully";
            }
            else{
                status = "Deposit Failed because Saving Transaction Details Failed!" ;
            }
        }
        else{
            status = "Deposit Failed";
        }
        return status;
    }

    public static String getWithdraw(long acc,long amo){
        String status;
        if(customerprop.withdraw(acc,amo)){
            if(transactionControl.saveTransaction(acc,amo,"Withdraw")) {
                status = "Withdraw Successful and Transaction Details Saved Successfully";
            }
            else{
                status = "withdraw Failed because Saving Transaction Details Failed!";
            }
        }
        else{
            status = "withdraw Failed";
        }
        return status;
    }

    public static String getDelete(long acc){
        String res;
        if(customerprop.deleteAcc(acc)){
            res = "Customer Details Deleted successfully";
        }
        else{
            res = "Not Deleted    !!Try Again!!";
        }
        return res;
    }
}
