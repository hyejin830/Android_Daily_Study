package com.example.final_project.Model;

public class MessageModel {
    private String userName;
    private String message;

    public MessageModel(String userName, String message) {
        this.userName = userName;
        this.message = message;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserName() {
        return userName;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "MessageModel{" +
                "userName='" + userName + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
