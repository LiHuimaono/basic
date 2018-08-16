package com.llxh.basic.base.utils.proxy;

public class UserServiceProxy implements UserService {
    private UserServiceImpl userService;
    UserServiceProxy(UserServiceImpl userService){
        this.userService = userService;
    }
    @Override
    public void sayHello(String name) {
        System.out.println("before log..............");
        userService.sayHello(name);
        System.out.println("end log ...该方法执行了10毫秒");
    }
}
