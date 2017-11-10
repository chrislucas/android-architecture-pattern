package arch.xplore.roompersistencelib.utils;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import arch.xplore.roompersistencelib.db.DatabaseApp;

/**
 * Created by r028367 on 10/11/2017.
 */

public class MyDatabaseBuilder {

    private DatabaseApp databaseApp;
    private static MyDatabaseBuilder instance = null;

    private MyDatabaseBuilder() {}

    public DatabaseApp getDatabaseApp() {
        return databaseApp;
    }

    public synchronized static MyDatabaseBuilder getInstance(Context context) {
        if(instance == null) {
            instance = new MyDatabaseBuilder();
            // Isso parece ser sinixtro
            //instance.databaseApp =Room.inMemoryDatabaseBuilder(context, DatabaseApp.class).build();
            RoomDatabase.Builder<DatabaseApp> db = Room.databaseBuilder(context
                    , DatabaseApp.class, DatabaseApp.NAME);
            instance.databaseApp = db
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public void destroy() {
        instance = null;
    }

}
