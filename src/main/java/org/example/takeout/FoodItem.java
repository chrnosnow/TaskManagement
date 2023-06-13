package org.example.takeout;

public class FoodItem implements PricedItem<Double> {
    private String name;
    private String description;
    private double price;

    public FoodItem(String name, String description, double price){
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public Double getPrice(){
        return this.price;
    }

    @Override
    public void setPrice(Double price){
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return "Enjoy " + name + ": " + description + "   Cost: " + price;
    }
}
