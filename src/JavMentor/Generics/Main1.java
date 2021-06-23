package JavMentor.Generics;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main1 {
    public static void main(String[] args) {
        Set<Integer> listFirst = new HashSet<>();
        listFirst.add(1);
        listFirst.add(2);
        listFirst.add(3);

        Set<Integer> listSecond = new HashSet<>();

        listSecond.add(0);
        listSecond.add(1);
        listSecond.add(2);
        symmetricDifference(listFirst, listSecond);
    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> newSet = new TreeSet<>(set2);
        Set<T> newSet1 = new TreeSet<>(set1);
        newSet.removeAll(set1);
        newSet1.removeAll(set2);
        newSet.addAll(newSet1);
        return newSet;
    }

}
