package com.liuwenbin.note.java.string;

/**
 * @ Description：字符串替换空格
 * .              将空格替换成"%20"
 * @ Author     ：liuwenbin
 * @ Date       ：2019/1/11
 */

public class ReplaceSpace {

    public static String replace(String s) {
        int index1 = s.length() - 1;
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < index1; i++) {
            if (sb.charAt(i) == ' ') {
                sb.append("  ");
            }
        }

        int index2 = sb.length() - 1;
        while (index1 >= 0 && index1 < index2) {
            char c = sb.charAt(index1--);
            if (c == ' ') {
                sb.setCharAt(index2--, '0');
                sb.setCharAt(index2--, '2');
                sb.setCharAt(index2--, '%');
            } else {
                sb.setCharAt(index2--, c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "We Are Happy";
        System.out.println(replace(s));
    }
}
