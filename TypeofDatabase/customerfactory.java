// to give the access for more than one database implementation , so to not create object
// in main for customeroperationsimpl we are cretaing this class for flexcible access
package TypeofDatabase;


import Services.CustomerOperationsImpl;

public class customerfactory {
    private static CustomerOperations ref;
    public static void setOperations(CustomerOperations impl){
        ref = impl;
    }
    public static CustomerOperations getImpl(){
       setOperations(new CustomerOperationsImpl());//here we can pass any other implementation like other databases
        return ref;
    }
}
