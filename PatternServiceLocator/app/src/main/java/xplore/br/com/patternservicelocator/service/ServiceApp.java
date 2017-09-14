package xplore.br.com.patternservicelocator.service;

/**
 * Created by r028367 on 14/09/2017.
 */

public interface ServiceApp <T> {
    String getServiceName();
    <T extends ServiceApp> T getService();
}
