package com.yutou.chapter2;

import java.util.Arrays;

/**
 * 冒泡排序,升序
 */
public class BubbleSort {

    public static void sort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 -i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[]{4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
