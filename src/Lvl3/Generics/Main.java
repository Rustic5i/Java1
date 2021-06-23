package Lvl3.Generics;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String arrString [] = new String[5];
        arrString[0] = "Привет";
        arrString[1] = "как дела";
        arrString[2]= "что делаешь?";
        arrString[3] = "мой друг";

        Integer arrInt [] = {1,2,3,4,5};
        arr(arrInt,1,3);
        System.out.println(Arrays.toString(arrInt));

    }
    public static <T> void arr(T[] arr,int b,int c){
        T cell = arr[c];
        arr[c] = arr[b];
        arr[b] = cell;
    }
    public static <T>  ArrayList<T> arrayList(T[] arr){
        ArrayList<T> list = new ArrayList<T>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }

        return list;
    }

}
