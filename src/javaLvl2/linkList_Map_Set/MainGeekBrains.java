package javaLvl2.linkList_Map_Set;

import java.util.ArrayList;

public class MainGeekBrains {
    public static void main(String[] args) {
        ArrayList<String> str = new ArrayList<>();
        ArrayList<String> str2 = new ArrayList<>();
        ArrayList<Integer> in2 = new ArrayList<>();
        ArrayList<Box> boxes = new ArrayList<>();

        boxes.add(new Box(5));
        boxes.add(new Box(6));
       boxes.remove(new Box(5)); // В классе Box,  прежде чем пытаться удалить его, нужно перепоределить метод equals.  По умолчанию метод equals сравнивает как бы ссылки. а нам нужносравнить чесло size в классе Box
        System.out.println(boxes);

     System.out.println(boxes.get(0).equals(new Box(6)));


        in2.add(20);

        int c = 20+ in2.get(0);

        str.add("Привет");
        str.add("Hello");
        str.add("People");
        str.add("People");
        str.add("People");
        str.add("People");
        str.add("People");
        str.add("People");
        str.add("People");
        str.add("People");
        str.remove(0);

        str2.add("array");
        str2.add("12");

        str.addAll(1, str2);
        str.addAll(0,str2);

        str.remove("People");
        while (str.remove("People"));

        System.out.println(str);
        System.out.println(str.size());
        System.out.println(c);
    }
}
