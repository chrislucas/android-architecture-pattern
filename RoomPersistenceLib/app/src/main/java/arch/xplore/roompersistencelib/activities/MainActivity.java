package arch.xplore.roompersistencelib.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import arch.xplore.roompersistencelib.R;
import arch.xplore.roompersistencelib.fragments.InsertUser;
import arch.xplore.roompersistencelib.fragments.ListUsers;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FragmentManager fm;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        Fragment fragment =  null;
        switch (v.getId()) {
            case R.id.insert_button:
                fragment = InsertUser.newInstance();
                break;
            case R.id.select_users_button:
                fragment = ListUsers.newInstance();
                break;
        }
        if(fragment != null) {
            fm = getSupportFragmentManager();
            //FragmentManager.BackStackEntry backStackEntry = fm.getBackStackEntryAt(fm.getBackStackEntryCount());
            //backStackEntry.
            //fm.getFragments().get(fm.getBackStackEntryCount());

            ft = fm.beginTransaction();
            ft.replace(R.id.canvas, fragment);
            ft.commit();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
