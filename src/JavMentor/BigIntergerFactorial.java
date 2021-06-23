package JavMentor;

import java.math.BigInteger;

//Реализуйте метод factorial, вычисляющий факториал заданного натурального числа.
//
//        Факториал N вычисляется как 1 ⋅ 2 ⋅ ... ⋅ N.
//
//        Поскольку это очень быстро растущая функция, то даже для небольших N вместимости типов int и long очень скоро не хватит. Поэтому будем использовать BigInteger.
//
//        Воспользуйтесь предоставленным шаблоном. Декларацию класса, метод main и обработку ввода-вывода добавит проверяющая система.
//
//        Пример ввода 1: 1
//        Пример возвращаемого значения 1: 1
//
//        Пример ввода 2: 3
//        Пример возвращаемого значения 2: 6
//
//        Требования:
//        1. Метод должен быть public.
//        1. Метод должен быть static.
//        3. Передаваемый параметр должен иметь тип int.
//        4. Метод должен быть реализован через цикл.
public class BigIntergerFactorial {
    public static void main(String[] args) throws Exception {
        System.out.println(factorial(5));

    }

    public static BigInteger factorial(int value) {
        if (Math.abs(value) == 0 || Math.abs(value) == 1) {
            return BigInteger.valueOf(1);
        }
        return BigInteger.valueOf(value).multiply(factorial(value - 1)); //Рукурсия - метод вызывет сам себя
    }
}
