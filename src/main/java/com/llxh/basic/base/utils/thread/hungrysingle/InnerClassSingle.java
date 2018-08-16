package com.llxh.basic.base.utils.thread.hungrysingle;

import java.util.ArrayList;
import java.util.List;

/**
 * 饿汉
 * 内部类单例
 */
public class InnerClassSingle {
    private InnerClassSingle(){}
    private static class innerSingle{
        private static InnerClassSingle INSTANCE = new InnerClassSingle();
    }
    public static final InnerClassSingle getInstance(){
        return innerSingle.INSTANCE;
    }
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
