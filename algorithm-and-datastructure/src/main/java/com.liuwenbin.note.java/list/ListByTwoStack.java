package com.liuwenbin.note.java.list;

import java.util.Stack;

/**
 * @ Description：双栈实现队列
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/11
 */
 
public class ListByTwoStack {

    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();

    public void push(Integer node) {
        in.push(node);
    }

    public Integer pop() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }
}
