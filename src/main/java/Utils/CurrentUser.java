package Utils;

import dataObjects.User;

import java.util.List;

public class CurrentUser {
    private boolean logged = false;
    private User loggedUser;
    private DatabaseProvider dbProvider;

    public CurrentUser() {
        this.dbProvider = DatabaseProvider.getInstance();
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
