package com.taskmanager.viewModels.accountVM;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AccountRegisterVM {
    private int id;

    @NotEmpty(message = "Username is required.")
    @Size(min = 2, max = 50, message = "Username should contains between 2 and 50 characters.")
    @Pattern(regexp = "^([A-z-_.0-9])+$", message = "Username should not consist any special chars.")
    private String username;

    @NotEmpty(message = "Password is required.")
    @Size(min = 2, max = 50, message = "Password should contains between 2 and 50 characters.")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
