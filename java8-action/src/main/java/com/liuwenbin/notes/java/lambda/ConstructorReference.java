package com.liuwenbin.notes.java.lambda;

import com.liuwenbin.notes.java.entity.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author liuwenbin on 2019-07-14
 */
public class ConstructorReference {

    public static void main(String[] args) {

        // 1. Apple()的构造函数
        Supplier<Apple> s = Apple::new;
        Apple a1 = s.get();
        System.out.println("a1: " + a1);

        // 2. Apple(int weight)的构造函数
        Function<Integer, Apple> f = Apple::new;
        Apple a2 = f.apply(10);
        System.out.println("a2: " + a2);

        List<Integer> weights = Arrays.asList(3, 2, 8, 4);
        List<Apple> apples = map(weights, Apple::new);
        System.out.println("list of weights: ");
        apples.forEach(System.out::println);

        // 3. Apple(int weight, String color)的构造函数
        BiFunction<Integer, String, Apple> b = Apple::new;
        Apple a3 = b.apply(2, "red");
        System.out.println("a3: " + a3);

    }

    private static List<Apple> map(List<Integer> list,
                                   Function<Integer, Apple> function) {
        List<Apple> results = new ArrayList<>();
        for (Integer weight : list) {
            results.add(function.apply(weight));
        }
        return results;
    }


}
