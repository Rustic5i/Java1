package JavMentor.Override;
//Урок с кодом
//        Напишите статический класс AsciiCharSequence, реализующий компактное хранение последовательности ASCII-символов (их коды влезают в один байт) в массиве байт. По сравнению с классом String из Java 8, хранящим каждый символ как char, AsciiCharSequence будет занимать в два раза меньше памяти
//
//        Класс AsciiCharSequence должен:
//
//        реализовывать интерфейс java.lang.CharSequence;
//        иметь конструктор, принимающий массив байт;
//        определять методы length(), charAt(), subSequence() и toString()
//
//        Сигнатуры методов и ожидания по их поведению смотрите в описании интерфейса java.lang.CharSequence (JavaDoc или исходники).
//
//        В данном задании методам charAt() и subSequence() всегда будут подаваться корректные входные параметры, поэтому их проверкой и обработкой ошибок заниматься не нужно. Тем более мы еще не проходили исключения.

public class ToString {
    public static void main(String[] args) {
        byte[] c = {97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108};
        AsciiCharSequence c1 = new AsciiCharSequence(c);
        c1.toString();
        System.out.println("Работа метода toString() = " + c1.toString());
        System.out.println("Длинна массива = " + c1.length());
        System.out.println("Выводим симвод charAt() = " + c1.charAt(0));
        System.out.println("Распечатываем нужный кусок subSequence() = " + c1.subSequence(0, 9));
    }

    public static class AsciiCharSequence implements CharSequence {
        private byte[] arrChar;

        public AsciiCharSequence(byte[] arrChar) {
            this.arrChar = arrChar;
        }

        @Override
        public int length() {
            int count = 0;
            for (byte a : arrChar) {
                count++;
            }
            return count;
        }

        @Override
        public char charAt(int i) { //возвращает значение char по указанному индексу. Индекс колеблется от 0 до length()-1.
            return (char) arrChar[i];
        }

        @Override
        public CharSequence subSequence(int i, int i1) { //возвращает последовательность символов из строки, начиная и заканчивая указанными индексами.
            byte[] arrSubSequence = new byte[i1-i];
            for (int j = 0; j < arrSubSequence.length; j++) {
                arrSubSequence[j]=arrChar[i];
                i++;
            }
            return new AsciiCharSequence(arrSubSequence);
        }

        @Override
        public String toString() {
//            StringBuilder stringBuilder = new StringBuilder();
//            for (int i = 0; i < arrChar.length; i++) {
//                stringBuilder.append(charAt(i));
//            }
//            return String.valueOf(stringBuilder);
            return new String(arrChar); //оказываеться можно было все сделать в одну срочку =)
        }
    }
}
