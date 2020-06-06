import dataObjects.Rating;
import dataObjects.Recipe;
import dataObjects.User;

import java.util.List;

public class PitrusMain {
    public static void main(String[] args) {
        DatabaseProvider db = DatabaseProvider.getInstance();

        db.addUser(new User("Papaj","Karol","papa@gmal","kaslo"));

        User user = db.getUserByName("Papaj","Karol");

        Recipe initRecipe = new Recipe(user,"Kawa");
        initRecipe.setDescription("Pychota");
        initRecipe.setIngredients("Ziemniaki\n");

        db.addRecipe(initRecipe);

        Recipe recipe = db.getRecipeByTitle("Kawa");

        db.addRating(new Rating(user,recipe,1));

        System.out.println("Ratings");
        for(Rating rating : recipe.getRatings()) {
            System.out.println(rating.getRate());
        }

        System.out.println("Recipes");
        for(Recipe recipe1 : user.getRecipes()) {
            System.out.println(recipe1.getTitle());
        }

        System.out.println(user.getEmail());

        db.closeSession();
    }
}
