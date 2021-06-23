package FilleTxt;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            File filleTxt = new File ("2.txt");

            if (filleTxt.exists()) // проверяем если такой файл не существует, содаем новый
            filleTxt.createNewFile(); // содаем новый файл
            PrintWriter pw = new PrintWriter(filleTxt); // показывыйем в какой файл будем заптсывать
            pw.println("Hello World"); //что будем туда записывать
            pw.println("Hello Rustic");
            pw.println(" Dance");
            pw.println(" Dance");
            pw.close(); // закрываем файл
            br =  new BufferedReader(new FileReader("1.txt"));// указываем с какого файла будем считывать
            String line;
            while ((line = br.readLine())!= null){ // записываем новую строку в переменную line до тех пор пока строчка не закончиться, не будет равна нулю
                System.out.println(line);
            }
        }catch (IOException e){
            System.out.print("Ошибка "+e);
        } finally {
            try {
                br.close(); // Закрваем считывание файла
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
