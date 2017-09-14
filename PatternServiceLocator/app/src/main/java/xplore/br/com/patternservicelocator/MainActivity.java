package xplore.br.com.patternservicelocator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Locale;

import xplore.br.com.patternservicelocator.service.ServiceApp;
import xplore.br.com.patternservicelocator.service.ServiceContact;
import xplore.br.com.patternservicelocator.service.ServiceLocator;
import xplore.br.com.patternservicelocator.service.ServiceMusic;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ServiceLocator serviceLocator = new ServiceLocator();
        //
        //ServiceApp<ServiceMusic> service1 = serviceLocator.getService(ServiceContact.SERVICE_NAME);
        //Toast.makeText(this, service1.getServiceName(), Toast.LENGTH_LONG).show();

        // situacao bizarra que compila
        // ServiceApp<ServiceContact> service2 = serviceLocator.getService(ServiceMusic.SERVICE_NAME);
        // na linha de codigo temos uma instancia de ServiceMusic mesmo usando essa sintaxe de generics
        // passando ServiceContact
        // codigo mais bizarro ((ServiceContact)service2).getServiceName() // ClassCastException
        // so para efeito de teste :), DO NOT JUDGE


    }
}
