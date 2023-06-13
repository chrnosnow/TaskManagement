package org.example.bakecake;

public class CakeRecipe {
    private boolean whiskInUse = false;
    private boolean ovenInUse = false;
    private boolean mixingBowlInUse = false;

    public void preheatOven() {
        try {
            printStep("Oven preheating...");
            ovenInUse = true;
            Thread.sleep(15000);
            printStep("Done!");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void preparation() {
        try {
            printStep("Drain and mash the pineapple...");

            synchronized (this) {
                while (whiskInUse) {
                    printStep("Waiting for the whisk...");
                    wait();
                }
                whiskInUse = true;
                printStep("Mashing...");
                Thread.sleep(1000);
            }

            synchronized (this) {
                whiskInUse = false;
                printStep("Releasing whisk");
                notifyAll();
            }

            printStep("Done!");

        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void mixWetIngredients() {
        try {
            printStep("Mixing wet ingredients...");

            synchronized (this) {
                while (mixingBowlInUse) {
                    printStep("Waiting for the mixing bowl...");
                    wait();
                }

                printStep("Using mixing bowl");
                mixingBowlInUse = true;
            }

            Thread.sleep(1000);
            printStep("Melting butter and coconut oil over bain marie....");
            Thread.sleep(1000);
            printStep("Letting the butter to cool down...");
            Thread.sleep(500);
            printStep("Adding the eggs...");
            Thread.sleep(500);
            printStep("Adding salt...");
            Thread.sleep(500);
            printStep("Adding vanilla extract...");
            Thread.sleep(500);
            printStep("Adding sugar....");
            whiskInUse = true;
            printStep("Mixing....");
            Thread.sleep(1500);
            whiskInUse = false;

            synchronized (this) {
                mixingBowlInUse = false;
                printStep("Releasing mixing bowl");
                notifyAll();
            }

            printStep("Done");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void mixDryIngredients() {
        try {
            printStep("Mixing dry ingredients...");

            synchronized (this) {
                while (mixingBowlInUse) {
                    printStep("Waiting for the mixing bowl...");
                    wait();
                }

                printStep("Using the mixing bowl");
                mixingBowlInUse = true;
            }

            Thread.sleep(500);
            printStep("Adding cake flour...");
            Thread.sleep(500);
            printStep("Adding the baking powder...");
            Thread.sleep(500);

            whiskInUse = true;
            printStep("Mixing...");
            Thread.sleep(1000);
            whiskInUse = false;

            synchronized (this) {
                mixingBowlInUse = false;
                printStep("Releasing mixing bowl");
                notifyAll();
            }

            printStep("Done!");

        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void combineIngredients() {
        try {
            printStep("Combining ingredients...");
            synchronized (this) {
                while (mixingBowlInUse) {
                    printStep("Waiting for the mixing bowl...");
                    wait();
                }
            }

            mixingBowlInUse = true;
            Thread.sleep(200);
            printStep("Adding dry mix to wet mix....");
            Thread.sleep(200);

            synchronized (this) {
                while (whiskInUse) {
                    printStep("Waiting for the whisk...");
                    wait();
                }
            }

            whiskInUse = true;
            printStep("Mixing...");
            Thread.sleep(1000);
            printStep("Adding the mashed pineapple");
            Thread.sleep(200);
            printStep("Mixing...");
            Thread.sleep(200);

            synchronized (this) {
                whiskInUse = false;
                mixingBowlInUse = false;
                printStep("Releasing mixing bowl and whisk");
                notifyAll();
            }

            printStep("Done");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void bakeCake() {
        try {
            printStep("Baking cake...");
            ovenInUse = true;
            Thread.sleep(10000);
            ovenInUse = false;
            printStep("Done");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void makeFrosting() {
        try {
            printStep("Making frosting...");
            synchronized (this) {
                while (whiskInUse && mixingBowlInUse) {
                    printStep("Waiting for the bowl and whisk...");
                    wait();
                }
            }

            whiskInUse = true;
            mixingBowlInUse = true;
            printStep("Adding cream....");
            Thread.sleep(200);
            printStep("Adding powder sugar....");
            Thread.sleep(200);
            printStep("Mixing...");
            Thread.sleep(500);

            synchronized (this) {
                whiskInUse = false;
                mixingBowlInUse = false;
                printStep("Releasing whisk and mixing bowl");
                notifyAll();
            }

            printStep("Done!");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void frostCake() {
        try {
            printStep("Moisten the cake with pineapple syrup....");
            Thread.sleep(1500);
            printStep("Frosting the cake....");
            Thread.sleep(500);
            printStep("Sprinkling chopped walnuts on top of the frosting...");
            Thread.sleep(500);
            printStep("Done!");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }


    private void printStep(String step) {
        System.out.println(Thread.currentThread().getName() + " " + "- " + step);
    }
}
