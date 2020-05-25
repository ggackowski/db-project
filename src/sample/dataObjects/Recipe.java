package sample.dataObjects;

import java.util.ArrayList;
import java.util.List;

//@Entity
public class Recipe {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int dbID;

    private Author author;
    private String description;
    private List<String> ingredients;
    private List<Rating> ratings;

    public Recipe() {}
    public Recipe(Author author) {
        this.author = author;
        this.ratings = new ArrayList<>();
        this.ingredients = new ArrayList<>();
        author.addRecipe(this);
    }

    public Author getAuthor() {
        return author;
    }
    public String getDescription() {
        return description;
    }
    public List<String> getIngredients() {
        return ingredients;
    }
    public List<Rating> getRatings() {
        return ratings;
    }

    public void addDescription (String description) {
        this.description = description;
    }
    public void addIngredient (String ingredient) {
        if(ingredients.contains(ingredient))
            return;
        ingredients.add(ingredient);
    }
    public void addRating (Rating rating) {
        if(ratings.contains(rating))
            return;
        ratings.add(rating);
    }
}