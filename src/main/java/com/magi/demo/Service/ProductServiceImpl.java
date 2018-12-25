package com.magi.demo.Service;

import com.magi.demo.Mapper.ProductMapper;
import com.magi.demo.Mapper.RegisterMapper;
import com.magi.demo.Model.Product;
import com.magi.demo.Model.User;
import com.magi.demo.Utils.myUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private RegisterMapper registerMapper;

    private myUtil util = new myUtil();

    @Override
    public int addProduct(Product product) {
        return productMapper.insert(product);
    }

    @Override
    public List<Product> getProducts() {
        User user = util.getCurrentUser();
        // registerMapper.selectByUserId(user.getId());
        return productMapper.selectByUserId(user.getId());
    }
}
