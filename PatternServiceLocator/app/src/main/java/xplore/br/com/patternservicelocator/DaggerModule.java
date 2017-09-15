package xplore.br.com.patternservicelocator;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by r028367 on 15/09/2017.
 *
 * Sobre Dagger https://google.github.io/dagger/
 *
 *
 * Annotations
 *
 * @Module
 * Anotacao usada em classes. Transforma uma classe
 * num modulo dagger
 *
 * @Singleton
 *
 * Cria uma instancia unica de um objeto para aplicacao
 * inteira. Famoso padrão singleton
 *
 * @Provides
 *
 * Anotacao usada em metodo. Define que tal metodo
 * retorna uma instancia de uma dependencia
 *
 *
 */

@Module
public class DaggerModule {

    private Context context;

    public DaggerModule(Application application) {
        this.context = application;
    }

    /**
     * A anotacao provides tem um funcionamento interessante
     * A anotacao e usada em metodos cujo nome é uma juncao
     * do nome dado anotacao (Provides) e o nome da classe
     * cujo metodo pretende prover uma instancia
     *
     * Exemplo: Metodo que prove uma instância de Context
     *
     * #providesContext
     * */

    @Provides
    public Context providesContext() {
        return context;
    }

    @Provides
    /**
     * A anotacao 'Named' serve para marcar um metodo
     * que foi anotado como 'Provider'
     * */
    @Named("DaggerModule.UserMobile")
    public String providesSharePrefValue() {
        return "";
    }

    @Provides
    @Singleton
    public SharedPreferences providesSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }





}
