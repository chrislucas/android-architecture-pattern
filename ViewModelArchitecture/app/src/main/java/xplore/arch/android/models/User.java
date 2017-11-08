package xplore.arch.android.models;

/**
 * Created by r028367 on 08/11/2017.
 */

public class User {
    private String register;
    private int id;

    public User(String register, int id) {
        this.register = register;
        this.id = id;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
