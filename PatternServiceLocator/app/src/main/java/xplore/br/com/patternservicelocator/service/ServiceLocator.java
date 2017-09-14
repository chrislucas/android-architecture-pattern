package xplore.br.com.patternservicelocator.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by r028367 on 14/09/2017.
 */

public class ServiceLocator {

    private Map<String, ServiceApp> services;

    public ServiceLocator() {
        services = new HashMap<>();
        services.put(ServiceMusic.SERVICE_NAME,  new ServiceMusic());
        services.put(ServiceContact.SERVICE_NAME, new ServiceContact());
    }

    public ServiceApp getService(String name) {
        return services.get(name).getService();
    }

}
