package com.loop.entity;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = -2944228894066998120L;
    private String id;
    private String name;
    private String password;
    private String token;
    private String nick;

    public User() {
    }

    public User(String id, String name, String password, String token, String nick) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.token = token;
        this.nick = nick;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                ", nick='" + nick + '\'' +
                '}';
    }
}






