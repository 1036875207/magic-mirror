package com.magi.demo.Controller;
import com.magi.demo.Service.ProductService;
import com.magi.demo.Service.UserService;
import com.magi.demo.Model.User;
import com.magi.demo.Utils.Resful;
import com.magi.demo.Utils.myUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    private myUtil util = new myUtil();

    @RequestMapping("/user")
    String home() {
        return "Hello User!";
    }


    @RequestMapping(value = "/addUser", method = POST)
    public Resful addUser(@RequestParam(name = "username")String username, @RequestParam(name = "password")String password, @RequestParam(name = "age")Integer age, @RequestParam(name = "gender")String gender, @RequestParam(name = "country")String country) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setGender(util.genderTranslate(gender));
        user.setCountry(country);
        user.setAge(age);
        return util.getResful(userService.addUser(user));
    }

    @RequestMapping(value = "/login", method = POST)
    public Resful login(@RequestParam(name = "username")String username, @RequestParam(name = "password")String password, HttpServletRequest request) {
        User user = userService.login(username, password);
        request.getSession().setAttribute("userId", user.getId());
        return util.getResful(user);
    }

    @RequestMapping("/current")
    public Resful getUser(HttpServletRequest request,HttpServletResponse response) {
        return util.getResful(util.getCurrentUser());
    }

    @RequestMapping("/getProducts")
    public Resful getProducts() {

        return util.getResful(productService.getProducts());
    }
}
