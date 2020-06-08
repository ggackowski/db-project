package dataGeneration;

import Utils.DatabaseProvider;
import dataObjects.Recipe;
import dataObjects.User;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DataGenerator {

    private DatabaseProvider db;

    public DataGenerator () {
        db = DatabaseProvider.getInstance();
    }

    public void generateAll () {
        generateUsers();
        generateRecipes();
        generateRatings();
    }

    public void generateUsers () {
        List<String> nameList = Arrays.asList("Jane","John","Ann","Lucas","George","Harry","Josh","Franklin","Michael","Trevor","Martin","Christopher","Isabel","James","Caroline","Quentin");
        List<String> surnameList = Arrays.asList("Foster","Johnson","Deep","Tractor","Philips","Tully","Johns","Bond","Took","Roosevelt","Grim","Tolkien","Albinos","Paper","Rock");

        int iName, iSurname;
        iName = iSurname = 0;
        for(int i = 0; i < 21; i++) {
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
        List<String> recipeNameList = Arrays.asList("Prosty indyk","Sos koperkowy","Sos do pieczeni","Kanapka z szynka","Rosół z kury");
        List<String> ingredients = Arrays.asList("1 turkey\n","szalotka 1 sztuka\n" + //indyk i sos koperkowy
                "olej roślinny do smażenia - 2 łyżki\n" +
                "mleko 3,2% - 200 mililitrów\n" +
                "koper drobno pokrojony - 0.25 pęczka\n" +
                "masło - 2 łyżki\n" +
                "pieprz biały - 1 szczypta\n" +
                "Sos do pieczeni jasny Knorr - 1 sztuka", "Sos do pieczeni jasny Knorr - 1 sztuka\n" + //sos pieczeń
                "ząbek czosnku - 1 sztuka\n" +
                "natka pietruszki - 1 pęczek\n" +
                "olej - 2 łyżki","Bułka - 1 sztuka\n" + //kanapka z szynką
                "Szynka - 2 plastry\n" +
                "Masło","krótki makaron - 100 gramów\n" + //rosół
                "Rosół z kury Knorr - 2 sztuki\n" +
                "korzeń pietruszki - 1 sztuka\n" +
                "marchewka - 2 sztuki\n" +
                "świeża natka pietruszki - 1 łyżka");
        List<String> descriptions = Arrays.asList("Umieść indyka w piekarniku\nWyjmij go po godzinie\nSmacznego", "Na patelni," +
                " na której przygotowywane było mięso na rozgrzanym tłuszczu zeszklij drobno posiekaną szalotkę, dodaj do niej mleko.\n" +
                "Dodaj Sos do pieczeni jasny Knorr, dzięki któremu sos będzie gęsty i dobrze doprawiony. Całość dokładnie wymieszaj.\n" +
                "Wszystko razem gotuj aż sos zacznie gęstnieć. Na koniec dodaj masło i koperek . Sos " +
                "energicznie wymieszaj, tak aby otrzymać gładką emulsję. Sos dopraw szczyptą białego pieprzu do smaku.","Czosnek" +
                " posiekaj drobno i rozetrzyj na desce nożem.\n" +
                "Na rozgrzanym oleju podsmaż czosnek, wlej 250 ml ciepłej wody i dodaj Sos do pieczeni jasny Knorr , dzięki której sos" +
                " będzie gęsty i dobrze doprawiony. Sos gotuj 2-3 minuty.\n" +
                "W trakcie gotowania dodaj posiekaną natkę pietruszki. Gotowy sos podawaj do pieczonych mięs, np. karkówki.", "Przekrój bułkę\n" +
                "Posmaruj bułkę masłem\n" +
                "Połóż plastry szynki\n" +
                "Kanapka gotowa","Ugotuj makaron wg wskazówek na opakowaniu.\n" +
                "Obierz i pokrój w plasterki marchewkę i pietruszkę.\n" +
                "Dodaj kostki rosołowe Knorr do 1 l wody. Zagotuj. Dodaj warzywa i gotuj przez 10 min.\n" +
                "Dodaj makaron i jeszcze raz zagotuj.Zupę serwuj posypaną posiekaną zieloną pietruszką.");
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

    public void generateRatings () {
        List<User> allUsers= db.getUsers();
        List<Recipe> allRecipes= db.getRecipes();

        int iUser,iRecipe;
        iUser = iRecipe = 0;
        for(int i = 0; i < 40; i++) {
            Random random = new Random();
            Recipe recipe = allRecipes.get(iRecipe);
            int randInt = random.nextInt();
            if(randInt < 0) {
                randInt *= -1;
            }
            recipe.addRating(allUsers.get(iUser),randInt%6);
            db.updateRecipe(recipe);

            iUser += 5;
            iRecipe += 3;

            iUser %= allUsers.size();
            iRecipe %= allRecipes.size();
        }
    }
}
