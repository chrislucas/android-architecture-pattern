package br.com.xplore.databinding.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;


/**
 * Created by r028367 on 13/11/2017.
 */

public class User extends BaseObservable{
    private String name;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        //notifyPropertyChanged(BR.name);
    }
}
