package dataObjects;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int dbID;

    @ManyToOne
    private User author;
    private String description;

//    @OneToMany
//    private List<String> ingredients;

    @OneToMany
    @JoinColumn(name = "RECIPE_FK")
    private List<Rating> ratings;

    public Recipe() {}
    public Recipe(User author) {
        this.author = author;
        this.ratings = new ArrayList<>();
//        this.ingredients = new ArrayList<>();
        author.addRecipe(this);
    }

    public User getAuthor() {
        return author;
    }
    public String getDescription() {
        return description;
    }
//    public List<String> getIngredients() {
//        return ingredients;
//    }
    public List<Rating> getRatings() {
        return ratings;
    }

    public void addDescription (String description) {
        this.description = description;
    }
//    public void addIngredient (String ingredient) {
//        if(ingredients.contains(ingredient))
//            return;
//        ingredients.add(ingredient);
//    }
    public void addRating (Rating rating) {
        if(ratings.contains(rating))
            return;
        ratings.add(rating);
    }

    public void addAuthor(User author) {
        this.author = author;
    }
}