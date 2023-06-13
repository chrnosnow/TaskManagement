package org.example.takeout;

public class Customer {
    private String name;
    private double wallet;

    public Customer(String name, double money) {
        this.name = name;
        this.wallet = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public void increaseWallet(double money) {
        wallet += money;
    }

    public void decreaseWallet(double money) {
        if (money <= wallet) {
            wallet -= money;
        }
    }
}
