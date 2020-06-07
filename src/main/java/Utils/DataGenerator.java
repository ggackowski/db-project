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
        List<String> surnameList = Arrays.asList("Foster","Johnson","Deep","Tractor","Philips","Tully","Johns","Bond","Took","Roosevelt","Grim","Tolkien","Albinos","Paper","Rock","Grant");

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
        List<String> recipeNameList = Arrays.asList("Super Turkey","Mega Wonsz","Chinese-Man","Frank-Dear","Long Dolphin","ManInBlack","Parrot Sauce","Gorilla Spicy Breast","Kremowka");

        List<User> allUsers = db.getUsers();

        if(allUsers.size() <= 0)
            return;

        int i = 0;
        for(String title : recipeNameList) {
            if(db.addRecipe(new Recipe(allUsers.get(i),title)))
                System.out.println("Added recipe: "+title);
            else
                System.out.println("Adding recipe: "+title+" FAILURE");
            i++;
            i%=allUsers.size();
        }
    }
}
