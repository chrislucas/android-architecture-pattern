package xplore.arch.android.actv;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

import arch.xplore.viewmodelarchitecture.R;
import xplore.arch.android.lifecycleobserver.BoundLocationListener;
import xplore.arch.android.lifecycleobserver.DelegateUpdateInfo;
import xplore.arch.android.lifecycleobserver.ImplLocationListener;
import xplore.arch.android.lifecycleobserver.LifecycleObserverLocationListener;

public class SampleLocationActivity extends AppCompatActivity implements DelegateUpdateInfo<Location> {

    private static final int REQUEST_CODE_PERMISSION = 0x33;
    private LifecycleObserverLocationListener lifecycleObserver;
    private TextView textViewLocation;
    private LocationListener locationListener;

    @Override
    public void publish(Location location) {
        textViewLocation.setText(String.format(Locale.getDefault(), "%f %f"
                , location.getLatitude(), location.getLatitude()));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions
            , @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if( permissions.length > 0 && requestCode == REQUEST_CODE_PERMISSION) {
            boolean allPermissionsGranted = true;
            for(int i : grantResults) {
                if(i == PackageManager.PERMISSION_DENIED) {
                    allPermissionsGranted = false;
                    break;
                }
            }
            if(allPermissionsGranted) {
                initializeLifeCycleObserver();
            }
        }
    }

    private void checkPermissions() {
        String permissions [] = {
             Manifest.permission.ACCESS_FINE_LOCATION
            ,Manifest.permission.ACCESS_COARSE_LOCATION
            ,Manifest.permission.INTERNET
        };
        ArrayList<String> permissionsThatIShoulddAsk = new ArrayList<>();
        //for(String permission : permissions)
            //if(ActivityCompat.shouldShowRequestPermissionRationale(this, permission))
        permissionsThatIShoulddAsk.addAll(Arrays.asList(permissions));
        if(permissionsThatIShoulddAsk.size() > 0) {
            permissions = new String[permissionsThatIShoulddAsk.size()];
            permissions = permissionsThatIShoulddAsk.toArray(permissions);
            ActivityCompat.requestPermissions(this, permissions, REQUEST_CODE_PERMISSION);
        }
        else {
            initializeLifeCycleObserver();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_location);
        textViewLocation = findViewById(R.id.id_location);
        locationListener = new ImplLocationListener(this);
        checkPermissions();
    }

    private void initializeLifeCycleObserver() {
        lifecycleObserver = (LifecycleObserverLocationListener) BoundLocationListener.bindLocationListener(locationListener, this);
        final Handler manager = new Handler();
        final Handler task = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(lifecycleObserver.setLocationManager() ) {
                    manager.removeCallbacks(this);
                }
                else {
                    Log.e("FIND_LOCATION", "FALHA");
                    String message = "Não foi possível encontrar a sua localização ainda.\nO App tentará em 15s";
                    CharSequence s = textViewLocation.getText();
                    if(s.length() == 0 || ! s.equals(message)) {
                        textViewLocation.setText(message);
                        textViewLocation.setTextColor(ContextCompat.getColor(getApplicationContext()
                                , R.color.colorAccent));
                    }
                    task.postDelayed(this, 15000);
                }
            }
        };
        manager.post(runnable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //lifecycleObserver.unSetLocationManager();
    }
}
