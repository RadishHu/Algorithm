package com.yutou.chapter1;

/**
 * 欧几里德算法
 * 计算非负整数最大公约数
 */
public class EuclideanAlgorithm {

    public static int gcb(int p,int q) {
        if (q == 0) return p;
        int r = p % q;
        return gcb(q,r);
    }



    public static void main(String[] args) {
        System.out.println(gcb(101,77));
    }
}
