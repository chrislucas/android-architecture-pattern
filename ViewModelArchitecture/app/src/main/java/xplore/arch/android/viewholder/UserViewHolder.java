package xplore.arch.android.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import arch.xplore.viewmodelarchitecture.R;

/**
 * Created by r028367 on 08/11/2017.
 */

public class UserViewHolder extends RecyclerView.ViewHolder {

    private TextView id, register;

    public UserViewHolder(View itemView) {
        super(itemView);
        id = itemView.findViewById(R.id.id_user);
        register = itemView.findViewById(R.id.register_user);
    }

    public TextView getId() {
        return id;
    }

    public TextView getRegister() {
        return register;
    }
}
