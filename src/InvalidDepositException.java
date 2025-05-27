public class InvalidDepositException extends Exception {
    public InvalidDepositException() {
        super("The Deposit has to greater than and not equal zero.");
    }
}
