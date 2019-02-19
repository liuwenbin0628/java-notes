package com.liuwenbin.note.java.math;

/**
 * @ Description：求 1+2+3+...+n
 * .             要求不能使用乘除法、for、while、if、else、switch、case 等关键字及条件判断语句 A ? B : C。
 * @ Author     ：liuwenbin
 * @ Date       ：2019/1/12
 */

public class Sum {

    public int sum(int n) {
        int res = n;
        boolean b = (n > 0)
                && (res += sum(n - 1)) > 0; // 利用&&的短路特性
        return res;
    }
}
