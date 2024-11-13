package Entity;

import java.sql.Date;
public class customer {
    private String fullname;
    private String emailid;
    private String address;
    private long  mobile;
    private Date dob;
    private String id;
    private double initialbal;
    private String typeofacc;
    private String password;
    private long accono;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getInitialbal() {
        return initialbal;
    }

    public void setInitialbal(double initialbal) {
        this.initialbal = initialbal;
    }

    public String getTypeofacc() {
        return typeofacc;
    }

    public void setTypeofacc(String typeofacc) {
        this.typeofacc = typeofacc;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getAccono() {
        return accono;
    }

    public void setAccono(long accono) {
        this.accono = accono;
    }
    public customer(){
        super();
    }

    public customer(String fullname, String emailid, String address, long mobile, Date dob, String id, double initialbal, String typeofacc, String password, long accono) {
        this.fullname = fullname;
        this.emailid = emailid;
        this.address = address;
        this.mobile = mobile;
        this.dob = dob;
        this.id = id;
        this.initialbal = initialbal;
        this.typeofacc = typeofacc;
        this.password = password;
        this.accono = accono;
    }

    @Override
    public String toString() {
        return "customer{" +
                "fullname='" + fullname + '\'' +
                ", emailid='" + emailid + '\'' +
                ", address='" + address + '\'' +
                ", mobile=" + mobile +
                ", dob=" + dob +
                ", id='" + id + '\'' +
                ", initialbal='" + initialbal + '\'' +
                ", typeofacc='" + typeofacc + '\'' +
                ", password='" + password + '\'' +
                ", accono=" + accono +
                '}';
    }
}
