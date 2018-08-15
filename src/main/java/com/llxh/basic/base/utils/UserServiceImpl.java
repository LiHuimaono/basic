package com.llxh.basic.base.utils;

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
