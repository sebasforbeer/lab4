package com.example.lab42.model;

public class Add_comment_json {

    private String login;
    private String comment;

    public Add_comment_json(String login, String comment) {
        this.login = login;
        this.comment = comment;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
