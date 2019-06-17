package com.llxh.basic.design.single;

public enum EnumSingleton {
    INSTANCE;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        EnumSingleton first = EnumSingleton.INSTANCE;
        first.setName("first");
        System.out.println(first.getName());
    }
}
