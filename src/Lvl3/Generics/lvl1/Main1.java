package Lvl3.Generics.lvl1;

import java.util.Objects;
//       Урок с кодом
//        Реализуйте generic-класс Pair, похожий на Optional,
//        но содержащий пару элементов разных типов и не запрещающий элементам принимать значение null.
//        Реализуйте методы getFirst(), getSecond(), equals() и hashCode(),
//        а также статический фабричный метод of(). Конструктор должен быть закрытым (private).
//        С корректно реализованным классом Pair должен компилироваться и успешно работать следующий код:
//
//        Pair<Integer, String> pair = Pair.of(1, "hello");
//        Integer i = pair.getFirst(); // 1
//        String s = pair.getSecond(); // "hello"
//        Pair<Integer, String> pair2 = Pair.of(1, "hello");
//        boolean mustBeTrue = pair.equals(pair2); // true!
//        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
//        Пожалуйста, не меняйте модификатор доступа класса Pair.
//        Для корректной проверки класс должен иметь пакетную видимость.



public class Main1 {
    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"
        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
    }

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
            Box<T> t = new Box<T>();
            return t;
        }
    }
}