package br.com.xplore.databinding.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import br.com.xplore.databinding.R;
import br.com.xplore.databinding.adapter.holder.ViewHolderUserGithub;
import br.com.xplore.databinding.model.User;

/**
 * Created by r028367 on 13/11/2017.
 */

public class AdapterUserGithub extends RecyclerView.Adapter<ViewHolderUserGithub> {

    private List<User> users;

    public AdapterUserGithub(List<User> users) {
        this.users = users;
    }

    @Override
    public ViewHolderUserGithub onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(layoutInflater
                , R.layout.layout_adapter_user_github, parent, false);
        /**
         * Instanciando o meu ViewHolder
         * */
        return new ViewHolderUserGithub(viewDataBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolderUserGithub holder, int position) {
        // usando o viewholder vinculado a esse adapter
        User user = users.get(position);
        holder.bind(user);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
