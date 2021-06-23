package javaLvl2.Stream;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Привет");
        list.add("Как дела?");
        list.add("ok");
        list.add("пока");

//        for (int i = 0; i < list.size(); i++) {
//            list.set(i,String.valueOf(list.get(i).length()));
//        }
        System.out.println(list);
        List<Integer> list1 = list.stream().map(element -> element.length()).collect(Collectors.toList());
        System.out.println(list1);

        int[] array = {1, 2, 5, 6, 8};
        int[] c = Arrays.stream(array).map(element -> {
            if (element % 3 == 0) {
                element = element / 3;
            }
            return element;
        }).toArray();
        System.out.println(Arrays.toString(c));

        Set<String> set = new TreeSet<>();
        set.add("Привет");
        set.add("Как дела?");
        set.add("ok");
        set.add("пока");

       Set <Integer> set1 = set.stream().map(e -> e.length()).collect(Collectors.toSet());
       System.out.println("Set : "+set1);
    }
}
