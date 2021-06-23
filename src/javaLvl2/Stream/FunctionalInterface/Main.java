package javaLvl2.Stream.FunctionalInterface;

import javax.annotation.processing.Generated;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SimpleGen sg = new SimpleGen(5);
        GetNextElement getNextElement = sg::getNumber;
        int c = getNextElement.Get();
        System.out.println(c);

        List <String> list =  new ArrayList<>(List.of("Hello","Cat","java","bag"));
        System.out.println(list);
        list.removeIf(sg::rest); // Ссылка на метод "::" мы взяли реализация метода rest класса SimpleGen.
                                 // И присвоили методу  функц интерф Predicate
        //мы это смогли сделать так как соблюдены два условия 1. методы  rest и метод test  интререйса Predicate
        // возращает одно и тоже
        // 2. принимают одинаковые параметры
        System.out.println(list);



    }
}
