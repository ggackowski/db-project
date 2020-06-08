package dataObjects;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int dbID;

    @ManyToOne
    @JoinColumn(name = "AUTHOR_FK")
    private User author;

    private String title;
    private String description;
    private String ingredients;

    @ManyToMany
    private List<User> raters;

    private int ratingsSum;
    private int ratingsNumber;

    public Recipe() {}
    public Recipe(User author, String title) {
        this.author = author;
        this.title = title;
        author.addRecipe(this);
        this.ratingsNumber = 0;
        this.ratingsSum = 0;
        this.raters = new ArrayList<>();
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

    public double getAVGRating () {
        return(double)ratingsSum/(double)ratingsNumber;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription (String description) {
        this.description = description;
    }
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void addRating (User user, int rating) {
        if(user.equals(author) || raters.contains(user))
            return;
        raters.add(user);
        ratingsSum += rating;
        ratingsNumber++;
    }
    public void addAuthor(User author) {
        this.author = author;
    }

    public void removeRater (User user) {
        raters.remove(user);
    }
}