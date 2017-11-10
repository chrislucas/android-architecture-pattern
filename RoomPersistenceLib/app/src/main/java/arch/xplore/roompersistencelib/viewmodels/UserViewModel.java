package arch.xplore.roompersistencelib.viewmodels;

import android.arch.lifecycle.MutableLiveData;

import arch.xplore.roompersistencelib.models.User;

/**
 * Created by r028367 on 09/11/2017.
 */

public class UserViewModel {

    private MutableLiveData<User> mutableLiveDataUser;

    public UserViewModel(MutableLiveData<User> mutableLiveDataUser) {
        this.mutableLiveDataUser = mutableLiveDataUser;
    }

    public MutableLiveData<User> getMutableLiveDataUser() {
        return mutableLiveDataUser;
    }
}
