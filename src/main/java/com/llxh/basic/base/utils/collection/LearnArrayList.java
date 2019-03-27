package com.llxh.basic.base.utils.collection;

import java.util.*;

public class LearnArrayList {

    LinkedList<Integer> linkedList = new LinkedList<>();
    private Vector<Integer> integerVector = new Vector<>();
    private List<Integer> integerList = new ArrayList<>();

    /**
     *
     * @param args  ss
     * @throws InterruptedException ss
     */
    public static void main(String[] args) throws InterruptedException {
        LearnArrayList learnArrayList = new LearnArrayList();
        Thread threadA = new Thread(()->{
           for (int i=1;i<=10;i++){
//               learnArrayList.linkedList.add(i);
               learnArrayList.integerList.add(i);
               learnArrayList.integerVector.add(i);
           }
        });
        Thread threadB = new Thread(()->{
            for (int i=11;i<=20;i++){
//                learnArrayList.linkedList.add(i);
                learnArrayList.integerList.add(i);
                learnArrayList.integerVector.add(i);
            }
        });
        Thread threadC = new Thread(()->{
            for (int i=21;i<=30;i++){
//                learnArrayList.linkedList.add(i);
                learnArrayList.integerList.add(i);
                learnArrayList.integerVector.add(i);
            }
        });
        threadA.start();
        threadB.start();
        threadC.start();
        threadB.join();
        learnArrayList.integerVector.forEach(integer -> System.out.print(integer+","));
        System.out.println();
        learnArrayList.integerList.forEach(integer -> System.out.print(integer+","));
        System.out.println();
//        learnArrayList.linkedList.forEach(integer -> System.out.print(integer+","));
    }
}
