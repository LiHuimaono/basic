package com.llxh.basic.base.utils.thread.lazysingle;

import java.util.ArrayList;
import java.util.List;

/**
 * 懒汉
 * 双检机制单例
 */
public class DoubleCheckSingle {
    private List<String> list = new ArrayList<>(10);
    private static DoubleCheckSingle instance;
    private DoubleCheckSingle(){}
    public static DoubleCheckSingle getInstance(){
        if (instance == null){
            synchronized (DoubleCheckSingle.class){
                if (instance == null){
                    instance = new DoubleCheckSingle();
                }
            }
        }
        return instance;
    }
    public synchronized void listAdd(){
        System.out.println("list增加元素开始");
        for (int i=0;i<10;i++){
            list.add("lh"+i);
        }
        System.out.println("list增加元素结束");
    }
    public synchronized void outList(){
        for (String s:list
                ) {
            System.out.println(s);
        }
    }
}
