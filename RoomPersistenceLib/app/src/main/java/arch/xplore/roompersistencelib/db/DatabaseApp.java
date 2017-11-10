package arch.xplore.roompersistencelib.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;

import arch.xplore.roompersistencelib.daos.UserDao;
import arch.xplore.roompersistencelib.db.typeconverters.TypeUserConverter;
import arch.xplore.roompersistencelib.models.User;

/**
 * Created by r028367 on 10/11/2017.
 */
@Database(entities = {User.class}, version = 1, exportSchema = false)
@TypeConverters({TypeUserConverter.class})
public abstract class DatabaseApp extends RoomDatabase {
    public static final String NAME = "how_to_using_room_lib";
    public abstract UserDao userDao();
}
