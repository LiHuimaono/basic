package com.llxh.basic.base.utils.thread.lazysingle;

import java.util.ArrayList;
import java.util.List;

/**
 * 懒汉
 * synchronized版本单例
 */
public class SyncSingle {
    private List<String> list = new ArrayList<>(10);
    private static SyncSingle syncSingle;
    private SyncSingle(){}
    public static synchronized SyncSingle getInstance(){
        if (syncSingle == null){
                syncSingle = new SyncSingle();
        }
        return syncSingle;
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
