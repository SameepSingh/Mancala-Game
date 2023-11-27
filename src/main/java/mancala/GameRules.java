package mancala;

import java.io.Serializable;
/**
 * Abstract class representing the rules of a Mancala game.
 * KalahRules and AyoRules will subclass this class.
 */
public abstract class GameRules implements Serializable{
    private MancalaDataStructure gameBoard;
    private Player playerOne;
    private Player playerTwo;


    private int currentPlayer = 1; // Player number (1 or 2)

    /**
     * Constructor to initialize the game board.
     */
    public GameRules() {
        gameBoard = new MancalaDataStructure();
        resetBoard();
    }

    /**
     * Get the number of stones in a pit.
     *
     * @param pitNum The number of the pit.
     * @return The number of stones in the pit.
     */
    public int getNumStones(int pitNum) {
        return gameBoard.getNumStones(pitNum);
    }

    /**
     * Get the game data structure.
     *
     * @return The MancalaDataStructure.
     */
    MancalaDataStructure getDataStructure() {
        return gameBoard;
    }

    /**
     * Check if a side (player's pits) is empty.
     *
     * @param pitNum The number of a pit in the side.
     * @return True if the side is empty, false otherwise.
     */
    boolean isSideEmpty(int pitNum) {
        // This method can be implemented in the abstract class.
        return false;
    }

    /**
     * Set the current player.
     *
     * @param playerNum The player number (1 or 2).
     */
    public void setPlayer(int playerNum) {
        currentPlayer = playerNum;
    }

    /**
     * Perform a move and return the number of stones added to the player's store.
     *
     * @param startPit  The starting pit for the move.
     * @param playerNum The player making the move.
     * @return The number of stones added to the player's store.
     * @throws InvalidMoveException If the move is invalid.
     */
    public abstract int moveStones(int startPit, int playerNum) throws InvalidMoveException;

    /**
     * Distribute stones from a pit and return the number distributed.
     *
     * @param startPit The starting pit for distribution.
     * @return The number of stones distributed.
     */
    abstract int distributeStones(int startPit);

    /**
     * Capture stones from the opponent's pit and return the number captured.
     *
     * @param stoppingPoint The stopping point for capturing stones.
     * @return The number of stones captured.
     */
    abstract int captureStones(int stoppingPoint);

    /**
     * Register two players and set their stores on the board.
     *
     * @param one The first player.
     * @param two The second player.
     */
      public void registerPlayers(Player one, Player two) {
        // Create and connect stores for each player
        Store storeOne = new Store();
        storeOne.setOwner(one);
        one.setStore(storeOne);
        gameBoard.setStore(storeOne, 1);  // Assuming playerNum 1 for Player one

        Store storeTwo = new Store();
        storeTwo.setOwner(two);
        two.setStore(storeTwo);
        gameBoard.setStore(storeTwo, 2);  // Assuming playerNum 2 for Player two

        // Store references to the players for game logic purposes
        playerOne = one;
        playerTwo = two;
    }

    public int getCurrentPlayer(){
        return currentPlayer;
    }

    public void resetBoard() {
        gameBoard.setUpPits();
        gameBoard.emptyStores();
    }

     public boolean isGameOver() {
        boolean isPlayerOneSideEmpty = true;
        boolean isPlayerTwoSideEmpty = true;

        // Check if all pits for player one (pits 1-6) are empty
        for (int i = 1; i <= 6; i++) {
            if (gameBoard.getNumStones(i) > 0) {
                isPlayerOneSideEmpty = false;
                break;
            }
        }

        // Check if all pits for player two (pits 8-13) are empty
        for (int i = 8; i <= 13; i++) {
            if (gameBoard.getNumStones(i) > 0) {
                isPlayerTwoSideEmpty = false;
                break;
            }
        }

        // The game is over if either side is completely empty
        return isPlayerOneSideEmpty || isPlayerTwoSideEmpty;
    }

    @Override
    public String toString() {
        // Implement toString() method logic here.
        return "";
    }
}
