package com.llxh.basic.base.utils.sort;

import java.util.Arrays;
import java.util.Random;

public class MergerSortDemo {
    public static void main(String[] args) {
        int [] nums = new int[10];
        Random random = new Random();
        for (int i=0;i<10;i++){
            nums[i] = random.nextInt(500);
        }
        Arrays.stream(nums).forEach(s-> System.out.print(s+","));
        sort(nums,0,nums.length-1);
        System.out.println();
        Arrays.stream(nums).forEach(s-> System.out.print(s+","));

    }
    private static void sort(int []nums,int low, int high){
        int mid = (low+high)/2;
        if (low<high){
            sort(nums,low,mid);
            sort(nums,mid+1,high);
            merger(nums,low,mid,high);
        }
    }
    private static void merger(int[] nums,int low,int mid,int high){
        int [] temp = new int[high-low+1];
        int i =low;
        int j = mid+1;
        int k = 0;

        while (i<=mid&&j<=high){
            if (nums[i] < nums[j]){
                temp[k++] = nums[i++];
            }else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid){
            temp[k++] = nums[i++];
        }
        while (j <= high){
            temp[k++] = nums[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            nums[k2 + low] = temp[k2];
        }
    }
}
