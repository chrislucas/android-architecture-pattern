package br.com.xplore.databinding.http;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by r028367 on 13/11/2017.
 */

public class RetrofitServiceGenerator {
    private static OkHttpClient.Builder builderHttpClient;
    private static OkHttpClient httpClient;
    private static Retrofit retrofit;
    private static Retrofit.Builder builderRetrofit;

    public static <Clazz> Clazz getService(Class<Clazz> clazz, String baseUrl) {
        retrofit = getRetrofitInstance(baseUrl);
        Clazz c = retrofit.create(clazz);
        return c;
    }

    private static <Clazz extends Class> Retrofit getRetrofitInstance(String url) {
        builderHttpClient   = new OkHttpClient.Builder();
        httpClient          = builderHttpClient.build();
        builderRetrofit     = new Retrofit
                .Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit instance = builderRetrofit.client(httpClient).build();
        return instance;
    }
}
