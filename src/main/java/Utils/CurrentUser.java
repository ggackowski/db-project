package Utils;

import dataObjects.User;

import java.util.List;

public class CurrentUser {
    private boolean logged;
    private User loggedUser;
    private final DatabaseProvider dbProvider;

    private static CurrentUser instance;

    public static CurrentUser getInstance() {
        if(instance == null)
            instance = new CurrentUser();
        return instance;
    }

    private CurrentUser() {
        this.dbProvider = DatabaseProvider.getInstance();
        logged = false;
        loggedUser = null;
    }

    public boolean login (String email, String password) {
        if(logged)
            return false;

        User user = dbProvider.getUserByEmail(email);

        if(user == null)
            return false;

        if(!user.getPassword().equals(password))
            return false;

        this.loggedUser = user;
        this.logged = true;
        return true;
    }

    public void logout () {
        this.logged = false;
    }

    public User getLoggedUser() {
        return loggedUser;
    }
    public boolean isUserLogged() {
        return logged;
    }
}
