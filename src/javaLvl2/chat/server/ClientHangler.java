package javaLvl2.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHangler {
    private String name;
    private Socket socket;
    private Server owner;
    private DataInputStream in; //Вход
    private DataOutputStream out;      //Выход


    public ClientHangler(Socket socket, Server owner){
        try {
            this.socket = socket;
            this.owner = owner;
            this.in = new DataInputStream(socket.getInputStream()); //содаем обработчик на запись
            this.out = new DataOutputStream(socket.getOutputStream()); // обработка на чтение
        } catch (IOException e) {
            e.printStackTrace();
        }
        name= "";
        System.out.println("Клиент "+name+" Подключился (не авторизован)");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true){
                        String str = in.readUTF();
                        if (str.startsWith("/auth")){
                            System.out.println("ПРОШЛИ КАКУЮТУ ХЕРНЮ");
                            String [] arr = str.split(" ");
                            try {
                                String n = owner.getAuthService().getNickByLoginPass(arr[1],arr[2]);
                                if (!owner.isNickAlreadyAuthorized(n)){
                                name = n;
                                System.out.println("Клиент "+name+" авторизован ");
                                owner.broadcastMsg("Клиент "+name+" подключился");
                                setMsg("123");
                                owner.subscribeClientHandler(ClientHangler.this);
                                break;
                                }else {
                                    setMsg("Учетная запись уже занята");
                                }
                            }catch (AuthException e){
                                setMsg("Неверные логин/пароль");
                            }
                        }
                    }
                    while (true){
                        String str = in.readUTF();
                        if (str.equals("end")){
                            System.out.println("Клиент "+name+" отключился");
                            owner.broadcastMsg("Клиент "+name+" отключился");
                            break;
                        }
                        else if (str.startsWith("/w")){
                            System.out.println(name+": "+str);
                            String [] arryStr = str.split(" ",3);
                            owner.broadcastMsg(": "+arryStr[2],arryStr[1],ClientHangler.this);
                        }else{
                        System.out.println(name+": "+str);
                        owner.broadcastMsg(name+": "+str);}
                    }

                }catch (IOException e){
                    System.out.println("Ошибка подключение клиента "+name);
                } finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                    }
                    owner.unsubscribeClientHandler(ClientHangler.this);
                }
            }
        }).start();
    }

    public void setMsg (String msg){
        try {
            out.writeUTF(msg);
            out.flush();
        } catch (IOException e) {
           System.out.println("Ошибка отправки сообщения "+name);
        }
    }

    public String getName() {
        return name;
    }
}
