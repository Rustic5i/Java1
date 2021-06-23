package JavMentor.Mail.Mycommand;

import JavMentor.Mail.Package;
import JavMentor.Mail.*;

import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        //   Package aPackage = new Package("w",20);
        Sendable sendable = new MailPackage("wawd", "scs", new Package("Все супер", 45));
        // AbstractSendable s = new MailPackage("wawd","scs",aPackage);

        Thief thief = new Thief(40);

        System.out.println(thief.processMail(sendable));

    }

    public static class UntrustworthyMailWorker implements MailService {
        private MailService[] mailServices;
        private RealMailService realMailService = new RealMailService();

        public UntrustworthyMailWorker(MailService[] mailServices) {
            this.mailServices = mailServices;

        }

        public RealMailService getRealMailService() {
            return realMailService;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            //Sendable newMail = new MailPackage("","",null);
            for (int i = 0; i < mailServices.length; i++) {
                mail = mailServices[i].processMail(mail);
            }
            return realMailService.processMail(mail);
        }
    }

    public static class Thief implements MailService {
        private int minPrice;
        private int stolenValue;

        public Thief(int minPrice) {
            this.minPrice = minPrice;
        }

        public int getStolenValue() {
            return stolenValue;
        }


        @Override
        public Sendable processMail(Sendable mail) {

            MailPackage m = (MailPackage) mail;
            if (m.getContent().getPrice() < minPrice) {
                stolenValue = stolenValue + m.getContent().getPrice();
                return mail;
            }
            Sendable s1 = new MailPackage(mail.getFrom(), mail.getTo(), new Package("stones instead of " + m.getContent().getContent(), 0));
            return s1;
        }
    }

    public static class Spy implements MailService {
        private Logger logger;

        public Spy(Logger logger) {
            this.logger = logger;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail.getClass() == MailMessage.class) {
                MailMessage mailMessage = (MailMessage) mail;
                if (mail.getTo().equals("Austin Powers") || mail.getFrom().equals("Austin Powers")) {
                    // logger.log(Level.WARNING, "Detected target mail correspondence: from " + mail.getFrom() + " to " + mail.getTo() + "\"" + mailMessage.getMessage() + "\"");
                    logger.warning("Detected target mail correspondence: from " + mail.getFrom() + " to " + mail.getTo() + " \"" + mailMessage.getMessage() + "\"");
                } else {
                    logger.info("Usual correspondence: from " + mail.getFrom() + " to " + mail.getTo());
                    // logger.log(Level.INFO, "Usual correspondence: from " + mail.getFrom() + " to " + mail.getTo());
                }
            }
            return mail;
        }
    }

    public static class Inspector implements MailService {
        @Override
        public Sendable processMail(Sendable mail) {
            MailPackage m = (MailPackage) mail;
            if (m.getContent().getContent().contains("weapons") || m.getContent().getContent().contains("banned substance")) {
                throw new IllegalPackageException();
            } else if (m.getContent().getContent().contains("stones")) {
                throw new StolenPackageException();
            }
            return mail;
        }
    }

    public static class StolenPackageException extends RuntimeException {
    }

    public static class IllegalPackageException extends RuntimeException {
    }

}

////////////////////////////////
