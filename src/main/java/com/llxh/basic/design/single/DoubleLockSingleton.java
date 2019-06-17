package com.llxh.basic.design.single;

public class DoubleLockSingleton {
    private DoubleLockSingleton() {
    }

    private volatile static DoubleLockSingleton INSTANCE;

    public static DoubleLockSingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (DoubleLockSingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DoubleLockSingleton();
                }
            }
        }
        return INSTANCE;
    }

}
