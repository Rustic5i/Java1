package JavMentor.Mail.Mycommand;

import JavMentor.Mail.MailPackage;
import JavMentor.Mail.MailService;
import JavMentor.Mail.RealMailService;
import JavMentor.Mail.Sendable;

public class UntrustworthyMailWorker implements MailService {
    private MailService [] mailServices;
    private RealMailService realMailService;

    public UntrustworthyMailWorker(MailService[] mailServices) {
        this.mailServices = mailServices;

    }
    public RealMailService getRealMailService(){
        return realMailService;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        Sendable newMail = new MailPackage("","",null);
        for (int i = 0; i < mailServices.length; i++) {
            newMail = mailServices[i].processMail(mail);
        }

        return newMail;
    }
}
