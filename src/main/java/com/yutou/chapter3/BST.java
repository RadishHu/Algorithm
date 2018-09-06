package com.yutou.chapter3;

/**
 * 二叉查找树
 */
public class BST<Key extends Comparable<Key>,Value> {

    private Node root;

    private class Node {

        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private int N;

        public Node(Key key,Value value,int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    /**
     * 返回某个节点包含节点的数量
     * @param x
     * @return
     */
    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    /**
     * 返回二叉查找树的节点数量
     * @return
     */
    public int size() {
        return size(root);
    }

    /**
     * 根据key进行查找
     * @param x
     * @param key
     * @return
     */
    private Value get(Node x, Key key) {
        if (x == null) return null;
        int com = key.compareTo(x.key);

        if (com > 0) return get(x.right,key);
        else if (com < 0) return get(x.left,key);
        else return x.value;
    }

    public Value get(Key key) {
        return get(root,key);
    }

    private Node put(Node x,Key key,Value value) {
        if (x == null) return new Node(key,value,1);
        int com = key.compareTo(x.key);
        if (com < 0) x.left = put(x.left,key,value);
        else if (com > 0) x.right = put(x.right,key,value);
        else x.value = value;

        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void put(Key key,Value value) {
        root = put(root,key,value);
    }

    /**
     * 查找最小的节点
     * @param x
     * @return
     */
    private Node min(Node x) {
        if (x.left == null) return x;
        else return min(x.left);
    }

    public Key min() {
        return min(root).key;
    }

    /**
     * 向上取整
     * @param x
     * @param key
     * @return
     */
    private Node floor(Node x,Key key) {
        if (x == null) return null;
        int com = key.compareTo(x.key);
        if (com == 0) return x;
        else if (com < 0) return floor(x.left,key);
        Node t = floor(x.right,key);
        if (t == null) return x;
        else return t;
    }

    public Key floor(Key key) {
        Node x = floor(root,key);
        if (x == null) return null;
        else return x.key;
    }

    /**
     * 删除最小的值
     * @param x
     * @return
     */
    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.right) + size(x.left) + 1;
        return x;
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    /**
     * 删除节点
     * @param x
     * @param key
     * @return
     */
    private Node delete(Node x,Key key) {
        if (x == null) return null;
        int com = key.compareTo(x.key);
        if (com < 0) x.left = delete(x.left,key);
        else if (com > 0) x.right = delete(x.right,key);
        else {
            if (x.right == null) return x.left;
            else if (x.left == null) return x.right;
            Node t = x;
            min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key) {
        root = delete(root,key);
    }
}
