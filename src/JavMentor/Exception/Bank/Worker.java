package JavMentor.Exception.Bank;

public class Worker implements BankWorker{
    @Override
    public boolean checkClientForCredit(BankClient client) throws BadCreditHistoryException, ProblemWithLawException {
            if (client.getHistory()==false){
               throw  new BadCreditHistoryException();
            }
            else if (client.getProblemWithLaw()==false){
                throw new ProblemWithLawException();
            }
        return true;
    }
}
