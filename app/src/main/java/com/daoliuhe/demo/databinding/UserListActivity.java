package com.daoliuhe.demo.databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.daoliuhe.demo.databinding.databinding.ActivityUserListBinding;

public class UserListActivity extends AppCompatActivity {

    private ActivityUserListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_list);
    }
}
