package xplore.arch.android.actv;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import arch.xplore.viewmodelarchitecture.R;
import xplore.arch.android.viewmodels.LiveDataChronometerViewModel;

public class SampleChronometer2 extends AppCompatActivity {

    private LiveDataChronometerViewModel liveDataChronometerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_chronometer2);
        liveDataChronometerViewModel = ViewModelProviders
                .of(this)
                .get(LiveDataChronometerViewModel.class);

        /**
         * Temos um observador na activity que verifica quando um valor do tipo
         * long muda. Nesse exemplo esse observador fica observando o timer da
         *
         * */
        final Observer<Long> observer = new Observer<Long>() {
            @Override
            public void onChanged(@Nullable Long timer) {
                ((TextView) findViewById(R.id.text_timer))
                        .setText(String.format(Locale.getDefault(), "%d", timer));
                Log.i("OBSERVABLE_DATA", "UPDATE");
            }
        };
        liveDataChronometerViewModel.getElapsedTime().observe(this, observer);
    }
}
