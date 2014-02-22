package example003.bean;

import example002.bean.User;

/**
 * Created by DongZhukai on 14-2-24.
 */
public class Mobile {
    private int id;
    private String telnumber;
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelnumber() {
        return telnumber;
    }

    public void setTelnumber(String telnumber) {
        this.telnumber = telnumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
