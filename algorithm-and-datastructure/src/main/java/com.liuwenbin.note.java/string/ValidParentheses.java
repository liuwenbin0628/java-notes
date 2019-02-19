package com.liuwenbin.note.java.string;

import java.util.Stack;

/**
 * @ Description：判断是否是有效括号
 * .              什么是有效括号？ 比如"()[]{}"就是，"([)]"就不是。
 * @ Author     ：liuwenbin
 * @ Date       ：2019/1/11
 */

public class ValidParentheses {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            switch (c) {
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                default:
                    if (stack.isEmpty() || c != stack.pop())
                        return false;
                    break;
            }
        }

        return stack.isEmpty();
    }
}
