package org.example.takeout;


import java.util.HashMap;
import java.util.Map;

public class ShoppingCart<T extends PricedItem<Double>> {
    private Map<T, Integer> cart; //maps a food item to its number of units in the shopping cart

    public ShoppingCart(){
        this.cart = new HashMap<>();
    }

    public void addItem(T item){
        Integer itemUnits = cart.getOrDefault(item, 0) + 1;
        cart.put(item, itemUnits);
    }

    public double getTotalPrice(){
        double totalPrice = 0;
        for(T item : cart.keySet()){
            totalPrice += item.getPrice() * cart.get(item);
        }

        return totalPrice;
    }

}
