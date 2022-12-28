package ma.enset.comptecqrses.commonapi.exceptions;

public class BalanceNotSufficientException extends RuntimeException {
    public BalanceNotSufficientException(String balance) {
        super(balance);
    }
}
