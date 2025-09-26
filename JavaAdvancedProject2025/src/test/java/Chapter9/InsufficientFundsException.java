package Chapter9;

public class InsufficientFundsException extends Exception {

    public InsufficientFundsException(String message) {
        super("Insufficient Funds" + message);
    }
}