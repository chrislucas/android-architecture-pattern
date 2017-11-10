package arch.xplore.roompersistencelib.db.typeconverters;

import android.arch.persistence.room.TypeConverter;

import arch.xplore.roompersistencelib.enums.TypeUser;

/**
 * Created by r028367 on 10/11/2017.
 */

public class TypeUserConverter {
    @TypeConverter
    public int getIDTypeUser(TypeUser typeUser) {
        return typeUser.getType();
    }

    @TypeConverter
    public TypeUser getTypeUser(int i) {
        return TypeUser.getType(i);
    }
}
