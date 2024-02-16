package com.example.web_assign_1.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    private int user_id;
    private String userName;
    private String email;
    private String hashpass;

    public User() {
    }

    public User(int user_id, String userName, String email, String hashpass) {
        this.user_id = user_id;
        this.userName = userName;
        this.email = email;
        this.hashpass = hashpass;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashpass() {
        return hashpass;
    }

    public void setHashpass(String hashpass) {
        this.hashpass = hashpass;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
