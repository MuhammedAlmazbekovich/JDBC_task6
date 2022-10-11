package org.example.model;

public class City {
    private int id;
    private String name;
    private int areaOfTheTerritory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAreaOfTheTerritory() {
        return areaOfTheTerritory;
    }

    public void setAreaOfTheTerritory(int areaOfTheTerritory) {
        this.areaOfTheTerritory = areaOfTheTerritory;
    }

    @Override
    public String toString() {
        return "City id = " + id + "\nname = " + name  + "\narea of the territory = " + areaOfTheTerritory ;
    }
}
