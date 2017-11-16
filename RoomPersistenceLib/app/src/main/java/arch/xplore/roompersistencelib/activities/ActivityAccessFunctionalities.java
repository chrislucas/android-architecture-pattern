package arch.xplore.roompersistencelib.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.lang.ref.WeakReference;

import arch.xplore.roompersistencelib.R;
import arch.xplore.roompersistencelib.utils.MyDatabaseBuilder;

public class ActivityAccessFunctionalities extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access_functionalities);
    }
}
