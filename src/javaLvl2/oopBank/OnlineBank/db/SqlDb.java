package javaLvl2.oopBank.OnlineBank.db;

import javaLvl2.oopBank.OnlineBank.model.Bank;

import java.sql.*;
import java.util.Date;

public class SqlDb implements AdapterDb {
    private Connection conn;
    private Statement stm;
    private PreparedStatement pstmt;
    private static SqlDb instance;
    private final String ThePathToTheFile = "jdbc:sqlite:C:\\program\\BANK_SQL.db";


    private SqlDb() {
        /*
    review:
    Тут, ты пытался сделать из этого класса singletone, и при этом все поля статичные, и метод getInstance
    не используется нигде. Сейчас, в том виде, в котором этот класс жив - это не законченный концепт.
    Чтобы довести класс до конца, нужно понять, чего ты хочешь тут достичь:
    - либо это синглтон - и тогда нужно сделать поля класса НЕ статичными, и работать с методами класса только через его единственный инстанс
    - либо это просто утилитарный класс и тогда делай все методы статичными и убирай метод getInstance
    на деле, конечно же, работу с БД лучше оформить как синглтон. Ибо один класс будет обслуживать потоки соединений с клиентами и доставать данные с базы.
    Тем более, у тебя на весь доступ к БД используется один коннекшн.
     */
        connect();
        listUsers();
    }
    public static synchronized SqlDb getInstance(){
        if(instance == null) return instance =  new SqlDb();
        else return instance;
    }

    public synchronized void connect(){
        try {
            Class.forName("org.sqlite.JDBC");
             /*
            review:
            тут есть проблема. Connection класс - про его поддержку работы в нескольких потоках не сказано в javadoc'е ничего.
            Когда такое видишь, у тебя есть два пути (третий - забить :-)):
            - либо лезешь в исходный код и пытаешься понять сам, насколько безопасно использовать класс в нескольких потоках
            - либо сразу предполагаешь, что класс не thread-safe.
            Если класс не потокобезопасен - твоя первая задача эту самую безопасность закодить.
            В твоём случае, класс Connection - не потокобезопасен. В доках про это не написано, но могу сказать, что как минимум
            драйвер к Postgresql коннекты создаёт НЕ потокобезопасные.
            Поэтому в твоём случае, использовать один коннекшн на все потоки - приведёт к ошибкам.
            Самый простой пример - который я могу тут увидеть это:
            - в одном из методов ты меняешь autocommit режим. Что если в это же самое время другой поток пытается
            обновить данные через этот же коннекшн?
             */
            conn = DriverManager.getConnection(ThePathToTheFile);
            stm = conn.createStatement();
        }catch (Exception e){
            System.out.println("Ошибка загрузки драйверов JDBC");
        }

    }
    public boolean getNickByLoginPass(String namberShot, int pin, Bank bank)  {
        try {
             /*
            review:
            Каждый раз когда ты вручную собираешь строку с SQL выражением, помни
            если ты вставляешь внешние параметры в SQL, если эти параметры приходят откуда то извне - через сеть,
            или вводятся пользователем - это открывает дыру в безопасности приложения, а именно для атак вида
            SQL injection.
            Как от этого уйти?
            В JDBC есть специальный класс - PreparedStatement, который позволяет тебе писать шаблонные SQL выражения, и
            вставлять параметры более безопасно.
             */
           // ResultSet rs = stm.executeQuery("SELECT * FROM users WHERE Schot = '"+namberShot+"' AND Pin= '"+pin+"'");
            pstmt = conn.prepareStatement("SELECT * FROM users WHERE Schot = ? AND Pin= ?");
            pstmt.setString(1,namberShot);
            pstmt.setInt(2,pin);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                bank.newSchot(rs.getString(1),rs.getInt(3));
                bank.setManeClient(rs.getString(2));
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public void sqlTransferMoney (String schotAdress, int tranferMoney, String schot){
        try {
           conn.setAutoCommit(false);
          // stm.executeUpdate("UPDATE `users` SET `Money` = `Money`+'"+tranferMoney+"' WHERE (`Schot` = '"+schotAdress+"')");
           //stm.executeUpdate("UPDATE `users` SET `Money` = `Money`-'"+tranferMoney+"' WHERE (`Schot` = '"+schot+"')");
           pstmt = conn.prepareStatement("UPDATE users SET Money = Money + ? WHERE (Schot = ?)");
           PreparedStatement preparedStatement1 = conn.prepareStatement("UPDATE users SET Money = Money - ? WHERE (Schot = ?)");

           pstmt.setInt(1,tranferMoney);
           pstmt.setString(2,schotAdress);
           preparedStatement1.setInt(1,tranferMoney);
           preparedStatement1.setString(2,schot);

           pstmt.executeUpdate();
           preparedStatement1.executeUpdate();

           conn.commit();
           conn.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void sqlTransferMoney (String schotAdress, int tranferMoney){
        try {
           // stm.executeUpdate("UPDATE `users` SET `Money` = `Money`+'"+tranferMoney+"' WHERE (`Schot` = '"+schotAdress+"')");
            pstmt = conn.prepareStatement("UPDATE users SET Money = Money + ? WHERE (Schot =  ?)");
            pstmt.setInt(1,tranferMoney);
            pstmt.setString(2,schotAdress);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void sqlWithdrawMoney (String schotAdress, int tranferMoney){
        try {
           // stm.executeUpdate("UPDATE `users` SET `Money` = `Money`-'"+tranferMoney+"' WHERE (`Schot` = '"+schotAdress+"')");
            pstmt = conn.prepareStatement("UPDATE users SET Money = Money -? WHERE (Schot = ?)");
            pstmt.setInt(1,tranferMoney);
            pstmt.setString(2,schotAdress);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public String checkLogin(String schotAdress) {
         /*
        review:
        ResultSet реализует интерфейс AutoCloseable. Поэтому хорошей практикой будет закрывать его после использования.
        Сделать это можно легко и просто прямо в try (...).
        Пример сделал ниже
         */
        try {
           // ResultSet rs = stm.executeQuery("SELECT Name FROM users WHERE Schot = '"+schotAdress+"'");
            pstmt = conn.prepareStatement("SELECT Name FROM users WHERE Schot = ?");
            pstmt.setString(1,schotAdress);
            ResultSet rs = pstmt.executeQuery();
            rs.close();
            return rs.getString(1);
        } catch (SQLException e) {
            System.out.println(e);
        }
       return null;
    }

    public  void disconnect() {
        try {
            conn.close();
            pstmt.close();
            stm.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void listUsers(){
        try {
            ResultSet rs = stm.executeQuery("SELECT * FROM users");
            while (rs.next()){
                /*
                review:
                собирать строку с параметрами через конкатенацию - плохая практика.
                Это очень НЕ читабельно.
                Поэтому, можно использовать String.format(), который позволяет задать шаблон, и указать места, куда будут подставлены
                значения переданных параметров.
                Пример:
                String.format("Счёт: %s Имя %s", rs.getString(1), rs.getString(2))...
                 */
               //System.out.println("Счет: "+rs.getString(1)+" Имя "+rs.getString(2)+" Сумма "+rs.getString(3)+"руб pin "+rs.getString(4));
                System.out.println(String.format("Счёт: %s Имя %s Сумма %s руб pin %s ", rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addHistory (String senderSchot, String schot,int money){
        Date date = new Date();
        try {
            // stm.executeUpdate("insert into history (Date,Sender_Schot,SchotName,MoneyTransfer) values ('"+date+"','"+senderSchot+"','"+schot+"','"+money+"')");
            pstmt = conn.prepareStatement("insert into history (Date,Sender_Schot,SchotName,MoneyTransfer) values (?,?,?,?)");
            pstmt.setString(1, String.valueOf(date));
            pstmt.setString(2,senderSchot);
            pstmt.setString(3,schot);
            pstmt.setInt(4,money);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public StringBuilder getHistoryMoneyTransfer (String schot){
         /*
        review:
        слишком много конкатенации.
        Используй StringBuilder вместо текущего варианта.
        (к слову, если не знал, код, который написан у тебя ниже - компилятором будет переведён на код, использующий
        StringBuilder автоматически. Это можно увидеть, если после компиляции проекта, декомпилировать его).
         */
        StringBuilder history = new StringBuilder("");
        try {

            int i =0;
          //  ResultSet rs = stm.executeQuery("SELECT  Date, Name, MoneyTransfer, id FROM history inner join users on history.SchotName = users.Schot WHERE Sender_Schot = '"+schot+"'ORDER BY id DESC");
            pstmt = conn.prepareStatement("SELECT  Date, Name, MoneyTransfer, id FROM history inner join users on history.SchotName = users.Schot WHERE Sender_Schot = ? ORDER BY id DESC");
            pstmt.setString(1,schot);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next() &&  (i < 6)  ){
               history.append("-----------------------------------------------\n");
               history.append(rs.getString(1)+"\n");
               history.append("Перевод "+rs.getString(2)+" "+rs.getInt(3)+"руб\n");
               i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("КАКАЯ-ТА ОШИБКА");
            history.append("КАКАЯ-ТА ОШИБКА");
        }
        return history;
    }
    public String getHistoryCashInflow (String schot){ // Поступление денежных средств
        String history = "";
        try {
            int i =0;
           // ResultSet rs = stm.executeQuery("SELECT  Date, Name, MoneyTransfer, id FROM history INNER JOIN users ON history.Sender_Schot = users.Schot WHERE SchotName = '"+schot+"' ORDER BY id DESC");
            pstmt = conn.prepareStatement("SELECT  Date, Name, MoneyTransfer, id FROM history INNER JOIN users ON history.Sender_Schot = users.Schot WHERE SchotName = ? ORDER BY id DESC");
            pstmt.setString(1,schot);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next() &&  (i < 6)  ){
                history = history+"-----------------------------------------------\n";
                history = history+rs.getString(1)+"\n";
                history = history+"Поступления от: "+rs.getString(2)+" "+rs.getInt(3)+"руб\n";
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return history;
    }
    public int checkMoney(String schotAdress) {
        try {
           // ResultSet rs = stm.executeQuery("SELECT Money FROM users WHERE Schot = '"+schotAdress+"'");
            pstmt = conn.prepareStatement("SELECT Money FROM users WHERE Schot = ?");
            pstmt.setString(1,schotAdress);
            ResultSet rs = pstmt.executeQuery();
            System.out.println(rs.getString(1));
            return rs.getInt(1);
        } catch (SQLException e) {
            System.out.println(e);
        }
        System.out.println("ERROR_SQL_checkMoney....");
        return 0;
    }
}

