package JavMentor.Exception.Bank;

public interface BankWorker {
    boolean checkClientForCredit(BankClient client) throws BadCreditHistoryException, ProblemWithLawException;
}
