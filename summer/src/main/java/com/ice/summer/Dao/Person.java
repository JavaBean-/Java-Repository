package com.ice.summer.Dao;

public class Person {

    private int id;

    private String username;

    private String password;

    private String created;

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getCreated() {
        return created;
    }

    public String getDescription() {
        return description;
    }

    private String description;


}
