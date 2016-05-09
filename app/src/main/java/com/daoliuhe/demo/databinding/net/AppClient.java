package com.daoliuhe.demo.databinding.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by 21829 on 2016/5/4.
 */
public class AppClient {
    static final int CONNECT_TIMEOUT_MILLIS = 30* 1000; // 15s
    static final int READ_TIMEOUT_MILLIS = 30 * 1000; // 20s
    private UserService service;

    public static OkHttpClient getOkClient() {
        OkHttpClient client = new OkHttpClient();
        //client.setConnectTimeout(CONNECT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
        //client.setReadTimeout(READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
        return client;
    }

    public AppClient() {
        ////http://10.1.0.152:8280/plm/user?number=21829;26078
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.1.0.152:8280/")
                //.addConverterFactory(GsonConverterFactory.create())
                //.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(getOkClient())
                .build();

        service = retrofit.create(UserService.class);
    }

    public UserService getService() {
        return service;
    }
}
