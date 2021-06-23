package JavMentor.Generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> ar = new ArrayList<>();
        ar.add(10);
        ar.remove(-1);
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);
        dynamicArray.add(4);
        dynamicArray.add(5);
        dynamicArray.add(6);
        dynamicArray.add(7);
        dynamicArray.add(8);
        dynamicArray.remove(2);
        Integer c = dynamicArray.get(1);
    }

    public static class DynamicArray<T> {
        private Object[] arr;
        private int count = 0;

        public DynamicArray() {
            this.arr = new Object[1];
        }

        public void add(T el) {
            if (count >= arr.length) {
                arr = Arrays.copyOf(arr, arr.length * 2);
            }
            arr[count++] = el;
        }

        public void remove(int index) {
            System.arraycopy(arr, index + 1, arr, index, arr.length - 1 - index);
            count--;
        }

        public T get(int index) {
            T t = (T) arr[index];
            return t;
        }
    }


    //////////////////////////////////
    public static class Pair<T, T1> {
        private T first;
        private T1 second;

        private Pair() {
        }

        private Pair(T first, T1 second) {
            this.first = first;
            this.second = second;
        }

        public static <T, T1> Pair<T, T1> of(T first, T1 second) {
            return new Pair(first, second);
        }

        public T getFirst() {
            return first;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(first, pair.first) &&
                    Objects.equals(second, pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }

        public T1 getSecond() {
            return second;
        }
    }


    public static class Box<T extends Object> {
        private T object;

        public static <T> Box<T> getBox() {
            return new Box<T>();
        }
    }
}
