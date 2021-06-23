import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//решить в 14 строк, с 17 по 23 строки твоего решение не нужно,
//без сканера можно решить, используй функциональное программирование
public class Main1 {
    public static void main(String[] args) {
        String str = "sushil mittal";
        System.out.println("****forEach without using parallel****");
        str.chars().forEach(s -> System.out.print((char) s));
        System.out.println("\n****forEach with using parallel****");

        str.chars().parallel().sorted().forEach(s -> System.out.print((char) s));
        System.out.println("\n****forEachOrdered with using parallel****");

        str.chars().parallel().sorted().forEachOrdered(s -> System.out.print((char) s));
    }

}

