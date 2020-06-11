package com.jit.chapter05.daomain;

public class Item {
    private String id;
    private Product product;
    private int number = 1;
    private double sunMoney; //总金额

    public Item(String id, Product product) {
        this.id = id;
        this.product = product;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getSunMoney() {
        return this.product.getPrice()*this.number;
    }

    public void addProduct(){
        this.number++;
    }
}
