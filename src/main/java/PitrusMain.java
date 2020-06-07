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

//        DataGenerator dg = new DataGenerator();
//
//        dg.generateAll();
//
//        List<Recipe> allRecipes = db.getRecipes();
//
//        for(Recipe recipe : allRecipes) {
//            recipe.setIngredients("ingredients");
//            recipe.setDescription("description");
//            db.updateRecipe(recipe);
//        }
//
//        CurrentUser currUs = CurrentUser.getInstance();
//
//        List<User> allUsers = db.getUsers();
//        User user = allUsers.get(1);
//
//        if(currUs.login(user.getEmail(),user.getPassword()))
//            System.out.println("SUCCESS SUCCESS SUCCESS SUCCESS SUCCESS SUCCESS SUCCESS");
//        else
//            System.out.println("FAILURE FAILURE FAILURE FAILURE FAILURE FAILURE FAILURE");
//
//        Rating rating = new Rating(user,allRecipes.get(3),1);
//
//        System.out.println(user.getEmail());
//        System.out.println(allRecipes.get(3).getAuthor().getEmail());
//
//        if(db.addRating(rating))
//            System.out.println("SUCCESS SUCCESS SUCCESS SUCCESS SUCCESS SUCCESS SUCCESS");
//        else
//            System.out.println("FAILURE FAILURE FAILURE FAILURE FAILURE FAILURE FAILURE");

//        User user = db.getUserByName("Jane","Foster");
        Recipe recipe = db.getRecipeByTitle("ManInBlack");

//        db.addUser(new User("Filip","Hajzer","hajzer@example.com","xD"));

//        db.removeUser(user);
        db.removeRecipe(recipe);

//        Rating rating = new Rating(user,recipe,1);
//        db.addRating(rating);
//
//        List<Rating> ratings = user.getRatings();
//
//        db.removeRating(ratings.get(0));

        db.closeSession();
    }
}
