package javaLvl2.chat.server;

public interface AuthService {
    String getNickByLoginPass(String login,String pass) throws AuthException;
    boolean checkLogin(String login);

}
