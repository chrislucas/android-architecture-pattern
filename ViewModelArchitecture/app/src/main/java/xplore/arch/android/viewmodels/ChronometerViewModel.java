package xplore.arch.android.viewmodels;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;

/**
 * Created by r028367 on 08/11/2017.
 */

public class ChronometerViewModel extends ViewModel {

    @Nullable
    private Long time;

    @Nullable
    public Long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
