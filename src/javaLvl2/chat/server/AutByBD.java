package javaLvl2.chat.server;

public class AutByBD implements AuthService{
    public AutByBD() {
        SQLHandler.connect();
    }

    @Override
    public String getNickByLoginPass(String login, String pass) throws AuthException {
        String str = SQLHandler.getNickByLoginPass(login,pass);
        if (str != null) return str;
        else throw new AuthException("Неверный логин/пароль");
    }

    @Override
    public boolean checkLogin(String login) {
        return SQLHandler.checkLogin(login);
    }
}
