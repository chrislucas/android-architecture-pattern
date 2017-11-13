package br.com.xplore.databinding.adapter.holder;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.com.xplore.databinding.R;

/**
 * Created by r028367 on 13/11/2017.
 */

public class ViewHolderUsergithub extends RecyclerView.ViewHolder {

    private ViewDataBinding viewDataBinding;
    private TextView name;

    public ViewHolderUsergithub(ViewDataBinding viewDataBinding) {
        super(viewDataBinding.getRoot());
        View viewRoot = viewDataBinding.getRoot();
        name = viewRoot.findViewById(R.id.github_username);
    }

    public TextView getName() {
        return name;
    }

    public void setName(TextView name) {
        this.name = name;
    }
}
