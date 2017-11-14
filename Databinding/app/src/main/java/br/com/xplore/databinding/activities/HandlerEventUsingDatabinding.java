package br.com.xplore.databinding.activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import br.com.xplore.databinding.R;

import br.com.xplore.databinding.databinding.ActivityHandlerEventUsingDatabindingBinding;
import br.com.xplore.databinding.events.EventsActivityHandlerEventUsingDatabinding;
import br.com.xplore.databinding.events.ImplEventsActivityHandlerEventUsingDatabinding;

public class HandlerEventUsingDatabinding extends AppCompatActivity
        implements EventsActivityHandlerEventUsingDatabinding.Actor<String> {

    public static final String MESSAGE = "Uma mensagem qualquer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityHandlerEventUsingDatabindingBinding binding = DataBindingUtil.setContentView(this
                , R.layout.activity_handler_event_using_databinding);

        ImplEventsActivityHandlerEventUsingDatabinding impl
                = new ImplEventsActivityHandlerEventUsingDatabinding(this);

        binding.setImplEvents(impl);
        binding.setMessage(MESSAGE);
    }

    @Override
    public void passData(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
