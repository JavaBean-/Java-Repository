package com.ice.summer.Dao;

import java.io.Serializable;

public class User implements Serializable {

    private String address;

    private String userName;

    private String passWord;

    private Long id;

    private String name;

    public User(String s, String aa, String aa123456, String aa1, String s1) {
    }

    public User() {
    }

    public String getPassWord() {
        return passWord;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setId(long i) {
        this.id = i ;
    }

    public void setName(String s) {
        this.name = s ;
    }

    public void setAddress(String s) {
        this.address = s ;
    }
}
