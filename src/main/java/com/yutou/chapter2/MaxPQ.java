package com.yutou.chapter2;

/**
 * 优先队列
 */
public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N = 0;

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN];
    }

    public boolean isEmpty() {return N==0;}

    public int size() {return N;}

    public void insert(Key v) {
        pq[++N] = v;

        swim(N);
    }

    public Key delMax() {
        Key max = pq[1];
        pq[1] = pq[N--];
        pq[N+1] = null;

        sink(1);
        return max;
    }

    /**
     * 数组元素上浮
     * @param k 要上浮元素的索引
     */
    public void swim(int k) {

        while (k > 1 && pq[k].compareTo(pq[k/2]) > 0) {
            Key t = pq[k];
            pq[k] = pq[k/2];
            pq[k/2] = t;
            k = k / 2;
        }
    }

    public void sink(int k) {

        while (k*2 <= N) {
            int j = k * 2;
            if (j < N && pq[j].compareTo(pq[j+1]) < 0) j++;
            if (pq[k].compareTo(pq[j]) > 0) break;

            Key t = pq[k];
            pq[k] = pq[j];
            pq[j] =  t;
            k = j;
        }
    }
}

