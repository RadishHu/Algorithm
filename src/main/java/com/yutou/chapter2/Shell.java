package com.yutou.chapter2;

import edu.princeton.cs.algs4.StdOut;

/**
 * 希尔排序
 */
public class Shell {

    /**
     * 对数组进行排序
     * @param a
     */
    public static void sort(Comparable[] a) {

        int N = a.length;
        int h = 1;
        while (h < N/3) h = h * 3 + 1;

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && a[j].compareTo(a[j-h]) < 0; j -= h) {
                    Comparable t = a[j];
                    a[j] = a[j-h];
                    a[j-h] = t;
                }
            }
            h /= 3;
        }
    }

    /**
     * 对元素进行比较
     * @param v
     * @param w
     * @return
     */
    private static boolean less(Comparable v,Comparable w) {

        return v.compareTo(w) < 0;
    }

    /**
     * 交换数组中两个元素
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Comparable[] a,int i,int j) {

        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
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

    /**
     * 检测数组元素是否排序
     * @param a
     * @return
     */
    private static boolean isSorted(Comparable[] a) {

        for (int i = 1; i < a.length; i++) {
            if (less(a[i],a[i - 1])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Comparable<Integer>[] arr = new Integer[]{10,9,8,7,6,5,4,3,2,1,0};
        sort(arr);
        show(arr);
    }
}
