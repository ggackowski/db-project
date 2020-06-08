import Utils.CurrentUser;
import Utils.DataGenerator;
import Utils.DatabaseProvider;
import dataObjects.Rating;
import dataObjects.Recipe;
import dataObjects.User;

import java.util.List;

public class PitrusMain {

    public static void main(String[] args) {
        DatabaseProvider db = DatabaseProvider.getInstance();

        DataGenerator dg = new DataGenerator();

        dg.generateAll();

//        List<Recipe> allRecipes = db.getRecipes();
//
//        for(Recipe recipe : allRecipes) {
//            recipe.setIngredients("ingredients");
//            recipe.setDescription("description");
//            db.updateRecipe(recipe);
//        }

        Recipe recipe = db.getRecipeByTitle("Easy Turkey");
        System.out.println("Got recipe xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        User user = db.getUserByName("Harry","Paper");
        System.out.println("Got user xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

        Rating rating = new Rating(user,recipe,1);

        if(db.addRating(rating))
            System.out.println("SUCCESS SUCCESS SUCCESS SUCCESS SUCCESS SUCCESS SUCCESS");
        else
            System.out.println("FAILURE FAILURE FAILURE FAILURE FAILURE FAILURE FAILURE");

//        rating = new Rating(user,allRecipes.get(6),1);
//
//        if(db.addRating(rating))
//            System.out.println("SUCCESS SUCCESS SUCCESS SUCCESS SUCCESS SUCCESS SUCCESS");
//        else
//            System.out.println("FAILURE FAILURE FAILURE FAILURE FAILURE FAILURE FAILURE");

//        List<Rating> ratings = user.getRatings();
//
//        db.removeRating(ratings.get(0));

        db.closeSession();
    }
}
