package br.com.xplore.databinding.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import br.com.xplore.databinding.BR;


/**
 * Created by r028367 on 13/11/2017.
 */

public class User extends BaseObservable{
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Override
    public String toString() {
        return String.format("Username: %s", name);
    }
}
