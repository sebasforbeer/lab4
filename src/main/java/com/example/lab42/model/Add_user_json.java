package com.example.lab42.model;

public class Add_user_json {
    private String login;

    public Add_user_json(String login) {
        this.login = login;
    }

    public Add_user_json() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
