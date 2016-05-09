package com.daoliuhe.demo.databinding;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.daoliuhe.demo.databinding.bean.User;
import com.daoliuhe.demo.databinding.databinding.ActivityMainBinding;

public class MainActivity extends Activity {
    private  ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        User user = new User("test", "user");
        user.setShow(false);
        user.setDisplayName("tom");
        user.setAddress("杭州市");
        binding.setUser(user);

        //String address = etAddress.getText().toString();

    }

    public void onClickbt(View view){
        Toast.makeText(MainActivity.this, binding.etAddress.getText(), Toast.LENGTH_SHORT).show();
    }

    public void userSearch(View view){
        startActivity(new Intent(this,UserListActivity.class));
    }

//    View.OnClickListener onClickbt = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            Toast.makeText(MainActivity.this, binding.etAddress.getText(), Toast.LENGTH_SHORT).show();
//        }
//    };
}
