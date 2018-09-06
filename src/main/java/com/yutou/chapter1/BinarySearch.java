package com.yutou.chapter1;

import java.util.Arrays;

/**
 * 二分法查找
 */
public class BinarySearch {

    /**
     * 从数组中查找指定的数字，如果存在，返回索引，不存在返回-1
     * @param key 需要查找的数字
     * @param arr 从中查找的数组，要求数组已经进行生序排列
     * @return 如果数组中存在
     */
    public static int rank(int key,int[] arr) {

        int start = 0;
        int end = arr.length -1;

        while(start <= end) {
            int mid = start + (end - start)/2;
            if (key < arr[mid]) end = mid -1;
            else if (key > arr[mid]) start = mid + 1;
            else return mid;
        }
        return -1;
    }

    /**
     * 二分法递归实现
     */
    public static int rank2(int key,int[] arr) {

        return rank2(key,arr,0,arr.length-1);
    }

    public static int rank2(int key,int[] arr,int start,int end) {

        if (start > end) return -1;

        int mid = (end - start) / 2 + start;

        if (key < arr[mid]) return rank2(key,arr,start,mid -1);
        else if (key > arr[mid]) return rank2(key,arr,mid + 1,end);
        else return mid;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{10,5,3,4};
        Arrays.sort(arr);
        System.out.println(rank(2,arr));
        System.out.println(rank2(2,arr));
    }
}
