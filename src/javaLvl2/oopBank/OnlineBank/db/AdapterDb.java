package javaLvl2.oopBank.OnlineBank.db;

import javaLvl2.oopBank.OnlineBank.model.Bank;

public interface AdapterDb {
    void connect();
    void disconnect();

    boolean getNickByLoginPass(String namberShot, int pin, Bank bank);
    String checkLogin(String schotAdress);

    int checkMoney(String schotAdress);
    void sqlTransferMoney (String schotAdress, int tranferMoney, String schot);
    void sqlTransferMoney (String schotAdress, int tranferMoney);
    void sqlWithdrawMoney (String schotAdress, int tranferMoney);

    void addHistory (String senderSchot, String schot,int money);
    StringBuilder getHistoryMoneyTransfer (String schot);
    String getHistoryCashInflow (String schot);

}
