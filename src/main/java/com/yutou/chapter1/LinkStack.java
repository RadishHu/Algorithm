package com.yutou.chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;


/**
 * 使用链表实现下压栈
 */
public class LinkStack<Item> {

    private Node first; //栈定，最近添加的元素
    private int N;  //元素的数量

    private class Node { //定义节点类

        private Item item;
        private Node next;
    }

    public boolean isEmpty() {return first==null;}

    public int size() {return N;}

    public void push(Item item) {

        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop() {

        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    //测试用例
    public static void main(String[] args) {
        //原始Stack测试
        /*Stack<String> s = new Stack<String>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + "");
        }

        StdOut.println(s.size() + "left on Stack");*/

        //链表实现Stack测试
        LinkStack<String> s = new LinkStack<String>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }

        StdOut.print(s.size() + "left on Stack");

    }
}


