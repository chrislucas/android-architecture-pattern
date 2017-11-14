package br.com.xplore.databinding.events;

/**
 * Created by r028367 on 14/11/2017.
 */

public class ImplEventsActivityHandlerEventUsingDatabinding
        implements EventsActivityHandlerEventUsingDatabinding.Presenter<String> {


    private EventsActivityHandlerEventUsingDatabinding.Actor<String> actor;

    public ImplEventsActivityHandlerEventUsingDatabinding(EventsActivityHandlerEventUsingDatabinding.Actor actor) {
        this.actor = actor;
    }

    @Override
    public void onPassData(String s) {
        this.actor.passData(s);
    }
}
