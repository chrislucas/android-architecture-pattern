package xplore.arch.android.lifecycleobserver;

import android.arch.lifecycle.LifecycleObserver;
import android.content.Context;
import android.location.LocationListener;

/**
 * Created by r028367 on 09/11/2017.
 */

public class BoundLocationListener {
    public static LifecycleObserver bindLocationListener(LocationListener locationListener
            , Context context) {
        return new LifecycleObserverLocationListener(context, locationListener);
    }
}
