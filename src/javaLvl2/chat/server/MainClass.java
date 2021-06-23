package javaLvl2.chat.server;

public class MainClass {
    public static void main(String[] args) {
        SQLHandler.connect();
        SQLHandler.test();
        SQLHandler.disconnect();
        Server server =  new Server();
    }
}
