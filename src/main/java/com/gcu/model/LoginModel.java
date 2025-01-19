package com.gcu.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginModel {
    @NotNull(message="User name is a required field")
    @Size(min=1, max=32, message = "user name must be between 1 and 32 Characters")
    private String username;
    @NotNull(message="Password is a required field")
    @Size(min=1, max=32, message = "Password must be between 1 and 32 Characters")
    private String password;
    //default constructor
    public LoginModel() {}
    //parameterized constructor
    public LoginModel(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
    //getter for username
    public String getUsername()
    {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
}
