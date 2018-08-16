package com.llxh.basic.base.utils;

import org.hibernate.boot.jaxb.SourceType;

import javax.tools.OptionChecker;
import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.Collector;

public class StreamLearn {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        List<User> users = getName(cyclicBarrier,new User());
        cyclicBarrier.await();

        System.out.println(users.size());
        users.clear();
        cyclicBarrier.reset();
        users = getName(cyclicBarrier,new User());
        cyclicBarrier.await();
        System.out.println(users.size());
        /*Collections.sort(users,(user1,user2)->{
            return user1.getUserAge().compareTo(user2.getUserAge());
        });*/
//        users.stream().forEach(user -> System.out.println(user.getUserAge()));


    }
    private static List<User> getName(CyclicBarrier cyclicBarrier,User user)throws InterruptedException,BrokenBarrierException{

        List<User> users = new LinkedList<>();
        user.setUserAge(80);
        users.add(user);
        new Thread(()-> {
                for (int i=0;i<100000;i++){
                    User user1 = new User();
                    user1.setUserAge(79);
                    users.add(user1);
                }
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException|BrokenBarrierException e) {
                    e.printStackTrace();
                }
        }).start();
        new Thread(()->{
            for (int i=0;i<100000;i++){
                User user1 = new User();
                user1.setUserAge(66);
                users.add(user1);
            }
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        return users;
    }
}
