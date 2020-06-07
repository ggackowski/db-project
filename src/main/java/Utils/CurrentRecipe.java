package Utils;

import dataObjects.Recipe;

public class CurrentRecipe {

    Recipe current;

    private static CurrentRecipe instance;

    private CurrentRecipe() {
        current = null;
    }

    public static CurrentRecipe getInstance() {
        if(instance == null)
            instance = new CurrentRecipe();
        return instance;
    }

    public void set(Recipe recipe) {
        current = recipe;
    }

    public Recipe get() {
        return current;
    }

}
