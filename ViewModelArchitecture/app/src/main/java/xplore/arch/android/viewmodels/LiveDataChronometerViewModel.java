package xplore.arch.android.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by r028367 on 08/11/2017.
 */

public class LiveDataChronometerViewModel extends ViewModel {
    private static final int DELAY_MS = 1000;
    // Wrap Data
    private MutableLiveData<Long> mElapsedTime = new MutableLiveData<>();
    private long mInitialTime;
    public LiveDataChronometerViewModel() {
        mInitialTime = SystemClock.elapsedRealtime();
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                final long newValue = (SystemClock.elapsedRealtime() - mInitialTime) / 1000;
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        mElapsedTime.setValue(newValue);
                    }
                });
            }
        };
        timer.scheduleAtFixedRate(timerTask, DELAY_MS, DELAY_MS);
    }

    /**
     * Retorna o dado encapsulado
     * */
    public LiveData<Long> getElapsedTime() {
        return mElapsedTime;
    }
}
