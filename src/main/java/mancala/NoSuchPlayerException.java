package mancala;

public class NoSuchPlayerException extends Exception {
    public NoSuchPlayerException() {
        super("No such player was found");
    }

    public NoSuchPlayerException(String message) {
        super(message);
    }
}