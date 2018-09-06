package com.yutou.chapter2;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

/**
 * 优先队列的使用实例
 */
public class TestTopM {

    public static void main(String[] args) {

        int size = 6;
        MinPQ pq = new MinPQ(size);
        int[] arr = new int[]{32,54,23,12,33,53,54,64,87,46,12};

        for (int i = 0; i < arr.length; i++) {
            pq.insert(arr[i]);
            if (pq.size() > size) pq.delMin();
        }

        Stack stack = new Stack();
        while (!pq.isEmpty()) stack.push(pq.delMin());
        stack.forEach(t -> StdOut.println(t));
        /*for (Object i : stack) {
            System.out.println(Integer.parseInt(i.toString()));
        }*/
    }
}
