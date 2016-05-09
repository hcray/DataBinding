package com.daoliuhe.demo.databinding.bean;

import org.json.JSONException;

import java.io.Serializable;
import java.lang.reflect.Type;

/**
 * Created by 21829 on 2016/4/7.
 */
public class User {
    private String firstName;

    private String lastName;

    private boolean show;

    private String displayName;

    private String address;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
