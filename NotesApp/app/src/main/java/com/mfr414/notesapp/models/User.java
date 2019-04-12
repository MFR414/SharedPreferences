package com.mfr414.notesapp.models;

public class User {
    String username;
    String password;
    int layout;

    public User(String user, String pass,int lay) {
        this.username = user;
        this.password = pass;
        this.layout = lay;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLayout() { return layout;}

    public void setLayout(int layout) { this.layout = layout; }
}
