package javaLvl2.chat.dz.client1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MainClass1 {
    public static void main(String[] args) {
        Socket socket = null;
        Scanner sms1 = new Scanner(System.in);
        try {
            socket = new Socket("localhost", 8289);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            Scanner scanner = new Scanner(socket.getInputStream()); // Тут мы считываем с потока
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        //   if (scanner.hasNext()) {
                        String smsClient = scanner.nextLine();
                        if (smsClient.equals("end")) break;
                        System.out.println("Сервер : "+smsClient);
                    }
                }
                // }
            });
            Thread t2 = new Thread(new Runnable() { // Отсылка сообщений
                @Override
                public void run() {
                    while (true) {
                        String stringSms = sms1.nextLine();
                        if (stringSms.equals("end")) break;
                        printWriter.println(stringSms);
                        printWriter.flush();
                    }
                }
            });
            t1.start();
            t2.start();
            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            System.out.println("Что то пошло не так ERROR");
        } finally {
            try {
                socket.close();
                System.out.println("Сервер закрыт");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
