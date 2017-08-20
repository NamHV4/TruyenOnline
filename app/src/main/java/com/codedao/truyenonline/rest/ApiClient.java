package com.codedao.truyenonline.rest;

import android.util.Log;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.util.concurrent.TimeUnit;

import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by utnam on 8/20/2017.
 */

public class ApiClient {
    public static final String BASE_URL = "https://damha.us/nam/ebook_server/";
    public static final String TAG = "tag";
    private static Retrofit retrofit = null;
    static HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
        @Override
        public void log(String message) {
            Log.e(TAG, "\n" + message);
        }
    });

    public static Retrofit getClient() {
        if (retrofit==null) {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            CookieHandler cookieHandler = new CookieManager();
            OkHttpClient client = new OkHttpClient.Builder().addNetworkInterceptor(logging)
                    .cookieJar(new JavaNetCookieJar(cookieHandler))
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .build();
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
