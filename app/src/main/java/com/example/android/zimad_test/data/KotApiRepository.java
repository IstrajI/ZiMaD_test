package com.example.android.zimad_test.data;

import com.example.android.zimad_test.data.entities.Response;


import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class KotApiRepository {
    private KotApi kotApi;
    private static KotApiRepository kotApiRepository;

    public static KotApiRepository getInstance() {
        if (kotApiRepository == null) {
            kotApiRepository = new KotApiRepository();
        }

        return kotApiRepository;
    }

    private KotApiRepository() {
        final String baseUrl = "https://kot3.com/xim/";

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        final OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .addInterceptor(loggingInterceptor)
                .build();

        kotApi = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(KotApi.class);
    }

    public Observable<Response> getCatPosts() {
        return kotApi.getPetPosts("cat");
    }

    public Observable<Response> getDogPosts() {
        return kotApi.getPetPosts("dog");
    }
}
