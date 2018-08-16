package com.llxh.basic.base.utils.thread;

import com.llxh.basic.base.utils.thread.hungrysingle.EnumSingle;
import com.llxh.basic.base.utils.thread.hungrysingle.InnerClassSingle;
import com.llxh.basic.base.utils.thread.lazysingle.DoubleCheckSingle;
import com.llxh.basic.base.utils.thread.lazysingle.SyncSingle;

import javax.sound.midi.Soundbank;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
//        syncSingleTest();
//        doubleCheckSingleTest();
//        innerClassSingleTest();
        enumSingleTest();
    }
    private static void syncSingleTest() throws InterruptedException {
        Thread A = new Thread(()->{
            SyncSingle syncSingle = SyncSingle.getInstance();
            System.out.println("A"+syncSingle.toString());
            syncSingle.listAdd();
        });
        Thread B = new Thread(()->{
            SyncSingle syncSingle = SyncSingle.getInstance();
            System.out.println("B"+syncSingle.toString());
            syncSingle.outList();
        });
        A.start();
        A.join();
        B.start();
    }
    private static void doubleCheckSingleTest() throws InterruptedException {
        Thread threadA = new Thread(()->{
            DoubleCheckSingle doubleCheckSingle = DoubleCheckSingle.getInstance();
            System.out.println(doubleCheckSingle.toString());
            doubleCheckSingle.listAdd();
        });
        Thread threadB = new Thread(()->{
           DoubleCheckSingle doubleCheckSingle = DoubleCheckSingle.getInstance();
            System.out.println(doubleCheckSingle.toString());
            doubleCheckSingle.outList();
        });
        threadA.start();
        threadA.join();
        threadB.start();
    }
    private static void innerClassSingleTest() throws InterruptedException {
        Thread threadA = new Thread(()->{
            InnerClassSingle innerClassSingle = InnerClassSingle.getInstance();
            System.out.println(innerClassSingle.toString());
            innerClassSingle.listAdd();
        });
        Thread threadB = new Thread(()->{
           InnerClassSingle innerClassSingle = InnerClassSingle.getInstance();
            System.out.println(innerClassSingle.toString());
            innerClassSingle.outList();
        });
        threadA.start();
        threadA.join();
        threadB.start();
    }
    private static void enumSingleTest() throws InterruptedException {
        Thread threadA = new Thread(()->{
            EnumSingle single = EnumSingle.SINGLE;
            System.out.println(single.toString());
            single.listAdd();
        });
        Thread threadB = new Thread(()->{
            EnumSingle single = EnumSingle.SINGLE;
            System.out.println(single.toString());
            single.outList();
        });
        threadA.start();
        threadA.join();
        threadB.start();
    }
}
