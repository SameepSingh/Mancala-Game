package mancala;

public class PitNotFoundException extends Exception {
    public PitNotFoundException() {
        super("Pit was not found");
    }

    public PitNotFoundException(String message) {
        super(message);
    }
}