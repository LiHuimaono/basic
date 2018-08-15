package com.llxh.basic.base.utils;

public class ProxyTest {
    public static void main(String[] args) {
        UserServiceProxy userServiceProxy = new UserServiceProxy(new UserServiceImpl());
        userServiceProxy.sayHello("lh");
    }
}
