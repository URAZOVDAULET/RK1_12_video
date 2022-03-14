package com.example.demo2;

public class User {
    private String name;
    private String surname;
    private String login;
    private String pass;
    private String gender;

    public User(String name, String surname, String login, String pass, String gender) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.pass = pass;
        this.gender = gender;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
