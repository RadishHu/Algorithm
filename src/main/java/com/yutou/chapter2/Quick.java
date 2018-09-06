package com.yutou.chapter2;

import edu.princeton.cs.algs4.StdOut;

/**
 * 快速排序
 */
public class Quick {

    /**
     *
     * @param a 要排序的数组
     * @param start 数组开始的索引
     * @param end 数组结束的索引
     */
    public static void sort(Comparable[] a, int start, int end) {

        if (start >= end) return;

        int i = start; //开始的指针
        int j = end;   //结尾的指针

        Comparable split = a[start]; //用于切分的元素

        while (i < j) {

            while (i < j && a[j].compareTo(split) >= 0) j--;
            if (i < j) a[i++] = a[j];

            while (i < j && a[i].compareTo(split) < 0) i++;
            if (i < j) a[j--] = a[i];
        }
        a[i] = split;

        sort(a,start,i-1);
        sort(a,i+1,end);
    }

    /**
     * 单行中打印数组
     * @param a
     */
    private static void show(Comparable[] a) {

        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }


    public static void main(String[] args) {
        Comparable<Integer>[] arr = new Integer[]{3,1,54,23,54,12,543,98,0};
        sort(arr,0,arr.length - 1);
        show(arr);
    }
}
