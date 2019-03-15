package com.sweeeeeet;

/**
 * Author:sweet
 * Created:2019/1/19
 */
public class Goods {
    private String name;
    private double price;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Goods(String id,String name, double price) {
        this.name = name;
        this.price = price;
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("[%2s]:%s:%.2f\n",this.getId(),this.getName(),this.getPrice());
    }
}
