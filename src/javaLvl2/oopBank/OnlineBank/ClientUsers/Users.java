package javaLvl2.oopBank.OnlineBank.ClientUsers;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public  class Users {
    private final Socket socket = new Socket("localhost", 8189);
    private final DataOutputStream out = new DataOutputStream(socket.getOutputStream());
    private final Scanner scInput = new Scanner(socket.getInputStream());
    private Scanner scUsers = new Scanner(System.in);

    public Users() throws IOException {
        try {
           // socket = new Socket("localhost", 8189);
          //  scInput = new Scanner(socket.getInputStream());
          //  out = new DataOutputStream(socket.getOutputStream());
          //  scUsers = new Scanner(System.in);

            System.out.println("Клиент Подключился (не авторизован)");
            outThread();
            inputThread();
       // } catch (IOException ignored) {
           System.out.println("ERORR: подключение к серверу");
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void outThread (){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {

                    String str = scUsers.nextLine();

                        try {
                            out.writeUTF(str);
                            out.flush();
                            if (str.equalsIgnoreCase("end")){
                                Thread.currentThread().interrupt();
                                System.out.println(Thread.currentThread().isInterrupted());

                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                            System.out.println("Ошибка ввода вывода 1");
                        }
                }
            }
        }).start();
    }
    private void inputThread(){
        try {
            while (true) {
                String str = scInput.nextLine();
                System.out.println(str);
            }
        }catch (Exception e){
            scInput.close();
            System.out.println("Ошибка ввода вывода 2");
        }
    }

}
