package com.example.final_project.Model;

public class UserModel {

    private String userName;
    private String userEmail;

    public UserModel(String userName, String userEmail) {
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }
}