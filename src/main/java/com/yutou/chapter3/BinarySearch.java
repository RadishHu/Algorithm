package com.yutou.chapter3;

/**
 * 二分查找，基于有序数组
 */
public class BinarySearch<Key extends Comparable<Key>,Value> {

    private Key[] keys;
    private Value[] values;
    private int N;

    public BinarySearch(int capacity) {

        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) return values[i];
        else return null;
    }

    public void put(Key key,Value value) {
        int i = rank(key,0,N-1);
        if (i < N && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }

        for (int j = N; j > i; j--) {
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }


    public int rank(Key key,int start,int end) {
        if (end < start) return end;

        int mid = start + (end -start) / 2;

        int com = key.compareTo(keys[mid]);
        if (com < 0) return rank(key,start,mid - 1);
        else if (com > 0) return rank(key,mid + 1,end);
        else return mid;
    }

    public int rank(Key key) {
        int start = 0;
        int end = keys.length;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (key.compareTo(keys[mid]) < 0) end = mid - 1;
            else if (key.compareTo(keys[mid]) > 0) start = mid + 1;
            else return mid;
        }

        return end;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public Key min() { return keys[0];}

    public Key max() { return keys[N-1];}

    public Key select(int k) { return keys[k];};
}
