package com.llxh.basic.base.utils.proxy.staticproxy;

public class UserServiceProxy implements UserService {
    private UserServiceImpl userService;
    UserServiceProxy(UserServiceImpl userService){
        this.userService = userService;
    }
    @Override
    public void sayHello(String name) {
        System.out.println("before log..............");
        userService.sayHello(name);
        System.out.println("end log ...该方法执行花费1秒时间");
    }
}
