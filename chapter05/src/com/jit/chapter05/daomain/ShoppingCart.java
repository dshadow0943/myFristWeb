package com.jit.chapter05.daomain;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List<Item> items = new ArrayList<Item>();

    public List<Item> getItems() {
        return items;
    }

    public double getTotalSumMoney() {
        double totalSumMoney = 0;
        for (Item item:this.getItems()){
            totalSumMoney += item.getSunMoney();
        }
        return totalSumMoney;
    }

    public void addCart(Product product){
        boolean flag = false;
        for (Item item:this.getItems()){
            if (item.getProduct().getId().equals(product.getId())){
                item.addProduct();
                flag = true;
                break;
            }
        }
        if (flag == false){
            items.add(new Item(product.getId()+"1", product));
        }
    }

    public void removeCart(String id){
        for (Item item:this.items){
            if (item.getId().equals(id)){
                System.out.println("mid="+item.getId());
                this.items.remove(item);
                break;
            }
        }
    }

    public void removeCart(Product product){
        for (Item item:items){
            if (item.getProduct().getId().equals(product.getId())){
                this.items.remove(item);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "items=" + items +
                '}';
    }
}
