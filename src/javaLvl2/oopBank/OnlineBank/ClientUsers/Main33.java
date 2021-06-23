package javaLvl2.oopBank.OnlineBank.ClientUsers;

import java.io.IOException;

public class Main33 {
    public static void main(String[] args) {
        try {
            Users users = new Users();
        } catch (IOException e) {
            System.out.println("ERORR: подключение к серверу");
        }
    }
}
