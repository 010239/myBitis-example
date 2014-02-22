package example004.bean;

import java.util.List;

/**
 * Created by DongZhukai on 14-2-24.
 */
public class User {
    private int id;
    private String userName;
    private String password;
    private List<Mobile> mobiles;  //这里也可以是Set集合

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Mobile> getMobiles() {
        return mobiles;
    }

    public void setMobiles(List<Mobile> mobiles) {
        this.mobiles = mobiles;
    }
}
