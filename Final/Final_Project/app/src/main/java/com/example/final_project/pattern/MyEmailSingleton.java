package com.example.final_project.pattern;

public class MyEmailSingleton {

    private static final MyEmailSingleton instance = new MyEmailSingleton();
    private String myEmail;

    public String getMyEmail() {
        return myEmail;
    }

    public void setMyEmail(String myEmail) {
        this.myEmail = myEmail;
    }

    private MyEmailSingleton() {
    }

    public static MyEmailSingleton getInstance() {
        return instance;
    }
}
