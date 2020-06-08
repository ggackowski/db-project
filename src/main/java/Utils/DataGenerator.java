package Utils;

import dataObjects.Recipe;
import dataObjects.User;

import java.util.Arrays;
import java.util.List;

public class DataGenerator {

    private DatabaseProvider db;

    public DataGenerator () {
        db = DatabaseProvider.getInstance();
    }

    public void generateAll () {
        generateUsers();
        generateRecipes();

    }

    public void generateUsers () {
        List<String> nameList = Arrays.asList("Jane","John","Ann","Lucas","George","Harry","Josh","Franklin","Michael","Trevor","Martin","Christopher","Isabel","James","Caroline","Quentin");
        List<String> surnameList = Arrays.asList("Foster","Johnson","Deep","Tractor","Philips","Tully","Johns","Bond","Took","Roosevelt","Grim","Tolkien","Albinos","Paper","Rock");

        int iName, iSurname;
        iName = iSurname = 0;
        for(int i = 0; i < 20; i++) {
            String name = nameList.get(iName);
            String surname = surnameList.get(iSurname);
            if(db.addUser(new User(name,surname,name+surname+"@example.com","test123")))
                System.out.println("Added user: "+name+" "+surname);
            else
                System.out.println("Adding user: "+name+" "+surname+" FAILURE");
            iName = (iName + 5) % nameList.size();
            iSurname = (iSurname + 13) % surnameList.size();
        }
    }

    public void generateRecipes () {
        List<String> recipeNameList = Arrays.asList("Easy Turkey","Sos koperkowy","Sos do pieczeni");
        List<String> ingredients = Arrays.asList("1 turkey\n","szalotka 1 sztuka\n" +
                "olej roślinny do smażenia 2 łyżki\n" +
                "mleko 3,2% 200 mililitrów\n" +
                "koper drobno pokrojony 0.25 pęczka\n" +
                "masło 2 łyżki\n" +
                "pieprz biały 1 szczypta\n" +
                "Sos do pieczeni jasny Knorr 1 sztuka", "Sos do pieczeni jasny Knorr 1 sztuka\n" +
                "ząbek czosnku 1 sztuka\n" +
                "natka pietruszki 1 pęczek\n" +
                "olej 2 łyżki");
        List<String> descriptions = Arrays.asList("Put him into the oven\nTake out after 1 hours\nEnjoy your meal", "Na patelni," +
                " na której przygotowywane było mięso na rozgrzanym tłuszczu zeszklij drobno posiekaną szalotkę, dodaj do niej mleko.\n" +
                "Dodaj Sos do pieczeni jasny Knorr, dzięki któremu sos będzie gęsty i dobrze doprawiony. Całość dokładnie wymieszaj.\n" +
                "Wszystko razem gotuj aż sos zacznie gęstnieć. Na koniec dodaj masło i koperek . Sos " +
                "energicznie wymieszaj, tak aby otrzymać gładką emulsję. Sos dopraw szczyptą białego pieprzu do smaku.","Czosnek" +
                " posiekaj drobno i rozetrzyj na desce nożem.\n" +
                "Na rozgrzanym oleju podsmaż czosnek, wlej 250 ml ciepłej wody i dodaj Sos do pieczeni jasny Knorr , dzięki której sos" +
                " będzie gęsty i dobrze doprawiony. Sos gotuj 2-3 minuty.\n" +
                "W trakcie gotowania dodaj posiekaną natkę pietruszki. Gotowy sos podawaj do pieczonych mięs, np. karkówki.");
        List<User> allUsers = db.getUsers();

        if(allUsers.size() <= 0)
            return;

        int i = 0;
        int j = 0;
        for(String title : recipeNameList) {
            Recipe recipe = new Recipe(allUsers.get(i),title);
            recipe.setDescription(descriptions.get(j));
            recipe.setIngredients(ingredients.get(j));
            if(db.addRecipe(recipe))
                System.out.println("Added recipe: "+title);
            else
                System.out.println("Adding recipe: "+title+" FAILURE");
            i++;
            j++;
            i%=allUsers.size();
        }
    }
}
