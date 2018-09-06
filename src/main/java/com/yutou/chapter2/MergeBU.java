package com.yutou.chapter2;

import edu.princeton.cs.algs4.StdOut;

public class MergeBU {
    private static Comparable[] temp;

    public static void sort(Comparable[] a) {

        temp = new Comparable[a.length];

        for (int sz = 1; sz < a.length; sz *= 2) {
            for (int start = 0; start < a.length - sz; start += sz * 2) {
                int mid = start + sz - 1;
                int end = Math.min(start + sz * 2 - 1,a.length - 1);

                int i = start;
                int j = mid + 1;

                for (int k = 0; k < a.length; k++) temp[k] = a[k];
                for (int k = start; k <= end; k++) {
                    if (i > mid) a[k] = temp[j++];
                    else if (j > end) a[k] = temp[i++];
                    else if (a[j].compareTo(a[i]) < 0) a[k] = temp[j++];
                    else a[k] = temp[i++];
                }
            }
        }
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
        sort(arr);
        show(arr);
    }
}
