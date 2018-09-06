package com.yutou.chapter1;

import java.util.Iterator;

/**
 * 链表实现背包
 */
public class LinkBag<Item> implements Iterable<Item>{

    private Node first;

    private class Node {

        private Item item;
        private Node next;
    }

    public void add(Item item) {

        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {

            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() { }
    }
}
