package com.daoliuhe.demo.databinding.net;

import com.daoliuhe.demo.databinding.bean.UserInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by 21829 on 2016/5/4.
 */
public interface UserService {
    //http://10.1.0.152:8280/plm/user?number=21829;26078
    @GET("plm/user")
    //@HEAD("username: cG9ydGFs\npassword: cG9ydGFsQGFnaWxlMjAxNDA5Mjk=")
    //@HEAD( "password: cG9ydGFsQGFnaWxlMjAxNDA5Mjk=")
    Observable<List<UserInfo>> listUsers(@Query("number") String number);
}
