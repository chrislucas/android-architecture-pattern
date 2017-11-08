package xplore.arch.android.viewholder.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import arch.xplore.viewmodelarchitecture.R;
import xplore.arch.android.models.User;
import xplore.arch.android.viewholder.UserViewHolder;

/**
 * Created by r028367 on 08/11/2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private List<User> users;

    public UserAdapter(List<User> users) {
        this.users = users;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.adapter_user, parent, false);
        return new UserViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User user = users.get(position);
        holder.getId().setText(String.valueOf(user.getId()));
        holder.getRegister().setText(user.getRegister());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
