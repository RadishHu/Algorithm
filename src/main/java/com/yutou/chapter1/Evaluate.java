package com.yutou.chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

/**
 * 使用双栈模拟计算
 */
public class Evaluate {

    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();

        while (!StdIn.isEmpty()) {
            //读取字符，如果是运算符则压入栈
            String s = StdIn.readString();
            if (s.equals("("));
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals("sqrt")) ops.push(s);
            else if (s.equals(")")) {
                String op = ops.pop();
                double val = vals.pop();
                if (op.equals("+")) val = vals.pop() + val;
                else if (op.equals("-")) val = vals.pop() - val;
                else if (op.equals("*")) val = vals.pop() * val;
                else if (op.equals("/")) val = vals.pop() / val;
                else if (op.equals("sqrt"))  val = Math.sqrt(val);

                vals.push(val);
            }
            else vals.push(Double.parseDouble(s));
        }
        StdOut.println(vals.pop());

    }
}
