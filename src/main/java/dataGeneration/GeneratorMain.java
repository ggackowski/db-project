package dataGeneration;

import Utils.DatabaseProvider;
import dataObjects.Recipe;
import dataObjects.User;

import java.util.List;

public class GeneratorMain {

    public static void main(String[] args) {
        DatabaseProvider db = DatabaseProvider.getInstance();

        DataGenerator dg = new DataGenerator();

        dg.generateAll();

        db.closeSession();
    }
}
