package javaLvl2.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server {
     private ServerSocket serv = null; //У нас есть сервер
     private   Vector<ClientHangler> vch = new Vector<>();
     private AuthService authService;

    public AuthService getAuthService() {
        return authService;
    }

    public Server() {
        try { // Запускаем прогу
            authService = new AutByBD();
            serv = new ServerSocket(8189); // Мы просушиваем порт 8189
            System.out.println("Сервер запущен, ожидаем подключения клиентов...");
            while (true) {
               Socket sock = serv.accept(); // Блокируящая операция. Пока кто то не подключиться мы с этой строки не сдвинемся, Как только килент подлючаеться, вс. инфу записываем в sock
                new ClientHangler(sock,this);
            }
        } catch (IOException e) {
            System.out.println("Ошибка инициализации сервера ");
        } finally {
            try {
                serv.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            SQLHandler.disconnect();
        }

    }
    public synchronized void broadcastMsg(String msg){
        for (ClientHangler o: vch) {
            o.setMsg(msg);
        }
    }
    public synchronized void broadcastMsg(String msg,String name,ClientHangler clientHangler){
        for (ClientHangler o: vch) {
            if (o.getName().equals(name)){
                o.setMsg(o.getName()+msg);
                clientHangler.setMsg("Вы :"+msg);
            }
        }
    }
    public boolean isNickAlreadyAuthorized(String nick){
        for (ClientHangler o: vch) {
            if (o.getName().equals(nick)) return true;
        }
        return false;
    }
    public synchronized void unsubscribeClientHandler (ClientHangler o){
        vch.remove(o);
    }
    public synchronized void subscribeClientHandler (ClientHangler o){
        vch.add(o);
    }
}
