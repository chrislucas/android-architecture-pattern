package arch.xplore.roompersistencelib.viewholders.recycleviewadapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.Locale;

import arch.xplore.roompersistencelib.R;
import arch.xplore.roompersistencelib.enums.TypeUser;
import arch.xplore.roompersistencelib.models.User;
import arch.xplore.roompersistencelib.viewholders.ViewHolderUser;

/**
 * Created by r028367 on 10/11/2017.
 */

public class RecycleViewAdapterUser extends RecyclerView.Adapter<ViewHolderUser> {

    private List<User> users;

    public RecycleViewAdapterUser(List<User> users) {
        this.users = users;
    }

    @Override
    public ViewHolderUser onCreateViewHolder(ViewGroup parent, int viewType) {
        /**
         * Carregar o layout criado para cada item da lista de usuario
         * */
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_recycleview_adapter_user
                , parent
                , false);
        return new ViewHolderUser(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderUser holder, int position) {
        User user = users.get(position);
        holder.getUserId().setText(String.valueOf(user.getId()));
        holder.getUserRegister().setText(user.getRegister());
        holder.getUserName().setText(user.getName());
        String description = user.getTypeUser().toString();
        holder.getTypeUser().setText(description);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "%d usuários", users.size());
    }
}
