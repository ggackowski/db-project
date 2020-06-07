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
    private String title;
    private String description;
    private String ingredients;

    @OneToMany
    private final List<Rating> ratings = new ArrayList<>();

    public Recipe() {}
    public Recipe(User author, String title) {
        this.author = author;
        this.title = title;
        author.addRecipe(this);
    }
    public Recipe(User author, String title, String description, String ingredients) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.ingredients = ingredients;
        author.addRecipe(this);
    }


    public User getAuthor() {
        return author;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getIngredients() {
        return ingredients;
    }
    public List<Rating> getRatings() {
        return ratings;
    }

    public void setDescription (String description) {
        this.description = description;
    }
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void addRating (Rating rating) {
        if(!ratings.contains(rating))
            ratings.add(rating);
    }

    public void addAuthor(User author) {
        this.author = author;
    }
}