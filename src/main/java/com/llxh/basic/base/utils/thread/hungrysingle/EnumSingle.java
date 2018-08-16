package com.llxh.basic.base.utils.thread.hungrysingle;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
import java.util.List;

/**
 * 饿汉
 * 枚举单例
 */
public enum EnumSingle {
    SINGLE;
    private List<String > list = new ArrayList<>(10);;

    public synchronized void listAdd(){
        System.out.println("list增加元素开始");
        for (int i=0;i<10;i++){
            list.add("lh"+i);
        }
        System.out.println("list增加元素结束");
    }
    public synchronized void outList(){
        for (String s:list) {
            System.out.println(s);
        }
    }

}
