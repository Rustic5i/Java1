package javaLvl2.chat.dz.server1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Socket socket = null;
        ServerSocket serverSocket = null;
        Scanner console = new Scanner(System.in);
        try {
            serverSocket = new ServerSocket(8289);
            System.out.println("Сервер запущен, ожидается подключение клиента: ");
            socket = serverSocket.accept();

            PrintWriter out = new PrintWriter(socket.getOutputStream());
            Scanner scanner = new Scanner(socket.getInputStream()); // Тут мы считываем с потока
            System.out.println("Клиент подключился");
               Thread t1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true){
                          if (scanner.hasNext()) {
                              String smsClient = scanner.nextLine();
                              if (smsClient.equals("end")) break;
                              System.out.println("Клиент : "+smsClient);
                          }
                        }
                    }
                });
               Thread t2 = new Thread(new Runnable() { // Отсылка сообщений
                   @Override
                   public void run() {
                       while (true) {
                           String str = console.nextLine();
                           if (str.equals("end")) break;
                           out.println(str);
                           out.flush();
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
                serverSocket.close();
                System.out.println("Сервер закрыт");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
