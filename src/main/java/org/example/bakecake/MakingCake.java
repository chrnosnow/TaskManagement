package org.example.bakecake;

import java.util.Scanner;

public class MakingCake {
    private CakeRecipe recipe;

    public MakingCake(){
        this.recipe = new CakeRecipe();
    }

    public void start() {

        try{
            Thread preheatOven = new Thread(recipe::preheatOven, "preheatOven");
            Thread preparation = new Thread(recipe::preparation, "preparation");
            Thread mixWetIngredients = new Thread(recipe::mixWetIngredients, "mixWetIngredients");
            Thread mixDryIngredients = new Thread(recipe::mixDryIngredients, "mixDryIngredients");
            Thread combineIngredients = new Thread(recipe::combineIngredients, "combineIngredients");
            Thread bakeCake = new Thread(recipe::bakeCake, "bakeCake");
            Thread makeFrosting = new Thread(recipe::makeFrosting, "makeFrosting");
            Thread frostCake = new Thread(recipe::frostCake, "frostCake");

            preheatOven.start();
            preparation.start();
            mixWetIngredients.start();
            mixDryIngredients.start();

            mixWetIngredients.join();
            mixDryIngredients.join();
            combineIngredients.start();
            combineIngredients.join();
            preheatOven.join();
            bakeCake.start();
            makeFrosting.start();
            makeFrosting.join();
            bakeCake.join();
            frostCake.start();
            frostCake.join();

            System.out.println("Cake complete!");
        } catch(Exception e){
            System.out.println(e);
        }
    }
}
