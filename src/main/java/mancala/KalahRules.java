package mancala;

public class KalahRules extends GameRules {

    public KalahRules() {
        super(); // Calls the constructor of the superclass to initialize the game board.
    }

    @Override      
    public int moveStones(int startPit, int playerNum) throws InvalidMoveException {
     if (startPit < 0 || startPit >12) {
        throw new InvalidMoveException();
    }

    int stonesInitiallyInStore = getDataStructure().getStoreCount(playerNum);
    int stonesDistributed = distributeStones(startPit);
    int lastPit = ((startPit + stonesDistributed)-1) % 12;
    
    
    // Check if the last stone lands in the player's store for a free turn
   if (lastPit == getDataStructure().getStorePosition(playerNum)) {
        
        return -1; // Indicate a free turn
    }
    

    // Check for capture condition
    if (getDataStructure().getNumStones(lastPit) == 1) {

        System.out.println("PIT NUMBER = "+ lastPit);

        int capturedStones = captureStones(lastPit);
        getDataStructure().addToStore(playerNum, capturedStones);
    }

    int stonesFinallyInStore = getDataStructure().getStoreCount(playerNum);
    return stonesFinallyInStore - stonesInitiallyInStore; // Return the number of stones added to the player's store

}
       

    @Override
    int distributeStones(int startPit) {
        
    int stonesToMove = getDataStructure().removeStones(startPit);
    int currentPlayer = getCurrentPlayer();

    System.out.println("HERE" +  currentPlayer);

    getDataStructure().setIterator(startPit, currentPlayer+1, false); // Skip the starting pit

    for (int i = 0; i < stonesToMove; i++) {
        Countable nextPit = getDataStructure().next();
        nextPit.addStone();
    }

    return stonesToMove; // Return the number of stones distributed
        
    }

    @Override
    int captureStones(int stoppingPoint) {

    int oppositePit = 11 - stoppingPoint; // Calculate the opposite pit index
    int capturedStones = getDataStructure().removeStones(oppositePit); // Capture stones from the opposite pit
    capturedStones += getDataStructure().removeStones(stoppingPoint); // Also take the last stone
    return capturedStones; // Return the total number of captured stones
}

 private boolean isOwnedPit(int pit, int playerNum) {
    if (playerNum == 1) {
        // Assuming player 1's pits are 0-5
        return pit >= 0 && pit < 6;
    } else if (playerNum == 2) {
        // Assuming player 2's pits are 6-11
        return pit >= 6 && pit < 12;
    }
    return false;
 }
   
    
}

