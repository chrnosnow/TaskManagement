package org.example.takeout;

import java.util.ArrayList;
import java.util.List;

public class Restaurants {
    List<FoodPlace> restaurants = new ArrayList<>();

    public Restaurants(){
        this.initialize();
    }


    public FoodPlace createBrics(){
        FoodMenu menu = new FoodMenu();
        menu.add(new FoodItem("Ramen", "the best ramen in town", 54));
        menu.add(new FoodItem("Pizza", "with figs", 41));
        menu.add(new FoodItem("Burger menu", "Burger with beef, ancho sauce and chips", 44.5));
        return new FoodPlace("Brics", "Str. Alexandru Lapusneanu 16", menu);
    }

    public FoodPlace createCreveterie(){
        FoodMenu menu = new FoodMenu();
        menu.add(new FoodItem("Fish borsch", "with polenta and pepper", 25));
        menu.add(new FoodItem("Row salad", "with carp row from Danube Delta", 35.5));
        menu.add(new FoodItem("AOP spaghetti", "with seafood and clams", 54));
        return new FoodPlace("Creveterie", "Str. Vasile Pogor 4", menu);
    }

    public FoodPlace createHOF(){
        FoodMenu menu = new FoodMenu();
        menu.add(new FoodItem("Fish and chips", "with ranch sauce", 50.5));
        menu.add(new FoodItem("American bucket menu", "a mix of chicken breast, wings and drumsticks", 68.9));
        menu.add(new FoodItem("Kartoffel salad", "with bacon, potatoes and mayo", 32.9));
        return new FoodPlace("House of Food", "Str. Dochia 11A", menu);
    }

    public void initialize(){
        restaurants.add(createBrics());
        restaurants.add(createCreveterie());
        restaurants.add(createHOF());
    }

    public void print(){
        for(int i = 0; i < restaurants.size(); i++){
            System.out.println((i+1) + ". " + restaurants.get(i).getName());
        }
    }

}
