package dataObjects;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int dbID;

    private String name;
    private String surname;

    private String email;
    private String password;

    @OneToMany
    @JoinColumn(name = "USER_FK")
    private final List<Rating> ratings = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "USER_FK")
    private final List<Recipe> recipes = new ArrayList<>();

    public User() {}
    public User(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String fullName() {
        return name + " " + surname;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

    public List<Rating> getRatings() {
        return ratings;
    }
    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void addRating (Rating rating) {
        if(!ratings.contains(rating))
            ratings.add(rating);
    }
    public void addRecipe (Recipe recipe) {
        if(!recipes.contains(recipe))
            recipes.add(recipe);
    }

    public void removeRecipe (Recipe recipe) {
        recipes.remove(recipe);
    }
    public void removeRating (Rating rating) {
        ratings.remove(rating);
    }
}