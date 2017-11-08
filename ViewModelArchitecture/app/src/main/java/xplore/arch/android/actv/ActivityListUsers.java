package xplore.arch.android.actv;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Calendar;
import java.util.List;

import arch.xplore.viewmodelarchitecture.R;
import xplore.arch.android.models.User;
import xplore.arch.android.viewholder.adapter.UserAdapter;
import xplore.arch.android.viewmodels.ViewModelListUsers;

public class ActivityListUsers extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);
        recyclerView    = findViewById(R.id.list_user);
        layoutManager   = new LinearLayoutManager(this
                , LinearLayoutManager.VERTICAL, true);
        final ViewModelListUsers viewModelListUsers = ViewModelProviders
                .of(this)
                .get(ViewModelListUsers.class);

        viewModelListUsers
                .getUsers()
                .observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable final List<User> users) {
                /**
                 * Se precisar fazer alguma atualizacao ela sera aqui
                 **/
                adapter = new UserAdapter(users);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);

            }
        });
        final User user = viewModelListUsers
                .getUsers()
                .getValue()
                .get(0);
        // Clock
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                new Handler().postDelayed(this, 1000);
                user.setId(Calendar.getInstance().get(Calendar.SECOND));
                //Log.i("Loop", String.valueOf(Calendar.getInstance().getTime()));
            }
        }, 1000);
    }
}
