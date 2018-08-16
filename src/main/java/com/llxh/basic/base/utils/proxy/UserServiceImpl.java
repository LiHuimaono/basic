package com.llxh.basic.base.utils.proxy;

import com.llxh.basic.base.utils.proxy.UserService;

public class UserServiceImpl implements UserService {
    public void sayHello(String name){
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello"+name);
    }
}
