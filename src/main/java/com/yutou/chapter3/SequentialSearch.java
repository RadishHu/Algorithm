package com.yutou.chapter3;

/**
 * 快速查找，基于无序链表
 */
public class SequentialSearch<Key,Value> {

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key,Value value,Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node first;

    public Value get(Key key) {

        for (Node i = first; i.next != null; i = i.next) {
            if (key.equals(i.key)) return i.value;
        }
        return null;
    }

    public void put(Key key,Value value) {

        for (Node i = first; i.next != null; i = i.next) {
            if (key.equals(i.key)) i.value = value;
        }
        first = new Node(key,value,first);
    }
}
