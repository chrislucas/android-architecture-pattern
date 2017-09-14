package xplore.br.com.patternservicelocator.service;

/**
 * Created by r028367 on 14/09/2017.
 */

public class ServiceMusic implements ServiceApp {

    public static final String SERVICE_NAME = "MUSIC_SERVICE";

    public class Music {
        private String name;
        private byte [] buffer;
    }

    private Music music;
    private String serviceName;

    public ServiceMusic() {
        this.serviceName = SERVICE_NAME;
    }

    public Music getMusic() {
        return this.music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    @Override
    public String getServiceName() {
        return SERVICE_NAME;
    }

    @Override
    public ServiceMusic getService() {
        return this;
    }
}
