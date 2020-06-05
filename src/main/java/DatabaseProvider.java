import dataObjects.Product;
import dataObjects.Rating;
import dataObjects.Recipe;
import dataObjects.User;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.metamodel.EntityType;
import java.util.List;

public class DatabaseProvider {

    private static final SessionFactory ourSessionFactory;

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

    public DatabaseProvider() {
        final Session session = getSession();
        try {
            System.out.println  ("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            session.close();
        }
    }

    public List<Recipe> getRecipes() {
        Query query = getSession().createQuery("from Recipe");
        return query.list();
    }
    public List<User> getUsers() {
        Query query = getSession().createQuery("from User");
        return query.list();
    }
    public List<Product> getProduct() {
        Query query = getSession().createQuery("from Product");
        return query.list();
    }

    public void addRecipe (Recipe recipe) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        session.save(recipe);
        tx.commit();
    }

    public void addUser (User user) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
    }

    public void addProduct (Product product) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        session.save(product);
        tx.commit();
    }

    public void addRating (Rating rating) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        session.save(rating);
        tx.commit();
    }
}
