package Entity;

public class admin {
      private String adminname;
      private String adminpass;

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getAdminpass() {
        return adminpass;
    }

    public void setAdminpass(String adminpass) {
        this.adminpass = adminpass;
    }

   public admin() {
       super();
   }

    public admin(String adminname, String adminpass) {
        this.adminname = adminname;
        this.adminpass = adminpass;
    }

    @Override
    public String toString() {
        return "admin{" +
                "adminname='" + adminname + '\'' +
                ", adminpass='" + adminpass + '\'' +
                '}';
    }
}
