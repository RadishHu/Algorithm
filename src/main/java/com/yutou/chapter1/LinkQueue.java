package com.yutou.chapter1;


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 链表实现队列
 */
public class LinkQueue<Item> {

    private Node first;
    private Node last;
    private int N;

    private class Node {

        private Item item;
        private Node next;
    }

    public boolean isEmpty() {return first==null;}

    public int size() {return N;}

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if (isEmpty()) first = last;
        else oldLast.next = last;
        N++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;

        if (isEmpty()) last = null;
        N--;
        return item;
    }

    /**
     * 测试用例
     */
    public static void main(String[] args) {

        LinkQueue<String> q = new LinkQueue<String>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                q.enqueue(item);
            else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
        }

        StdOut.println("(" + q.size() + "left on queue)");
    }
}
