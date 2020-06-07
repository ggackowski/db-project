import Utils.DataGenerator;
import Utils.DatabaseProvider;

public class PitrusMain {

    public static void main(String[] args) {
        DatabaseProvider db = DatabaseProvider.getInstance();

        DataGenerator dg = new DataGenerator();

        dg.generateAll();

        db.closeSession();
    }
}
