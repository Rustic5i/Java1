package javaLvl2.chat.server;

import java.util.HashMap;

public class AuthBase implements AuthService{
    class LPN{
        String login;
        String pass;
        String nick;

        public LPN(String login, String pass, String nick) {
            this.login = login;
            this.pass = pass;
            this.nick = nick;
        }
    }

    HashMap<String, LPN> hm;

    public AuthBase() {
        hm = new HashMap<>();
        hm.put("login1", new LPN("login1","pass1","nick1"));
        hm.put("login2", new LPN("login2","pass2","nick2"));
        hm.put("login3", new LPN("login3","pass3","nick3"));
        hm.put("login4", new LPN("login4","pass4","nick4"));
    }

    @Override
    public String getNickByLoginPass(String login, String pass) throws AuthException {
        if (checkLogin(login)) {
            LPN o = hm.get(login);
            if (o.pass.equals(pass))
                return o.nick;
        }
        throw new AuthException("Неверный логин/пароль ");
    }

    @Override
    public boolean checkLogin(String login) {
        return hm.containsKey(login);
    }
}
