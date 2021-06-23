package JavMentor.Mail.Mycommand;

import JavMentor.Mail.AbstractSendable;
import JavMentor.Mail.MailService;
import JavMentor.Mail.Sendable;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Spy implements MailService {
    private Logger logger;

    public Spy(Logger logger) {
        this.logger = logger;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        AbstractSendable sendable = (AbstractSendable) mail;
        if (sendable.getFrom().equals("Austin Powers")){
            logger.log(Level.WARNING,"Detected target mail carrespondence: from "+mail.getFrom()+ "to"+mail.getTo() );
        }
        logger.log(Level.INFO,"Usual carrespondence: from "+mail.getFrom()+ "to"+mail.getTo());
        return mail;
    }
}
