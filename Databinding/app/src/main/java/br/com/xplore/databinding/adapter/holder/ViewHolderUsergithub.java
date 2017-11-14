package br.com.xplore.databinding.adapter.holder;

import android.databinding.ViewDataBinding;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.logging.Handler;

import br.com.xplore.databinding.BR;
import br.com.xplore.databinding.R;
import br.com.xplore.databinding.model.User;

/**
 * Created by r028367 on 13/11/2017.
 */

public class ViewHolderUserGithub extends RecyclerView.ViewHolder {
    private ViewDataBinding viewDataBinding;
    private TextView name;
    /**
     * Constructor
     * */
    public ViewHolderUserGithub(ViewDataBinding viewDataBinding) {
        super(viewDataBinding.getRoot());
        this.viewDataBinding = viewDataBinding;
        View viewRoot = viewDataBinding.getRoot();
        name = viewRoot.findViewById(R.id.github_username);
    }

    public TextView getName() {
        return name;
    }

    public void setName(TextView name) {
        this.name = name;
    }

    public void bind(Object user) {
        viewDataBinding.setVariable(BR.user, user);
        new android.os.Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                viewDataBinding.executePendingBindings();
            }
        });
    }
}
