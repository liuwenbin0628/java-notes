package com.liuwenbin.notes.java.lambda;

import com.liuwenbin.notes.java.entity.Apple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

/**
 * @author liuwenbin on 2019-07-14
 */
public class Sort {

    public static void main(String[] args) {
        // 1. 使用匿名内部类（java8以前最常用的方式）
        sort1();

        // 2. ------ lambda ----------
        // 2.1 normal
        sort2();

        // 2.2 用comparing
        sort3();

        // 2.3 用方法引用（最终解决方案）
        sort4();

        // 2.4 比较器链
        sort5();
    }

    private static void sort1() {
        List<Apple> apples = getApples();
        apples.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });
        System.out.println("-- after sort: " + apples);
    }

    private static void sort2() {
        List<Apple> apples = getApples();
        apples.sort((a1, a2) -> a1.getWeight() - a2.getWeight());
        System.out.println("-- after sort: " + apples);
    }

    private static void sort3() {
        List<Apple> apples = getApples();
        apples.sort(comparing(a -> a.getWeight()));
        System.out.println("-- after sort: " + apples);
    }

    private static void sort4() {
        List<Apple> apples = getApples();
        apples.sort(comparing(Apple::getWeight));
        System.out.println("-- after sort: " + apples);
    }

    private static void sort5() {
        List<Apple> apples = getApples();
        apples.sort(comparing(Apple::getWeight)
                .reversed()                        // 逆序
                .thenComparing(Apple::getColor));  //（假如质量相同）再比较颜色
        System.out.println("-- after sort: " + apples);
    }

    private static List<Apple> getApples() {
        List<Apple> apples = Arrays.asList(
                new Apple(6, "green"),
                new Apple(5, "red"),
                new Apple(2, "red"),
                new Apple(3, "green"),
                new Apple(4, "green"),
                new Apple(2, "green")
        );
        System.out.println("-- before sort: " + apples);
        return apples;
    }

}
