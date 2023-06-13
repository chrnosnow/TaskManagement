package org.example.takeout;

public class FoodPlace {
    private String name;
    private String address;
    private FoodMenu menu;

    public FoodPlace(String name, String address, FoodMenu menu){
        this.name = name;
        this.address = address;
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public FoodMenu getMenu() {
        return menu;
    }

    public void setMenu(FoodMenu menu) {
        this.menu = menu;
    }
}
