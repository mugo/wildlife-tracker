package ke.co.safaricom.models;

import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class WildlifeSighting {

    private int id;
    private String location;
    private String animalRangerName;
    private String name;
    private String health;
    private String age;
    private String species;
    private Date date = new Date();
    private Timestamp time;
    private static ArrayList<WildlifeSighting> instances = new ArrayList<>();

    public WildlifeSighting(String animalRangerName, String name, String health, String age, String species, String location) {
        this.animalRangerName = animalRangerName;
        this.age = age;
        this.health = health;
        this.species = species;
        this.location = location;
        this.name = name;
        instances.add(this);
        this.id=instances.size();
    }

    public static List<WildlifeSighting> getAll() {
        String sql = "SELECT * FROM AnimalSighting";
        try (Connection con = DataBase.sql2o.open()){
            return con.createQuery(sql).executeAndFetch(WildlifeSighting.class);
        }
    }

    public static ArrayList<WildlifeSighting> getAllInstances() {
        return instances;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WildlifeSighting)) return false;
        WildlifeSighting that = (WildlifeSighting) o;
        return getId() == that.getId() && Objects.equals(getLocation(), that.getLocation()) && Objects.equals(getAnimalRangerName(), that.getAnimalRangerName()) && Objects.equals(getName(), that.getName()) && Objects.equals(getHealth(), that.getHealth()) && Objects.equals(getAge(), that.getAge()) && Objects.equals(getSpecies(), that.getSpecies()) && Objects.equals(getDate(), that.getDate()) && Objects.equals(getTime(), that.getTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLocation(), getAnimalRangerName(), getName(), getHealth(), getAge(), getSpecies(), getDate(), getTime());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAnimalRangerName() {
        return animalRangerName;
    }

    public void setAnimalRangerName(String animalRangerName) {
        this.animalRangerName = animalRangerName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
    

    public void save() {
    }
}
