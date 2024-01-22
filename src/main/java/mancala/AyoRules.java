package mancala;

public class AyoRules extends GameRules {

    public AyoRules() {
        super(); // Calls the constructor of the superclass to initialize the game board.
    }


    @Override
    public int moveStones(int startPit, int playerNum) throws InvalidMoveException {
        if (startPit < 1 || startPit > 12) {
        throw new InvalidMoveException();
    }

    int stonesInitiallyInStore = getDataStructure().getStoreCount(playerNum);
    int lastPit = startPit;
    int stonesInLastPit;

    do {
        int stonesDistributed = distributeStones(lastPit);
        lastPit = (lastPit + stonesDistributed - 1) % 12 + 1;
        stonesInLastPit = getDataStructure().getNumStones(lastPit);
        
        // If last stone ends in an empty pit on player's side and opposite pit has stones, capture them
        if (stonesInLastPit == 1 && isOwnedPit(lastPit, playerNum) && getDataStructure().getNumStones(oppositePit(lastPit)) > 0) {
            int capturedStones = captureStones(oppositePit(lastPit));
            getDataStructure().addToStore(playerNum, capturedStones);
        }
    } while (stonesInLastPit > 1); // Continue if last pit is not empty

    return getDataStructure().getStoreCount(playerNum) - stonesInitiallyInStore;
}
    

    @Override
    int distributeStones(int startPit) {

    int stonesToMove = getDataStructure().removeStones(startPit);
    getDataStructure().setIterator(startPit, getCurrentPlayer(), true); // Skip the starting pit

    for (int i = 0; i < stonesToMove; i++) {
        getDataStructure().next().addStone();
    }

    return stonesToMove; // Return the number of stones distributed
    }

    @Override
    int captureStones(int stoppingPoint) {

    int capturedStones = getDataStructure().removeStones(stoppingPoint);
    return capturedStones; 
    }

    private boolean isOwnedPit(int pit, int playerNum) {
    // Assuming player 1's pits are 1-6 and player 2's pits are 7-12
    return (playerNum == 1 && pit >= 1 && pit <= 6) || (playerNum == 2 && pit >= 7 && pit <= 12);
    }

    private int oppositePit(int pit) {
     // Calculate and return the opposite pit index
    return 12-pit;
    }
}
