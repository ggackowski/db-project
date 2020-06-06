import dataObjects.User;

import java.util.List;

public class CurrentUser {
    private boolean logged = false;
    private User loggedUser;
    private DatabaseProvider dbProvider;

    public CurrentUser(DatabaseProvider dbProvider) {
        this.dbProvider = dbProvider;
    }

    public boolean login (String email, String password) {
        if(logged)
            return false;

        List<User> allUsers = dbProvider.getUsers();

        for(User user : allUsers) {
            if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
                this.loggedUser = user;
                this.logged = true;
                return true;
            }
        }
        return false;
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
