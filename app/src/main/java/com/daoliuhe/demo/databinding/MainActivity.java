package com.daoliuhe.demo.databinding;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.daoliuhe.demo.databinding.bean.User;
import com.daoliuhe.demo.databinding.databinding.ActivityMainBinding;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        User user = new User("test", "user");
        user.setShow(true);
        user.setDisplayName("tom");
        binding.setUser(user);
    }
}
