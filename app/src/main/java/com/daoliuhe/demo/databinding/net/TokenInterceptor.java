package com.daoliuhe.demo.databinding.net;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 21829 on 2016/5/9.
 */
public class TokenInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder().addHeader("username", "cG9ydGFs").addHeader("password", "cG9ydGFsQGFnaWxlMjAxNDA5Mjk=").build();
        //request.header("username: cG9ydGFs");
        //request.header("password: cG9ydGFsQGFnaWxlMjAxNDA5Mjk=");
        //@HEAD("username: cG9ydGFs\npassword: cG9ydGFsQGFnaWxlMjAxNDA5Mjk=")

        return chain.proceed(request);
    }
}
