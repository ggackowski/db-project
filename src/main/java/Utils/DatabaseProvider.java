package Utils;

import dataObjects.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.metamodel.EntityType;
import java.util.List;

public class DatabaseProvider {

    private static final SessionFactory ourSessionFactory;
    private final Session session;

    private static DatabaseProvider instance;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }
    public void closeSession () {
        session.close();
    }

    private DatabaseProvider() {
        this.session = getSession();
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }

    }

    public static DatabaseProvider getInstance() {
        if(instance == null)
            instance = new DatabaseProvider();
        return instance;
    }

    public List<Recipe> getRecipes() {
        Query query = session.createQuery("from Recipe");
        return query.list();
    }
    public List<User> getUsers() {
        Query query = session.createQuery("from User");
        return query.list();
    }

    public boolean addUser(User user) {
        if(getUserByEmail(user.getEmail()) == null) {
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(user);
            tx.commit();
            return true;
        }
        return false;
    }
    public boolean addRecipe(Recipe recipe) {
        if(getRecipeByTitle(recipe.getTitle()) == null) {
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(recipe);
            tx.commit();
            return true;
        }
        recipe.getAuthor().removeRecipe(recipe);
        return false;
    }

    public void updateUser(User user) {
        Transaction tx = session.beginTransaction();
        session.update(user);
        tx.commit();
    }
    public void updateRecipe(Recipe recipe) {
        Transaction tx = session.beginTransaction();
        session.update(recipe);
        tx.commit();
    }

    public void removeUser (User user) {
        Transaction tx = session.beginTransaction();
        List<Recipe> recipes = user.getRecipes();

        for(Recipe recipe : recipes) {
            session.remove(recipe);
        }

        recipes = getRecipes();
        for(Recipe recipe : recipes) {
            recipe.removeRater(user);
        }

        session.remove(user);
        tx.commit();
    }
    public void removeRecipe (Recipe recipe) {
        Transaction tx = session.beginTransaction();
        session.remove(recipe);
        tx.commit();
    }

    public User getUserByName (String name, String surname) {
        List<User> allUsers = getUsers();

        for(User user : allUsers) {
            if(user.getName().equals(name) && user.getSurname().equals(surname))
                return user;
        }
        return null;
    }
    public User getUserByEmail (String email) {
        List<User> allUsers = getUsers();

        for(User user : allUsers) {
            if(user.getEmail().equals(email))
                return user;
        }
        return null;
    }
    public Recipe getRecipeByTitle (String title) {
        List<Recipe> allRecipes = getRecipes();

        for(Recipe recipe : allRecipes) {
            if(recipe.getTitle().equals(title))
                return recipe;
        }
        return null;
    }
}
