package lab.xplore.timerandtimertask;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;


/**
 * Created by r028367 on 09/11/2017.
 */

public class LiveDataClock extends ViewModel{

    private MutableLiveData<Long> mElapsedTime;

    public LiveDataClock() {
        mElapsedTime = new MutableLiveData<>();
    }

    public void startClock() {
        Handler start = new Handler();
        final Handler clock = new Handler();
        start.post(new Runnable() {
            @Override
            public void run() {
                long currentTime = System.currentTimeMillis();
                mElapsedTime.setValue(currentTime);
                clock.postDelayed(this, 1000);
            }
        });
    }

    public LiveData<Long> getTimer() {
        return mElapsedTime;
    }

}
