package lab.xplore.timerandtimertask;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    private TextView clockTextView;
    private SimpleDateFormat simpleDateFormat
            = new SimpleDateFormat("dd/MMM/YYYY HH:mm:ss", Locale.getDefault());

    private Timer timer;
    private Handler clock;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clockTextView  = findViewById(R.id.id_clock);
        //updateClockWithLiveData();
        directlyUpdateClockWithTimeAndTimerTask();
    }

    private void updateClockWithLiveData() {
        LiveDataClock liveDataClock = ViewModelProviders
                .of(this)
                .get(LiveDataClock.class);

        liveDataClock.startClock();

        final Observer<Long> observerClock = new Observer<Long>() {
            @Override
            public void onChanged(@Nullable Long aLong) {
                clockTextView
                        .setText(simpleDateFormat
                                .format(aLong));
            }
        };

        liveDataClock.getTimer().observe(this, observerClock);
    }

    /**
     * Sem o uso do livedata
     * */
    private void directlyUpdateClockWithTimeAndTimerTask() {

        /**
         * Facilita a criacao de tarefas que precisam ser executadas em background. Entretanto
         * cada tarefa é executada em uma thread unica de forma sequencial. Se o desenvolvedor
         * implementar um metodo que possui N tarefas e uma delas levar muito tempo isso prejudicara
         * o desempenho das demais tarefas.
         *
         *
         * */
        timer       = new Timer();
        clock       = new Handler();
        runnable    = new Runnable() {
            @Override
            public void run() {
                clockTextView
                        .setText(simpleDateFormat
                                .format(Calendar.getInstance().getTime()));
            }
        };
        /**
         * TimerTask vs Handler em android
         *
         *  Um ponto importante sobre TimerTask em android é que ela nao permite atualizar elementos
         *  da UI diretamente, precisamos de uma instancia de handler para fazer isso
         *
         * */
        TimerTask updateClock = new TimerTask() {
            @Override
            public void run() {
                clock.post(runnable);
            }
        };
        timer.schedule(updateClock, 1000,1000);
        /**
         *
         * schedule(TimerTask task, long delay, long period)
         *  Agenda uma tarefa para ser executada de forma repetida
         *  num certo periodo. A tarefa comeca apos o tempo estipulado
         *  no delay
         *
         * https://developer.android.com/reference/java/util/Timer.html#scheduleAtFixedRate(java.util.TimerTask, long, long)
         * scheduleAtFixedRate(TimerTask task, long delay, long period)
         *  Segundo a documentacao Fixed-rate execution é apropriada para atividades
         *  recorrentes que sao sensiveis a precisão do tempo. Fixed-rate tambem eh
         *  apropriado para agendar multiplas tarefas repetidas sequencialmente que precisam
         *  manter um sincronistmo entre si.
         * */
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(timer != null) {
            timer.cancel();
        }
        if(clock != null && runnable != null) {
           clock.removeCallbacks(runnable);
        }
    }
}
