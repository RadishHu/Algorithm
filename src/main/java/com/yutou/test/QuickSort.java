package com.yutou.test;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {
    public static void sort(int[] arr, int start, int end) {

        if (start >= end) return;

        int i = start;
        int j = end;
        int sp = arr[i];

        while (i < j) {
            while (i < j && arr[j] > sp) {
                j--;
            }
            if (i < j) arr[i++] = arr[j];

            while (i < j && arr[i] <= sp) {
                i++;
            }
            if (i < j) arr[j--] = arr[i];
        }

        arr[i] = sp;

        sort(arr,start,j-1);
        sort(arr,j + 1,end);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,3,2,1,0};
        sort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
