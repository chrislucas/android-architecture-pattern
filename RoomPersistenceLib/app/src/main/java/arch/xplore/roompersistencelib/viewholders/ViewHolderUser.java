package arch.xplore.roompersistencelib.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import arch.xplore.roompersistencelib.R;
import arch.xplore.roompersistencelib.models.User;

/**
 * Created by r028367 on 10/11/2017.
 */

public class ViewHolderUser extends RecyclerView.ViewHolder {

    private TextView userId, userRegister, userName, typeUser;

    public ViewHolderUser(View itemView) {
        super(itemView);
        userId = itemView.findViewById(R.id.user_id);
        userRegister = itemView.findViewById(R.id.user_register);
        userName = itemView.findViewById(R.id.user_name);
        typeUser = itemView.findViewById(R.id.type_user);
    }

    public TextView getUserId() {
        return userId;
    }

    public void setUserId(TextView userId) {
        this.userId = userId;
    }

    public TextView getUserRegister() {
        return userRegister;
    }

    public void setUserRegister(TextView userRegister) {
        this.userRegister = userRegister;
    }

    public TextView getUserName() {
        return userName;
    }

    public void setUserName(TextView userName) {
        this.userName = userName;
    }

    public TextView getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(TextView typeUser) {
        this.typeUser = typeUser;
    }
}
