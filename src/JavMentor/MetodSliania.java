package JavMentor;

import java.util.Arrays;

//Урок с кодом
//        Реализуйте метод, сливающий два отсортированных по неубыванию массива чисел в один отсортированный в том же порядке массив. Массивы могут быть любой длины, в том числе нулевой.
//
//        Предполагается, что вы реализуете алгоритм слияния, имеющий линейную сложность: он будет идти по двум исходным массивам и сразу формировать отсортированный результирующий массив. Так, чтобы сортировка полученного массива при помощи Arrays.sort() уже не требовалась.
//
//        К сожалению, автоматически это не проверить, так что это остается на вашей совести :)
//
//        Воспользуйтесь предоставленным шаблоном. Декларацию класса, метод main и обработку ввода-вывода добавит проверяющая система.
//
//        Пример ввода: {0, 2, 2} и {1, 3}
//        Пример вывода: {0, 1, 2, 2, 3}
public class MetodSliania {
    public static void main(String[] args) throws Exception {
        int a1[] = {0, 4, 8, 10};
        int a2[] = {1, 3, 6};
        System.out.println(Arrays.toString(mergeArrays(a1,a2)));

    }

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int countA1 = 0;
        int countA2 = 0;
        int countFinish = 0;
        int c[];
        int arrFinish[] = new int[a1.length + a2.length];
        for (int i = 0; i < arrFinish.length; i++) {
            if ((a1.length > countA1) && (!(a2.length > countA2)||(a1[countA1] <= a2[countA2]))) {
                arrFinish[countFinish] = a1[countA1];
                countA1++;
                countFinish++;
            } else if ((a2.length > countA2) && (!(a1.length > countA1) ||(a2[countA2] < a1[countA1]))) {
                arrFinish[countFinish] = a2[countA2];
                countA2++;
                countFinish++;
            }
        }

        return arrFinish;
    }
}
