package ru.geekbrains.java1.lesson1;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class PopularWords {
    public static void main(String[] args) throws IOException {

        long time = System.currentTimeMillis(); // Засекаем время
        BufferedInputStream read = new BufferedInputStream(new FileInputStream("Proishozhdenie.txt")); // через буфер быстрее
        int lenght = read.available();
        byte [] bytes = new byte[1000000];
        read.read(bytes);
        String text = new String(bytes);
        ArrayList<String[]> arrayList = new ArrayList<>(); // Сюда будем записывать массив строк заделеный по словам
       TreeMap<String, Integer> treeMap = new TreeMap<>(); //Сюда будем записывать все слова и их количество повторений в книге
        String [] lines = text.split("\n");
        String [] words = new String[0];

        for (int i = 0; i < lines.length; i++) {
             words = lines[i].split("[,\\s\\-:\\?\\.\\!»]");
            arrayList.add(words);
        }

        read.close();

        System.out.println("--------------------");

        for (String[] c: arrayList) {
            for (String word : c) {
                Integer counter = 0;
                    for (String[] arrComparison : arrayList) {
                        for (String wordComparison : arrComparison) {
                            if (word.equals(wordComparison)) {
                                counter = counter + 1;
                                treeMap.put(word, counter);
                        }
                    }
                }

            }
        }


        System.out.print(treeMap.firstEntry());
        System.out.println();



        treeMap.entrySet().forEach(System.out::println);
        System.out.println();
///Два способа сортировки Map по значение // ни один как работает я не понимаю =(//
        //Первый способ
        List<Map.Entry<String, Integer>> list = new ArrayList<>(treeMap.entrySet());
        Collections.sort(list, Comparator.comparingInt(Map.Entry::getValue));
        list.forEach(System.out::println);
        // Второй способ
      //  treeMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println); // как это работаем я без понятия
        System.out.println("Время : "+(System.currentTimeMillis() - time));


    }
}

