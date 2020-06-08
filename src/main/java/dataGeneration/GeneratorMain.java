package dataGeneration;

import Utils.DatabaseProvider;
import dataObjects.Recipe;
import dataObjects.User;

import java.util.List;

public class GeneratorMain {

    public static void main(String[] args) {
        DatabaseProvider db = DatabaseProvider.getInstance();

//        DataGenerator dg = new DataGenerator();
//
//        dg.generateAll();

        List<Recipe> allRecipes = db.getRecipes();
        List<User> allUsers = db.getUsers();

//        for(Recipe recipe : allRecipes) {
//            recipe.setIngredients("ingredients");
//            recipe.setDescription("description");
//            db.updateRecipe(recipe);
//        }

        Recipe recipe = allRecipes.get(0);

//        recipe.addRating(allUsers.get(2),11);
//        recipe.addRating(allUsers.get(3),12);
//        recipe.addRating(allUsers.get(4),13);
//        recipe.addRating(allUsers.get(5),14);
//        db.updateRecipe(recipe);

        db.removeUser(db.getUserByEmail("TrevorTully@example.com"));

        System.out.println(recipe.getAVGRating());

//        db.removeRecipe(recipe);

//        System.out.println(recipe.getAVGRating());

//        if(db.addRating(rating))
//            System.out.println("SUCCESS SUCCESS SUCCESS SUCCESS SUCCESS SUCCESS SUCCESS");
//        else
//            System.out.println("FAILURE FAILURE FAILURE FAILURE FAILURE FAILURE FAILURE");

//        rating = new Rating(user,allRecipes.get(6),1);
//
//        if(db.addRating(rating))
//            System.out.println("SUCCESS SUCCESS SUCCESS SUCCESS SUCCESS SUCCESS SUCCESS");
//        else
//            System.out.println("FAILURE FAILURE FAILURE FAILURE FAILURE FAILURE FAILURE");

//        List<Rating> ratings = user.getRatings();
//
//        db.removeRating(ratings.get(0));

//        db.closeSession();
    }
}
