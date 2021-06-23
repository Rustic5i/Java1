package javaLvl2.oopBank.OnlineBank.model;

import javaLvl2.oopBank.OnlineBank.db.AdapterDb;
import javaLvl2.oopBank.OnlineBank.db.SqlDb;

import java.util.TreeMap;

public final class Bank {
    private AdapterDb sqlBd;
    private Client client;
    private Schot schot;
    private static Bank instance;
    private int namberATM;
    private TreeMap<Integer,Schot> treeSchot = new TreeMap<>();
    private Bank() {
        sqlBd = SqlDb.getInstance();
        client = new Client("");
    }

    public boolean getNickByLoginPass(String namberShot, int pin)  {
      return sqlBd.getNickByLoginPass(namberShot,pin,this);
    }
    public String getNameClient(){
        return client.getName();
    }
    public void setManeClient(String name){
        client.setName(name);
    }
    public String checkSchotAdress(String schotAdress) {
        return sqlBd.checkLogin(schotAdress);
    }
    public String getHistory (Integer namberATM){
        String operationsHistory = "Доступно последние 10 операций \n"+sqlBd.getHistoryCashInflow(treeSchot.get(namberATM).getSchot())+sqlBd.getHistoryMoneyTransfer(treeSchot.get(namberATM).getSchot());
       return operationsHistory;
    }
    public  void disconnect() {
        sqlBd.disconnect();
    }
    public String withdrawMoney (int money,Integer namberATM){
        return treeSchot.get(namberATM).withdrawMoney(money);
    }
    public String putMoney (int many, Integer namberATM){
        return treeSchot.get(namberATM).putMoney(many);
    }
    public String transferMoney(String schotAdress, int money,Integer namberATM){
        return treeSchot.get(namberATM).transferMoney(schotAdress,money);
    }
    public String getSchot() {
        return schot.getSchot();
    }
    public int getMoney() {
        return schot.getMoney();
    }
    public void setMoney(int money) {
        schot.setMoney(money);;
    }
    public void setSchot(String schot) {
        this.schot.setSchot(schot);
    }

    public static synchronized Bank getInstance (){
        if (instance == null){
            instance = new Bank();
        }
        return instance;
    }

    public void setNamberATM(int namberATM) {
        this.namberATM = namberATM;
    }

    public void newSchot(String newSchot, int money){
        treeSchot.put(namberATM,schot= new Schot(sqlBd,newSchot,money));
    }
}
