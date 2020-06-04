package dataObjects;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int dbID;

    private String name;
    private String surname;
    @OneToMany
    @JoinColumn(name = "AUTHOR_FK")
    private List<Recipe> recipes;

    public Author() {}
    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.recipes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public List<Recipe> getRecipes() {
        return recipes;
    }
    public void addRecipe (Recipe recipe) {
        if(recipes.contains(recipe))
            return;
        recipes.add(recipe);
    }
}
