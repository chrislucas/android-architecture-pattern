package xplore.arch.android.lifecycleobserver;

import android.Manifest;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by r028367 on 09/11/2017.
 */

public class LifecycleObserverLocationListener implements LifecycleObserver {

    private Context context;
    private LocationManager mLocationManager;
    private LocationListener locationListener;

    public LifecycleObserverLocationListener(Context context, LocationListener locationListener) {
        this.context = context;
        this.locationListener = locationListener;
    }
    private static final int CRITERIA_ACCURACIES[] = {
         Criteria.ACCURACY_COARSE
        ,Criteria.ACCURACY_FINE
    };

    private void set(Location location) {
        Log.i("LOCATION_MANAGER"
                , String.format(Locale.getDefault(), "Acc: %f Alt: %f Lat: %f Lon: %f"
                        , location.getAccuracy()
                        , location.getAltitude()
                        , location.getLatitude()
                        , location.getLongitude()
                ));
        locationListener.onLocationChanged(location);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public boolean setLocationManager() {
        mLocationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        boolean A = ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED;
        boolean B = ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED;
        boolean rs = false;
        if (A && B) {
            mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER
                    , 0, 0, locationListener);
            boolean gpsStatus     = mLocationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            boolean networkStatus = mLocationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
            if(gpsStatus || networkStatus) {
                Location location = mLocationManager
                        .getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if(location != null) {
                    set(location);
                    rs = true;
                }
                else {
                    Criteria criteria = new Criteria();
                    for(int c : CRITERIA_ACCURACIES) {
                        criteria.setAccuracy(c);
                        String bestProvider = mLocationManager.getBestProvider(criteria, true);
                        location = mLocationManager.getLastKnownLocation(bestProvider);
                        if(location != null) {
                            set(location);
                            rs = true;
                            break;
                        }
                    }
                }
            }
        }
        else {
            Log.e("ATTEMPT_TO_FIND_LOC", "ERROR");
        }
        // TODO: Consider calling
        //    ActivityCompat#requestPermissions
        // here to request the missing permissions, and then overriding
        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
        //                                          int[] grantResults)
        // to handle the case where the user grants the permission. See the documentation
        // for ActivityCompat#requestPermissions for more details.
        return rs;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void unSetLocationManager() {
        if(mLocationManager != null) {
            mLocationManager.removeUpdates(locationListener);
            mLocationManager = null;
            Toast.makeText(context
                    , "Location Manager desabilitado", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Location Manager não foi definido", Toast.LENGTH_SHORT)
                    .show();
        }
    }
}
