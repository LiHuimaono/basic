package com.llxh.basic.base.utils.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSortDemo {
    public static void main(String[] args) {
        int [] a = new int[15];
        Random r = new Random();
        for (int i = 0;i<15;i++){
            a[i] = r.nextInt(100);
        }
        Arrays.stream(a)
                .forEach(s-> System.out.print(s+","));
        System.out.println();
        quickSort(a,0,a.length-1);
        Arrays.stream(a)
         .forEach(s-> System.out.print(s+","));
    }

    /**
     * 递归调用，第一次查到中间坐标之后，然后递归调用函数分别对中间下标两边的数值进行排序
     * @param a 待排序的数组
     * @param low 开始下标
     * @param high 结束下标
     */
    private static void quickSort(int [] a,int low,int high){
        if (low<high){
            int middle = getMiddle(a,low,high);
            quickSort(a,low,middle-1);
            quickSort(a,middle+1,high);
        }
    }

    /**
     * 根据low下标所代表的值，把数组分成两部分，然后返回low下标的值重新排列之后的下标
     * @param a 待排序的数组
     * @param low 开始下标
     * @param high 结束下标
     * @return 返回排序后的中间值的下标
     */
    private static int getMiddle(int []a,int low,int high){
        int temp = a[low];
        while (low < high){
            while (low < high && a[high] >= temp)
            {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] <= temp)
            {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = temp;
        return low;
    }
}
