package com.gimba.xaberchords;

import android.app.Application;
import android.graphics.Bitmap;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class app extends Application {
    private static Retrofit retrofit = null;
    private static String baseUrl ="http://ilyaxabibullin.xyz/";

    public static Bitmap getImage() {
        return image;
    }

    static Bitmap image = null;
    public static void setImage(Bitmap bitmap){
        image = bitmap;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }
    public static Retrofit getChordApi(){return retrofit;}
}
