package MyController;

import Entity.admin;
import Services.adminprop;

public class admincontrol {
    public static void getAdminDetails(String uname, String pwd){
        admin ad = new admin();
        ad.setAdminname(uname);
        ad.setAdminpass(pwd);
        adminprop.insertadmin(ad.getAdminname(),ad.getAdminpass());
    }
    public static boolean getAdminValidate(String uname, String pwd){
        admin ad = new admin();
        ad.setAdminname(uname);
        ad.setAdminpass(pwd);
        if(adminprop.validateAdmin(ad.getAdminname(),ad.getAdminpass())){
            return true;
        }
        return false;
    }
}
