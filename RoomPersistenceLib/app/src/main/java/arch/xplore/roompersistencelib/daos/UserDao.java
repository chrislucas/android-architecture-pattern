package arch.xplore.roompersistencelib.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import arch.xplore.roompersistencelib.models.User;

/**
 * Created by r028367 on 09/11/2017.
 */

@Dao
public interface UserDao {

    @Query("SELECT * FROM users")
    List<User> getAll();

    @Query("SELECT * FROM users WHERE register = :register")
    User getByRegister(String register);

    @Insert
    long insert(User user);

    @Delete
    void delete(User user);

    @Query("SELECT CAST(COUNT(users.id) AS BIT) FROM users")
    boolean hasUsers();
}
