package com.llxh.basic.base.utils.thread;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        syncSingleTest();
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
    private static void doubleCheckSingleTest(){

    }
}
