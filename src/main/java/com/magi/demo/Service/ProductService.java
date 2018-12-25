package com.magi.demo.Service;

import com.magi.demo.Model.Product;

import java.util.List;

public interface ProductService {

    // 产品注册
    int addProduct(Product product);

    // 产品查询
    List<Product> getProducts();
}
