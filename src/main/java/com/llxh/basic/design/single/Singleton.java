package com.llxh.basic.design.single;

public class Singleton {
    private static Singleton uniqueInstance;

    private static Singleton uniqueInstance1 = new Singleton();

    private Singleton() {
    }
    public static Singleton getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

    public static synchronized Singleton getUniqueInstance1() {
        if (uniqueInstance1 == null) {
            uniqueInstance1 = new Singleton();
        }
        return uniqueInstance1;
    }
}
