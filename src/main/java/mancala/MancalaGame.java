package mancala;

import java.io.Serializable;

public class MancalaGame implements Serializable {
    private static final long serialVersionUID = 1L;

    private GameRules gameRules;  // Game rules
    private Player currentPlayer; // Current player
    private Player playerOne;
    private Player playerTwo;

    // Constructors
    public MancalaGame() {
        gameRules = new KalahRules(); // or new AyoRules();

        // Create UserProfiles for both players
        UserProfile userProfileOne = new UserProfile("Player 1");
        UserProfile userProfileTwo = new UserProfile("Player 2");

        // Initialize players with the created UserProfiles
        this.playerOne = new Player();
        this.playerTwo = new Player();

        // Set the current player to playerOne initially
        this.currentPlayer = playerOne;

        // Register players with the game rules
        this.gameRules.registerPlayers(playerOne, playerTwo);
    }
      /**
     * Sets the players for the game.
     *
     * @param onePlayer The first player.
     * @param twoPlayer The second player.
     */
    // Set players
    public void setPlayers(Player onePlayer, Player twoPlayer) {
         gameRules.registerPlayers(onePlayer,twoPlayer);
    }

    // Start a new game
    public void startNewGame() {
        this.gameRules.resetBoard();
        this.currentPlayer = playerOne; // Or decide based on some logic or user choice
    }
   
    // Get the game rules
    public GameRules getBoard() {
        return gameRules;
    }

    // Get the current player
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getPlayerOne(){
        return playerOne;
    }

    public Player getPlayerTwo(){
        return playerTwo;
    }



    // Get the number of stones in a pit
    public int getNumStones(int pitNum) {
        return gameRules.getDataStructure().getNumStones(pitNum);
    }

    // Get the number of stones in a player's store
    public int getStoreCount(Player player) {
        // Assuming a method in GameRules to get store count by player
        return gameRules.getDataStructure().getStoreCount(player == playerOne ? 1 : 2);
    }

    // Get the winner of the game
    public Player getWinner() {
        int stonesPlayerOne = getStoreCount(playerOne);
        int stonesPlayerTwo = getStoreCount(playerTwo);
        
        if (stonesPlayerOne > stonesPlayerTwo) {
            return playerOne;
        } else if (stonesPlayerOne < stonesPlayerTwo) {
            return playerTwo;
        } else {
            return null; // A tie, could be handled differently based on game rules
        }
    }

    // Check if the game is over
    public boolean isGameOver() {
        return gameRules.isGameOver();
    }

    // Move stones
   
    public int move(int startPit) throws InvalidMoveException {
        try {
            // Utilize the moveStones method which would contain the logic for making a move
            return gameRules.moveStones(startPit, currentPlayer == playerOne ? 1 : 2);
        } catch (InvalidMoveException e) {
            // Handle the exception, possibly by logging it or notifying the user
            System.err.println("Invalid move: " + e.getMessage());
            return 0;
        }
    }
    
// Helper method to switch the current player
private void switchCurrentPlayer() {
    currentPlayer = (currentPlayer == playerOne) ? playerTwo : playerOne;
}


    // Set the game rules
    public void setBoard(GameRules theBoard) {
        this.gameRules = theBoard;
    }

    // Set the current player
    public void setCurrentPlayer(Player player) {
        this.currentPlayer = player;
    }

    // Convert to string representation
    @Override
    public String toString() {
        return "Current Player: " + currentPlayer.getName() + "\n" +
               "Board:\n" + gameRules.getDataStructure().toString();
    }
}
