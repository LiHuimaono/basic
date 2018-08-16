package com.llxh.basic.base.utils.proxy.staticproxy;

public class UserServiceImpl implements UserService {
    public void sayHello(String name){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello"+name);
    }
}
