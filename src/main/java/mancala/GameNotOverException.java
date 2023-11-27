package mancala;

public class GameNotOverException extends Exception {
    public GameNotOverException() {
        super("Game was not over exception");
    }

    public GameNotOverException(String message) {
        super(message);
    }
}