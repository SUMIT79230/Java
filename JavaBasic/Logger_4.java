import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Logger_4 {
    
    // create Logger
    private static final Logger logger = Logger.getLogger(Logger_4.class.getName());

    public static void main(String[] args) throws IOException {

        // Console Handler - display on console 
        ConsoleHandler consoleHandler = new ConsoleHandler();

        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(new SimpleFormatter());

        //  File Handler - Save in File
        FileHandler fileHandler = new FileHandler("app.log", true);
        fileHandler.setLevel(Level.ALL);
        fileHandler.setFormatter(new SimpleFormatter());

        //  Logger setup
        logger.setLevel(Level.ALL);
        logger.addHandler(consoleHandler);
        logger.addHandler(fileHandler);
        logger.setUseParentHandlers(false);

        logger.severe("SEVERE  - App crash ya critical error!");
        logger.warning("WARNING - Kuch galat ho sakta hai");
        logger.info("INFO    - Program start hua");
        logger.config("CONFIG  - Configuration load hui");
        logger.fine("FINE    - Basic debug info");
        logger.finer("FINER   - Detailed debug info");
        logger.finest("FINEST  - Sabse zyada detail");

        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            logger.log(Level.SEVERE, "Division by zero error aaya!", e);
        }

        logger.info(" Bank App Start ");
        deposit(5000);
        withdraw(2000, 5000);
        withdraw(9000, 3000);
        withdraw(-500, 3000);

        fileHandler.close();
    }

    static void deposit(int amount) {
        if (amount <= 0) {
            logger.warning("Invalid deposit amount: " + amount);
            return;
        }
        logger.info("Deposit successful: ₹" + amount);
    }

    static void withdraw(int amount, int balance) {
        logger.info("Withdrawal request: ₹" + amount);

        if (amount <= 0) {
            logger.severe("Invalid amount: ₹" + amount);
            return;
        }

        if (amount > balance) {
            logger.warning("Insufficient balance! Amount: ₹" + amount + ", Balance: ₹" + balance);
            return;
        }

        int newBalance = balance - amount;
        logger.info("Withdrawal successful! New Balance: ₹" + newBalance);
    }
}
