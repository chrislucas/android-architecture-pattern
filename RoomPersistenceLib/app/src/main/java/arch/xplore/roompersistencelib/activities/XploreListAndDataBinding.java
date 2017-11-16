package arch.xplore.roompersistencelib.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.lang.ref.WeakReference;

import arch.xplore.roompersistencelib.R;
import arch.xplore.roompersistencelib.utils.MyDatabaseBuilder;

public class XploreListAndDataBinding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xplore_list_and_data_binding);
        WeakReference<Context> weakReference = new WeakReference<Context>(this);
        MyDatabaseBuilder myDatabaseBuilder = MyDatabaseBuilder.getInstance(weakReference);
        boolean hasUser = myDatabaseBuilder.getDatabaseApp().userDao().hasUsers();
        Log.i("TABLE_USERS_HAS_USERS", String.valueOf(hasUser));
    }
}
