package com.jit.chapter05.dao;

import com.jit.chapter05.daomain.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private static List<Product> list = new ArrayList<Product>();
    static {
        list.add(new Product("10001", "CAD二次开发教程", "CAD.jpg", 298, "学习之路"));
        list.add(new Product("10002", "Lua编程实战视频教程", "Lua.jpg", 36.6, "学习之路"));
        list.add(new Product("10003", "vb视频教程", "vb.jpg", 55.00, "学习之路"));
        list.add(new Product("10004", "WPF MVVM编程模式", "WPF-MVVM.jpg", 13.86, "学习之路"));
        list.add(new Product("10005", "中学生c++编程", "c++.jpg", 399.00, "学习之路"));
        list.add(new Product("10006", "少儿趣味编程教学", "sr.jpg", 199.00, "学习之路"));
        list.add(new Product("10007", "编程爱好者学python之快速入门", "python.jpg", 9.9, "学习之路"));
    }

    public List<Product> findAll(){
        return list;
    }

    public Product findById(String id){
        Product product = null;
        for (Product p:list){
            if (p.getId().equals(id)){
                product = p;
                break;
            }
        }
        return product;
    }
}
