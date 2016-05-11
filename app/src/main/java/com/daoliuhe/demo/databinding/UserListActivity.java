package com.daoliuhe.demo.databinding;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.daoliuhe.demo.databinding.bean.UserInfo;
import com.daoliuhe.demo.databinding.databinding.ActivityUserListBinding;
import com.daoliuhe.demo.databinding.net.AppClient;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class UserListActivity extends RxAppCompatActivity {
    private  static final String TAG = "UserListActivity";

    private ActivityUserListBinding binding;

    private List<UserInfo> list = new ArrayList<UserInfo>();
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_list);

        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

     /*  for (int i = 0; i < 10; i++) {
            UserInfo user = new UserInfo();
            user.setName("name" + i);
            user.setNumber("1000" + i);
            list.add(user);
        }*/
        userAdapter = new UserAdapter(list);
        binding.recyclerView.setAdapter(userAdapter);
    }


    public void userSearch(View view) {
        new AppClient().getService().listUsers(binding.searchEditText.getText().toString())
                .compose(this.<List<UserInfo>>bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    Observer<List<UserInfo>> observer = new Observer<List<UserInfo>>(){

        @Override
        public void onCompleted() {
            Log.d(TAG, "onCompleted: ");
        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, "onError: " + e.getLocalizedMessage());
        }

        @Override
        public void onNext(List<UserInfo> userInfos) {
            list.clear();
            if (userInfos.isEmpty()) {
                Toast.makeText(UserListActivity.this,"没有查询到结果",Toast.LENGTH_SHORT).show();
            } else {
                list.addAll(userInfos);
            }
            userAdapter.notifyDataSetChanged();
        }
    };
}
