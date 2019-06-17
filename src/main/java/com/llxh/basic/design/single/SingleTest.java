package com.llxh.basic.design.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingleTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Singleton singleton = Singleton.getUniqueInstance();
        Class c = Class.forName("com.llxh.basic.design.single.Singleton");
        Constructor constructor =  c.getDeclaredConstructor();
        Singleton singleton1 = (Singleton) c.newInstance();
        constructor.setAccessible(true);
        Singleton singleton2 = (Singleton) constructor.newInstance();

    }
}
