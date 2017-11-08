package xplore.arch.android.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import xplore.arch.android.models.User;

/**
 * Created by r028367 on 08/11/2017.
 *
 * Objetos do tipo ViewModel sao automaticamente retidos durante a mudanca de configuracao
 * da tela, nao sendo necessario guardar a instancia e recuperada nos metodos auxiliares
 * que temos na Activity onSaveInstance e onRestoreInstance
 */

public class ViewModelListUsers extends ViewModel {
    private MutableLiveData<List<User>> users;
    public LiveData<List<User>> getUsers() {
        if(users == null) {
            users = new MutableLiveData<>();
            setUsers();
        }
        return users;
    }
    /**
     * Um metodo qualquer que inicializa a lista de usuarioa caso for preciso
     * */
    private void setUsers() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("r028333", 1));
        userList.add(new User("r028334", 2));
        userList.add(new User("r028335", 3));
        userList.add(new User("r028336", 4));
        userList.add(new User("r028337", 5));
        userList.add(new User("r028338", 6));
        userList.add(new User("r028339", 7));
        userList.add(new User("r028340", 8));
        userList.add(new User("r028341", 9));
        userList.add(new User("r028342", 10));
        users.setValue(userList);
    }
}
