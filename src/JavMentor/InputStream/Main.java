package JavMentor.InputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) {

    }
//    Реализуйте метод, который зачитает данные из InputStream и преобразует их в строку, используя заданную кодировку.
//
//            Пример:
//    InputStream последовательно возвращает четыре байта: 48 49 50 51.
//    Метод, вызванный для такого InputStream и кодировки ASCII, должен вернуть строку: "0123".
//
//    Требования:
//            1. Метод должен быть публичным.
//            2. Сигнатура метода должна быть: readAsString(InputStream inputStream, Charset charset)
    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream,charset);
        int intRead;
        char charRead = 0;
        StringBuilder str = new StringBuilder();
        while ((intRead = inputStreamReader.read())!=-1){
            charRead = (char) intRead;
            str.append(charRead);
        }
        inputStreamReader.close();
        inputStream.close();
        return str.toString();
    }
//    Напишите метод void print(InputStream inputStream, OutputStream outputStream) который принимает InputStream и OutputStream, считывает все байты из inputStream и записывает в OutputStream только четные.
//
//    Пример ввода: 3, 10, 4, 5, 7
//
//    Пример вывода: 10, 4
//
//    Требования:
//            1. Метод должен быть публичным.
//            2. Параметры должны иметь тип InputStream inputStream и OutputStream outputStream.
//3. Сигнатура метода должна быть: print(InputStream inputStream, OutputStream outputStream)

    public static void print(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] c = inputStream.readAllBytes();
        for (int i = 0; i < c.length; i++) {
            if ((c[i]%2) == 0){
                outputStream.write(c[i]);
                outputStream.flush();
            }
        }
        inputStream.close();
        outputStream.flush();
    }
//    Напишите метод int sumOfStream(InputStream inputStream), который принимает InputStream и возвращает сумму всех его элементов.
//
//    Пример ввода: 1, 2, 4, 10
//
//    Пример вывода: 17
//
//    Требования:
//            1. Метод должен быть публичным.
//            2. Параметр должен иметь тип InputStream.
//3. Сигнатура метода должна быть: sumOfStream(InputStream inputStream)
    public static int sumOfStream(InputStream inputStream) throws IOException {
        int sum = 0;
        byte[] c = inputStream.readAllBytes();
        for (int i = 0; i < c.length; i++) {
            sum = sum+c[i];
        }
        inputStream.close();
        return sum;
    }
}

