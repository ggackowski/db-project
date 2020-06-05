package dataObjects;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int dbID;

    private String name;

    @ManyToMany(mappedBy = "products")
    private final List<Recipe> recipes = new ArrayList<>();

    public Product () {}
    public Product (String name) {
        this.name = name;
    }

    public void addRecipe (Recipe recipe) {
        if(!recipes.contains(recipe))
            recipes.add(recipe);
    }
}
