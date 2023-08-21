package ke.co.safaricom.models;

import java.util.Objects;

public class Wildlife {
    private String name;
    private String health;
    private String age;

    public Wildlife(String name, String health, String age) {
        this.name = name;
        this.health = health;
        this.age = age;
    }

    public Wildlife(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wildlife)) return false;
        Wildlife wildlife = (Wildlife) o;
        return Objects.equals(name, wildlife.name) && Objects.equals(health, wildlife.health) && Objects.equals(age, wildlife.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, health, age);
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


    public void save() {
    }
}
