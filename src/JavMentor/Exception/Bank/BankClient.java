package JavMentor.Exception.Bank;

public class BankClient {
   private Boolean history;
   private Boolean problemWithLaw;

    public BankClient(Boolean history, Boolean problemWithLaw) {
        this.history = history;
        this.problemWithLaw = problemWithLaw;
    }

    public Boolean getHistory() {
        return history;
    }

    public Boolean getProblemWithLaw() {
        return problemWithLaw;
    }
}
