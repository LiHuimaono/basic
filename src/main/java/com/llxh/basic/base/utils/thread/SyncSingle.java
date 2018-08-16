package com.llxh.basic.base.utils.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * synchronized版本单例
 */
class SyncSingle {
    private List<String> list = new ArrayList<>(10);
    private static SyncSingle syncSingle;
    private SyncSingle(){}
    static synchronized SyncSingle getInstance(){
        if (syncSingle == null){
                syncSingle = new SyncSingle();
        }
        return syncSingle;
    }
    synchronized void listAdd(){
        System.out.println("list增加元素开始");
        for (int i=0;i<10;i++){
            list.add("lh"+i);
        }
        System.out.println("list增加元素结束");
    }
    synchronized void outList(){
        for (String s:list
             ) {
            System.out.println(s);
        }
    }
}
