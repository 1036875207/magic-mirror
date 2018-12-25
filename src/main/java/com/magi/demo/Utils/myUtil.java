package com.magi.demo.Utils;

import com.magi.demo.Model.User;
import com.magi.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class myUtil {

    @Autowired
    private UserService userService;
    // 获取当前已登入对象
    public User getCurrentUser() {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        //已经拿到session,就可以拿到session中保存的用户信息了。
        try {
            int id = (int)request.getSession().getAttribute("userId");
            return userService.getCurrentUser(id);
        } catch (Exception e) {
            return userService.getCurrentUser(1);
        }
    }

    // 性别转换函数
    public int genderTranslate(String gender) {
        if (gender.equals('男')) {
            return 0;
        } else if (gender.equals(('女'))){
            return 1;
        }
        try {
            return Integer.parseInt(gender);
        } catch (Exception e) {
            return 0;
        }
    }

    public String genderTranslate(int gender) {
        String[] gArray = {"男", "女"};
        return gArray[gender];
    }

    public byte[] intToByte(int val){
        byte[] b = new byte[4];
        b[0] = (byte)(val & 0xff);
        b[1] = (byte)((val >> 8) & 0xff);
        b[2] = (byte)((val >> 16) & 0xff);
        b[3] = (byte)((val >> 24) & 0xff);
        return b;
    }

    // resful 接口封装
    public Resful getResful(int data) {
        Resful res = new Resful();
        if (data == 0) {
            res.setCode(400);
            res.setData(data);
            res.setMessage("DataSet Operation Error");
        } else {
            res.setCode(200);
            res.setData(data);
            res.setMessage("SUCCESS");
        }
        return res;
    }

    public Resful getResful(Object user) {
        Resful res = new Resful();
        if (user == null) {
            res.setCode(400);
            res.setData("");
            res.setMessage("DataSet Operation Error");
        } else {
            res.setCode(200);
            res.setData(user);
            res.setMessage("SUCCESS");
        }
        return  res;
    }
}
