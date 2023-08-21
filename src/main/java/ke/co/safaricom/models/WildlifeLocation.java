package ke.co.safaricom.models;

import java.util.ArrayList;
import java.util.Objects;

public class WildlifeLocation {
  private String name;
  private int id;
  private static ArrayList<WildlifeLocation> instances = new ArrayList<>();

    public WildlifeLocation(String name, int id) {
        this.name = name;
        this.id = id;
        instances.add(this);
        this.id=instances.size();
    }

    public static ArrayList<WildlifeLocation> getAllInstances() {
        return  instances;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WildlifeLocation testLocation = (WildlifeLocation) o;
        return id == testLocation.id && name.equals(testLocation.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
