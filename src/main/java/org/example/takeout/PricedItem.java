package org.example.takeout;

//interface with a T type parameter that is bounded by Number class
//will represent an item in the take-out system
public interface PricedItem <T extends Number>{
    abstract T getPrice();
    abstract void setPrice(T price);
}
