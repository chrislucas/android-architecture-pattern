package xplore.br.com.patternservicelocator.service;

/**
 * Created by r028367 on 14/09/2017.
 */

public class ServiceContact implements ServiceApp {

    public static final String SERVICE_NAME = "CONTACT_SERVICE";

    private String serviceName;

    public ServiceContact() {
        this.serviceName = "SERVICE_NAME";
    }

    @Override
    public String getServiceName() {
        return SERVICE_NAME;
    }

    @Override
    public ServiceContact getService() {
        return this;
    }
}
