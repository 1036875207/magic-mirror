package com.magi.demo.Service;
import com.magi.demo.Model.Product;
import com.magi.demo.Model.User;
import com.magi.demo.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements  UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
        // System.out.println(userMapper.insertSelective(user));
    }

    @Override
    public User getCurrentUser(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User login(String username,String password) {
        return userMapper.login(username, password);
    }

}
