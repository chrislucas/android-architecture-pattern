package xplore.arch.android.lifecycleobserver;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by r028367 on 09/11/2017.
 */

public class ImplLocationListener implements LocationListener {

    private DelegateUpdateInfo<Location> delegateUpdateInfo;

    public ImplLocationListener(DelegateUpdateInfo<Location> delegateUpdateInfo) {
        this.delegateUpdateInfo = delegateUpdateInfo;
    }

    @Override
    public void onLocationChanged(Location location) {
        this.delegateUpdateInfo.publish(location);
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {
        Log.i("PROVIDER_ENABLED", s);
    }

    @Override
    public void onProviderDisabled(String s) {
        Log.i("PROVIDER_DISABLED", s);
    }
}
