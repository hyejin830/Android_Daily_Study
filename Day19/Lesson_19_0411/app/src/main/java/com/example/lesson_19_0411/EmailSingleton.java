package com.example.lesson_19_0411;

public class EmailSingleton { // 디자인 패턴

    private static final EmailSingleton instance = new EmailSingleton();
    private String data;

    private EmailSingleton() {

    }

    public static EmailSingleton getInstance() {
        return instance;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
