package com.yutou.chapter2;

import edu.princeton.cs.algs4.StdOut;

/**
 * 自顶向下的归并排序
 */
public class Merge {

    private static Comparable[] temp;

    public static void sort(Comparable[] a) {

        temp = new Comparable[a.length];
        sort(a,0,a.length-1);
    }

    public static void sort(Comparable[] a, int start, int end) {

        if (start >= end) return;

        int mid = start + (end - start) / 2;
        sort(a,start,mid);
        sort(a,mid + 1,end);

        //合并数组
        for (int i = 0; i < a.length; i++) temp[i] = a[i];

        int i = start;
        int j = mid + 1;
        for (int k = start; k <= end; k++) {
            if (i > mid) a[k] = temp[j++];
            else if (j > end) a[k] = temp[i++];
            else if (temp[j].compareTo(temp[i]) < 0) a[k] = temp[j++];
            else a[k] = temp[i++];
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
