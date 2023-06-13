package org.example.takeout;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FoodMenuTest {

    @Test
    void getLowestCostFoodIfEmpty() {
        FoodMenu menu = new FoodMenu();
        assertTrue(menu.getLowestCostFood().isEmpty());
    }

    @Test
    void getLowestCostFoodDistinctPrice() {
        FoodMenu menu = new FoodMenu();
        menu.add(new FoodItem("soup", "", 10.5));
        menu.add(new FoodItem("water", "", 12));
        menu.add(new FoodItem("chips", "", 9));
        menu.add(new FoodItem("salsa", "", 11.5));
        assertEquals(menu.getLowestCostFood().toString(), "[Enjoy chips:    Cost: 9.0]");
    }

    @Test
    void getLowestCostFoodSamePrice() {
        FoodMenu menu = new FoodMenu();
        menu.add(new FoodItem("soup", "", 10.5));
        menu.add(new FoodItem("water", "", 12));
        menu.add(new FoodItem("cola", "", 10.5));
        menu.add(new FoodItem("salsa", "", 11.5));
        menu.add(new FoodItem("fish", "", 10.5));
        assertEquals(menu.getLowestCostFood().size(), 3);
    }
}