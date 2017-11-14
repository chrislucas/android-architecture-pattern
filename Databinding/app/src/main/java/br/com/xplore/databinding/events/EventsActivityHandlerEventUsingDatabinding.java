package br.com.xplore.databinding.events;

/**
 * Created by r028367 on 14/11/2017.
 */

public interface EventsActivityHandlerEventUsingDatabinding<Data> {

    interface Presenter<Data> {
        void onPassData(Data data);
    }

    interface Actor<Data> {
        void passData(Data data);
    }
}
