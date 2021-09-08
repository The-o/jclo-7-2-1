package ru.netology.model;

import javax.validation.constraints.NotBlank;

import org.springframework.validation.annotation.Validated;

@Validated
public class User {

    @NotBlank
    private String login;

    @NotBlank
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
