package com.llxh.basic.base.utils.sort;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

public class SortDemo {
    public static void main(String[] args) {
        int [] a = {45,45,3,56,6,32,15};
//        insertSort(a);
//        Arrays.stream(a).forEach(s -> System.out.print(s+","));
        sheelSort(a);
        System.out.println();
        Arrays.stream(a).forEach(s-> System.out.print(s+","));
    }

    /**
     * 插入排序，
     * 在要排序的一组数中，假设前面(n-1) [n>=2] 个数已经是排好顺序的，
     * 现在要把第n个数插到前面的有序数中，使得这n个数也是排好顺序的。
     * 如此反复循环，直到全部排好顺序。
     * 首先设定插入次数，即循环次数，for(int i=1;i<length;i++)，1个数的那次不用插入。
     * 设定插入数和得到已经排好序列的最后一个数的位数。insertNum和j=i-1。
     * 从最后一个数开始向前循环，如果插入数小于当前数，就将当前数向后移动一位。
     * 将当前数放置到空着的位置，即j+1.
     */
    public static void insertSort(int [] a){
        int len = a.length;
        int insertNum;
        for (int i = 1;i<len;i++){
            insertNum = a[i];
            int j = i-1;
            while (j>=0&&a[j]>insertNum){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = insertNum;
        }
    }
    private static void sheelSort(int [] a){
        int len = a.length;
        while (len!=0){
            len = len/2;
            for(int i = 0;i<len;i++){
                for(int j = i+len;j<a.length;j+=len){
                    int k = j-len;
                    int tmp = a[j];
                    while (k>=0 && tmp<a[k]){
                        a[k+len] = a[k];
                        k-=len;
                    }
                    a[k+len] = tmp;
                }
            }
        }
    }
}
