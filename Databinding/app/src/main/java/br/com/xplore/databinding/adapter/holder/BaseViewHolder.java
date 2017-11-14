package br.com.xplore.databinding.adapter.holder;

import android.databinding.ViewDataBinding;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import br.com.xplore.databinding.BR;

/**
 * Created by r028367 on 14/11/2017.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {

    private ViewDataBinding viewDataBinding;

    public BaseViewHolder(ViewDataBinding viewDataBinding) {
        super(viewDataBinding.getRoot());
        this.viewDataBinding = viewDataBinding;
    }

    public void bind(Object data) {
        viewDataBinding.setVariable(BR.user, data);
        new android.os.Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                viewDataBinding.executePendingBindings();
            }
        });
    }
}
