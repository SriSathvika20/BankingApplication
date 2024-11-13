package TypeofDatabase;

import Entity.customer;

public interface CustomerOperations {
    public String saveCustomer(customer c);
    public String updateCustomer(customer c, String q);
    public void fetchAllCustomer();
    public String deleteCustomer(long accno,String pwd);
    public boolean fetchCustomer(long accno);

}
