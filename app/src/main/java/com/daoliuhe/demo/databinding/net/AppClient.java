package com.daoliuhe.demo.databinding.net;

import retrofit2.Retrofit;

/**
 * Created by 21829 on 2016/5/4.
 */
public class AppClient {
    private UserService service;

    public AppClient() {
        ////http://10.1.0.152:8280/plm/user?number=21829;26078
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.1.0.152:8280/")
                .build();

        service = retrofit.create(UserService.class);
    }

    public UserService getService() {
        return service;
    }
}
