package javaLvl2.Stream;

import java.util.Arrays;

public class ForEach {
    public static void main(String[] args) {
        int[] array = {5, 6, 10, 232, 55};
        Arrays.stream(array).parallel().forEach(e -> {
            e*=2; System.out.println(e);
        });
        Arrays.stream(array).forEach(System.out ::println);
    }
}
