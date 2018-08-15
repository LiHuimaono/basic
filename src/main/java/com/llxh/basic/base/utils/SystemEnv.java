package com.llxh.basic.base.utils;

import java.util.Map;
import java.util.Properties;

public class SystemEnv {
    public static void main(String[] args) {
        String map = System.getenv("JAVA_HOME");
        Properties p = System.getProperties();
        System.out.println(System.getenv("url1"));
        System.out.println(map);
       /* map.entrySet().stream().forEach(s ->{
            System.out.println(s.getKey()+":"+s.getValue());
        });*/
    }
}
