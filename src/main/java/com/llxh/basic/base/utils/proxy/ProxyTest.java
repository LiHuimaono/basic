package com.llxh.basic.base.utils.proxy;

import com.llxh.basic.base.utils.proxy.UserServiceImpl;
import com.llxh.basic.base.utils.proxy.UserServiceProxy;

public class ProxyTest {
    public static void main(String[] args) {
        UserServiceProxy userServiceProxy = new UserServiceProxy(new UserServiceImpl());
        userServiceProxy.sayHello("lh");
    }
}
