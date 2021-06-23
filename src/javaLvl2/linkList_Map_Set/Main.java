package javaLvl2.linkList_Map_Set;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {




        FileInputStream stream = new FileInputStream("moscow-buildings.csv");

        int length = stream.available(); // узнаем длину файла это length = 6918623
        byte [] data = new byte[length];  // data[6918623];
        stream.read(data);                // считываем. КАК ?!
        String text = new String(data);

        ArrayList<String []> lineWords = new ArrayList<>();
         String [] lines = text.split("\n"); //  разбиваем на строки split возвращает всегда массив!!!
         for (String line : lines) {
             String [] words = line.split(",");  // разбиваем строку на отдельные слова split возвращает всегда массив!!!
             lineWords.add(words);
        }
         System.out.println(lineWords);
    }
}
