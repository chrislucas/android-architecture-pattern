package arch.xplore.roompersistencelib.enums;

import android.util.SparseArray;

/**
 * Created by r028367 on 09/11/2017.
 */

public enum TypeUser {
    TECHNICIAN(0), SUPERVISOR(1);
    private int type;

    TypeUser(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    static SparseArray<String> map;

    static  {
        map = new SparseArray<>();
        map.put(1, "Técnico");
        map.put(2, "Supervisor");
    }

    public static TypeUser getType(int i) {
        TypeUser typeUser = null;
        if(i < values().length) {
            typeUser = values()[i];
        }
        return typeUser;
    }

    public String getDescription(TypeUser typeUser) {
        return map.get(typeUser.getType());
    }

    @Override
    public String toString() {
        return this.name();
    }
}
