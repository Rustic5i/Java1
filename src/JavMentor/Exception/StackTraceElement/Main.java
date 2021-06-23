package JavMentor.Exception.StackTraceElement;
//Урок с кодом
//        Реализуйте метод, позволяющий другим методам узнать, откуда их вызвали.
//
//        Метод getCallerClassAndMethodName() должен возвращать имя класса и метода, откуда вызван метод, вызвавший данный утилитный метод. Или null (нулевую ссылку, а не строку "null"), если метод, вызвавший getCallerClassAndMethodName() является точкой входа в программу, т.е. его никто не вызывал.
//
//        Это актуально, например, в библиотеках логирования, где для каждого сообщения в логе надо выводить класс и метод, откуда сообщение было залогировано.
//
//        Пример
//
//        package org.stepic.java.example;
//
//public class Test {
//    public static void main(String[] args) {
//        System.out.println(getCallerClassAndMethodName());
//        anotherMethod();
//    }
//
//    private static void anotherMethod() {
//        System.out.println(getCallerClassAndMethodName());
//    }
////    public static String getCallerClassAndMethodName() {
//        // ...
//    }
//}
//    При запуске эта программа должна вывести:
//
//        null
//        org.your.project.Test#main
//        P.S. При тестировании этой программы в среде разработки вы можете получить другой результат: вместо null в первой строчке будет напечатан какой-то посторонний класс и метод. Это связано с тем, что среда разработки обычно запускает не ваш класс, а свой собственный, который затем уже вызывает ваш. Чтобы этого избежать, запускайте программу командой "java" в командной строке.
//
//        P.P.S. Эта задача в уроке про исключения не случайно :)
public class Main {
    public static void main(String[] args) {
        //сТЕК  ТРЕЙС очень полезная тема !!!
        // СТЭК ТРЕЙС похож на массив или колекции но есть одно но, он работает по принцепу
        // Послежний зашел, первый ушел))
        // ряд полезных методов:
        //String getClassName() - Возвращает имя класса.
        //String getMethodName() - Возвращает имя метода.
        //String getFileName() - Возвращает имя файла (в одном файле может быть много классов).
        //String getModuleName() - Возвращает имя модуля (может быть null).
        //String getModuleVersion() - Возвращает версию модуля (может быть null).
        //int getLineNumber() - Возвращает номер строки в файле, в которой был вызов метода..
        m1();
        m2();
        m3();
        System.out.println(getCallerClassAndMethodName());

    }

    static void m1() {
        System.out.println(getCallerClassAndMethodName());
        m2();
    }

    static void m2() {
        System.out.println(getCallerClassAndMethodName());
        m3();
    }

    static void m3() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] elements = new Throwable().getStackTrace();
        StackTraceElement [] elements1 =Thread.currentThread().getStackTrace();
        if (elements.length > 2) {
          return elements[2].getClassName()+"#"+elements[2].getMethodName();
        } else {
            elements.clone();
            return null;
        }
    }
}

