package org.example.takeout;

import java.util.*;

public class FoodMenu {
    private List<FoodItem> menu;

    public FoodMenu(){
        this.menu = new ArrayList<>();
    }

    public void add(FoodItem food){
        menu.add(food);
    }

    public FoodItem getFood(int num){
        int index = num - 1;
        if(index >= 0 && index < menu.size()){
            return menu.get(index);
        }

        return null;
    }

    public List<FoodItem> getLowestCostFood(){
        if(menu.isEmpty()){
            return new ArrayList<>();
        }

        List<FoodItem> result = new ArrayList<>();
        FoodItem lowestCostFood = menu.get(0);
        Comparator<FoodItem> comparator = Comparator.comparing(FoodItem::getPrice);
        for (FoodItem foodItem : menu) {
            if (comparator.compare(foodItem, lowestCostFood) < 0) {
                result.clear();
                lowestCostFood = foodItem;
                result.add(lowestCostFood);
            } else if (comparator.compare(foodItem, lowestCostFood) == 0){
                lowestCostFood = foodItem;
                result.add(lowestCostFood);
            }
        }

        return result;
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < menu.size(); i++){
            sb.append(i+1 + ". " + menu.get(i).toString() + "\n");
        }

        return sb.toString();
    }

}
