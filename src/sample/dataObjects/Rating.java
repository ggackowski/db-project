package sample.dataObjects;

//@Entity
public class Rating {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int dbID;

    private int rate;
    private User user;
    private Recipe recipe;

    public Rating() {}
    public Rating(User user, Recipe recipe, int rate) {
        this.user = user;
        this.recipe = recipe;
        this.rate = rate;
        user.addRating(this);
        recipe.addRating(this);
    }

    public int getRate() {
        return rate;
    }
    public User getUser() {
        return user;
    }
    public Recipe getRecipe() {
        return recipe;
    }
}
