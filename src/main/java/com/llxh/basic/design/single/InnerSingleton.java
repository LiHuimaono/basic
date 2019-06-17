package com.llxh.basic.design.single;

public class InnerSingleton {

    private InnerSingleton() {}

    private static class SingleHolder {
        private static final InnerSingleton INSTANCE = new InnerSingleton();
    }

    public static InnerSingleton getInstance() {
        return SingleHolder.INSTANCE;
    }
}
