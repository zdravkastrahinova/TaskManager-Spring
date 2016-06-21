package com.taskmanager.services;

import com.taskmanager.models.User;

public class AuthenticationService {
    private static User LoggedUser;

    public static User getLoggedUser() {
        return LoggedUser;
    }

    public static void setLoggedUser(User loggedUser) {
        LoggedUser = loggedUser;
    }

    public static void logout() {
        setLoggedUser(null);
    }
}