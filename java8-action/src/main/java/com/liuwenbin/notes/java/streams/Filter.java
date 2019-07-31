package com.liuwenbin.notes.java.streams;


import com.liuwenbin.notes.java.entity.Dish;

import java.util.List;
import java.util.stream.Collectors;

import static com.liuwenbin.notes.java.entity.Dish.dishes;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * @author liuwenbin on 2019-07-15
 */
public class Filter {

    public static void main(String[] args) {

        /* stream basic */
        List<String> names1 = dishes.stream()
                .filter(d -> d.getCalories() < 600)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());
        names1.forEach(System.out::println);

        System.out.println(" ------------------ ");

        /* stream operation */
        List<String> names2 = dishes.stream()
                .filter(d -> {
                    System.out.println("filtering " + d.getName());
                    return d.getCalories() > 300;
                })
                .map(d -> {
                    System.out.println("mapping " + d.getName());
                    return d.getName();
                })
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(names2);


    }



}
