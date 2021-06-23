package FilleTxt;

import java.io.*;
import java.util.Scanner;

public class MainClass extends Utilita {
    public static void main(String[] args) throws IOException {
        File file = new File("1"); // создаем файлы
        File file2 = new File("2");
        File file3 = new File("3");

        if (file.exists() || file2.exists() || file3.exists()) // проверяем есть ли уже этот файл
        file.createNewFile(); // создаем новый файл если его нет
        file2.createNewFile();
        file3.createNewFile();
        PrintWriter pw = new PrintWriter(file); //  записываем в файл текст
        PrintWriter pw2 = new PrintWriter(file2);
        pw.println("World Требуется написать 500 уникальных текстов для безанкорных ссылок. Я даю ссылку на страницу, Вы для нее пишете текст. Текст – это 1-2 предложения по 80-100 символов с пробелами, в котором есть указание на страницу.\n" +
                "\n" +
                "Пример текстов:\n" +
                "На этом сайте можно снять квартиру на сутки. В центре города, хороший ремонт, недорого.\n" +
                "А вот квартиры на сутки можно найти здесь. Все по высшему разряду, будете довольны World.\n" +
                "\n" +
                "Всё должно быть написано руками, никаких генераторов, синонимайзеров и т.д. Текст должен быть уникальный и грамотный.");
        pw2.println("Очень часто при публикации сообщений в соцсетях или блогах люди задумываются о том, какой длины должны быть эти сообщения. Проще всего ответить на это что-нибудь типа «длина зависит от множества факторов», но поступить так не особенно интересно. Существует довольно большое количество исследований, цель которых заключалась в определении идеальной длины контента онлайн. Стоит взглянуть на их результаты поподробнее.");

        pw.flush();
        pw2.flush();
        pw.close();
        pw2.close();

        StringBuilder stringTxt = new StringBuilder(); // создали стринг билбер
        Scanner[] arraySc = new  Scanner [2]; // создаем массив из сканеров
        arraySc[0] = new Scanner(file);
        arraySc[1] = new Scanner(file2);

        for (Scanner a:arraySc) { // Проходимся по массиву
            while (a.hasNextLine()){ // hasNextLine этот метод возвращает тру, если есть строки еще, которые мы не считали
                stringTxt.append(a.nextLine()).append("\n"); // записываем все переменную append какждый за прибавляет
            }
            a.close();
        }

        PrintWriter pw3 = new PrintWriter(file3); //
        pw3.println(stringTxt); // из StringBuilder перезаписываем в файл "3"
        pw3.close();
        System.out.println(stringTxt.toString());

        Utilita utilita = new Utilita();
        utilita.findWorld("3","World");
      //  findWorld("3", "World");

    }

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
