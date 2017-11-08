package xplore.arch.android.actv;

import android.arch.lifecycle.ViewModelProviders;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Chronometer;

import arch.xplore.viewmodelarchitecture.R;
import xplore.arch.android.viewmodels.ChronometerViewModel;

public class SampleChronometer1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_chronometer1);
        Chronometer chronometer = findViewById(R.id.chrono1);
        ChronometerViewModel chronometerViewModel = ViewModelProviders
                .of(this)
                .get(ChronometerViewModel.class);
        if(chronometerViewModel.getTime() == null) {
            long s = SystemClock.elapsedRealtime();
            chronometerViewModel.setTime(s);
            chronometer.setBase(s);
        }
        else {
            chronometer.setBase(chronometerViewModel.getTime());
        }
        chronometer.start();
    }
}
