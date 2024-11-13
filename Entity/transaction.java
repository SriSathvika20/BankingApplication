package Entity;

import java.sql.Date;
public class transaction {
   private long accno;
   private String ttype;
   private long tamount;
   private Date tdate;
   private String tid;

    public long getAccno() {
        return accno;
    }

    public void setAccno(long accno) {
        this.accno = accno;
    }

    public String getTtype() {
        return ttype;
    }

    public void setTtype(String ttype) {
        this.ttype = ttype;
    }

    public long getTamount() {
        return tamount;
    }

    public void setTamount(long tamount) {
        this.tamount = tamount;
    }

    public Date getTdate() {
        return tdate;
    }

    public void setTdate(Date tdate) {
        this.tdate = tdate;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public transaction() {
        super();
    }

    public transaction(long accno, String ttype, long tamount, Date tdate, String tid) {
        this.accno = accno;
        this.ttype = ttype;
        this.tamount = tamount;
        this.tdate = tdate;
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "transaction{" +
                "accno=" + accno +
                ", ttype='" + ttype + '\'' +
                ", tamount=" + tamount +
                ", tdate=" + tdate +
                ", tid=" + tid +
                '}';
    }
}
