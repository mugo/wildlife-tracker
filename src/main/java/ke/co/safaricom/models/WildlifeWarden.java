package ke.co.safaricom.models;

import java.util.ArrayList;
import java.util.Objects;

public class WildlifeWarden {
    private String name;
    private int tag;
    private int phone;
    private String email;
    private static ArrayList<WildlifeWarden> instances = new ArrayList<>();
    private int id;

    public WildlifeWarden(String name, int tag, int phone, String email) {
        this.name = name;
        this.tag = tag;
        this.phone = phone;
        this.email = email;
        instances.add(this);
        this.id=instances.size();
    }

    public static ArrayList<WildlifeWarden> getAllInstances() {
        return instances;
    }


    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WildlifeWarden testRanger = (WildlifeWarden) o;
        return tag == testRanger.tag && phone == testRanger.phone && name.equals(testRanger.name) && email.equals(testRanger.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, tag, phone, email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
