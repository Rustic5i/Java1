package JavMentor.Stream;
/*
Напишите программу, читающую из System.in текст в кодировке UTF-8, подсчитывающую в нем частоту появления слов, и
в конце выводящую 10 наиболее часто встречающихся слов.
Словом будем считать любую непрерывную последовательность символов, состоящую только из букв и цифр. Например, в
строке "Мама мыла раму 33 раза!" ровно пять слов: "Мама", "мыла", "раму", "33" и "раза".
Подсчет слов должен выполняться без учета регистра, т.е. "МАМА", "мама" и "Мама" — это одно и то же слово.
Выводите слова в нижнем регистре.
Если в тексте меньше 10 уникальных слов, то выводите сколько есть.
Если в тексте некоторые слова имеют одинаковую частоту, т.е. их нельзя однозначно упорядочить только по частоте,
то дополнительно упорядочите слова с одинаковой частотой в лексикографическом порядке.
Задача имеет красивое решение через стримы без циклов и условных операторов. Попробуйте придумать его.
Sample Input 1:
Мама мыла-мыла-мыла раму!
Sample Output 1:
мыла
мама
раму
Sample Input 2:
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam,
tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus
imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur
adipiscing elit. Integer vel odio nec mi tempor dignissim.
Sample Output 2:
consectetur
faucibus
ipsum
lorem
adipiscing
amet
dolor
eget
elit
mi
*/


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {

        //ff ff ff aa aa aa ww ww ww dd dd dd er er er er

/*
        Scanner scanner = new Scanner(System.in).useDelimiter("[^a-zA-Z-а-яА-Я0-9]+|[\\s\\-]+");
        HashMap<String, Integer> map = new HashMap<>();
        scanner.forEachRemaining(e -> {
            String el = e.toLowerCase();
            map.merge(el, 1, (prev, van) -> prev + van);
        });

        map.entrySet().stream().
                //Сортеруем по ключу
                sorted((entry, t1) -> entry.getKey().compareTo(t1.getKey())).
                // Сортеруем по значению
                sorted((e1, e2) -> {
                    return -1 * e1.getValue().compareTo(e2.getValue());
                }).
                limit(10).
                forEach(e -> {
                    System.out.println(e.getKey());
                });
*/



/*        Scanner scanner = new Scanner(System.in).useDelimiter("[^a-zA-Z-а-яА-Я0-9]+|[\\s\\-]+");
        HashMap<String, Integer> map = new HashMap<>();
        scanner.forEachRemaining(e -> {
            String el = e.toLowerCase();
            map.merge(el, 1, (prev, van) -> prev + van);
        });
        map.entrySet().stream().sorted((e1, e2) -> {
            int c = -1 * e1.getValue().compareTo(e2.getValue());
            if (c == 0) {
                c = e1.getKey().compareTo(e2.getKey());
            }
            return c;
        }).limit(10).forEach(e -> {
            System.out.println(e.getKey());
        });*/


//решить в 14 строк, с 17 по 23 строки твоего решение не нужно,
//без сканера можно решить, используй функциональное программирование
/*        Scanner scanner = new Scanner(System.in).useDelimiter("[^a-zA-Z-а-яА-Я0-9]+|[\\s\\-]+");
        HashMap<String, Integer> map = new HashMap<>();

        scanner.forEachRemaining(e -> {
            String el = e.toLowerCase();
            map.merge(el, 1, (prev, van) -> prev + van);
        });

        map.entrySet().stream().sorted(new MyComparator()).limit(10).forEach(e -> {
            System.out.println(e.getKey());
        });*/
    }
   /* static class MyComparator implements Comparator<Map.Entry<String, Integer>> {

        @Override
        public int compare(Map.Entry<String, Integer> stringIntegerEntry, Map.Entry<String, Integer> t1) {
            int res = -1 * stringIntegerEntry.getValue().compareTo(t1.getValue());
            if (res == 0) {
                res = stringIntegerEntry.getKey().compareTo(t1.getKey());
            }
            return res;
        }
    }*/
}

