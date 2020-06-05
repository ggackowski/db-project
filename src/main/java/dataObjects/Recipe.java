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

    @OneToMany
    @JoinColumn(name = "RECIPE_FK")
    private final List<Rating> ratings = new ArrayList<>();

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "ingredients",
            joinColumns = @JoinColumn(name = "RECIPE_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID")
    )
    private final List<Product> ingredients = new ArrayList<>();

    public Recipe() {}
    public Recipe(User author) {
        this.author = author;
        author.addRecipe(this);
    }

    public User getAuthor() {
        return author;
    }
    public String getDescription() {
        return description;
    }
    public List<Rating> getRatings() {
        return ratings;
    }

    public void addDescription (String description) {
        this.description = description;
    }
    public void addIngredient (Product ingredient) {
        if(!ingredients.contains(ingredient))
            ingredients.add(ingredient);
    }
    public void addRating (Rating rating) {
        if(!ratings.contains(rating))
            ratings.add(rating);
    }

    public void addAuthor(User author) {
        this.author = author;
    }
}