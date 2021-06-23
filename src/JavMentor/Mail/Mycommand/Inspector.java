package JavMentor.Mail.Mycommand;

import JavMentor.Mail.MailPackage;
import JavMentor.Mail.MailService;
import JavMentor.Mail.Mycommand.Exception.IllegalPackageException;
import JavMentor.Mail.Mycommand.Exception.StolenPackageException;
import JavMentor.Mail.Sendable;

public class Inspector implements MailService {
    @Override
    public Sendable processMail(Sendable mail) {
            MailPackage m = (MailPackage) mail;
            if (m.getContent().equals("weapons")||m.getContent().equals("banned substance")){
                throw new IllegalPackageException();
            }
            else if (m.getContent().equals("stones")){
                throw new StolenPackageException();
            }
        return mail;
    }
}
