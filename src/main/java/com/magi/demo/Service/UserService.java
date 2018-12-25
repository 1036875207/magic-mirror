package com.magi.demo.Service;

import com.magi.demo.Model.Config;
import com.magi.demo.Model.Product;
import com.magi.demo.Model.User;

import java.util.List;

public interface UserService { 
    int addUser(User user);

    User getCurrentUser(int id);

//    List<Product> getCurrentProduct(int id);
//
//    Config getCurrentConfig(int id);

    User login(String username, String password);
}
