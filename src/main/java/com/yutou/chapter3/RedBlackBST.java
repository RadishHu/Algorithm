package com.yutou.chapter3;

/**
 * 红黑树
 */
public class RedBlackBST <Key extends Comparable<Key>,Value>{

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node {

        Key key;
        Value value;
        Node left;
        Node right;
        int N;
        boolean color;

        Node(Key key, Value value, int N, boolean color) {
            this.key = key;
            this.value = value;
            this.N = N;
            this.color = color;
        }
    }

    private boolean isRed(Node h) {

        if (h == null) return false;
        return h.color == RED;
    }

    /**
     * 左旋转
     * @param h
     * @return
     */
    private Node rotateLeft(Node h) {

        Node x = h.right;
        h.right = x.left;
        x.left = h;

        x.color = h.color;
        h.color = RED;

        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.left);

        return x;
    }

    /**
     * 右旋转
     * @param h
     * @return
     */
    private Node rotateRight(Node h) {

        Node x = h.left;
        h.left = x.right;
        x.right = h;

        x.color = h.color;
        h.color = RED;

        x.N = h.N;
        h.N = 1 + size(h.right) + size(h.left);
        return x;
    }

    /**
     * 颜色转换
     * @param h
     */
    private void flipColors(Node h) {

        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    private int size(Node h) {
        return h.N;
    }

    /**
     * 添加元素
     * @param h
     * @param key
     * @param value
     * @return
     */
    private Node put(Node h, Key key, Value value) {

        if (h == null) {
            return new Node(key,value,1,RED);
        }

        int com = key.compareTo(h.key);

        if (com < 0) h.left = put(h.left,key,value);
        else if (com > 0) h.right = put(h.right,key,value);
        else h.value = value;

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        h.N = size(h.left) + size(h.left) + 1;
        return h;
    }
}
