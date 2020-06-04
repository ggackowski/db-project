package sample.dataObjects;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int dbID;

    private String name;
    private String surname;
    @OneToMany
    private List<Rating> ratings;

    public User() {}
    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.ratings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public List<Rating> getRatings() {
        return ratings;
    }
    public void addRating (Rating rating) {
        if(ratings.contains(rating))
            return;
        ratings.add(rating);
    }
}
