package javaLvl2.chat.server;

import java.sql.*;

public class SQLHandler {
    private static Connection conn;
    private static Statement stmt;

    public static void connect (){
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:users.db");
            stmt = conn.createStatement();
        }catch (Exception e){
            System.out.println("Ошибка загрузки драйверов JDBC");
        }

    }
    public static void test (){
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM main");
            while (rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getNickByLoginPass(String login, String pass)  {
        try {
            ResultSet rs = stmt.executeQuery("SELECT Nick FROM main WHERE Login = '"+login+"' AND Pass= '"+pass+"'");
           if (rs.next()){
               return rs.getString(1);
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean checkLogin(String login) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM main WHERE Login = '"+login+"'");
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public static void disconnect() {
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
