package JavMentor.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        logging();
    }
    public static void logging() {
        Logger LOGGER = Logger.getLogger("com.javamentor.logging.Test");
        LOGGER.log(Level.INFO,"Все хорошо");
        LOGGER.log(Level.WARNING,"Произошла ошибка");
    }
}
