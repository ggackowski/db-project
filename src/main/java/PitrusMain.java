import Utils.DataGenerator;
import Utils.DatabaseProvider;
import dataObjects.Recipe;

import java.util.List;

public class PitrusMain {

    public static void main(String[] args) {
        DatabaseProvider db = DatabaseProvider.getInstance();

        DataGenerator dg = new DataGenerator();

        dg.generateAll();

        List<Recipe> allRecipes = db.getRecipes();

        for(Recipe recipe : allRecipes) {
            recipe.setIngredients("ingredients");
            recipe.setDescription("description");
            db.updateRecipe(recipe);
        }

        db.closeSession();
    }
}
