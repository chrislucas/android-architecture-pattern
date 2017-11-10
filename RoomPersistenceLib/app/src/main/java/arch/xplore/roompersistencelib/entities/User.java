package arch.xplore.roompersistencelib.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import arch.xplore.roompersistencelib.enums.TypeUser;

/**
 * Created by r028367 on 09/11/2017.
 */
@Entity(tableName = "Users")
public class User {
    @PrimaryKey
    private int id;
    @ColumnInfo(name="register")
    private String register;
    @ColumnInfo(name="token")
    private String token;
    @ColumnInfo(name="name")
    private String name;
    @ColumnInfo(name="type_user")
    private TypeUser typeUser;
    @Ignore
    private long lastVacation;          // timestamp

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public TypeUser getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(TypeUser typeUser) {
        this.typeUser = typeUser;
    }

    public long getLastVacation() {
        return lastVacation;
    }

    public void setLastVacation(long lastVacation) {
        this.lastVacation = lastVacation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
