package com.yutou.chapter2;

import edu.princeton.cs.algs4.StdOut;

/**
 * 选择排序
 */
public class Selection {
    /**
     * 对数组进行排序,升序
     * @param a
     */
    public static void sort(Comparable[] a) {

        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].compareTo(a[min]) < 0) min = j;
            }

            Comparable t = a[i];
            a[i] = a[min];
            a[min] = t;
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

        Comparable<Integer>[] arr = new Integer[]{3,1,54,23,54,12,543,98};
        sort(arr);
        show(arr);
    }
}
