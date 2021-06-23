package javaLvl2.chat.dz.client1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MainClass {
    public MainClass() {
    }

    public static void main(String[] args) {

        Socket socket = null;

        try {
            socket = new Socket("localhost", 8289);
            Scanner sms = new Scanner(socket.getInputStream());
            System.out.println("Вроде как мы тоже подключились");
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());



           Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        if (sms.hasNext()) {
                            String sms1 = sms.nextLine();
                            System.out.println(sms1);
                        }
                    }
                }
            });
           Thread t2 = new Thread(new Runnable() {
               @Override
               public void run() {
                   while (true) {
                       Scanner sms2 = new Scanner(System.in);
                       String clientSms = sms2.nextLine();
                       printWriter.println(clientSms);
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
            System.out.println("ERROR");
        }
        try {
            socket.close();
            System.out.println("Сервер закрыт");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
