package com.sweet.collectionplus;

/**
 * Author:sweet
 * Created:2019/1/8
 */
public class Order {
    private String titile;
    private double price;
    private int amount;

    public Order(String titile, double price, int amount) {
        this.titile = titile;
        this.price = price;
        this.amount = amount;
    }

    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
