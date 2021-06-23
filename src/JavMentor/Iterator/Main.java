package JavMentor.Iterator;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// Java-программа для демонстрации Comparator
// thenComparingInt (ToIntFunction) метод


import java.util.Arrays;

import java.util.Collections;

import java.util.Comparator;

import java.util.List;


public class Main {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("[^a-zA-Z-а-яА-Я0-9]+|[\\s\\-]+");
        HashMap<String, Integer> map = new HashMap<>();
        scanner.forEachRemaining(e -> {
            String el = e.toLowerCase();
            map.merge(el, 1, (prev, van) -> prev + van);
        });
        map.entrySet().stream().
                sorted(Comparator.comparing(Map.Entry<String, Integer>::getValue).
                reversed().
                thenComparing(Map.Entry::getKey)).
                limit(10).
                forEach(entry -> System.out.println(entry.getKey()));
        
//        List<HardwareItems> list = getItems();
//
//        System.out.println("before sort:");
//
//        list.forEach(System.out::println);
//
//
//        // Применяем сортировку и
//
//        // также применяем thenComparingInt ()
//
//        Collections
//
//                .sort(list, Comparator.
//                        comparing(HardwareItems::getName)
//                        .thenComparingInt(HardwareItems::getPrice));
//
//        System.out.println("after sort:");
//
//        list.forEach(System.out::println);

    }

    private static List<HardwareItems> getItems() {

        return Arrays.asList(

                new HardwareItems("Laptop", 40000),

                new HardwareItems("Desktop", 20000),

                new HardwareItems("Laptop", 45500),

                new HardwareItems("Monitor", 10000),

                new HardwareItems("Desktop", 22000));

    }


    private static class HardwareItems {

        private String name;

        private int price;


        public HardwareItems(String name, int price) {

            this.name = name;

            this.price = price;

        }


        public String getName() {

            return name;

        }


        public int getPrice() {

            return price;

        }


        @Override

        public String toString() {

            return "HardwareItems [name="

                    + name

                    + ", price="

                    + price + "]";

        }

    }

}
