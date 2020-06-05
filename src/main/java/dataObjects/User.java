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
    @OneToMany
    private List<Rating> ratings;

    @OneToMany
    @JoinColumn(name = "USER_FK")
    private List<Recipe> recipes;

    public User() {}
    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.ratings = new ArrayList<>();
        this.recipes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public List<Rating> getRatings() {
        return ratings;
    }
    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void addRating (Rating rating) {
        if(ratings.contains(rating))
            return;
        ratings.add(rating);
    }
    public void addRecipe (Recipe recipe) {
        if(recipes.contains(recipe))
            return;
        recipes.add(recipe);
    }
}
