package FilleTxt;

import java.io.FileInputStream;
import java.io.IOException;

public class Utilita {


    public static boolean findWorld (String fileName, String world){ // метод для поиска слово по байтов ТОЛЬКО АНГ СЛОВА
        byte [] b = world.getBytes();
        try {
            FileInputStream fis = new FileInputStream (fileName);
            int c = 0;
            int x = 0;
            do {
                x = fis.read();
                if (b[c] == x){
                    c++;
                    if (c == b.length){
                        System.out.println("Я нашел!!!");
                        return true;
                    }
                }else {
                    c =0;
                }
            }while (x!=-1);
        } catch (IOException e) {
            System.out.println("ERROR");
        }

        return false;
    }
}
