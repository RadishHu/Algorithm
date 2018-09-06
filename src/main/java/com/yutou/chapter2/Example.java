package com.yutou.chapter2;

import edu.princeton.cs.algs4.StdOut;

/**
 * 排序算法的模板
 */
public class Example {

    /**
     * 对数组进行排序
     * @param a
     */
    public static void sort(Comparable[] a) {

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

    /**
     * 合并数组的两个部分，将a[lo,mid] 与 a[mid+1,hi]合并
     * @param a
     * @param lo
     * @param mid
     * @param hi
     */
    private static void merge(Comparable[] a, int lo, int mid, int hi) {

        int i = lo;
        int j = mid + 1;
        Comparable[] aux = new Comparable[a.length];

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (aux[j].compareTo(aux[i]) < 0) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    public static void main(String[] args) {

        Comparable<Integer>[] arr = new Integer[]{3,1,54,23,54,12,543,98,0};
        sort(arr);
        show(arr);
    }
}
