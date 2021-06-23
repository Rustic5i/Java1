package JavMentor.Exception.Bank;

public class Main {
    public static void main(String[] args) {
        BankClient[] arrClient = {new  BankClient(true,true),
                new BankClient(false,false),
                new BankClient(true,false),
                new BankClient(false,true)};
        BankWorker worker = new Worker();
        for (int i = 0; i < arrClient.length ; i++) {
            System.out.println(getCreditForClient(worker,arrClient[i]));
        }

    }
    public static boolean getCreditForClient(BankWorker bankWorker, BankClient bankClient)  {
        try {
           return bankWorker.checkClientForCredit(bankClient);
        }catch (BadCreditHistoryException e){
            System.out.println("Проблемы с банковской историей");
            return false;
        }catch (ProblemWithLawException e){
            return false;
        }
    }
}
