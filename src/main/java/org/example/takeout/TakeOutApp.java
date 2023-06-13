package org.example.takeout;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class TakeOutApp {
    private Customer customer;
    private ShoppingCart<FoodItem> shoppingCart;
    private FoodMenu menu;
    private Restaurants foodPlaces;

    public TakeOutApp(Customer customer) {
        this.customer = customer;
        this.shoppingCart = new ShoppingCart<>();
        foodPlaces = new Restaurants();
        menu = new FoodMenu();
    }


    public List<FoodPlace> getRestaurants() {
        return foodPlaces.restaurants;
    }

    public void displayRestaurants() {
        foodPlaces.print();
    }

    public FoodMenu restaurantMenu(int num) {
        int index = num - 1;
        List<FoodPlace> listOfRestaurants = this.getRestaurants();
        menu = listOfRestaurants.get(index).getMenu();
        return menu;
    }


    public void shop(int num) {
        FoodItem item = menu.getFood(num);
        shoppingCart.addItem(item);
        System.out.println(item.getName() + " was added to cart. Total price: " + shoppingCart.getTotalPrice());
    }

    public void finalizeOrder() {
        double wallet = customer.getWallet();
        double cartPrice = shoppingCart.getTotalPrice();
        if (cartPrice <= wallet) {
            customer.decreaseWallet(cartPrice);
            System.out.println("Payment complete! Your remaining money: " + customer.getWallet());
        } else {
            System.out.println("You don't have enough money to purchase all items!");
        }
    }


}
