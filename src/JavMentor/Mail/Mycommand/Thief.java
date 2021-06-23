package JavMentor.Mail.Mycommand;

import JavMentor.Mail.*;
import JavMentor.Mail.Package;

public class Thief implements MailService {
    private int minPrice;
    private int stolenValue;
    private final Package aPackage = new Package("stones instead of {content}",0);

    public Thief(int minPrice) {
        this.minPrice = minPrice;
    }
    public int getStolenValue(){
        return stolenValue;
    }


    @Override
    public Sendable processMail(Sendable mail) {
        MailPackage m = (MailPackage) mail;
        if (m.getContent().getPrice()<minPrice){
            return mail;
        }
        Sendable s1 = new MailPackage(mail.getFrom(),mail.getTo(),aPackage);
        return s1;
    }
}
