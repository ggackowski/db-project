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
    @JoinColumn(name = "USER_FK")
    private User author;

    private String title;
    private String description;
    private String ingredients;

    @OneToMany
    @JoinColumn(name = "RECIPE_FK")
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

    public double getAVGRating () {
        if(ratings.size() < 1)
            return 0;
        int sum = 0;
        for(Rating rating : ratings) {
            sum += rating.getRate();
        }
        return(double)sum/(double)ratings.size();
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

    public void addRating (Rating rating) {
        if(!ratings.contains(rating))
            ratings.add(rating);
    }
    public void addAuthor(User author) {
        this.author = author;
    }

    public void removeRating (Rating rating) {
        ratings.remove(rating);
    }
}